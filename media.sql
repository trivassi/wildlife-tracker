--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: T
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    age integer,
    email character varying,
    phone character varying,
    appointment timestamp without time zone,
    stylistid integer
);


ALTER TABLE clients OWNER TO "T";

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: T
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO "T";

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: T
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: T
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    age integer,
    email character varying,
    phone character varying
);


ALTER TABLE stylists OWNER TO "T";

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: T
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO "T";

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: T
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: T
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: T
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: T
--

COPY clients (id, name, age, email, phone, appointment, stylistid) FROM stdin;
1	wed	123	ewfef	reqg	2016-09-15 00:00:00	1
2	scsf	23	ERGFRG	sdfgreg	2016-09-14 00:00:00	1
3	sfcsdf	12	fefef	geqreg	2016-01-12 00:00:00	1
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: T
--

SELECT pg_catalog.setval('clients_id_seq', 4, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: T
--

COPY stylists (id, name, age, email, phone) FROM stdin;
3	thoms	24	sdf@efkjn.com	911
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: T
--

SELECT pg_catalog.setval('stylists_id_seq', 3, true);


--
-- Name: clients_pkey; Type: CONSTRAINT; Schema: public; Owner: T
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: T
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: T
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM "T";
GRANT ALL ON SCHEMA public TO "T";
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

