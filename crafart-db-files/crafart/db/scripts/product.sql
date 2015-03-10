CREATE TABLE product
(
  product_id bigint NOT NULL,
  category_id bigint,
  model character varying(45),
  sku character varying(45),
  upc character varying(45),
  location character varying(45),
  quantity character varying(45),
  stock_status_id character varying(45),
  image character varying(45),
  seller_id bigint,
  shipping bigint,
  price double precision,
  points smallint,
  tax_class_id bigint,
  date_available timestamp without time zone,
  weight character varying(45),
  weight_class_id bigint,
  length numeric,
  width numeric,
  height numeric,
  length_class_id bigint,
  subtract numeric,
  minimum numeric,
  sort_order character varying(45),
  status smallint,
  viewed smallint,
  created_dttm timestamp without time zone DEFAULT now(),
  modified_dttm timestamp without time zone DEFAULT now(),
  CONSTRAINT product_pkey PRIMARY KEY (product_id),
  CONSTRAINT product_category_id_fkey FOREIGN KEY (category_id)
      REFERENCES category (category_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT product_length_class_id_fkey FOREIGN KEY (length_class_id)
      REFERENCES length_class (length_class_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT product_seller_id_fkey FOREIGN KEY (seller_id)
      REFERENCES seller (seller_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT product_tax_class_id_fkey FOREIGN KEY (tax_class_id)
      REFERENCES tax_class (tax_class_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT product_weight_class_id_fkey FOREIGN KEY (weight_class_id)
      REFERENCES weight_class (weight_class_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

