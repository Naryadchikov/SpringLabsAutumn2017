package ioc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lab.model.simple.SimplePerson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class SpringTCFAppTest {

	@Autowired
	private SimplePerson person;

	private SimplePerson expectedPerson = HelloWorldTest.getExpectedPerson();

	@Test
	void testInitPerson() {
		assertEquals(expectedPerson, person);
	}

}