/*
 * метод с аннотацией @AfterSuite, запускается по завершению всех тестов
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

public @interface AfterSuite {
}
