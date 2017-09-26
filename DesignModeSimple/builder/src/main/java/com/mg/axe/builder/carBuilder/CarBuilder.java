package com.mg.axe.builder.carBuilder;

import com.mg.axe.builder.base.Builder;

/**
 * Created by Axe on 2017/9/26.
 * 构建着：用于构建汽车（最终获得的对象）
 */

public class CarBuilder implements Builder {

    @Override
    public String buildMake() {
        return "发电机";
    }

    @Override
    public String buildType() {
        return "机动车";
    }

    @Override
    public String buildSeat() {
        return "2坐";
    }
}
