package data01;

public class Node {
    public String value; //节点储存的值---数据部分
    public Node next; //指向下一个节点

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", next=" + next +
                '}';
    }
}
