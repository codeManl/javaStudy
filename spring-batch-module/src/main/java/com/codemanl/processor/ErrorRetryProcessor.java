package com.codemanl.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("ErrorRetryProcessor")
public class ErrorRetryProcessor implements ItemProcessor<String, String> {
    private int count = 0;

    @Override
    public String process(String item) throws Exception {
        System.out.println("processing item is : " + item);
//        if (Integer.valueOf(item) > 20) {
//            throw new RuntimeException(item + "> 20");
//        }
        if ("23".equalsIgnoreCase(item)) {
            count++;
            if (count >= 3) {
                System.out.println("retried " + count + " times success");
                return String.valueOf(Integer.parseInt(item) * -1);
            } else {
                System.out.println("Processed the " + count + " times fail");
                throw new RuntimeException("process failed. Attempt " + count);
            }
        } else {
            return String.valueOf(Integer.parseInt(item) * -1);
        }
    }
}
