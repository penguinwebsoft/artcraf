CREATE TABLE TAX_CLASS (
	TAX_CLASS_ID BIGINT PRIMARY KEY,
	TITLE VARCHAR(45),
	DESCRIPTION VARCHAR(45), 
	CREATED_DTTM TIMESTAMP DEFAULT NOW(),
	MODIFIED_DTTM TIMESTAMP DEFAULT NOW()
	)