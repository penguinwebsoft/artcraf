/**
 * 
 */
package com.crafart.data;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Karthi
 * @version 1.0
 * 
 */
@Repository("CommonDAOImpl")
@EnableTransactionManagement
public abstract class CommonDAOImpl {

	private JdbcTemplate jdbctemplate;

	private SimpleJdbcInsert simpleJdbcInsert;

	private SessionFactory sessionFactory;
	
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
	

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory(){
		return this.sessionFactory;
	}

}
