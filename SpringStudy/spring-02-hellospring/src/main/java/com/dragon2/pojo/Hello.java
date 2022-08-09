package com.dragon2.pojo;

/**
 * @author yanchongsheng
 * @since 2022-07-26
 */
public class Hello {
    private String name;
    private String gender;
    private Integer age;
    private RefTest bank;

    public Hello(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hello " + name + " Gender:"
                + gender + " Age:"
                + age + "Bank:" + (bank == null ? "None" : bank.toString());
    }

    public void setBank(RefTest bank) {
        this.bank = bank;
    }
}
