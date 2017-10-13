package lab.model.simple;

import lab.model.Squishee;

public class SimpleSquishee implements Squishee {

	private String name;

	public SimpleSquishee(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

}