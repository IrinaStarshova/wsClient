package com.accenture.flowershop.fe.ws;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FlowersStockWebServiceClient {

    public static void main(String[] arg) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
            executor.scheduleAtFixedRate(
                    FlowersStockWebServiceClient::increase,
                    0, 3, TimeUnit.SECONDS);
    }

    private static void increase(){
        FlowersStockWebServiceImplService service = new FlowersStockWebServiceImplService();
        FlowersStockWebService sei = service.getFlowersStockWebServiceImplPort();
        Random random=new Random();
        int count=10+random.nextInt(20);
        sei.increaseFlowersStockSize(count);
    }
}