package com.masterspring.common.performance.flywegiht;

import java.util.HashMap;

/**
 * Created by lihuiyan on 2016/1/25.
 */
public class FlyWeightFactory {
    HashMap<String, IReportManager> employeeReportManager = new HashMap<String, IReportManager>();
    HashMap<String, IReportManager> financialReportManager = new HashMap<String, IReportManager>();

    public IReportManager getEmployeeReportManager(String id) {
        IReportManager r = employeeReportManager.get(id);
        if (r == null) {
            r = new EmployeeReportManager();
            employeeReportManager.put(id, r);
        }
        return r;
    }

    public IReportManager getFinancialReportManager(String id) {
        IReportManager r = financialReportManager.get(id);
        if (r == null) {
            r = new FinancialReportManager();
            financialReportManager.put(id, r);
        }
        return r;

    }
}
