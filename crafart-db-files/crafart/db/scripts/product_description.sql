CREATE TABLE PRODUCT_DESCRIPTION (
	PRODUCT_DESCRIPTION_ID BIGINT PRIMARY KEY,
	PRODUCT_ID BIGINT REFERENCES PRODUCT(PRODUCT_ID),
	NAME VARCHAR(45),
	DESCRIPTION VARCHAR(45),
	META_DESCRIPTION VARCHAR(45),
	META_KEYWORD VARCHAR(45),
	TAG VARCHAR(45)
	)