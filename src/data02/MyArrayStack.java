package data02;

import java.util.Arrays;

public class MyArrayStack {
    private int[] stack; //数组，数组模拟栈，数据就放在该数组
    private int top = -1; //top 表示 栈顶，初始化为-1

    public MyArrayStack(int maxSise) {
        stack = new int[maxSise]; //创建一个数据，大小是传进来的
    }

    //栈满了---trun    不满---false
    public boolean isFull() {
        if (top == stack.length - 1) {
            return true;
        }
        return false;
    }

    //栈空---trun    不空---false
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }


    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了，添加失败");
            return;
        }
        top++;
        stack[top] = value;
    }

    //取栈点元素
    public int getTopValue() {
        if (isEmpty()) {
            System.out.println("栈空，没有栈顶元素");
            return -1;
        }
        return stack[top];
    }

    //出栈
    public int php() {
        if (isEmpty()) {
            System.out.println("栈空,无法弹出元素");
            return -1;
        }
        int vlue = stack[top]; //栈顶的值先保存起来
        stack[top] = 0; //栈顶清零，栈顶为空
        top--;
        return vlue;
    }

    @Override
    public String toString() {
        return "MyArrayStack{" +
                "stack=" + Arrays.toString(stack) +
                ", top=" + top +
                '}';
    }
}
