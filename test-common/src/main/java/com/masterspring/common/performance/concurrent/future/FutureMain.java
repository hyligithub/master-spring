package com.masterspring.common.performance.concurrent.future;

/**
 * Created by lihuiyan on 2016/2/16.
 */
public class FutureMain {

    public static void main(String[] args) {
        Client client = new Client();
        Data data = client.request("aa");
        System.out.println(data.getResult());
    }
}
