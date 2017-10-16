package lab.model.simple;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lab.model.Country;

@Entity
public class SimpleCountry implements Country, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private String codeName;

	public SimpleCountry() {
	}

	public SimpleCountry(String name, String codeName) {
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
		return Objects.equals(getName(), that.getName()) &&
			Objects.equals(getCodeName(), that.getCodeName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getCodeName());
	}

}