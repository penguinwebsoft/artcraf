CREATE TABLE TAX_RATE (
	TAX_RATE_ID BIGINT PRIMARY KEY NOT NULL,
	PRODUCT_ID BIGINT REFERENCES PRODUCT (PRODUCT_ID),
	SELLER_ID BIGINT REFERENCES SELLER (SELLER_ID),
	NAME VARCHAR(45),
	RATE SMALLINT,
	TYPE VARCHAR(45),
	CREATED_DTTM TIMESTAMP DEFAULT NOW(),
 	MODIFIED_DTTM TIMESTAMP DEFAULT NOW()
	)