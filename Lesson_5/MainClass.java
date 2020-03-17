/*
* При выполнения дз было примененно средство синхронизации Semaphore
* Та же был применён класс CountDownLatch, для самоблокировки потоков с помощью счетчика
* Метод определения победителя не реализован
*/
package HW2_5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class MainClass {
    private static final int CARS_COUNT = 4;
    // Разрешение количества машин
    static Semaphore tunnel = new Semaphore(CARS_COUNT/2,true);
    static CountDownLatch start = new CountDownLatch(CARS_COUNT);
    static CountDownLatch finish = new CountDownLatch(CARS_COUNT);

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(80), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        // Стартуем по готовности всех автомобилей
        while (start.getCount() > 0)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            // Если все машины финишировали - выводим сообщение
        while (finish.getCount() > 0)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
