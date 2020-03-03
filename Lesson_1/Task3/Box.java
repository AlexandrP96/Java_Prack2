/*
* Класс Box, в который можно складывать фрукты;
* Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
* Для хранения фруктов внутри коробки можно использовать ArrayList;
*/
package Lesson_1_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    // ArrayList в котором будем хранить экземпляры фруктов;
    public ArrayList<T> Fruits;

    public Box(T... Fruits) {
        this.Fruits = new ArrayList<>(Arrays.asList(Fruits));
    }
    // Метод который высчитывает вес коробки, зная количество фруктов и вес одного фрукта;
    public float getW() {
        if (Fruits.size() == 0) return 0;
        float weight = 0;
        for (T item: Fruits) weight += item.getW();
        return weight;
    }
    // Метод который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра;
    public boolean comp(Box box) {
        return this.getW() == box.getW();
    }
    // Метод, который позволяет пересыпать фрукты из текущей коробки в другую;
    // Пример работы данного метода (сначала создаём новую коробку с фруктами);
    // Box<Apple> box2 = new Box<>(apple1, apple2);
    // Переносим фрукты из одной коробки в другую;
    // box1.trn(box2);
    public void trn(Box<? super T> box) {
        box.Fruits.addAll(this.Fruits);
    }
    // Создаём экземпляры классов и выводим результат в консоль;
    public static void main(String[] args) {
        // Создаём два экземпляра Яблок;
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        // Создаём два экземпляра Апельсинов;
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        // Создаём "Коробки" которые наполняем фруктами;
        Box<Apple> box1 = new Box<>(apple1, apple2);
        Box<Orange> box2 = new Box<>(orange1, orange2);
        // Выводим результат boolean сравнения в консоль;
        System.out.println(box1.comp(box2));
        // Выводим вес коробок в консоль
        System.out.println(box1.getW());
        System.out.println(box2.getW());
    }
}
