package com.collicode.camelintegration;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class MyTransform implements Processor {


    @Override
    public void process(Exchange exchange) throws Exception {

        String myString = exchange.getIn().getBody(String.class);
        String[] lineSeparator = myString.split(System.getProperty("line.separator"));
        StringBuffer sb = new StringBuffer();
        sb.append("<Employees>");
        for (String lineData : lineSeparator)
        {
            String [] commaSeparator=lineData.split(",");
            sb.append("<Employee>");
            sb.append("<FirtsName>"+commaSeparator[0].toString()+"</FirstName>");
            sb.append("<LastName>"+commaSeparator[1].toString()+"</LastName>");
            sb.append("<Mobile>"+commaSeparator[2].toString()+"</Mobile>");
            sb.append("</Employee>");
        }

        sb.append("</Employees>");
        System.out.println("MyProcessor complete");
        exchange.getIn().setBody(sb.toString());
    }
}
