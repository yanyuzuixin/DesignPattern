package com.hjr.principle.inversion;

public class DependencyInversion {
    public static void main(String[] args) {

    }
}

class Email {
    public String getInfo() {
        return "电子邮件消息: hello, world";
    }
}

/**
 * 完成Person接收消息的功能
 * 方式1分析
 * 1. 简单，比较容易想到
 * 2. 如果我们获取的对象是微信、短信等等，同时Person也要增加相应的接收方法
 * 3. 解决思路：引入一个抽象的借口IReceiver，表示接收者，这样Person类与接口IReceiver发生依赖
 *    因为 微信、邮件等等属于接收的范围，他们各自实现IReceiver的接口就OK，这样就符合依赖倒转原则
 */
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
