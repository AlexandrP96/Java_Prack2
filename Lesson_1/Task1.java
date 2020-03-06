import java.util.Arrays;
/*
 * alexbox726@gmail.com
 */
// 1. Написать метод, который меняет два элемента массива местами
public class Task1 {
    public static void main(String[] args) {
        // Создаём массив типа данных Integer
        Integer[] Numb = new Integer[5];
        // Вкладываем числовые значения в каждый элемент
          Numb[0] = 1;
          Numb[1] = 2;
          Numb[2] = 3;
          Numb[3] = 4;
          Numb[4] = 5;
        // Выводим оригинальные значения массива в консоль
        System.out.println(Arrays.deepToString(Numb));
        // Используем метод SwapInt на массиве
        SwapInt(Numb);
        // Выводим готовый результат в консоль
        System.out.println(Arrays.deepToString(Numb));
    }
    // Метод SwapInt который меняет местами элементы в массиве
    private static void SwapInt(Object[] array) {
        Object tempo = array[0];
        array[0] = array[1];
        array[1] = array[2];
        array[2] = array[3];
        array[3] = array[4];
        array[4] = tempo;
    }
}
