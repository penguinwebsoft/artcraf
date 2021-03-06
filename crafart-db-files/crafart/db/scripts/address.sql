CREATE TABLE ADDRESS (
	ADDRESS_ID BIGINT PRIMARY KEY NOT NULL, 
	STREET VARCHAR(45), 
	STATE_ID BIGINT, 
	CITY_ID BIGINT, 
	PIN_CODE VARCHAR(45), 
	CREATED_DTTM TIMESTAMP,
	MODIFIED_DTTM TIMESTAMP
)

/**SETTING DEFAULT VALUES TO COLUMN**/ 
ALTER TABLE ADDRESS ALTER COLUMN MODIFIED_DTTM SET DEFAULT NOW()

ALTER TABLE ADDRESS ALTER COLUMN CREATED_DTTM SET DEFAULT NOW()