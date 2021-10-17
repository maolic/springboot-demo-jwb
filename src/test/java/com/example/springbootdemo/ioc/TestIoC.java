package com.example.springbootdemo.ioc;

import lombok.Data;

/**
 * 控制反转Demo
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 11:46
 */
public class TestIoC {
    public static void main(String[] args) {
        TireIoC tireIoC = new TireIoC(35);
        FrameworkIoC frameworkIoC = new FrameworkIoC(tireIoC);
        CarIoC car = new CarIoC(frameworkIoC);
        System.out.println(car);
    }
}

@Data
class CarIoC {
    private FrameworkIoC frameworkIoC;

    CarIoC(FrameworkIoC frameworkIoC) {
        this.frameworkIoC = frameworkIoC;
    }
}

@Data
class FrameworkIoC {
    private TireIoC tireIoC;

    public FrameworkIoC(TireIoC tireIoC) {
        this.tireIoC = tireIoC;
    }
}

@Data
class TireIoC {
    private int size;
    TireIoC(int size) {
        this.size = size;
    }
}