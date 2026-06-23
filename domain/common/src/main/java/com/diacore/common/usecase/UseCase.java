package com.diacore.common.usecase;

public interface UseCase<I, O> {
    O execute(Actor actor, I request);

    default O execute(Actor actor) {
        return execute(actor, null);
    }
}
