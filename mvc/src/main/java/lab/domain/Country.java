package lab.domain;

public class Country {

	private int id;
	private String name;
	private String codeName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeName() {
		return codeName;
	}

	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	@Override
	public String toString() {
		return "Country{" +
			"id=" + id +
			", name='" + name + '\'' +
			", codeName='" + codeName + '\'' +
			'}';
	}

}