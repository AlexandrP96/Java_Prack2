/*
 * ДЗ по 7 уроку
 */

package Lesson_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    // Статический метод start()  которому в качестве параметра передается или объект типа Class, или имя класса
    public static void start() throws InvocationTargetException, IllegalAccessException {
        Class<Tests> mt = Tests.class;
        Class<BeforeSuite> bs = BeforeSuite.class;
        Class<AfterSuite> as = AfterSuite.class;

        Method[] methodbs = bs.getDeclaredMethods();
        Method[] methodas = as.getDeclaredMethods();
        Method[] methods = mt.getDeclaredMethods();

        for (Method m : methods) {
            // Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                System.out.println(m.getAnnotation(BeforeSuite.class));
            }
            // Запущены методы с аннотациями @Test
            if (m.isAnnotationPresent(MyTest.class)) {
                System.out.println(m.getAnnotation(MyTest.class));
                // m.invoke(null);
            }
            // В конце запускается метод с аннотацией @AfterSuite
            if (m.isAnnotationPresent(AfterSuite.class)) {
                System.out.println(m.getAnnotation(AfterSuite.class));
            }
        }
    }

    public static void main (String[] args) {
        try {
            start();
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}