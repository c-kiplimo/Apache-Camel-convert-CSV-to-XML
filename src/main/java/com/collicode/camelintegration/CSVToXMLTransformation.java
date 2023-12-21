package com.collicode.camelintegration;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CSVToXMLTransformation {
	public static void main(String[] args) throws Exception {
		CamelContext _ctx = new DefaultCamelContext();
		_ctx.addRoutes(new RouteBuilder() {
			public void configure() throws Exception {
				from("file:src/main/resources/input?fileName=data.csv")
						.process(new MyTransform())
						.to("file:src/main/resources/output?fileName=data.xml");
			}
		});
		_ctx.start();
		Thread.sleep(4000);
		_ctx.stop();
	}
}
