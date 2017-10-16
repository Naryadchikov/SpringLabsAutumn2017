package orm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

import java.util.List;
import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class CountryDaoImplTest {

	private Country exampleCountry = new SimpleCountry("Australia", "AU");

	@Autowired
	private CountryDao countryDao;

	@BeforeEach
	public void setUp() {
		countryDao.save(exampleCountry);
	}

	@Test
	public void testSaveCountry() {
		List<Country> countryList = countryDao.getAllCountries();

		assertEquals(1, countryList.size());
		assertEquals(exampleCountry, countryList.get(0));
	}

	@Test
	public void testGtAllCountries() {
		countryDao.save(new SimpleCountry("Canada", "CA"));

		List<Country> countryList = countryDao.getAllCountries();

		assertEquals(2, countryList.size());
	}

	@Test
	public void testGetCountryByName() {
		Country country = countryDao.getCountryByName("Australia");

		assertEquals(exampleCountry, country);
	}

}