package org.example.exam.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 输入：
 * 输出：
 *
 * @author lifei
 */
public class Solution2 {
    private static Map<String, List<String>> superToSub = new HashMap<>();
    private static Map<String, List<String>> clazzToObj = new HashMap<>();

    private static void buildTwoMap(int n, String[] words) {
        for (int i = 0; i < n; i++) {
            String cur = words[i];
            if (cur.contains("subClassOf")) {
                String[] split = cur.split("subClassOf");
                String sub = split[0].trim();
                String sup = split[1].trim();
                if (!superToSub.containsKey(sup)) {
                    List<String> list = new ArrayList<>();
                    list.add(sub);
                    superToSub.put(sup, list);
                } else {
                    superToSub.get(sup).add(sub);
                }
                if (!superToSub.containsKey(sub)) {
                    superToSub.put(sub, new ArrayList<>());
                }
            } else if (cur.contains("instanceOf")) {
                String[] split = cur.split("instanceOf");
                String obj = split[0].trim();
                String clazz = split[1].trim();
                if (!clazzToObj.containsKey(clazz)) {
                    List<String> list = new ArrayList<>();
                    list.add(obj);
                    clazzToObj.put(clazz, list);
                } else {
                    clazzToObj.get(clazz).add(obj);
                }
            }
        }
    }

    private static List<String> findInstance(String clazz) {
        List<String> res = new ArrayList<>();
        if (clazzToObj.containsKey(clazz)) {
            res.addAll(clazzToObj.get(clazz));
        }
        if (superToSub.containsKey(clazz)) {
            for (String sub : superToSub.get(clazz)) {
                res.addAll(findInstance(sub));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // sc.nextLine();
        // String[] words = new String[n];
        // String clazz = "";
        // int i = 0;
        // while (i < n) {
        //     words[i] = sc.nextLine();
        //     i++;
        // }
        // clazz = sc.next();

        int n = 12;
        String[] words = new String[]{
                "student subClassOf person",
                "teacher subClassOf person",
                "child subClassOf person",
                "person subClassOf animal",
                "Tom instanceOf student",
                "Mary instanceOf student",
                "Kim instanceOf person",
                "Sam1 instanceOf person",
                "Sam2 instanceOf teacher",
                "Sam3 instanceOf teacher",
                "Sam4 instanceOf child",
                "Sam5 instanceOf child",
        };
        String clazz = "child ";

        // 构建两个map
        buildTwoMap(n, words);
        System.out.println(superToSub);
        System.out.println(clazzToObj);

        // 字符串拼接
        StringBuilder sb = new StringBuilder();
        for (String obj : findInstance(clazz)) {
            sb.append(' ');
            sb.append(obj);
        }
        if (sb.length() > 1) {
            System.out.println(sb.substring(1));
        }
    }
}
