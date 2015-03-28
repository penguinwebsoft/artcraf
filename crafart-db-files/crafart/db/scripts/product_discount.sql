CREATE TABLE PRODUCT_DISCOUNT (
	PRODUCT_DISCOUNT_ID BIGINT PRIMARY KEY NOT NULL,
	PRODUCT_ID BIGINT REFERENCES PRODUCT(PRODUCT_ID),
	SELLER_ID BIGINT REFERENCES SELLER(SELLER_ID),
	QUANTITY NUMERIC,
	PRICE FLOAT,
	START_DATE VARCHAR(45),
	END_DATE VARCHAR(45)
	)