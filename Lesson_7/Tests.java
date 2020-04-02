/*
 * Классы с наборами методов с аннотациями @Test
 * класс-тест
 */

package Lesson_7;

public class Tests {

    @BeforeSuite
    public void startT() {
        System.out.println("Стартуем");
    }
    // priority - приоритет класса с int значением
    @MyTest (priority = 3)
    public void Test_1() {
        System.out.println("Тест_1 с приоритетом 3");
    }

    @MyTest (priority = 0)
    public void Test_2() {
        System.out.println("Тест_2 с приоритетом 0");
    }

    @MyTest (priority = 1)
    public void Test_3() {
        System.out.println("Тест_3 с приоритетом 1");
    }

    @AfterSuite
    public void endT() {
        System.out.println("Заканчиваем");
    }
}
