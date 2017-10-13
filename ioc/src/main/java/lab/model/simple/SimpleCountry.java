package lab.model.simple;

import java.util.Objects;
import lab.model.Country;

public class SimpleCountry implements Country {

	private int id;
	private String name;
	private String codeName;

	public SimpleCountry(int id, String name, String codeName) {
		this.id = id;
		this.name = name;
		this.codeName = codeName;
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
	public String getCodeName() {
		return codeName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof SimpleCountry)) {
			return false;
		}
		SimpleCountry that = (SimpleCountry) o;
		return getId() == that.getId() &&
			Objects.equals(getName(), that.getName()) &&
			Objects.equals(getCodeName(), that.getCodeName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getCodeName());
	}

}