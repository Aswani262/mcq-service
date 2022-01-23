package com.tms.framework.eventhandling;

public @interface EventHandler {
    String topic() default "";

    String groupId() default "";
}
