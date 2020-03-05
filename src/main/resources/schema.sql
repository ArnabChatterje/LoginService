DROP TABLE IF EXISTS login;
  
CREATE TABLE login(
  
  username VARCHAR(250) primary key,
  password VARCHAR(250) NOT NULL
 
);

CREATE TABLE user(
  
  id int primary key,
  name VARCHAR(250) NOT NULL
 
);