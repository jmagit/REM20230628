package com.example.util;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.*;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Target({ TYPE, FIELD })
public @interface Autor {
	String nombre() default "(anonimo)";
}
