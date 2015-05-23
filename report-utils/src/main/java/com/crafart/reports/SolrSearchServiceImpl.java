package com.crafart.reports;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import com.crafart.exception.SearchException;
import com.crafart.model.SearchBO;
import com.crafart.model.SearchResponse;

/**
 * service provides search for single word search or phrase against the crafart
 * database. Based on the solr configuration @see db-data-config.xml, search
 * terms are searched against the solr documents which has table rows indexed
 * based on query definition. <li>Full search, phrase, or wild card searches are
 * done based on passing query filters in solr query<li>
 * 
 * @author p.periyasamy
 */
public class SolrSearchServiceImpl implements Search {

	private static final Logger log = Logger.getLogger(SolrSearchServiceImpl.class);

	private String url;

	public SolrSearchServiceImpl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * @param searchBO
	 * @return {@link SearchResponse}
	 * @throws SearchException
	 */
	public Map<String, String> searchForTerm(SearchBO searchBO) throws SearchException {
		SolrQuery solrQuery = new SolrQuery();
		String searchTerm = searchBO.getSearchTerm();
		solrQuery.setQuery(processSearchTerm(searchTerm));
		log.debug("processed search term ::::::::" + solrQuery.getQuery());
		try {
			SolrClient server = new HttpSolrClient(url);
			QueryResponse response = server.query(solrQuery);
			SolrDocumentList documentList = response.getResults();
			Map<String, String> searchResults = new HashMap<>();
			for (SolrDocument doc : documentList) {
				String product = (String) doc.getFirstValue("product_model");
				String productId = (String) doc.getFirstValue("id");
				searchResults.put(productId, product);
				System.out.println("product_model_name from solr engine :::::::::::: " + product + " :: id " + productId);
			}
			return searchResults;
		} catch (SolrServerException | IOException sExp) {
			throw new SearchException("Search error while searching for search terms " + searchTerm, sExp);
		}
	}

	/**
	 * utility method to process search terms entered by users, search phrases
	 * are processed to get better results from the solr engine <li>For
	 * instance:- if user intention is to search for mobiles and start typing
	 * "L" "e" "o" then user should be shown search results contains mobile
	 * brand or name starts with "Leo" and the results are <li>Lenovo A6000</li>
	 * <li>Lenovo A6010</li> in above scenario, the search phrases should be
	 * processed before passing to solr engine. <li>"Leo" word converted to
	 * "Leo*"</li> <li>"Lenovo A6000" phrase conveted to "Lenovo* A6000*" Adding
	 * wild card search upon entering every letter by the user, to enable
	 * incremental search options.
	 * 
	 * @param searchTerm
	 * @return processedString
	 */
	private String processSearchTerm(String searchTerm) {
		String[] searchTermWords = searchTerm.split(" ");
		String processedSearcTerm = new String();
		int count = 0;
		if (searchTermWords.length > 1) {
			for (String word : searchTermWords) {
				if (count < (searchTermWords.length - 1)) {
					processedSearcTerm = processedSearcTerm.concat(word.concat("* "));
				} else {
					processedSearcTerm = processedSearcTerm.concat(word.concat("*"));
				}
				count = +1;
			}
		} else {
			return searchTerm.concat("*");
		}
		return processedSearcTerm;
	}

}
