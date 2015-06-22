CREATE TABLE COURIER (
	COURIER_ID BIGINT PRIMARY KEY NOT NULL,
	NAME VARCHAR(45),
	IMAGE VARCHAR(45),
    
	SORT_ORDER SMALLINT,
	CREATED_DTTM TIMESTAMP DEFAULT NOW(),
	MODIFIED_DTTM TIMESTAMP DEFAULT NOW()
	)
	
	
	/************** alter table name to courier_name ***********/
	ALTER TABLE courier ADD COLUMN courier_name character varying(45);
    ALTER TABLE courier ADD COLUMN estimated_delivery_time time with time zone;
    ALTER TABLE courier DROP COLUMN product_limit small int;
   