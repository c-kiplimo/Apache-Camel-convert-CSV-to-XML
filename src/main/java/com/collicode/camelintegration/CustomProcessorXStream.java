package com.collicode.camelintegration;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import java.util.StringTokenizer;

public class CustomProcessorXStream implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        String newBody = exchange.getIn().getBody(String.class);
        StringTokenizer tokenizer = new StringTokenizer(newBody, ",");
        Employee employee = new Employee();
        while (tokenizer.hasMoreElements()){
            employee.setFistName((String) tokenizer.nextElement());
            employee.setLastName((String) tokenizer.nextElement());
            employee.setMobile((String) tokenizer.nextElement());
        }

        exchange.getIn().setBody(employee);
    }
}
