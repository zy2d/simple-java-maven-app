package com.mycompany.app;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Java功能演示程序
 */
public class App {

    private static final String MESSAGE = "Hello World!";
    
    private static final String LOGO = 
        "    _                   ____                      \n" +
        "   (_) __ ___   ____ _|  _ \\ ___ _ __ ___   ___  \n" +
        "   | |/ _` \\ \\ / / _` | |_) / _ \\ '_ ` _ \\ / _ \\ \n" +
        "   | | (_| |\\ V / (_| |  _ <  __/ | | | | | (_) |\n" +
        "  _/ |\\__,_| \\_/ \\__,_|_| \\_\\___|_| |_| |_|\\___/ \n" +
        " |__/                                             \n";

    public App() {}

    public static void main(String[] args) {
        // 显示LOGO
        System.out.println(LOGO);
        System.out.println(MESSAGE);
        
        // 演示各种Java功能
        demoDateTime();
        demoCollections();
        demoStringOperations();
        demoMathOperations();
    }

    public String getMessage() {
        return MESSAGE;
    }

    // 日期时间操作演示
    private static void demoDateTime() {
        System.out.println("\n=== 日期时间操作演示 ===");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间: " + now.format(formatter));
    }

    // 集合操作演示
    private static void demoCollections() {
        System.out.println("\n=== 集合操作演示 ===");
        
        // List演示
        List<String> list = new ArrayList<>();
        list.add("苹果");
        list.add("香蕉");
        list.add("橙子");
        System.out.println("List内容: " + list);
        
        // Set演示
        Set<String> set = new HashSet<>();
        set.add("红色");
        set.add("蓝色");
        set.add("红色"); // 重复元素不会被添加
        System.out.println("Set内容: " + set);
        
        // Map演示
        Map<String, Integer> map = new HashMap<>();
        map.put("张三", 25);
        map.put("李四", 30);
        System.out.println("Map内容: " + map);
    }

    // 字符串操作演示
    private static void demoStringOperations() {
        System.out.println("\n=== 字符串操作演示 ===");
        String text = "  Hello Java World  ";
        System.out.println("原始字符串: [" + text + "]");
        System.out.println("去除空格后: [" + text.trim() + "]");
        System.out.println("大写转换: " + text.toUpperCase());
        System.out.println("替换后: " + text.replace("Java", "我的"));
    }

    // 数学运算演示
    private static void demoMathOperations() {
        System.out.println("\n=== 数学运算演示 ===");
        System.out.println("随机数(0-100): " + (int)(Math.random() * 100));
        System.out.println("π值: " + Math.PI);
        System.out.println("e值: " + Math.E);
        System.out.println("2的3次方: " + Math.pow(2, 3));
        System.out.println("9的平方根: " + Math.sqrt(9));
    }
}
