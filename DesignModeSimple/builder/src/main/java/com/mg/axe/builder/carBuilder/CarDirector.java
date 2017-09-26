package com.mg.axe.builder.carBuilder;

/**
 * Created by Axe on 2017/9/26.
 * 指导者：指导车（最终对象）的生成
 */

public class CarDirector {

    private CarBuilder builder;

    public CarDirector(CarBuilder builder) {
        this.builder = builder;
    }

    /**
     * 调用此方法，构造好car
     * @return
     */
    public Car creatCar() {
        Car car = new Car();
        car.setMake(builder.buildMake());
        car.setSeat(builder.buildSeat());
        car.setType(builder.buildType());
        return car;
    }
}
