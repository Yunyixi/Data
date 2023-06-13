package data01;

public class Main {
    public static void main(String[] args) {
        MyLinklist linklist = new MyLinklist();
        System.out.println(linklist.isEmpty());
        linklist.add("aaaa");
        linklist.add("bbbb");
        linklist.add("cccc");
        System.out.println(linklist);
        System.out.println("长度：" + linklist.length());
        System.out.println(linklist.getNode(2));
        linklist.show();
        linklist.remove(2);
        linklist.remove(1);
        linklist.show();
    }
}
