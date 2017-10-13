package ioc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lab.model.simple.SimplePerson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class SimpleAppTest {

	private static final String APPLICATION_CONTEXT_XML_FILE_NAME = "application-context.xml";

	private BeanFactory context = new ClassPathXmlApplicationContext(
		APPLICATION_CONTEXT_XML_FILE_NAME);

	private SimplePerson expectedPerson = HelloWorldTest.getExpectedPerson();

	@Test
	void testInitPerson() {
		assertEquals(expectedPerson, context.getBean("person"));
	}

}