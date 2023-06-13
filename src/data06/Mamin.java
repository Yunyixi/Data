package data06;

import java.util.Arrays;

public class Mamin { //八皇后问题
    static int allnum = 0;

    private static void dfs(int hindex, boolean[] hang, boolean[] lie, boolean[] zuoxie, boolean[] youxie, int[][] map) {
        if (hindex == 8) {
            allnum++;
            printmap(map); //打印输出map
        } else {
            //hindex为行  i为具体的某一列
            for (int i = 0; i < 8; i++) {
                if (!hang[hindex] && !lie[i] && !zuoxie[hindex + i] && !youxie[hindex + (7 - i)]) {
                    hang[hindex] = true; //试探，列举
                    lie[i] = true;
                    zuoxie[hindex + i] = true;
                    youxie[hindex + (7 - i)] = true;
                    map[hindex][i] = 1;
                    dfs(hindex + 1, hang, lie, zuoxie, youxie, map);//dfs
                    hang[hindex] = false; //还原
                    lie[i] = false;
                    zuoxie[hindex + i] = false;
                    youxie[hindex + (7 - i)] = false;
                    map[hindex][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        boolean hang[] = new boolean[8]; //行
        boolean lie[] = new boolean[8]; //列
        boolean zuoxie[] = new boolean[15]; //左斜杠
        boolean youxie[] = new boolean[15]; //右斜杠
        int map[][] = new int[8][8]; //地图
        dfs(0, hang, lie, zuoxie, youxie, map); //进行下去
    }

    private static void printmap(int[][] map) {
        System.out.println("第" + allnum + "个排列为");
        for (int a[] : map) {
            System.out.println(Arrays.toString(a));
        }
    }

}
