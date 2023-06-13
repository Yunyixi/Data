package zhan;

public class ZhanDeno {
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        System.out.println(fun(4));
        System.out.println(fun01(30));
        Long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end - begin) + "毫秒");
    }

    //递归，自己调用自己
    public static int fun(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * fun(n = n - 1);
        }
    }

    //求斐波那契数列的第n项
    public static Long fun01(int n1) {
        if (n1 == 1 || n1 == 2) {
            return 1L;
        } else {
            return fun01(n1 - 1) + fun01(n1 - 2);
        }
    }
}

