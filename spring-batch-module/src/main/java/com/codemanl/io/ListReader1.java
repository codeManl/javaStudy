package com.codemanl.io;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.Iterator;
import java.util.List;

public class ListReader1 implements ItemReader<String> {

    private Iterator<String> iterator;

    public ListReader1(List<String> data) {
        this.iterator = data.iterator();
    }

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("-------------");
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            return null;
        }
    }
}
