package ioc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lab.model.simple.SimpleCountry;
import lab.model.simple.SimplePerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

	private BeanFactory context =
		new ClassPathXmlApplicationContext(APPLICATION_CONTEXT_XML_FILE_NAME);

	@Test
	void testInitPerson() {
		assertEquals(getExpectedPerson(), context.getBean("person"));
	}

	public static SimplePerson getExpectedPerson() {
		return new SimplePerson(
			1,
			"John Smith",
			new SimpleCountry(1, "Russia", "RU"),
			35,
			1.78f,
			true,
			List.of("adf@epam.com", "+7-905-222-3322"));
	}

}