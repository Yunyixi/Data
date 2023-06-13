package data02;

public class LinkedListStack {
    Node head = new Node(); //头指针

    //判断栈空 栈空--trun 栈不空--false
    public boolean isEmpty() {
        if (head.next == null) {
            return true;
        }
        return false;
    }

    //入栈
    public void phsh(String data) {
        Node newNode = new Node();
        newNode.date = data;
        newNode.next = head.next;
        head.next = newNode;
    }

    //出栈
    public void pop() {
        //判断栈空
        if (isEmpty()) {
            throw new RuntimeException("栈空,没有数据");
        }
        head.next = head.next.next;
    }

    @Override
    public String toString() {
        return "LinkedListStack{" +
                "head=" + head +
                '}';
    }
}
