package com.org.example.my.rulemachine.core;

import java.lang.annotation.Annotation;

/**
 * @author ：luoqi/02216
 * @date ：Created in 2020/10/13 11:33 上午
 * @description：
 */
public class Utils {

    private Utils() {}

    static <A extends Annotation> A findAnnotation(final Class<A> targetAnnotation, final Class<?> annotatedType) {
        A foundAnnotation = annotatedType.getAnnotation(targetAnnotation);
        if (null == foundAnnotation) {
            for (Annotation annotation : annotatedType.getAnnotations()) {
                Class<? extends Annotation> annotationType = annotation.annotationType();
                if (annotatedType.isAnnotationPresent(targetAnnotation)) {
                    foundAnnotation = annotationType.getAnnotation(targetAnnotation);
                    break;
                }
            }
        }
        return foundAnnotation;
    }

    static boolean isAnnotationPresent(final Class<? extends Annotation> targetAnnotation, final Class<?> annotatedType) {
        return findAnnotation(targetAnnotation, annotatedType) != null;
    }
}
