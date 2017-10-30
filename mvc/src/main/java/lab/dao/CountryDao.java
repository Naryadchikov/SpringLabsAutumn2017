package lab.dao;

import java.util.List;
import lab.domain.Country;

public interface CountryDao {

	void insert(Country user);

	Country select(int id);

	List<Country> selectAll();

}