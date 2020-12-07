package com.example.java8inaction.examples;

import com.example.java8inaction.entity.Trader;
import com.example.java8inaction.entity.Transaction;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * @author: slm
 */
public class Demo3 {
    public static void main(String[] args) {
        // 1. 找出2011年发生的所有交易，并按交易额排序（从低到高）。
        Trader.transactions.stream().filter(t -> t.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);
        // 2. 交易员都在哪些不同的城市工作过？
        System.out.println("===================================");
        Trader.transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
        // 3. 查找所有来自于剑桥的交易员，并按姓名排序。
        System.out.println("===================================");
        Trader.transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getTrader).sorted(Comparator.comparing(Trader::getName)).map(Trader::getName).distinct().forEach(System.out::println);
        // 4. 返回所有交易员的姓名字符串，按字母顺序排序。
        System.out.println("===================================");
        String str = Trader.transactions.stream().map(Transaction::getTrader).sorted(Comparator.comparing(Trader::getName)).map(Trader::getName).collect(Collectors.joining(","));
        System.out.println("str = " + str);
        // 5. 有没有交易员是在米兰工作的？
        System.out.println("===================================");
        boolean result = Trader.transactions.stream().anyMatch(t -> "Milan".equals(t.getTrader().getCity()));
        System.out.println("result = " + result);
        // 6. 打印生活在剑桥的交易员的总交易额。
        System.out.println("===================================");
        Integer sum = Trader.transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity())).map(Transaction::getValue).reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        // 7. 所有交易中，最高的交易额是多少？
        System.out.println("===================================");
        Trader.transactions.stream().map(Transaction::getValue).max(Integer::compareTo).ifPresent(System.out::println);
        // 8. 找到交易额最小的交易。
        System.out.println("===================================");
        Trader.transactions.stream().map(Transaction::getValue).min(Integer::compareTo).ifPresent(System.out::println);

    }
}
