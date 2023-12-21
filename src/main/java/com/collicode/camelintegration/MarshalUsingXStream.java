package com.collicode.camelintegration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;

import java.util.HashMap;
import java.util.Map;

public class MarshalUsingXStream extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("classpath:data.csv")
                .process(new CustomProcessorXStream())
                .marshal(populateXStreamDefinition())
                .log("Marshalled XML: ${body}")
                .to("mock:output");
    }

    private XStreamDataFormat populateXStreamDefinition() {
        XStreamDataFormat xstreamDefinition = new XStreamDataFormat();

        Map<String, String> aliases = new HashMap<>();
        aliases.put("Employee", Employee.class.getName());

        xstreamDefinition.setAliases(aliases);

        return xstreamDefinition;
    }
}
