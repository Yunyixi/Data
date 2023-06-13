package zhan;

public class Main {
    public static void main(String[] args) throws Exception {
        MyQueue myQueue = new MyQueue(5);
        System.out.println("队列是否为空：" + myQueue.isEmpty());
        System.out.println("队列是否为满了：" + myQueue.isfull());
        myQueue.addQueue(10);
        myQueue.addQueue(20);
        myQueue.addQueue(30);
        myQueue.addQueue(40);
        myQueue.addQueue(50);
        myQueue.addQueue(60);
        myQueue.addQueue(70);
        try {
            Thread.sleep(5000);//单位：毫秒
        } catch (Exception e) {
        }
        System.out.print("队列是否为空：" + myQueue.isEmpty() + "  ");
        System.out.println("队列是否为满了：" + myQueue.isfull());
        System.out.println(myQueue);
        myQueue.goQueue(); //出队一个数据
        myQueue.goQueue(); //出队一个数据
        System.out.println(myQueue);
    }
}
