package houzm.game.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 付诸实践
 * 1.找出2011年所有交易，并按照交易额排序（从低到高）
 * 2.交易员都在那些不同的城市工作过
 * 3.查找所有来自于剑桥的交易员，按照字母顺序排序
 *
 */
public class PracticeApp {

    private static List<Transaction> transactions = new ArrayList<>();

    static {
        //初始化数据
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
    }

    public static void main(String[] args) {
        //1.找出2011年所有交易，并按照交易额排序（从低到高）
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        systemLog(collect);

        //2.交易员都在那些不同的城市工作过
        List<String> collect1 = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        systemLog(collect1);

        //3.查找所有来自于剑桥的交易员，按照字母顺序排序
        List<Trader> collect2 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equalsIgnoreCase("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        systemLog(collect2);

        //4.返回所有交易员的姓名字符串，按照字母顺序排序
        List<String> collect3 = transactions.parallelStream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .distinct()
                .sorted(String::compareTo).collect(Collectors.toList());
        systemLog(collect3);

        //5.有没有交易员是在米兰工作的
        Optional<Trader> milan = transactions.parallelStream()
                .map(Transaction::getTrader)
                .filter(t -> t.getCity().equalsIgnoreCase("Milan"))
                .findAny();
        milan.ifPresent(System.out::println);

        //6.打印生活在剑桥的交易员的所有交易额
        Integer cambridge = transactions.parallelStream()
                .filter(t -> t.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum); //简洁写法，代替了.reduce(0, (a, b) -> a + b)
        System.out.println(cambridge);

        //7.所有交易中最高交易额
        Optional<Integer> maxTrnsactionValue = transactions.parallelStream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        maxTrnsactionValue.ifPresent(System.out::println);

        //8.找到交易额最小的交易
        Optional<Transaction> minTranction = transactions.parallelStream().reduce((a, b) -> a.getValue() > b.getValue() ? b : a);
        minTranction.ifPresent(System.out::println);
    }

    private static <T> void systemLog(List<T> collect) {
        System.out.println(Arrays.toString(collect.toArray()));
    }
}
