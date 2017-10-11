package com.example.stragety;

/**
 * Created by AxeChen on 2017/10/11.
 */

public class GetMoneyCalculater {

    private GetMoneyWay getMoneyWay;

    public void setGetMoneyWay(GetMoneyWay getMoneyWay) {
        this.getMoneyWay = getMoneyWay;
    }

    public int calculaterMoney(int count){
       return getMoneyWay.getMoney(count);
    }
}
