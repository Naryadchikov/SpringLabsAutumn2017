package lab.model.simple;

import lab.aop.AopLog;
import lab.model.Bar;
import lab.model.Customer;
import lab.model.CustomerBrokenException;
import lab.model.Squishee;
import org.springframework.stereotype.Service;

@Service
public class ApuBar implements Bar {

	@Override
	public Squishee sellSquishee(Customer customer)  {
		if (customer.isBroke()){
			throw new CustomerBrokenException();
		}

		AopLog.append("Here is your Squishee \n");

		return new SimpleSquishee("Usual Squishee");
	}

}