DROP SEQUENCE wk_user_sequence;
DROP SEQUENCE wk_topic_sequence;
DROP SEQUENCE wk_article_sequence;

DROP TABLE wk_users;
DROP TABLE wk_topics;
DROP TABLE wk_articles;


CREATE SEQUENCE wk_user_sequence
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE wk_topic_sequence
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE wk_article_sequence
START WITH 1
INCREMENT BY 1;


CREATE TABLE wk_users(
	ID NUMBER(7) PRIMARY KEY,
  user_name VARCHAR2(20) NOT NULL,
  PASSWORD VARCHAR2(50) NOT NULL,
  ISSUPERADMIN VARCHAR(1) NOT NULL,
  status NUMBER(2) NOT NULL
);


CREATE TABLE wk_topics(
  ID NUMBER(7) PRIMARY KEY ,
  NAME NVARCHAR2(50) NOT NULL,
  DESCRIPTION NVARCHAR2(200),
  create_by  VARCHAR2(20),
  create_date DATE,
  update_by VARCHAR2(20),
	update_date DATE
);

CREATE TABLE wk_articles(
  ID NUMBER(10) PRIMARY KEY ,
	id_topic NUMBER(7) NOT NULL,
  subject NVARCHAR2(200) NOT NULL,
	CONTENT LONG NOT NULL,
  STATUS NUMBER(2) NOT NULL,
	create_by  VARCHAR2(20),
  create_date DATE,
  update_by VARCHAR2(20),
	update_date DATE,
  CONSTRAINT fk_id_topic FOREIGN KEY (id_topic) REFERENCES wk_topics(ID)
);








