CREATE TABLE CRAFART.SELLER_CONTACT (
	SELLER_CONTACT_ID BIGINT SERIAL PRIMARY KEY NOT NULL, 
	SELLER_ID BIGINT REFERENCES CRAFART.SELLER(SELLER_ID), 
	CONTACT_ID BIGINT REFERENCES CRAFART.CONTACT(CONTACT_ID)
)