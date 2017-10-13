package lab.model.simple;

import java.util.List;
import java.util.Objects;
import lab.model.Country;
import lab.model.Person;

public class SimplePerson implements Person {

	private int id;
	private String name;
	private Country country;
	private int age;
	private float height;
	private boolean isProgrammer;
	private List<String> contacts;

	public SimplePerson(int id, String name, Country country, int age, float height, boolean isProgrammer, List<String> contacts) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.age = age;
		this.height = height;
		this.isProgrammer = isProgrammer;
		this.contacts = contacts;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public Country getCountry() {
		return country;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public float getHeight() {
		return height;
	}

	@Override
	public boolean isProgrammer() {
		return isProgrammer;
	}

	@Override
	public List<String> getContacts() {
		return contacts;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SimplePerson)) {
			return false;
		}
		SimplePerson that = (SimplePerson) o;
		return getId() == that.getId() &&
			getAge() == that.getAge() &&
			Float.compare(that.getHeight(), getHeight()) == 0 &&
			isProgrammer() == that.isProgrammer() &&
			Objects.equals(getName(), that.getName()) &&
			Objects.equals(getCountry(), that.getCountry()) &&
			Objects.equals(getContacts(), that.getContacts());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getCountry(), getAge(), getHeight(), isProgrammer(), getContacts());
	}

}