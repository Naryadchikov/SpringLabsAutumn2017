package lab.service;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;
import static org.springframework.transaction.annotation.Propagation.NEVER;
import static org.springframework.transaction.annotation.Propagation.NOT_SUPPORTED;
import static org.springframework.transaction.annotation.Propagation.REQUIRED;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

import java.util.List;
import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository //is more convenient declaration for such a class than general @Service
@Transactional
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	public List<Country> getAllCountriesInsideTransaction(Propagation propagation) {
		if (REQUIRED.equals(propagation)) {
			return getAllCountriesRequired();
		} else if (REQUIRES_NEW.equals(propagation)) {
			return getAllCountriesRequiresNew();
		} else if (SUPPORTS.equals(propagation)) {
			return getAllCountriesSupports();
		} else if (NEVER.equals(propagation)) {
			return getAllCountriesNever();
		} else if (MANDATORY.equals(propagation)) {
			return getAllCountriesMandatory();
		} else if (NOT_SUPPORTED.equals(propagation)) {
			return getAllCountriesNotSupported();
		} else {
			return getAllCountries();
		}
	}

	@Override
	@Transactional(propagation = REQUIRED)
	public List<Country> getAllCountriesRequired() {
		return countryDao.getCountryList();
	}

	@Override
	@Transactional(propagation = REQUIRES_NEW)
	public List<Country> getAllCountriesRequiresNew() {
		return countryDao.getCountryList();
	}

	@Override
	@Transactional(propagation = SUPPORTS)
	public List<Country> getAllCountriesSupports() {
		return countryDao.getCountryList();
	}

	@Override
	@Transactional(propagation = NEVER)
	public List<Country> getAllCountriesNever() {
		return countryDao.getCountryList();
	}

	@Override
	@Transactional(propagation = MANDATORY)
	public List<Country> getAllCountriesMandatory() {
		return countryDao.getCountryList();
	}

	@Override
	@Transactional(propagation = NOT_SUPPORTED)
	public List<Country> getAllCountriesNotSupported() {
		return countryDao.getCountryList();
	}

	@Override
	public List<Country> getAllCountries() {
		return countryDao.getCountryList();
	}

}