CREATE TABLE ATTRIBUTE_GROUP_DESC (
	ATTRIBUTE_GROUP_ID BIGINT PRIMARY KEY NOT NULL,
	ATTRIBUTE_GROUP_NAME VARCHAR(45),
	SORT_ORDER SMALLINT
	)

	/*INSERT QUERY*/
	INSERT INTO ATTRIBUTE_GROUP_DESC (attribute_group_id,attribute_group_name,sort_order) VALUES (1,'colour',1)
	INSERT INTO ATTRIBUTE_GROUP_DESC (attribute_group_id,attribute_group_name,sort_order) VALUES (2,'model',1)
	INSERT INTO ATTRIBUTE_GROUP_DESC (attribute_group_id,attribute_group_name,sort_order) VALUES (3,'size',3)