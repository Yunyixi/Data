package data02;

public class Node {
    String date;
    Node next;

    @Override
    public String toString() {
        return "Node{" +
                "date='" + date + '\'' +
                ", next=" + next +
                '}';
    }
}
