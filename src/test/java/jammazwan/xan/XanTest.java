package jammazwan.xan;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import jammazwan.entity.Employee;
import jammazwan.entity.Manager;

public class XanTest extends CamelSpringTestSupport {

	@Override
	protected AbstractXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
	}

	@Test
	public void testXan() throws Exception {
		Manager manager = new Manager("Tampa", "Acme Products", "Alquin", "Thomas");
		String managerReply = template.requestBodyAndHeader("direct:manager", manager, "CamelFileName", "manager.xml",
				String.class);
		assertTrue(managerReply.contains("company=\"Acme Products\""));

		Employee employee = new Employee("Dallas", "Acme Products", "Mary", "Smith");
		String employeeReply = template.requestBodyAndHeader("direct:employee", employee, "CamelFileName",
				"employee.xml", String.class);
		assertTrue(employeeReply.contains("<company>Acme Products</company>"));
	}

}
