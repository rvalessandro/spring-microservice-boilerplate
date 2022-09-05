package com.rvalessandro.springmicroserviceboilerplate.infrastructure.producers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventObject {
    private String eventName;
    private String context;
    private Object payload;
}
