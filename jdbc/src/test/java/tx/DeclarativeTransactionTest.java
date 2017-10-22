package tx;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jdbc.JdbcTest;
import lab.service.CountryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.annotation.Propagation;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:tx.xml")
public class DeclarativeTransactionTest extends JdbcTest {
    
	@Autowired
	private CountryService countryService;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    //@DirtiesContext
    public void testRequiredPropagationInsideTransaction() {
        assertNotNull(countryService.getAllCountriesInsideTransaction(Propagation.REQUIRED));
    }

    @Test
    //@DirtiesContext
    public void testRequiredPropagationWithoutTransaction() {
        assertNotNull(countryService.getAllCountriesRequired());
    }

    @Test
    //@DirtiesContext
    public void testMandatoryPropagationWithoutTransaction() {
        try {
            countryService.getAllCountriesMandatory();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalTransactionStateException);
            e.printStackTrace();
        }
    }

    @Test
    //@DirtiesContext
    public void testMandatoryPropagationInsideTransaction() {
        assertNotNull(countryService.getAllCountriesInsideTransaction(Propagation.MANDATORY));
    }

}