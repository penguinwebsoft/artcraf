CREATE TABLE attribute_category
(
  attribute_category_id bigint,
  sub_category_id bigint,
  attribute_id bigint
  CONSTRAINT attribute_category_attribute_id_fkey FOREIGN KEY (attribute_id)
      REFERENCES attribute (attribute_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT attribute_category_category_id_fkey FOREIGN KEY (sub_category_id)
      REFERENCES category (category_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

ALTER TABLE attribute_category
  ADD CONSTRAINT attribute_category_id_pk 
    PRIMARY KEY (attribute_category_id);