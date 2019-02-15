drop table if exists oauth_access_token; 
CREATE TABLE oauth_access_token ( 
  token_id VARCHAR(256) DEFAULT NULL, 
  token BLOB, 
  authentication_id VARCHAR(256) DEFAULT NULL PRIMARY KEY, 
  user_name VARCHAR(256) DEFAULT NULL, 
  client_id VARCHAR(256) DEFAULT NULL, 
  authentication BLOB, 
  refresh_token VARCHAR(256) DEFAULT NULL 
); 
  
drop table if exists oauth_refresh_token; 
CREATE TABLE oauth_refresh_token ( 
  token_id VARCHAR(256) DEFAULT NULL, 
  token BLOB, 
  authentication BLOB 
);