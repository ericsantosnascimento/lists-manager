CREATE USER acme WITH password 'lists-app';

--CREATE SCHEMA lists-app;

--GRANT USAGE ON SCHEMA lists-app TO lists-app;
ALTER USER lists-app SET search_path = 'public';

-- ensure that user lists-app will have the needed privileges on new tables
ALTER DEFAULT PRIVILEGES
   IN SCHEMA PUBLIC
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLES
   TO lists-app;

-- ensure that user lists-app will have the needed privileges on new sequences
ALTER DEFAULT PRIVILEGES
   IN SCHEMA PUBLIC
GRANT USAGE ON SEQUENCES
   TO lists-app;

-- ensure that new functions will not have default privilege in public schema
ALTER DEFAULT PRIVILEGES
REVOKE EXECUTE ON FUNCTIONS
 FROM PUBLIC;

-- revoke default function privilege
REVOKE EXECUTE
   ON ALL FUNCTIONS IN SCHEMA PUBLIC
 FROM PUBLIC;