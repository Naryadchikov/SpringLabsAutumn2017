package jdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class JdbcTest {

	@Autowired
	private CountryDao countryDao;

	private List<Country> expectedCountryList = new ArrayList<>();
	private List<Country> expectedCountryListStartsWithA = new ArrayList<>();
	private Country countryWithChangedName = new SimpleCountry(1, "Russia", "RU");

	@BeforeEach
	public void setUp() {
		initExpectedCountryLists();
		//countryDao.loadCountries();
	}

	@Test
	//@DirtiesContext
	public void testCountryList() {
		List<Country> countryList = countryDao.getCountryList();

		assertNotNull(countryList);
		assertEquals(expectedCountryList.size(), countryList.size());

		for (int i = 0; i < expectedCountryList.size(); i++) {
			assertEquals(expectedCountryList.get(i), countryList.get(i));
		}
	}

	@Test
	//@DirtiesContext
	public void testCountryListStartsWithA() {
		List<Country> countryList = countryDao.getCountryListStartWith("A");

		assertNotNull(countryList);
		assertEquals(expectedCountryListStartsWithA.size(), countryList.size());

		for (int i = 0; i < expectedCountryListStartsWithA.size(); i++) {
			assertEquals(expectedCountryListStartsWithA.get(i), countryList.get(i));
		}
	}

	@Test
	//@DirtiesContext
	public void testCountryChange() {
		countryDao.updateCountryName("RU", "Russia");
		assertEquals(countryWithChangedName, countryDao.getCountryByCodeName("RU"));
	}

	private void initExpectedCountryLists() {
		for (int i = 0; i < CountryDao.COUNTRY_INIT_DATA.length; i++) {
			String[] countryInitData = CountryDao.COUNTRY_INIT_DATA[i];
			Country country = new SimpleCountry(i, countryInitData[0], countryInitData[1]);

			expectedCountryList.add(country);

			if (country.getName().startsWith("A")) {
				expectedCountryListStartsWithA.add(country);
			}
		}
	}

}