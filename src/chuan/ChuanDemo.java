package chuan;

/**
 * 查找某字符在字符串出现次数
 */

public class ChuanDemo {
    public static void main(String[] args) {
        String string = "this is a test of java";
        char aChar = 'a';
        int count = 0; //计数器
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == aChar) {
                count++;
            }
        }
        try {
            Thread.sleep(5000);//单位：毫秒
        } catch (Exception e) {
        }
        System.out.println(aChar + "出现的次数：" + count);
    }
}
