/*
* 1 Часть ДЗ 4 Урока
* Задание сделанно по примеру из Вебинара
*/
package TimerThread;

public class HomeWork4Threads {
    // Видимое значение для всех потоков
    static volatile int VolNum = 1;
    static final int numb = 5;
    // Создаём новый монитор
    static final Object shared = new Object();

    public static void main(String[] args) {
        // Изначально пытался реализовать таким образом
//        Thread thread1 = new Thread();
//        Thread thread2 = new Thread();
//        Thread thread3 = new Thread();


        // Создаём первый поток
        new Thread(() -> {
            try {
                for (int i = 0; i < numb; i++) {
                    synchronized (shared) {
                        // Цикл условия защищающий от случайного пробуждения потока
                        while (VolNum != 1) {
                            shared.wait();
                        }
                        System.out.print("A");
                        VolNum = 2;
                        // Пробуждает все ждущие потоки
                        shared.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Запускаем поток
        }).start();
        // Второй поток
        new Thread(() -> {
            try {
                for (int i = 0; i < numb; i++) {
                    synchronized (shared) {
                        while (VolNum != 2) {
                            shared.wait();
                        }
                        System.out.print("B");
                        VolNum = 3;
                        shared.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Запускаем поток
        }).start();
        // Третий поток
        new Thread(() -> {
            try {
                for (int i = 0; i < numb; i++) {
                    synchronized (shared) {
                        while (VolNum != 3) {
                            shared.wait();
                        }
                        System.out.print("C");
                        VolNum = 1;
                        shared.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Запускаем поток
        }).start();
    }
}
