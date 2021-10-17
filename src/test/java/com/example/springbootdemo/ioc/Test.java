package com.example.springbootdemo.ioc;

import lombok.Data;

/**
 * 控制反转Demo
 *
 * @author Shen && syf0412@vip.qq.com
 * @date 2021/10/17 11:46
 */
public class Test {
    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car);
    }
}

@Data
class Car {
    private Framework framework;

    Car() {
        this.framework = new Framework();
    }
}

@Data
class Framework {
    private Tire tire;

    public Framework() {
        this.tire = new Tire();
    }
}

@Data
class Tire {
    private int size;
    Tire() {
        this.size = 30;
    }
}
