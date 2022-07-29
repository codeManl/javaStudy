package com.codemanl.listener;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

@Component("ErrorSkipListener")
public class ErrorSkipListener implements SkipListener<String, String> {
    @Override
    public void onSkipInRead(Throwable t) {
        System.out.println("read error cause by: " + t);
    }

    @Override
    public void onSkipInWrite(String item, Throwable t) {
        System.out.println("write  " + item + "  error cause by: " + t);
    }

    @Override
    public void onSkipInProcess(String item, Throwable t) {
        System.out.println("process  " + item + "  error cause by: " + t);
    }
}
