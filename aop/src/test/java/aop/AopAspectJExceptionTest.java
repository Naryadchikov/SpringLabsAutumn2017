package aop;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import lab.aop.AopLog;
import lab.model.Bar;
import lab.model.Customer;
import lab.model.CustomerBrokenException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class AopAspectJExceptionTest {

	@Autowired
	private Bar bar;
    
	@Autowired
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer.setBroke(true);
    }

    @Test
    void testAfterThrowingAdvice() {
        assertThrows(CustomerBrokenException.class, () -> bar.sellSquishee(customer));
        assertTrue("Customer is not broken ", AopLog.getStringValue().contains("Hmmm..."));
        System.out.println(AopLog.getStringValue());
    }

    @AfterEach
    void tearDown() {
        customer.setBroke(false);
    }

}