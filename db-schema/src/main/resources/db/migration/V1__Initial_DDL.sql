CREATE TABLE lists (

    id uuid PRIMARY KEY NOT NULL,
	name VARCHAR(200) NOT NULL,
    user_id uuid NOT NULL,
    removed boolean NOT NULL,
    created_at timestamptz,
    updated_at timestamptz

);

CREATE TABLE items (

    id uuid PRIMARY KEY NOT NULL,
	name VARCHAR(200) NOT NULL,
    checked boolean NOT NULL,
    quantity integer,
    removed boolean NOT NULL,
    list_id uuid NOT NULL,
    created_at timestamptz,
    updated_at timestamptz,
    CONSTRAINT item_list_fk FOREIGN KEY (list_id) REFERENCES "lists" (id)

);


CREATE TABLE invites (

    id uuid PRIMARY KEY NOT NULL,
	link VARCHAR(200) NOT NULL,
    expiration_date timestamptz,
    removed boolean NOT NULL,
    list_id uuid NOT NULL,
    CONSTRAINT invite_list_fk FOREIGN KEY (list_id) REFERENCES "lists" (id)

);