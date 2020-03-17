package HW2_5;

public class Road extends Stage {

    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " закончил этап: " + description);
            // Добавленно условие по которому счетчик отключается
            if(this.length == 40) {
                // Счетчик отключается
                MainClass.finish.countDown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
