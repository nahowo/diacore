package com.diacore.domain.common.adapter;

import com.diacore.domain.common.model.Event;

public interface EventPublisher {
    <T, S>void publish(Event<T, S> event);
}
