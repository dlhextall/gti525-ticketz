-- BEGIN Type creation
CREATE TYPE ticketstate AS ENUM ('AVAILABLE', 'RESERVED', 'SOLD');
-- END Type creation

-- BEGIN Object table creation
CREATE TABLE Artist (
  id SERIAL,
  name text NOT NULL,
  biography text
);

CREATE TABLE Show (
  id SERIAL,
  name text NOT NULL,
  description text NOT NULL,
  venue text NOT NULL,
  address text NOT NULL,
  imageFeaturedUrl text NOT NULL,
  imageThumbUrl text,
  imageDetailUrl text,
  featured boolean NOT NULL default false
);

CREATE TABLE Representation (
  id SERIAL,
  price numeric NOT NULL,
  moment timestamp NOT NULL
);

CREATE TABLE Ticket (
  id SERIAL,
  state ticketstate NOT NULL default 'AVAILABLE'
);

CREATE TABLE ClientOrder (
  id SERIAL,
  moment timestamp NOT NULL
);

CREATE TABLE Client (
  id SERIAL,
  lastName text NOT NULL,
  firstName text NOT NULL,
  address text NOT NULL,
  city text NOT NULL,
  province text NOT NULL,
  country text NOT NULL,
  postalCode text NOT NULL,
  telephone text NOT NULL
);

CREATE TABLE CreditCard (
  id SERIAL,
  last4 text NOT NULL,
  lastName text NOT NULL,
  firstName text NOT NULL
);
-- END Object table creation

-- BEGIN Relation table creation
CREATE TABLE Show_Artist (
  s_id int NOT NULL,
  a_id int NOT NULL
);

CREATE TABLE Show_Representation (
  s_id int NOT NULL,
  r_id int NOT NULL
);

CREATE TABLE Representation_Ticket (
  r_id int NOT NULL,
  t_id int NOT NULL
);

CREATE TABLE ClientOrder_Representation (
  co_id int NOT NULL,
  r_id int NOT NULL
);

CREATE TABLE ClientOrder_Client (
  co_id int NOT NULL,
  c_id int NOT NULL
);

CREATE TABLE Client_CreditCard (
  c_id int NOT NULL,
  cc_id int NOT NULL
);
-- END Relation table creation