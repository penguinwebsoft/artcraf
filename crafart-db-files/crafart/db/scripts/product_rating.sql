/* Added on 05/05/2015 */

CREATE TABLE PRODUCT_RATING (
PRODUCT_RATING_ID BIGINT PRIMARY KEY NOT NULL,
PRODUCT_ID BIGINT REFERENCES PRODUCT (PRODUCT_ID),
CUSTOMER_ID BIGINT REFERENCES CUSTOMER (CUSTOMER_ID),
POINTS NUMERIC 
)
