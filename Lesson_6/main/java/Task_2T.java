public class Task_2T {

    // Тоже самое задание только с параметром boolean в классе для
    // возвращения true/false в boolean значении
    public static boolean Task_2t(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4)
                return false;
        }
        return true;
    }
}
