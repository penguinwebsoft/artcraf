package com.crafart.reports;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.crafart.exception.SearchException;
import com.crafart.model.SearchBO;

@Service
public interface Search {

	public Map<String, String> searchForTerm(SearchBO searchBO) throws SearchException;
}
