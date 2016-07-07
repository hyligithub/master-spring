package com.masterspring.common.performance.flywegiht;

/**
 * Created by lihuiyan on 2016/1/25.
 */
public class EmployeeReportManager implements IReportManager {
    @Override
    public String createReport() {
        System.out.println(this.getClass().getName());
        return "this is employee report";
    }
}
