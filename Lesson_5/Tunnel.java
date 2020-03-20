package HW2_5;
/*
* класс CyclicBarrier применяем для ввода нескольких потоков в режим ожидания
* (не смог реализовать)
 */
import java.util.concurrent.BrokenBarrierException;

public class Tunnel extends Stage {
    // класс Tunnel был исправлен по типу Road
    // длина дороги теперь указывается в классе main
    Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                // Вызываем метод acquire для получения разрешение на старт этапа
                MainClass.tunnel.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                // через параметр выбивает ошибку MainClass.hold.wait(100);
                // MainClass.hold.await();
                // BrokenBarrierException относится к await | BrokenBarrierException
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // После завершения этапа освобождаем разрешение данное в начале условия
                // MainClass.hold.notifyAll();
                MainClass.tunnel.release();
                System.out.println(c.getName() + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
