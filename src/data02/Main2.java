package data02;

public class Main2 {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        System.out.println(stack);
        System.out.println("是否为空" + stack.isEmpty());
        stack.phsh("aaa");
        stack.phsh("bbb");
        stack.phsh("ccc");
        System.out.println(stack);
        stack.pop();//弹出一个
        stack.pop();//弹出一个
        System.out.println(stack);
    }
}
