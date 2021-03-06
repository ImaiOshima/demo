package com.wyh.demo.util.red;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author imai
 * @since 2021/4/17 4:45 下午
 */
public class RedPacketUtil {
    /** 发红包算法 */
    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {
        List<Integer> amountList = new ArrayList<>();
        if (totalAmount > 0 && totalPeopleNum > 0) {
            Integer restAmount = totalAmount;
            Integer restPeopleNum = totalPeopleNum;
            Random random = new Random();
            for (int i = 0; i < totalPeopleNum - 1; i++) {
                int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
                restAmount -= amount;
                restPeopleNum--;
                amountList.add(amount);
            }
            amountList.add(restAmount);
        }
        return amountList;
    }
}
