CREATE TABLE attribute
(
  
attribute_id bigint NOT NULL,
  
category_id bigint NOT NULL,
attribute_name character varying(45),
 
sort_order smallint,
  
CONSTRAINT attribute_pkey PRIMARY KEY (attribute_id),

CONSTRAINT category_id_fkey FOREIGN KEY (category_id)
      REFERENCES category (category_id) MATCH SIMPLE
  
ON UPDATE NO ACTION ON DELETE NO ACTION)