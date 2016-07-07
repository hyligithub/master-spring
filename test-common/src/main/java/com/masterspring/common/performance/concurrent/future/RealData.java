package com.masterspring.common.performance.concurrent.future;

/**
 * Created by lihuiyan on 2016/2/16.
 */
public class RealData implements Data {

    private String content;

    @Override
    public String getResult() {
        return content;
    }

    public RealData(String queryStr) {
        System.out.println("构造真实数据，这个过程应该很慢,queryStr = " + queryStr);
        StringBuffer stringBuffer = new StringBuffer(20);
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(i).append(",");
        }
        this.content = stringBuffer.toString();
    }

    protected void buildRealData(String realData) {
        System.out.println("build realdata");
        this.content = realData;
    }
}
