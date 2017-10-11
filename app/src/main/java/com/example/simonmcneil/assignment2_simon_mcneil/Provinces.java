package com.example.simonmcneil.assignment2_simon_mcneil;

/**
 * Created by simonmcneil on 2016-11-11.
 */

public class Provinces {

    private String province;
    private String capital;
    private int flag;


    public Provinces(String province, String capital, int flag) {

        this.province = province;
        this.capital = capital;
        this.flag = flag;
    }

    public String getProvince() {

        return province;
    }

    public String getCapital(){

        return capital;
    }

    public int getFlag() {

        return flag;
    }
}
