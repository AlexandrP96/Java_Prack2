package HW2_5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    //
    // private static Lock winner = new ReentrantLock();

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    String getName() {
        return name;
    }

    int getSpeed() {
        return speed;
    }

    Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            // указываем какой участник готовится
            System.out.println(this.name + " готовится");
            // Создаём счетчик
            Thread.sleep(500 + (int)(Math.random() * 800));
            MainClass.start.countDown();
            // Выводим имя готово участника
            System.out.println(this.name + " готов");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        // if (lock.winner) {
        //     System.out.println(this.name + "WIN");
        // }
    }
}
