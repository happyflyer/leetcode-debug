package org.example.exam.shenxinfu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ip地址拼接
 * <p>
 * 输入：
 * ["192.168.0.1", "192.168.0.12-192.168.0.15", "192.168.0.2", "192.168.0.7-192.168.0.9", "192.168.0.11", "192.168.0.3-192.168.0.5", "192.168.0.16", "192.168.0.100"]
 * 输出：
 * ["192.168.0.1-192.168.0.5","192.168.0.7-192.168.0.9","192.168.0.11-192.168.0.16","192.168.0.100"]
 * <p>
 * 输入：
 * ["192.168.0.1", "192.168.0.12-192.168.0.15", "192.168.0.2", "192.168.0.7-192.168.0.9", "192.168.0.11", "192.168.0.3-192.168.0.5", "0.0.0.0-255.255.255.255","192.168.0.16", "192.168.0.100"]
 * 输出：
 * ["0.0.0.0-255.255.255.255"]
 * <p>
 * 输入：
 * ["192.168.1.1","192.168.1.2","92.168.20.3-92.168.20.3"]
 * 输出：
 * ["92.168.20.3","192.168.1.1-192.168.1.2"]
 * <p>
 * 通过：9.09%
 *
 * @author lifei
 */
public class Solution2 {
    public ArrayList<String> merge(ArrayList<String> input) {
        ArrayList<String> padding = new ArrayList<>();
        for (String s : input) {
            if (s.contains("-")) {
                String[] split = s.split("-");
                padding.add(padding0(split[0]) + "-" + padding0(split[1]));
            } else {
                padding.add(padding0(s));
            }
        }
        Collections.sort(padding);
        System.out.println(padding);
        ArrayList<String> filter = new ArrayList<>();
        String prev = padding.get(0);
        String[] split1 = prev.split("-");
        String prevStart = split1[0];
        String prevEnd = split1.length > 1 ? split1[1] : split1[0];
        for (int i = 1; i < padding.size(); i++) {
            String[] split = padding.get(i).split("-");
            String start = split[0];
            String end = split.length > 1 ? split[1] : split[0];
            // 必然有 prevStart<=start
            if (start.compareTo(prevEnd) <= 0) {
                if (end.compareTo(prevEnd) > 0) {
                    prevEnd = end;
                }
            } else if (Integer.parseInt(start.split("\\.")[3]) - Integer.parseInt(prevEnd.split("\\.")[3]) == 1) {
                prevEnd = end;
            } else {
                if (prevStart.compareTo(prevEnd) == 0) {
                    filter.add(prevStart);
                } else {
                    filter.add(prevStart + "-" + prevEnd);
                }
                prevStart = start;
                prevEnd = end;
            }
        }
        // 最后一项
        if (prevStart.compareTo(prevEnd) == 0) {
            filter.add(prevStart);
        } else {
            filter.add(prevStart + "-" + prevEnd);
        }
        ArrayList<String> remove = new ArrayList<>();
        for (String s : filter) {
            if (s.contains("-")) {
                String[] split = s.split("-");
                remove.add(remove0(split[0]) + "-" + remove0(split[1]));
            } else {
                remove.add(remove0(s));
            }
        }
        return remove;
    }

    private String padding0(String ip) {
        String[] split = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(".");
            if (s.length() == 1) {
                sb.append("00");
            } else if (s.length() == 2) {
                sb.append("0");
            }
            sb.append(s);
        }
        return sb.substring(1);
    }

    private String remove0(String ip) {
        String[] split = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(".");
            sb.append(Integer.parseInt(s));
        }
        return sb.substring(1);
    }

    public static void main(String[] args) {
        String[] arr = new String[]{
                // "192.168.0.1", "192.168.0.12-192.168.0.15", "192.168.0.2", "192.168.0.7-192.168.0.9", "192.168.0.11", "192.168.0.3-192.168.0.5", "192.168.0.16", "192.168.0.100"
                // "192.168.0.1", "192.168.0.12-192.168.0.15", "192.168.0.2", "192.168.0.7-192.168.0.9", "192.168.0.11", "192.168.0.3-192.168.0.5", "0.0.0.0-255.255.255.255", "192.168.0.16", "192.168.0.100"
                "192.168.1.1", "192.168.1.2", "92.168.20.3-92.168.20.3"
        };
        ArrayList<String> input = new ArrayList<>(arr.length);
        input.addAll(Arrays.asList(arr));
        System.out.println(
                new Solution2().merge(input)
        );
        String[] arr2 = new String[]{
                // "192.168.0.1-192.168.0.5", "192.168.0.7-192.168.0.9", "192.168.0.11-192.168.0.16", "192.168.0.100"
                // "0.0.0.0-255.255.255.255"
                "92.168.20.3", "192.168.1.1-192.168.1.2"
        };
        System.out.println(Arrays.toString(arr2));
    }
}
