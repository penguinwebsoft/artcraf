CREATE TABLE discount
(
  discount_id bigint NOT NULL,
  code integer,
  type smallint,
  value integer,
  uses_per_coupon integer,
  uses_per_customer integer,
  start_date character varying(20),
  end_date character varying(20),
  status smallint,
  CONSTRAINT discount_pkey PRIMARY KEY (discount_id)
)

ALTER TABLE discount  OWNER TO postgres;
