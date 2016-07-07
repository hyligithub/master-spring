package com.masterspring.common.performance.flywegiht;

/**
 * Created by lihuiyan on 2016/1/25.
 */
public class FlyWeightMain {
    public static void main(String[] args){
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        IReportManager r = flyWeightFactory.getEmployeeReportManager("A");
        r.createReport();
    }

    public static void getFlyWeight(){

    }
}
