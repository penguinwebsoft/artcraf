CREATE TABLE INFORMATION (
	INFORMATION_ID BIGINT PRIMARY KEY NOT NULL,
        INFORMATION_TITLE CHARACTER VARYING(45),
	DESCRIPTION CHARACTER VARYING(500),
	META_TITLE CHARACTER VARYING(50),
	META_DESCRIPTION CHARACTER VARYING(100),
	META_KEYWORD CHARACTER VARYING(50),
	IS_ACTIVE CHARACTER VARYING(20),
	SORT_ORDER INTEGER
	)
	
	
alter table information drop column META_TITLE;
alter table information drop column META_DESCRIPTION;
alter table information drop column META_KEYWORD;

/*************add seo************/
alter table information add column seo_id BIGINT;

/************alter information adding seo_id*******************/
ALTER TABLE information
  ADD CONSTRAINT information_seo_id_fkey FOREIGN KEY (seo_id)
      REFERENCES seo (seo_id) ON UPDATE NO ACTION ON DELETE NO ACTION;