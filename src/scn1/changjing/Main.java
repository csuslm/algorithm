package scn1.changjing;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Double> doubles = divideRandom(10, 5);
        for (Double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }
    /**
     * 抢红包
     */
    public static List<Double> divideRandom(double cash, int n) {
        double UNIT = 0.01;
        List<Double> list = new LinkedList<>();
        while (n != 0) {
            if (n == 1) {
                list.add(cash);
            }
            Random random = new Random();
            double v = random.nextDouble();
            double value = (cash - UNIT - (cash / 2 + UNIT)) * v + (cash / 2 + UNIT);
            list.add(value);
            cash -= value;
            n--;
        }
        return list;
    }
}
