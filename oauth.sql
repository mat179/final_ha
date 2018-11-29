--
-- Table structure for table oauth_access_token
--

DROP TABLE IF EXISTS oauth_access_token;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE oauth_access_token (
  token_id varchar(255) DEFAULT NULL,
  token bytea,
  authentication_id varchar(255) NOT NULL,
  user_name varchar(255) DEFAULT NULL,
  client_id varchar(255) DEFAULT NULL,
  authentication bytea,
  refresh_token varchar(255) DEFAULT NULL,
  PRIMARY KEY (authentication_id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table oauth_access_token
--

LOCK TABLES oauth_access_token WRITE;
/*!40000 ALTER TABLE oauth_access_token DISABLE KEYS */;
/*!40000 ALTER TABLE oauth_access_token ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table oauth_approvals
--

DROP TABLE IF EXISTS oauth_approvals;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE oauth_approvals (
  userId varchar(255) DEFAULT NULL,
  clientId varchar(255) DEFAULT NULL,
  scope varchar(255) DEFAULT NULL,
  status varchar(10) DEFAULT NULL,
  expiresAt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  lastModifiedAt timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table oauth_approvals
--

LOCK TABLES oauth_approvals WRITE;
/*!40000 ALTER TABLE oauth_approvals DISABLE KEYS */;
/*!40000 ALTER TABLE oauth_approvals ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table oauth_client_details
--

DROP TABLE IF EXISTS oauth_client_details;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE oauth_client_details (
  client_id varchar(255) NOT NULL,
  resource_ids varchar(255) DEFAULT NULL,
  client_secret varchar(255) DEFAULT NULL,
  scope varchar(255) DEFAULT NULL,
  authorized_grant_types varchar(255) DEFAULT NULL,
  web_server_redirect_uri varchar(255) DEFAULT NULL,
  authorities varchar(255) DEFAULT NULL,
  access_token_validity numeric DEFAULT NULL,
  refresh_token_validity numeric DEFAULT NULL,
  additional_information varchar(4096) DEFAULT NULL,
  autoapprove varchar(255) DEFAULT NULL,
  PRIMARY KEY (client_id)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table oauth_client_details
--

LOCK TABLES oauth_client_details WRITE;
/*!40000 ALTER TABLE oauth_client_details DISABLE KEYS */;
/*!40000 ALTER TABLE oauth_client_details ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table oauth_client_token
--

DROP TABLE IF EXISTS oauth_client_token;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE oauth_client_token (
  token_id varchar(255) DEFAULT NULL,
  token bytea,
  authentication_id varchar(255) NOT NULL,
  user_name varchar(255) DEFAULT NULL,
  client_id varchar(255) DEFAULT NULL,
  PRIMARY KEY (authentication_id)
) ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table oauth_client_token
--

LOCK TABLES oauth_client_token WRITE;
/*!40000 ALTER TABLE oauth_client_token DISABLE KEYS */;
/*!40000 ALTER TABLE oauth_client_token ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table oauth_code
--

DROP TABLE IF EXISTS oauth_code;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE oauth_code (
  code varchar(255) DEFAULT NULL,
  authentication bytea
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table oauth_code
--

LOCK TABLES oauth_code WRITE;
/*!40000 ALTER TABLE oauth_code DISABLE KEYS */;
/*!40000 ALTER TABLE oauth_code ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table oauth_refresh_token
--

DROP TABLE IF EXISTS oauth_refresh_token;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE oauth_refresh_token (
  token_id varchar(255) DEFAULT NULL,
  token bytea,
  authentication bytea
);
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table oauth_refresh_token
--

LOCK TABLES oauth_refresh_token WRITE;
/*!40000 ALTER TABLE oauth_refresh_token DISABLE KEYS */;
/*!40000 ALTER TABLE oauth_refresh_token ENABLE KEYS */;
UNLOCK TABLES;






INSERT INTO oauth_client_details
    (client_id, client_secret, scope, authorized_grant_types,
    web_server_redirect_uri, authorities, access_token_validity,
    refresh_token_validity, additional_information, autoapprove)
VALUES
    ('healthapp', '{noop}HeAltH@!23', 'read,write,doctor',
    'password,authorization_code,refresh_token', null, null, 3600, 36000, null, true);
