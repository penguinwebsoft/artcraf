/* Added on 05/05/2015 */
CREATE SEQUENCE seq_rating
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_rating.product_rating_id

