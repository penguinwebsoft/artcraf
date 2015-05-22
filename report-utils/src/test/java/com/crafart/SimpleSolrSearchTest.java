package com.crafart;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crafart.exception.SearchException;
import com.crafart.model.SearchBO;
import com.crafart.reports.Search;

@ContextConfiguration({ "classpath:crafartreport-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class SimpleSolrSearchTest {

	@Autowired
	private Search SolrSearchServiceImpl;

	@Test
	public void testSingleSearch() {
		SearchBO searchBO = new SearchBO();
		searchBO.setSearchTerm("product_model:from");
		try {
			SolrSearchServiceImpl.searchForTerm(searchBO);
		} catch (SearchException sExp) {
			sExp.printStackTrace();
			Assert.fail();
		}
	}
	
	
	@Test
	public void testMultipleWordsSearch() {
		SearchBO searchBO = new SearchBO();
		searchBO.setSearchTerm("product_model:from test");
		try {
			SolrSearchServiceImpl.searchForTerm(searchBO);
		} catch (SearchException sExp) {
			sExp.printStackTrace();
			Assert.fail();
		}
	}

}
