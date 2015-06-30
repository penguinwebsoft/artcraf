/* Added on 05/05/2015 */
CREATE SEQUENCE seq_review
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 20
  owned by product_review.product_review_id
