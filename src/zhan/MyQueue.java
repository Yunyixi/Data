package zhan;

import java.util.Arrays;

public class MyQueue {
    private int head; //队列的头
    private int tail; //队列尾
    private int[] arr; //数组存放数据，模拟队列

    public MyQueue() {
    }

    public MyQueue(int size) { //初始化数据大小
        arr = new int[size];
        head = -1; //指向队列头的哪一个部位
        tail = -1; //指向队列尾的位置（不是最后一个位置）
    }

    //判断 ，trun---队列，满了  false---队列没满
    public boolean isEmpty() {
        if (tail == head) {
            return true;
        }
        return false;
    }

    //判断 ，trun---队列，为空  false---队列不为空
    public boolean isfull() {
        if (tail == arr.length - 1) {
            return true;
        }
        return false;
    }

    //添加数据
    public void addQueue(int data) {
        if (isfull()) {
            System.out.println("队列已满，为能添加" + data);
            return;
        }
        tail++; //尾部++
        arr[tail] = data;
    }

    //
    public void goQueue() throws Exception {
        if (isEmpty()) {
            System.out.println("队列为空，不能出队");
            throw new Exception("空队列");
        }
        head++;
        System.out.println(arr[head] + ",这个数据出对");
        arr[head] = 0; //队列头出队以后，置空
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    
}
