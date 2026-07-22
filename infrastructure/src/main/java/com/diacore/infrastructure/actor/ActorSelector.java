package com.diacore.infrastructure.actor;

import com.diacore.domain.common.usecase.Actor;
import com.diacore.domain.common.usecase.UseCase;

public class ActorSelector {
    public static BoundActor current() {
        return new BoundActor(ActorUtil.getCurrentActor());
    }

    public static BoundActor anonymous() {
        return new BoundActor(new Actor(null, "ANONYMOUS"));
    }

    public static class BoundActor {
        private final Actor actor;

        public BoundActor(Actor actor) {
            this.actor = actor;
        }

        public <T, R> UseCaseRequest<T, R> requestTo(UseCase<T, R> useCase) {
            return new UseCaseRequest<>(this.actor, useCase);
        }
    }

    public static class UseCaseRequest<T, R> {
        private final Actor actor;
        private final UseCase<T, R> useCase;

        public UseCaseRequest(Actor actor, UseCase<T, R> useCase) {
            this.actor = actor;
            this.useCase = useCase;
        }

        public R by(T request) {
            return useCase.execute(actor, request);
        }
    }
}
