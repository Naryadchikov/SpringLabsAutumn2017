package lab.mvc;

import java.util.List;
import javax.validation.Valid;
import lab.domain.Country;
import lab.mvc.form.bean.CountryFormBean;
import lab.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/addcountry.form")
public class CountryFormController {

	@Autowired
	private CountryService countryService;

	@ModelAttribute("countryFormBean")
	public CountryFormBean getCountryFormBean() {
		return new CountryFormBean();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return "addcountryform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processSubmit(@Valid CountryFormBean countryFormBean, Errors errors) {
		if (errors.hasErrors()) {
			return new ModelAndView("addcountryform");
		} else {
			List<Country> countryList;
			Country country = new Country();

			country.setName(countryFormBean.getName());
			country.setCodeName(countryFormBean.getCodeName());

			countryService.saveCountry(country);

			countryList = countryService.loadAllCountries();

			ModelAndView mav = new ModelAndView("countrylistview");
			mav.addObject("countryList", countryList);

			return mav;
		}
	}

}