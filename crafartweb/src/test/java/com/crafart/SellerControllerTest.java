package com.crafart;

import java.beans.PropertyEditor;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.crafart.service.businessobjects.SellerBO;

/**
 * Unit test for simple App.
 */
@ContextConfiguration({ "classpath:crafart-context-test.xml", "classpath:crafart-datasource-config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@Component
public class SellerControllerTest {

	@Autowired
	private SellerController sellerController;

	@Test
	@Rollback(true)
	public void testAddSeller() {

		SellerBO sellerBO = new SellerBO();
		sellerBO.setApproved(1);
		sellerBO.setGender("male");
		sellerBO.setDateOfBirth("00/00/000");
		sellerBO.setCommission("www");
		sellerBO.setCompanyLogo("qqq");
		sellerBO.setCompanyName("penguin");
		sellerBO.setCstNo("4444");
		sellerBO.setEpchNo("121212");
		sellerBO.setFirstName("zzz");
		sellerBO.setLastName("rrr");
		sellerBO.setStatus(2);
		sellerBO.setTinNo(2);
		sellerBO.setVatNo("asd123");

		try {
			sellerController.addSeller(sellerBO, new BindingResult() {

				@Override
				public void setNestedPath(String nestedPath) {
					// TODO Auto-generated method stub

				}

				@Override
				public void rejectValue(String field, String errorCode, Object[] errorArgs, String defaultMessage) {
					// TODO Auto-generated method stub

				}

				@Override
				public void rejectValue(String field, String errorCode, String defaultMessage) {
					// TODO Auto-generated method stub

				}

				@Override
				public void rejectValue(String field, String errorCode) {
					// TODO Auto-generated method stub

				}

				@Override
				public void reject(String errorCode, Object[] errorArgs, String defaultMessage) {
					// TODO Auto-generated method stub

				}

				@Override
				public void reject(String errorCode, String defaultMessage) {
					// TODO Auto-generated method stub

				}

				@Override
				public void reject(String errorCode) {
					// TODO Auto-generated method stub

				}

				@Override
				public void pushNestedPath(String subPath) {
					// TODO Auto-generated method stub

				}

				@Override
				public void popNestedPath() throws IllegalStateException {
					// TODO Auto-generated method stub

				}

				@Override
				public boolean hasGlobalErrors() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean hasFieldErrors(String field) {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean hasFieldErrors() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public boolean hasErrors() {
					// TODO Auto-generated method stub
					return false;
				}

				@Override
				public String getObjectName() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String getNestedPath() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public List<ObjectError> getGlobalErrors() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getGlobalErrorCount() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public ObjectError getGlobalError() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Object getFieldValue(String field) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Class<?> getFieldType(String field) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public List<FieldError> getFieldErrors(String field) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public List<FieldError> getFieldErrors() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getFieldErrorCount(String field) {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public int getFieldErrorCount() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public FieldError getFieldError(String field) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public FieldError getFieldError() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getErrorCount() {
					// TODO Auto-generated method stub
					return 0;
				}

				@Override
				public List<ObjectError> getAllErrors() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void addAllErrors(Errors errors) {
					// TODO Auto-generated method stub

				}

				@Override
				public String[] resolveMessageCodes(String errorCode, String field) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String[] resolveMessageCodes(String errorCode) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void recordSuppressedField(String field) {
					// TODO Auto-generated method stub

				}

				@Override
				public Object getTarget() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public String[] getSuppressedFields() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Object getRawFieldValue(String field) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public PropertyEditorRegistry getPropertyEditorRegistry() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public Map<String, Object> getModel() {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public PropertyEditor findEditor(String field, Class<?> valueType) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public void addError(ObjectError error) {
					// TODO Auto-generated method stub

				}
			}, new MockHttpServletRequest());
		} catch (Exception exp) {
			exp.printStackTrace();
			Assert.fail();
		}

	}
}
