CREATE TABLE MESSAGE (
  id                BIGINT                 PRIMARY KEY,
  name              CHARACTER VARYING(100) UNIQUE NOT NULL,
  phone             CHARACTER VARYING(100) NOT NULL,
  organization_id   BIGINT                 NOT NULL
  message           VARCHAR(500)           NOT NULL,
);


