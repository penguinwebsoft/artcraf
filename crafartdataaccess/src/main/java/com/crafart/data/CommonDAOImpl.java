/**
 * 
 */
package com.crafart.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("CommonDAOImpl")
public class CommonDAOImpl {

	private JdbcTemplate jdbctemplate;

	private SimpleJdbcInsert simpleJdbcInsert;

	public JdbcTemplate getJdbctemplate() {
		return this.jdbctemplate;
	}

	@Autowired
	public void setJdbctemplate(
			@Qualifier("jdbcTemplate") JdbcTemplate jdbcTemplate) {
		this.jdbctemplate = jdbcTemplate;
	}

	public SimpleJdbcInsert getSimpleJdbcInsert() {
		return simpleJdbcInsert;
	}

	public void setSimpleJdbcInsert(
			@Qualifier("dataSource") DataSource dataSource) {
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
	}

}
