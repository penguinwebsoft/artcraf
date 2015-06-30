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
	/* Alter query added on 27/05/2015 */
	
ALTER TABLE CRAFART_USER DROP COLUMN USER_GROUP_ID;
ALTER TABLE crafart_user ADD COLUMN user_group_id bigint
ALTER TABLE crafart_user ADD FOREIGN KEY (user_group_id) REFERENCES user_group;

	