package chuan;

/**
 * 查找某字符在字符串出现位置
 */

public class ChuanDemo02 {
    static String string = "this is a test of java Come to an end";
    static String string01 = "this is a test of java 结束";
    static String key = "a";
    static int count = 0;
    static int count01 = 0;

    public static void main(String[] args) {
        /*string.indexOf(key); //搜索字符串出现的第一个位置
        string.substring(3); //字符串位置*/
        demo();
        System.out.println("----------------------------------------------");
        System.out.println("字符串：" + string01);
        jiansu(string01, key);
        System.out.println(key + " 所出现的次数：" + count);
    }


    public static void demo() {
        System.out.println("字符串：" + string);
        while (true) {
            if (string.indexOf(key) == -1) {
                break;
            }
            string = string.substring(string.indexOf(key) + key.length());
            System.out.println(key + " 截取后的字符串：" + string);
            count++;
        }
        System.out.println(key + " 所出现的次数：" + count);
    }

    public static void jiansu(String string01, String key) {
        if (string01.indexOf(key) == -1) {
            return;
        }
        string01 = string01.substring(string01.indexOf(key) + key.length());
        System.out.println("截取后的字符串：" + string01);
        count01++;
        jiansu(string01, key);
    }
}
