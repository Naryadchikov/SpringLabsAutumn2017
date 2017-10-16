package lab.dao.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import lab.dao.CountryDao;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import org.springframework.stereotype.Repository;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {

	@Override
	public void save(Country country) {
		EntityManager em = emf.createEntityManager();

		if (em != null) {
			em.getTransaction().begin();
			em.persist(country);
			em.getTransaction().commit();
			em.close();
		}
	}

	@Override
	public List<Country> getAllCountries() {
		EntityManager em = emf.createEntityManager();
		List<Country> countries = null;

		if (em != null) {
			countries = em.createQuery("FROM SimpleCountry", Country.class).getResultList();
			em.close();
		}

		return countries;
	}

	@Override
	public Country getCountryByName(String name) {
		EntityManager em = emf.createEntityManager();
		Country country = null;

		if (em != null) {
			country = em.createQuery("SELECT s FROM SimpleCountry s WHERE s.name LIKE :name", Country.class)
				.setParameter("name", name).getSingleResult();
			em.close();
		}

		return country;
	}

}