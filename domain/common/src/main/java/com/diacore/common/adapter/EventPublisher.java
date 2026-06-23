package com.diacore.common.adapter;

import com.diacore.common.model.Event;

public interface EventPublisher {
    <T, S>void publish(Event<T, S> event);
}
