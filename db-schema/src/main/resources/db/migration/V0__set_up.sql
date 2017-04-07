CREATE USER listsapp WITH password 'listsapp';

--CREATE SCHEMA listsapp;

--GRANT USAGE ON SCHEMA listsapp TO listsapp;
ALTER USER listsapp SET search_path = 'public';

-- ensure that user listsapp will have the needed privileges on new tables
ALTER DEFAULT PRIVILEGES
   IN SCHEMA PUBLIC
GRANT SELECT, UPDATE, INSERT, DELETE ON TABLES
   TO listsapp;

-- ensure that user listsapp will have the needed privileges on new sequences
ALTER DEFAULT PRIVILEGES
   IN SCHEMA PUBLIC
GRANT USAGE ON SEQUENCES
   TO listsapp;

-- ensure that new functions will not have default privilege in public schema
ALTER DEFAULT PRIVILEGES
REVOKE EXECUTE ON FUNCTIONS
 FROM PUBLIC;

-- revoke default function privilege
REVOKE EXECUTE
   ON ALL FUNCTIONS IN SCHEMA PUBLIC
 FROM PUBLIC;