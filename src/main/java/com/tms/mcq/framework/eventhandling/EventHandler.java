package com.tms.mcq.framework.eventhandling;

public @interface EventHandler {
    String topic() default "";
    String groupId() default "";
}
