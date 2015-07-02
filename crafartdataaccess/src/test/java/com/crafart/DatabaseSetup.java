package com.crafart;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.postgresql.util.PSQLException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.data.CommonDAOImpl;

@ContextConfiguration("classpath:crafartdatasource-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class DatabaseSetup extends CommonDAOImpl {

	@Ignore
	public void testDummy() {
		try {
			// read db scripts from the sql file
			InputStream inputStream = this.getClass().getResourceAsStream("/dbsetup.sql");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			// creating string of create scripts separated by delimiter ";"
			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
					System.out.println("Skipped a blank line");
				} else {
					sb.append(line);
				}
			}

			System.out.println(sb);
			String queryString = new String(sb);
			// getting array of create scripts extracted from delimiter ";"
			String[] createScripts = queryString.split(";");
			
			for (String createScript : createScripts) {
				System.out.println(" query content  = " + createScript);

				// lastly inserting into database

				try {
					Session session = this.getSessionFactory().openSession();
					
					session.beginTransaction();
					session.createSQLQuery(createScript).executeUpdate();
					// has no effect.
					// Query doesn't
					// execute.
					session.getTransaction().commit();
					session.close();
				} catch (Exception psqlExp) {
					psqlExp.getCause();
					if (psqlExp instanceof PSQLException) {

						System.out.println("table already exists" + createScript);
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	@Test
	public void testCreateSequence() {
		try {
			// read db scripts from the sql file
			InputStream inputStream = this.getClass().getResourceAsStream("/dbsequence.sql");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			// creating string of create scripts separated by delimiter ";"
			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = reader.readLine()) != null) {
				if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
					System.out.println("Skipped a blank line");
				} else {
					sb.append(line);
				}
			}

			System.out.println(sb);
			String queryString = new String(sb);
			// getting array of create scripts extracted from delimiter ";"
			String[] createScripts = queryString.split(";");
			
			for (String createScript : createScripts) {
				System.out.println(" query content  = " + createScript);

				// lastly inserting into database

				try {
					Session session = this.getSessionFactory().openSession();
					
					session.beginTransaction();
					session.createSQLQuery(createScript).executeUpdate();
					// has no effect.
					// Query doesn't
					// execute.
					session.getTransaction().commit();
					session.close();
				} catch (Exception psqlExp) {
					psqlExp.getCause();
					if (psqlExp instanceof PSQLException) {

						System.out.println("table already exists" + createScript);
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
