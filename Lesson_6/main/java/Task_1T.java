public class Task_1T {

    // Тоже самое первое задание только с передачей параметров в
    // названии класса
    public static int[] Task_1t(int[] arr) {
        // Новый нуловый массив
        int[] outNa = null;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                outNa = new int[arr.length - i - 1];
                for (int b = i + 1, a = 0; b < arr.length; b++, a++) {
                    if (arr[b] == 4) continue;
                    // Присваиваем
                    outNa[a] = arr[b];
                }
            }
        }
        return arr;
    }
}
