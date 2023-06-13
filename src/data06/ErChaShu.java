package data06;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 树形结构,二叉树；
 */
public class ErChaShu {
    public static void main(String[] args) {
        ErChaShu01 erChaShu01 = new ErChaShu01(0);
        erChaShu01.leftChild = new ErChaShu01(1);
        erChaShu01.rightChild = new ErChaShu01(2);
        erChaShu01.leftChild.leftChild = new ErChaShu01(3);
        erChaShu01.leftChild.leftChild.leftChild = new ErChaShu01(7);
        erChaShu01.leftChild.leftChild.rightChild = new ErChaShu01(8);
        erChaShu01.leftChild.rightChild = new ErChaShu01(4);
        erChaShu01.leftChild.rightChild.leftChild = new ErChaShu01(9);
        erChaShu01.rightChild.leftChild = new ErChaShu01(5);
        erChaShu01.rightChild.rightChild = new ErChaShu01(6);
        System.out.println(erChaShu01);
        show(erChaShu01);
        System.out.println("先序遍历二叉树：");
        preOrder(erChaShu01);
        System.out.println("\n中序遍历二叉树：");
        inOrder(erChaShu01);
        System.out.println("\n后序遍历二叉树：");
        lastOrder(erChaShu01);
        System.out.println("\n二叉树节点：");
        leaf(erChaShu01);
        System.out.println("\n所有叶子节点的个数：" + leafCount(erChaShu01));
        System.out.println("书的高度：" + erChashuHigh(erChaShu01));
        System.out.println("树节点的总数：" + countChaShu01(erChaShu01));
        int[] a = {23, 5, 17, 4, 9, 31, 29, 18};
        ErChaShu01 root = createHuffmanTree(a);
        show(root);
    }

    public static ErChaShu01 createHuffmanTree(int[] arr) {
        List<ErChaShu01> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new ErChaShu01(arr[i]));
        }
        while (list.size() > 1) {
            Collections.sort(list);
            ErChaShu01 minNode = list.get(0);
            ErChaShu01 secondMinNode = list.get(1);
            ErChaShu01 parentNode = new ErChaShu01(minNode.data + secondMinNode.data);
            parentNode.leftChild = minNode;
            parentNode.rightChild = secondMinNode;
            list.remove(minNode);
            list.remove(secondMinNode);
            list.add(parentNode);

        }
        return list.get(0);
    }

    //打印二叉树
    private static void writeArray(ErChaShu01 currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.data);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.leftChild != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.leftChild, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.rightChild != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.rightChild, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }

    public static void show(ErChaShu01 erChaShu01) {
        if (erChaShu01 == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(erChaShu01);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(erChaShu01, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    // 用于获得树的层数
    public static int getTreeDepth(ErChaShu01 erChaShu01) {
        return erChaShu01 == null ? 0 : (1 + Math.max(getTreeDepth(erChaShu01.leftChild), getTreeDepth(erChaShu01.rightChild)));
    }

    //先序遍历
    public static void preOrder(ErChaShu01 erChaShu01) {
        if (erChaShu01 == null) {
            return;
        }
        System.out.print(erChaShu01.data + "  "); //先打印根节点
        preOrder(erChaShu01.leftChild); //递归打印左子树
        preOrder(erChaShu01.rightChild); //递归打印右子树
    }

    //中序遍历
    private static void inOrder(ErChaShu01 erChaShu01) {
        if (erChaShu01 == null) {
            return;
        }
        inOrder(erChaShu01.leftChild); //递归打印左子树
        System.out.print(erChaShu01.data + "  "); //先打印根节点
        inOrder(erChaShu01.rightChild); //递归打印右子树
    }

    //后序遍历
    private static void lastOrder(ErChaShu01 erChaShu01) {
        if (erChaShu01 == null) {
            return;
        }
        lastOrder(erChaShu01.leftChild); //递归打印左子树
        lastOrder(erChaShu01.rightChild); //递归打印右子树
        System.out.print(erChaShu01.data + "  "); //先打印根节点
    }

    //二叉树节点算法
    private static void leaf(ErChaShu01 erChaShu01) {
        if (erChaShu01 == null) {
            return;
        }
        if (erChaShu01.leftChild == null && erChaShu01.rightChild == null) {
            System.out.print(erChaShu01.data + "  ");
        }
        leaf(erChaShu01.leftChild);
        leaf(erChaShu01.rightChild);
    }

    //统计二叉树中叶子节点的个数--递归调用
    public static int leafCount(ErChaShu01 erChaShu01) {
        if (erChaShu01 == null) {
            return 1;
        }
        if (erChaShu01.leftChild == null && erChaShu01.rightChild == null) {
            return 1;
        } else {
            return leafCount(erChaShu01.leftChild) + leafCount(erChaShu01.rightChild);
        }
    }

    //求二叉树的高度
    public static int erChashuHigh(ErChaShu01 erChaShu01) {
        int lhigh = 0;
        int rhigh = 0;
        if (erChaShu01 == null) {
            return 0;
        }
        lhigh = erChashuHigh(erChaShu01.leftChild);
        rhigh = erChashuHigh(erChaShu01.rightChild);
        if (lhigh == rhigh) {
            return lhigh + 1;
        } else {
            return rhigh + 1;
        }
    }

    //统计所有节点总数
    static int count = 0;

    private static int countChaShu01(ErChaShu01 erChaShu01) {
        if (erChaShu01 == null) {
            return 0;
        }
        count++;
        countChaShu01(erChaShu01.leftChild);
        countChaShu01(erChaShu01.rightChild);
        return count;
    }

    //创建初始化
    public static class ErChaShu01 implements Comparable<ErChaShu01> {

        private int data;
        private ErChaShu01 leftChild;
        private ErChaShu01 rightChild;

        public ErChaShu01(int date) {
            this.data = date;
        }

        @Override
        public String toString() {
            return "ErChaShu01{" +
                    "data=" + data +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }

        @Override
        public int compareTo(ErChaShu01 o) {
            return this.data - o.data;
        }
    }
}

