package date08;

/**
 * 第八章查找
 * 任务：手机短信的内容电话号码提取
 */
public class Demo {
    public static void main(String[] args) {
        //模拟短信内容
        search();
        search01(); //优化后
    }

    public static void search() {
        String str = "看到信息速来柳职院食堂吃饭,电话19102581793";
        int count = 0;
        String phone = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;
                phone = phone + str.charAt(i);
            }
            System.out.print(str.charAt(i));
        }
        System.out.println("\n数字的个数：" + count);
        if (count == 11) {
            System.out.println("电话号码为：" + phone);
        }
    }

    //优化
    public static void search01() {
        String str = "6月9好中午12点，看到信息速来柳职院食堂吃饭,电话19102581793";
        int count = 0;
        String phone = "";
        int front = -1;
        for (int i = 0; i < str.length(); i++) {
            if (count == 11) { //找到一个号码
                break;
            }

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                System.out.println("是数字：" + str.charAt(i));
                if (front == -1) { //刚开始的第一个数字
                    count++;
                    phone = phone + str.charAt(i);
                } else if ((i - 1) == front) { //判断连续数字串
                    count++;
                    phone = phone + str.charAt(i);
                }
                front = i;
            } else {
                System.out.println("不是数字，不是电话号码");
                count = 0;
                front = -1; //保存前一个数字的位置
                phone = "";
            }
            System.out.println("此时，front=" + front + ",count=" + count + ",phone=" + phone);
        }
        System.out.println("\n数字的个数：" + count);
        if (count == 11) {
            String regex = "1[3-9]\\d{9}";
            if (phone.matches(regex)) {
                System.out.println("确认是电话号码，号码为：" + phone);
            } else {
                System.out.println("找到11位的数字串,但不是电话号码");
            }
        }
    }
}
