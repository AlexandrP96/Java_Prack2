/*
 * Классы с наборами методов с аннотациями @Test;
 */

package Lesson_7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Область видимости аннотации
// RUNTIME - аннотация может быть использована во время работы программы
@Retention(RetentionPolicy.RUNTIME)
// Цель использования аннотации
// для Метода
@Target(ElementType.METHOD)
// Экземпляр метода теста с приоритетом
public @interface MyTest {
    // 1 - 4
    int priority() default 4;
}
