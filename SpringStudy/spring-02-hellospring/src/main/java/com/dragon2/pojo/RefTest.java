package com.dragon2.pojo;

/**
 * @author yanchongsheng
 * @since 2022-08-03
 */
public class RefTest {
    private String bankName;
    private Float money;

    public RefTest(String bankName, Float money) {
        this.bankName = bankName;
        this.money = money;
    }

    @Override
    public String toString() {
        return bankName + " has " + money + "yuan.";
    }
}
