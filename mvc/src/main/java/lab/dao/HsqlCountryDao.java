package lab.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import lab.domain.Country;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class HsqlCountryDao extends JdbcDaoSupport implements CountryDao {

	@Override
	public void insert(Country country) {
		if (country != null) {
			getJdbcTemplate().update("insert into country(name, codeName) values(?, ?)",
				country.getName(), country.getCodeName());
		}
	}

	@Override
	public Country select(int id) {
		Country country = null;

		if (id > 0) {
			country = getJdbcTemplate().queryForObject("select id, name, codeName from country" +
				" where id = ?", new Object[] {id}, new CountryMapper());
		}

		return country;
	}

	@Override
	public List<Country> selectAll() {
		return getJdbcTemplate().query("select id, name, codeName from country", new CountryMapper());
	}

	private static final class CountryMapper implements RowMapper<Country> {

		@Override
		public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
			Country country = new Country();

			country.setId(rs.getInt("id"));
			country.setName(rs.getString("name"));
			country.setCodeName(rs.getString("codename"));

			return country;
		}
	}

}