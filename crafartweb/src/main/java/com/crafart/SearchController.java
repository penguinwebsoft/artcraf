package com.crafart;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crafart.exception.SearchException;
import com.crafart.model.SearchBO;
import com.crafart.reports.Search;

@Controller("SearchController")
@RequestMapping("search")
public class SearchController {

	private static final Logger log = Logger.getLogger(SearchController.class);

	@Autowired
	private Search SolrSearchServiceImpl;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public @ResponseBody ModelMap searchProducts(@RequestBody SearchBO searchBO ) {
		ModelMap model = new ModelMap();
		Map<String, String> serachResults;
		try {
			serachResults = SolrSearchServiceImpl.searchForTerm(searchBO);
			model.put("searchResults", serachResults);
		} catch (SearchException sExp) {
			log.error("Error while doing search for search term " + searchBO.getSearchTerm(), sExp);
			sExp.printStackTrace();
		}
		return model;

	}
}
