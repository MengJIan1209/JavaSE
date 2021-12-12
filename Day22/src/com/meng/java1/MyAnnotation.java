package com.meng.java1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {

    String value() default "hello";

}
