package com.systeric.springmicroserviceboilerplate.infrastructure.producers.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EventObject {
    public String eventName;
    public Context context;
    public Object payload;
}
