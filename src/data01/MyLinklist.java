package data01;

public class MyLinklist {
    public Node head; //用来储存表的头部
    public Node tail; //用来储存表的尾部

    public MyLinklist() {
        head = new Node();//创建头节点
        head.value = null;//头节点不存放数据
        head.next = null; //刚开始下一个节点为空
        tail = head; //刚开始头尾为空
    }

    //判断链表是否为空 turn--链表为空  false--链表有数据
    public boolean isEmpty() {
        if (head.next == null) {
            return true;
        }
        return false;
    }

    //添加元素--添加到尾部
    public void add(String str) {
        Node newNode = new Node(); //创建一个新的节点
        newNode.value = str;
        if (isEmpty()) {
            head.next = newNode; //头节点指向新的节点
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    //获取第i个元素
    public String getNode(int i) {
        Node node = head.next;
        int index = 0;
        while (node != null) {
            if (index == 1) {
                return node.value;
            }
            node = node.next;
            index++;
        }
        return null;
    }

    //返回链表的长度
    public int length() {
        int count = 0;
        Node node = head.next;
        while (node != null) {
            count++; //每个元素+1
            node = node.next;
        }
        return count + 1;
    }

    //删除链表数据
    public void remove(int i) {
        //链表为空时返回-1
        if (isEmpty()) {
            return;
        }
        //遍历的索引，这次从-1开始
        int index = -1;
        Node node = head;
        while (node != null) {
            if (index == (i - 1)) {
                Node target = node.next;
                // 用下下一个节点覆盖下一个节点
                node.next = node.next.next;
            }
            node = node.next;
            index++;
        }
    }

    public void show() {
        int count = 0;
        Node node = head.next;
        while (node != null) {
            count++; //每个元素+1
            System.out.print("第" + count + "元素:" + node.value + ",");
            node = node.next;
        }
        System.out.println();
    }


    @Override
    public String toString() {
        return "Nodelist{" +
                "head=" + head +
                ", tail=" + tail +
                '}';
    }
}
