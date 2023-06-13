package data02;

public class Main {
    public static void main(String[] args) {
        MyArrayStack stack = new MyArrayStack(4);
        System.out.println(stack);
        System.out.println("栈是否满了？" + stack.isFull());
        System.out.println("栈是否为空？" + stack.isFull());
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);
        System.out.println(stack);
        System.out.println("出栈的元素：" + stack.php());
        System.out.println("出栈的元素：" + stack.php());
        System.out.println("出栈的元素：" + stack.php());
        System.out.println(stack);
        System.out.println("此时栈顶的元素：" + stack.getTopValue());

    }
}
