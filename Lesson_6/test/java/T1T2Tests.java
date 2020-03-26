import org.junit.Assert;
import org.junit.Test;

public class T1T2Tests {

    @Test
    public void Task_1_Test_1() {
        int[] resultArray = Task_1T.Task_1t(new int[]{1, 7});
        int[] expectedArray = new int[]{4, 6, 2};
        Assert.assertArrayEquals(resultArray, expectedArray);
    }

    @Test
    public void Task_1_Test_2() {
        int[] resultArray = Task_1T.Task_1t(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7});
        int[] expectedArray = new int[]{1, 7};
        Assert.assertArrayEquals(resultArray, expectedArray);
    }

    @Test
    public void Task_1_Test_3() {
        int[] resultArray = Task_1T.Task_1t(new int[]{1, 9, 9, 6});
        int[] expectedArray = new int[]{1, 9, 9, 6};
        Assert.assertArrayEquals(resultArray, expectedArray);
    }

    // Тесты второго задания

    @Test
    public void Task_2_Test_1() {
        int[] arr = {3, 2, 5, 7};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                System.out.println(false);
            } else {
                System.out.println(true);
            }
        }
    }

    @Test
    public void Task_2_Test_2() {
        int[] arr = {1, 4};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                System.out.println(false);
            } else {
                System.out.println(true);
            }
        }
    }

    @Test
    public void Task_2_Test_3() {
        int[] arr = {4, 1, 4, 1, 4, 1, 1, 4};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1 && arr[i] != 4) {
                System.out.println(false);
            } else {
                System.out.println(true);
            }
        }
    }
}
