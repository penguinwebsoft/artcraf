CREATE TABLE User_detail
(
   user_id bigint NOT NULL,
  user_group_id bigint NOT NULL,
  user_name character varying(45),
  first_name character varying(45),
  last_name character varying(45),
  password character varying(30),
  is_active character varying(30),
  CONSTRAINT user_pkey PRIMARY KEY (user_id)
)
