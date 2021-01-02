package com.hjr.principle.inversion.improve;

public class DependencyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Wechat());
    }
}

interface IReceiver {
    String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息： email info";
    }
}

class Wechat implements IReceiver {
    public String getInfo() {
        return "微信消息： wechat info";
    }
}

class Person {
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}
