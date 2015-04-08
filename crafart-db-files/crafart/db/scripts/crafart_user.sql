CREATE TABLE CRAFART_USER (
	USER_ID BIGINT PRIMARY KEY NOT NULL,
	USER_GROUP_ID BIGINT,
	USER_NAME VARCHAR(45),
	PASSWORD VARCHAR(45),
	FIRST_NAME VARCHAR(45),
	LAST_NAME VARCHAR(45),
	IP VARCHAR(45),
	STATUS SMALLINT,
	SELLER_PERMISSION SMALLINT,
	CREATED_DTTM TIMESTAMP DEFAULT NOW(), 
	MODIFIED_DTTM TIMESTAMP DEFAULT NOW()
	)