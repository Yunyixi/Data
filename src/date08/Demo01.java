package date08;

import java.util.Scanner;

/**
 * 二分法查找
 */

public class Demo01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("是否开始：y/n");
        String str = scanner.next();
        while (scanner.next() == "y") {
            int[] arr = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
            for (int i = 0; i < arr.length; i++) {
                int value = arr[i];
                System.out.print(value + " ");
            }
            System.out.print("\n你要查询数的下标：");

            int key = scanner.nextInt();
            int index = search00(arr, key);//二分查找--非递归调用
            if (index == -1) {
                System.out.println("没有找到数据");
            } else {
                System.out.println("找到了，数组下标：" + index);
            }

            int index1 = search01(arr, key, 0, arr.length - 1);//二分查找--递归调用
            if (index1 == -1) {
                System.out.println("没有找到数据 -1");
            } else {
                System.out.println("找到了，数组下标：" + index1);
            }
        }
    }

    //实现方法，二分查找--非递归 从数组a里面查询 kry
    public static int search00(int[] arr, int key) {
        int mid = 0;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) { //要查找的数刚好在中间，那就直接返回
                // System.out.println("找到了，数组下标：" + mid);
                return mid;
            } else if (key < arr[mid]) { //要找的数比较小，在左半边
                high = mid - 1;
            } else {//要找的数比较大，在右半边
                low = mid + 1;
            }
        }
        return -1;
    }

    //二分查找--递归调用
    public static int search01(int[] arr, int key, int low, int high) {
        int mid = 0;
        if (low <= high) {
            mid = (low + high) / 2;
            if (key == arr[mid]) { //要查找的数刚好在中间，那就直接返回
                return mid;
            } else if (key < arr[mid]) { //要找的数比较小，在左半边
                return search01(arr, key, low, mid - 1);
            } else {//要找的数比较大，在右半边
                return search01(arr, key, mid + 1, high);
            }
        }
        return -1;
    }
}
