package data00;

import java.util.Objects;

public class LinearData01 {
    private int Defaulist = 3;
    private int size = 0;
    private LinearData00[] linearData00s;

    //在构造函数里面初始化数据
    public LinearData01() {
        linearData00s = new LinearData00[Defaulist];
    }

    public int length() {
        return linearData00s.length;
    }

    public void add(int index, LinearData00 linearData00) throws Exception {
        //添加范围0-size
        if (index < 0 || index > size) {
            System.out.println("添加错误");
            throw new Exception("异常");
        }
        //
        if (size == linearData00s.length) {
            grow();
        }

        if (index == size) {
            linearData00s[size] = linearData00;
        }
        for (int i = size - 1; i >= index; i--) {
            linearData00s[i + 1] = linearData00s[i];
        }
        linearData00s[index] = linearData00;
        size++;
    }

    public void add(LinearData00 linearData00) {
        if (size == linearData00s.length) {
            grow();
        }
        linearData00s[size] = linearData00;
        size++;
        System.out.println("添加成功，当前size=" + size);
    }

    public void grow() {
        System.out.println("开始扩容");
        LinearData00[] nemLLinearData00 = new LinearData00[linearData00s.length * 2];//扩容原身的两倍
        //返回更新数组
        for (int i = 0; i < linearData00s.length; i++) {
            nemLLinearData00[i] = linearData00s[i];
        }
        linearData00s = nemLLinearData00;
    }

    //按下标删除
    public void remove(int index) throws Exception {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            linearData00s[i] = linearData00s[i];
        }
        linearData00s[size - 1] = null;
        size--;
    }

    //按对象删除
    public void remove(LinearData00 linearData00) {
        //遍历获取数据
        for (int i = 0; i < size; i++) {
            if (Objects.equals(linearData00s[i], linearData00)) {
                if (i == size - 1) { //最后一个
                    linearData00s[i] = null;
                    size--;
                    break;
                }
                for (int j = i; j < size; j++) {
                    linearData00s[j] = linearData00s[j + 1];
                }
                size--;
                return;
            }
        }
    }

    public void checkIndex(int index) throws Exception {
        if (index < 0 || index >= size) {
            throw new Exception("index异常");
        }
        System.out.println("数据中有" + size + "条狗");
        return;
    }

    //打印输出对象内容
    public void show() {
        for (int i = 0; i < linearData00s.length; i++) {
            LinearData00 linearData00 = linearData00s[i];
            System.out.println("第" + (i + 1) + "个元素" + linearData00);
        }
    }
}
