CREATE TABLE IF NOT EXISTS MEMBER (
    USER_ID VARCHAR(20) PRIMARY KEY,
    USER_PWD VARCHAR(256) NOT NULL,
    USER_NM VARCHAR(20) NOT NULL,
    GENDER VARCHAR(1) NOT NULL,
	HEIGHT NUMBER(3) ,
	WEIGHT NUMBER(3) ,
	PRIVATE_YN VARCHAR(1) DEFAULT ('N'), 	-- 개인정보 보호여부
	REGDATE TIMESTAMP
);

CREATE TABLE IF NOT EXISTS oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS OAUTH_CLIENT_TOKEN (
    TOKEN_ID VARCHAR(256),
    TOKEN LONGVARBINARY,
    AUTHENTICATION_ID VARCHAR(256) PRIMARY KEY,
    USER_NAME VARCHAR(256),
    CLIENT_ID VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS OAUTH_ACCESS_TOKEN(
    TOKEN_ID VARCHAR(256),
    TOKEN LONGVARBINARY,
    AUTHENTICATION_ID VARCHAR(256) PRIMARY KEY,
    USER_NAME VARCHAR(256),
    CLIENT_ID VARCHAR(256),
    AUTHENTICATION LONGVARBINARY,
    REFRESH_TOKEN VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS oauth_refresh_token (
    token_id VARCHAR(256),
    token LONGVARBINARY,
    authentication LONGVARBINARY
);

CREATE TABLE IF NOT EXISTS oauth_code (
    code VARCHAR(256),
    authentication LONGVARBINARY
);

CREATE TABLE IF NOT EXISTS oauth_approvals(
    USER_ID VARCHAR(256),
    client_id VARCHAR(256),
    scope VARCHAR(256),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);