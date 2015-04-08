CREATE TABLE COMMISSION (
	COMMISSION_ID BIGINT PRIMARY KEY NOT NULL,
	NAME VARCHAR(45),
	TYPE VARCHAR(45),
	VALUE FLOAT,
	SORT_ORDER SMALLINT,
	CREATED_DTTM TIMESTAMP DEFAULT NOW(), 
	MODIFIED_DTTM TIMESTAMP DEFAULT NOW()
	)