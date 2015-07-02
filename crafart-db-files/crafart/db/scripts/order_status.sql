CREATE TABLE order_status
(
  order_status_id bigint NOT NULL,
  order_status_title character varying(45),
  order_status_subject character varying(45),
  description character varying(100),
  sort_order integer
)