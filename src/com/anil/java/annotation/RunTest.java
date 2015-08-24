/**
 * 
 */
package com.anil.java.annotation;

import java.lang.reflect.Method;

/**
 * @author anila
 * 
 */
public class RunTest {

	public static void main(String[] args) throws SecurityException,
			ClassNotFoundException {
		if (args == null || args.length==0) {
			args = new String[]{"com.anil.java.annotation.AnnotationTest"};
		}

		int passed = 0, failed = 0;
		for (Method m : Class.forName(args[0]).getMethods()) {
			if (m.isAnnotationPresent(Test.class)) {
				try {
					m.invoke(null);
					System.out.println("Annotation value obtained for method: " + m + " is:" + m.getAnnotation(Test.class).value()); 
					passed++;
				} catch (Throwable ex) {
					System.out
							.printf("Test %s failed: %s %n", m, ex.getCause());
					failed++;
				}
			}
		}
		System.out.printf("Passed: %d, Failed %d%n", passed, failed);

	}
}
