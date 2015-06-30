CREATE TABLE banner(
banner_id bigint NOT NULL,
banner_name character varying(100),
banner_image character varying(45),
banner_url character varying(100),
sort_order integer,
banner_group_id bigint;
)
