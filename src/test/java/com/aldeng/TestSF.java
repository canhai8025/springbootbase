package com.aldeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestSF {
    private static String BLANK = " ";

    private static String STAR = "*";

    public static void main(String[] args) {
        test97();
//        test98();
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int value = scanner.nextInt();
//            String ans = getAns(value);
//            System.out.println(ans);
//        }
//        test99();
    }
    /*【工号不够用了怎么办？】3020年，空间通信集团的员工人数突破20亿人，即将遇到现有工号不够用的窘境。
    现在，请你负责调研新工号系统。继承历史传统，新的工号系统由小写英文字母（a-z）和数字（0-9）两部分构成。新工号由一段英文字母开头，之后跟随一段数
    字，比如"aaahw0001","a12345","abcd1","a00"。注意新工号不能全为字母或者数字,允许数字部分有前导0或者全为0。
    但是过长的工号会增加同事们的记忆成本，现在给出新工号至少需要分配的人数X和新工号中字母的长度Y，求新工号中数字的最短长度Z*/
    public static void test97() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        if (parts.length < 2) {
            return;
        }
        long X = Long.parseLong(parts[0]);
        int Y = Integer.parseInt(parts[1]);
        long Z = (long) (Math.pow(26, Y) + 0.0001) * 10;
        int count = 1;
        while (Z < X) {
            count++;
            Z = Z * 10;
        }
        System.out.println("新工号中数字的最短长度Z:"+count);
    }
    /*【数组组成的最小数字】
    给定一个整型数组，请从该数组中选择3个元素组成最小数字并输出（如果数组长度小于3，则选择数组中所有元素来组成最小数字）。*/
    public static void test98() {
        Scanner in = new Scanner(System.in);
        List<String> tmp = Arrays.asList(in.nextLine().trim().split("\\,"));
        ArrayList<String> array = new ArrayList<>(tmp);
        array.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });
        String res = "";
        while (array.size() > 3) {
            array.remove(array.size() - 1);
        }
        array.sort((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            int min_len = Math.min(o1.length(), o2.length());
            for (int i = 0; i < min_len; i++) {
                if (o1.charAt(i) != o2.charAt(i)) {
                    return o1.charAt(i) - o2.charAt(i);
                }
            }
            return o1.length() < o2.length() ? -1 : 1;
        });
        for (int i = 0; i < array.size(); i++) {
            res += array.get(i);
        }
        System.out.println(res);
    }

    /*【数字反转打印】
    小华是个很有对数字很敏感的小朋友，他觉得数字的不同排列方式有特殊美感。某天，小华突发奇想，如果数字多行排列，第一行1个数，第二行2个，第三行3个，
    即第n行有n个数字，并且奇数行正序排列，偶数行逆序排列，数字依次累加。这样排列的数字一定很有意思。聪明的你能编写代码帮助小华完成这个想法吗？
    规则总结如下：
    a、每个数字占据4个位置，不足四位用‘*’补位，如1打印为1***。
    b、数字之间相邻4空格。
    c、数字的打印顺序按照正序逆序交替打印,奇数行正序，偶数行逆序。
    d、最后一行数字顶格，第n-1行相对第n行缩进四个空格*/
    private static String getAns(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int row = 1; row <= num; row++) {
            int min = count + 1;
            count = count + row;
            for (int i = 1; i <= (num - row)*4; i++) {
                stringBuilder.append(BLANK);
            }
            if (row % 2 == 1) {
                for (int i = min; i <= count; i++) {
                    stringBuilder.append(supply(i)).append(BLANK);
                }
            } else {
                for (int i = count; i >= min; i--) {
                    stringBuilder.append(supply(i)).append(BLANK);
                }
            }
            if (row < num) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }

    private static String supply(int num) {
        if (num < 10) {
            return num + STAR + STAR + STAR;
        } else if (num < 100) {
            return num + STAR + STAR;
        } else if (num < 1000) {
            return num + STAR;
        }
        return Integer.valueOf(num).toString();
    }

    /*【判断字符串子序列】给定字符串 target和 source, 判断 target 是否为 source 的子序列。
    你可以认为 target 和 source 中仅包含英文小写字母。字符串 source可能会很长（长度 ~= 500,000），而 target 是个短字符串（长度 <=100）。
    字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"abc"是"aebycd"的一个子序列，
    而"ayb"不是）。*/
    public static void test99() {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        String source = scanner.nextLine();
//        String target = "dh";
//        String source = "aldohou";
        int i = target.length() - 1;
        int j = source.length() - 1;
        int index = -1;
        while (i >= 0) {
            index = 1;
            while (j >= 0) {
                if (target.charAt(i) == source.charAt(j)) {
                    index = j;
                    j--;
                    break;
                } else {
                    index = j;
                    j--;
                    continue;
                }
            }
            i--;
        }
        System.out.println("最后一个子序列的起始位置:"+index);
    }
}
