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

    // 文件操作演示
    // private static void demoFileOperations() {
    //     System.out.println("\n=== 文件操作演示 ===");
    //     String filePath = "example.txt";
    //     try {
    //         // 创建文件
    //         File file = new File(filePath);
    //         if (file.createNewFile()) {
    //             System.out.println("文件创建成功: " + filePath);
    //         } else {
    //             System.out.println("文件已存在: " + filePath);
    //         }

    //         // 写入内容
    //         FileWriter writer = new FileWriter(file);
    //         writer.write("Hello, Java!");
    //         writer.close();

    //         // 读取内容
    //         BufferedReader reader = new BufferedReader(new FileReader(file));
    //         String line;
    //         System.out.println("文件内容:");
    //         while ((line = reader.readLine()) != null) {
    //             System.out.println(line);
    //         }
    //         reader.close();
    //     } catch (IOException e) {
    //         System.out.println("文件操作失败: " + e.getMessage());
    //     }
    // }
    // 网络操作演示
    private static void demoNetworkOperations() {
        System.out.println("\n=== 网络操作演示 ===");
        try {
            URL url = new URL("https://www.baidu.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            System.out.println("响应码: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            System.out.println("网页内容:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("网络操作失败: " + e.getMessage());
        }
    }
}
