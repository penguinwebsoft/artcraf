CREATE TABLE PRODUCT_ATTRIBUTE (
	ATTRIBUTE_ID BIGINT PRIMARY KEY NOT NULL,
	ATTRIBUTE_GROUP_ID BIGINT REFERENCES ATTRIBUTE_GROUP_DESC(ATTRIBUTE_GROUP_ID),
	PRODUCT_ID BIGINT REFERENCES PRODUCT (PRODUCT_ID),
	TEXT VARCHAR(100),
	SORT_ORDER SMALLINT
	)