package lab.model.simple;

import lab.model.Customer;

public class SimpleCustomer implements Customer {

	private String name;
	private boolean broke;

	public SimpleCustomer(String name, boolean broke) {
		this.name = name;
		this.broke = broke;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isBroke() {
		return broke;
	}

	@Override
	public void setBroke(boolean broke) {
		this.broke = broke;
	}

}