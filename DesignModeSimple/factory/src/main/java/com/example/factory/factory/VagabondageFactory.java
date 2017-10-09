package com.example.factory.factory;

import com.example.factory.abstractFactory.Factory;
import com.example.factory.abstractProduct.Hero;
import com.example.factory.product.Vagabondage;

/**
 * Created by AxeChen on 2017/10/9.
 */

public class VagabondageFactory extends Factory {
    @Override
    public Hero createHero() {
        return new Vagabondage();
    }
}
