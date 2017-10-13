package aop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.util.AssertionErrors.assertTrue;

import lab.aop.AopLog;
import lab.model.Bar;
import lab.model.Customer;
import lab.model.simple.ApuBar;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
class AopAspectJTest {

	@Autowired
    private Bar bar;
    
	@Autowired
    private Customer customer;

    @BeforeEach
    public void setUp() {
		customer.setBroke(false);
        bar.sellSquishee(customer);
    }

    @Test
    public void testBeforeAdvice() {
        assertTrue("Before advice is not good enought...", AopLog.getStringValue().contains("Hello"));
        assertTrue("Before advice is not good enought...", AopLog.getStringValue().contains("How are you doing?"));
        System.out.println(AopLog.getStringValue());
        AopLog.clear();
    }

    @Test
    public void testAfterAdvice() {
        assertTrue("After advice is not good enought...", AopLog.getStringValue().contains("Good Bye!"));
		System.out.println(AopLog.getStringValue());
		AopLog.clear();
    }

    @Test
    public void testAfterReturningAdvice() {
        assertTrue("Customer is broken", AopLog.getStringValue().contains("Good Enough?"));
        System.out.println(AopLog.getStringValue());
		AopLog.clear();
    }

    @Test
    public void testAroundAdvice() {
        assertTrue("Around advice is not good enought...", AopLog.getStringValue().contains("Hi!"));
        assertTrue("Around advice is not good enought...", AopLog.getStringValue().contains("See you!"));
        System.out.println(AopLog.getStringValue());
		AopLog.clear();
    }

    @Test
    public void testAllAdvices() {
        assertFalse(bar instanceof ApuBar, "barObject instanceof ApuBar");
		AopLog.clear();
    }

}