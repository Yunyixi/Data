package data00;

public class Main {
    public static void main(String[] args) throws Exception {
        LinearData01 data = new LinearData01();
        System.out.println("线性长度：" + data.length());
        data.add(new LinearData00("su"));
        data.add(new LinearData00("yong"));
        data.add(new LinearData00("fa"));
        data.add(new LinearData00("fa"));
        data.add(3, new LinearData00("tu gou"));
        data.show();
        LinearData00 fafa = new LinearData00("fafa");
        data.add(fafa);
        //data.add(new LinearData00("fafa3333"));
        data.show();
        System.out.println("-----------------------------");
        data.remove(fafa);
        data.show();
    }
}

