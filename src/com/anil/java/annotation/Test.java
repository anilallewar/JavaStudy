
package com.anil.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated method is a test method.
 * This annotation should be used only on parameterless static methods.
 *
 * @author anila
 */

//Indicates that annotations with this type are to be retained by the VM so they can be read reflectively at run-time
@Retention(RetentionPolicy.RUNTIME)
//Indicates that this annotation type can be used to annotate only method 
@Target(ElementType.METHOD)
public @interface Test {
	String value();
}
