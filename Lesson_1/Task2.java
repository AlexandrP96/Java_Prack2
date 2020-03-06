import java.util.ArrayList;
import java.util.Arrays;

// 2. Написать метод, который преобразует массив в ArrayList;
public class Task2 {
    public static void main(String[] args) {
        // Создаём массив типа данных Integer
        Integer[] Numb = new Integer[5];
        // Выводим оригинальные значения массива в консоль
        System.out.println(Arrays.deepToString(Numb));
        // Используем метод SwitchArray на массиве
        SwitchArray(Numb);
        // Выводим готовый результат в консоль
        System.out.println(Arrays.toString(Numb));
    }
    // Метод SwitchArray который преобразует массив в ArrayList
    public static <T> ArrayList SwitchArray(T[] array) {
        return new ArrayList(Arrays.asList(array));
    }
}
