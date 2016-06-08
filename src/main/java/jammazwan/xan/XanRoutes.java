package jammazwan.xan;

import org.apache.camel.builder.RouteBuilder;

public class XanRoutes extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:employee").unmarshal("jaxb").to("file:.");
		from("direct:manager").unmarshal("jaxb").to("file:.");
	}
}
