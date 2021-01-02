package com.hjr.principle.inversion.improve;

public class DependencyPass {
    public static void main(String[] args) {
        // 接口实现依赖方式执行
        //ChangHong changHong = new ChangHong();
        //OpenAndClose openAndClose = new OpenAndClose();
        //openAndClose.open(changHong);
        // 构造方法方式执行
        //OpenAndClose openAndClose = new OpenAndClose(new ChangHong());
        //openAndClose.open();
        // setter方法执行
        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.setTv(new ChangHong());
        openAndClose.open();
    }
}

/**
 * 方式1：通过接口传递实现依赖
 */
//// 开关的接口
//interface IOpenAndClose {
//    public void open(ITV itv); // 抽象方法，依赖ITV接口
//}
//
//interface ITV {
//    public void play();
//}
//
//class ChangHong implements ITV {
//    @Override
//    public void play() {
//        System.out.println("长虹电视 打开");
//    }
//}
//
//// 实现接口
//class OpenAndClose implements IOpenAndClose {
//    @Override
//    public void open(ITV itv) {
//        itv.play();
//    }
//}


/**
 * 方式2：通过构造方法传递依赖
 */

//interface IOpenAndClose {
//    public void open();
//}
//
//interface ITV {
//    public void play();
//}
//
//class ChangHong implements ITV {
//    @Override
//    public void play() {
//        System.out.println("长虹电视 打开");
//    }
//}
//
//class OpenAndClose implements IOpenAndClose {
//    public ITV tv;
//    public OpenAndClose(ITV tv) {
//        this.tv = tv;
//    }
//
//    @Override
//    public void open() {
//        this.tv.play();
//    }
//}

/**
 * 方式3：通过setter方式传递依赖
 */

interface IOpenAndClose {
    void open();
    void setTv(ITV tv);
}

interface ITV {
    void play();
}

class ChangHong implements ITV {
    @Override
    public void play() {
        System.out.println("长虹电视 打开");
    }
}

class OpenAndClose implements IOpenAndClose {
    private ITV tv;

    @Override
    public void setTv(ITV tv) {
        this.tv = tv;
    }

    @Override
    public void open() {
        this.tv.play();
    }
}