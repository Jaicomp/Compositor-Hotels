--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.5
-- Dumped by pg_dump version 9.5.5

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
-- Name: Booking; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Booking" (
    id integer NOT NULL,
    adult smallint,
    smallers smallint,
    entry_date date,
    departure_date date,
    idclient integer,
    idhotel integer,
    idtyperoom integer
);


ALTER TABLE "Booking" OWNER TO postgres;

--
-- Name: Booking_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Booking_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Booking_id_seq" OWNER TO postgres;

--
-- Name: Booking_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Booking_id_seq" OWNED BY "Booking".id;


--
-- Name: Client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Client" (
    id integer NOT NULL,
    username character varying(50),
    password character varying(50),
    firstname character varying(50),
    lastname character varying(50),
    email character varying(50)
);


ALTER TABLE "Client" OWNER TO postgres;

--
-- Name: Client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Client_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Client_id_seq" OWNER TO postgres;

--
-- Name: Client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Client_id_seq" OWNED BY "Client".id;


--
-- Name: Hotel; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Hotel" (
    id integer NOT NULL,
    name character varying(30),
    description character varying(100),
    url character varying(50)
);


ALTER TABLE "Hotel" OWNER TO postgres;

--
-- Name: Hotel_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Hotel_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Hotel_id_seq" OWNER TO postgres;

--
-- Name: Hotel_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Hotel_id_seq" OWNED BY "Hotel".id;


--
-- Name: Marketing; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "Marketing" (
    id integer NOT NULL,
    namepage character varying(50),
    title character varying(50),
    keywords character varying(50),
    description character varying(50),
    language character varying(50),
    visited integer
);


ALTER TABLE "Marketing" OWNER TO postgres;

--
-- Name: Marketing_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "Marketing_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "Marketing_id_seq" OWNER TO postgres;

--
-- Name: Marketing_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "Marketing_id_seq" OWNED BY "Marketing".id;


--
-- Name: R_Hotel_TypeRoom; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "R_Hotel_TypeRoom" (
    id integer NOT NULL,
    idhotel integer,
    idtyperoom integer,
    numroomsavailable integer,
    price integer
);


ALTER TABLE "R_Hotel_TypeRoom" OWNER TO postgres;

--
-- Name: R_Hotel_TypeRoom_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "R_Hotel_TypeRoom_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "R_Hotel_TypeRoom_id_seq" OWNER TO postgres;

--
-- Name: R_Hotel_TypeRoom_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "R_Hotel_TypeRoom_id_seq" OWNED BY "R_Hotel_TypeRoom".id;


--
-- Name: TypeRoom; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE "TypeRoom" (
    id integer NOT NULL,
    name character varying(30),
    description character varying(100)
);


ALTER TABLE "TypeRoom" OWNER TO postgres;

--
-- Name: TypeRoom_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE "TypeRoom_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE "TypeRoom_id_seq" OWNER TO postgres;

--
-- Name: TypeRoom_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE "TypeRoom_id_seq" OWNED BY "TypeRoom".id;


--
-- Name: dif; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE dif (
    "?column?" integer
);


ALTER TABLE dif OWNER TO postgres;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Booking" ALTER COLUMN id SET DEFAULT nextval('"Booking_id_seq"'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Client" ALTER COLUMN id SET DEFAULT nextval('"Client_id_seq"'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Hotel" ALTER COLUMN id SET DEFAULT nextval('"Hotel_id_seq"'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Marketing" ALTER COLUMN id SET DEFAULT nextval('"Marketing_id_seq"'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "R_Hotel_TypeRoom" ALTER COLUMN id SET DEFAULT nextval('"R_Hotel_TypeRoom_id_seq"'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TypeRoom" ALTER COLUMN id SET DEFAULT nextval('"TypeRoom_id_seq"'::regclass);


--
-- Data for Name: Booking; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Booking" (id, adult, smallers, entry_date, departure_date, idclient, idhotel, idtyperoom) FROM stdin;
3	1	0	2016-12-18	2016-12-19	1	1	1
4	1	0	2016-12-18	2016-12-19	1	1	1
5	1	0	2016-12-18	2016-12-19	5	1	1
6	10	9	2016-11-21	2016-11-22	6	2	2
7	1	0	2016-11-21	2016-11-21	1	2	1
8	5	5	2016-11-21	2016-11-21	1	2	1
9	1	0	2016-11-21	2016-11-21	1	1	3
10	2	0	2016-11-19	2016-11-19	1	2	5
\.


--
-- Name: Booking_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Booking_id_seq"', 10, true);


--
-- Data for Name: Client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Client" (id, username, password, firstname, lastname, email) FROM stdin;
1	admin	123	Jaime	Crespí	jai@com
2	jaime	123	jaime	crespi	jai@com
3	jai	123	f	l	e
4	ok	123	fir	las	ema
5	loli	123	loli	lolo	looool@gmail.com
6	josele	123	josito	josolo	asd
7	asd	asd	asd	asd	asd
\.


--
-- Name: Client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Client_id_seq"', 7, true);


--
-- Data for Name: Hotel; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Hotel" (id, name, description, url) FROM stdin;
1	SonNet	Gran Hotel en Puigpunyent	sonnet@mail.com
2	CanBlau	Gran Hotel en Puigpunyent	canblau@mail.com
\.


--
-- Name: Hotel_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Hotel_id_seq"', 3, true);


--
-- Data for Name: Marketing; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "Marketing" (id, namepage, title, keywords, description, language, visited) FROM stdin;
2	marketing.jsp	Marketing Pages	Booking,marketing,hotel	Status page	spanish	106
3	reservation.jsp	Reservation Page	Booking,reservation,hotel	Reservation a room	spanish	492
1	rooms.jsp	Rooms Page	Booking,rooms,hotel	Booking a room	spanish	329
4	tribago.jsp	Booking	Tribago,reservation,hotel	See avaliable room	spanish	49
5	reception.jsp	Reception	Reception,Back office, hotel	Manage rooms	spanish	449
\.


--
-- Name: Marketing_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"Marketing_id_seq"', 5, true);


--
-- Data for Name: R_Hotel_TypeRoom; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "R_Hotel_TypeRoom" (id, idhotel, idtyperoom, numroomsavailable, price) FROM stdin;
3	1	3	2	450
4	1	4	6	850
6	2	1	5	300
7	2	4	9	700
8	2	5	4	150
9	2	3	5	480
10	2	2	1	200
1	1	1	3	355
2	1	2	11	250
5	1	5	3	200
\.


--
-- Name: R_Hotel_TypeRoom_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"R_Hotel_TypeRoom_id_seq"', 10, true);


--
-- Data for Name: TypeRoom; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "TypeRoom" (id, name, description) FROM stdin;
1	Suite	Big room
2	Junior Suite	small room for children
3	Doble	For two people
4	Doble Vista Mar	For two people with sea view
5	Individual	For a person
\.


--
-- Name: TypeRoom_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('"TypeRoom_id_seq"', 5, true);


--
-- Data for Name: dif; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dif ("?column?") FROM stdin;
2
\.


--
-- Name: Booking_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Booking"
    ADD CONSTRAINT "Booking_pkey" PRIMARY KEY (id);


--
-- Name: Client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Client"
    ADD CONSTRAINT "Client_pkey" PRIMARY KEY (id);


--
-- Name: Hotel_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Hotel"
    ADD CONSTRAINT "Hotel_pkey" PRIMARY KEY (id);


--
-- Name: Marketing_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Marketing"
    ADD CONSTRAINT "Marketing_pkey" PRIMARY KEY (id);


--
-- Name: R_Hotel_TypeRoom_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "R_Hotel_TypeRoom"
    ADD CONSTRAINT "R_Hotel_TypeRoom_pkey" PRIMARY KEY (id);


--
-- Name: TypeRoom_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "TypeRoom"
    ADD CONSTRAINT "TypeRoom_pkey" PRIMARY KEY (id);


--
-- Name: Booking_idclient_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Booking"
    ADD CONSTRAINT "Booking_idclient_fkey" FOREIGN KEY (idclient) REFERENCES "Client"(id);


--
-- Name: Booking_idhotel_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Booking"
    ADD CONSTRAINT "Booking_idhotel_fkey" FOREIGN KEY (idhotel) REFERENCES "Hotel"(id);


--
-- Name: Booking_idtyperoom_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "Booking"
    ADD CONSTRAINT "Booking_idtyperoom_fkey" FOREIGN KEY (idtyperoom) REFERENCES "TypeRoom"(id);


--
-- Name: R_Hotel_TypeRoom_idhotel_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "R_Hotel_TypeRoom"
    ADD CONSTRAINT "R_Hotel_TypeRoom_idhotel_fkey" FOREIGN KEY (idhotel) REFERENCES "Hotel"(id);


--
-- Name: R_Hotel_TypeRoom_idtyperoom_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "R_Hotel_TypeRoom"
    ADD CONSTRAINT "R_Hotel_TypeRoom_idtyperoom_fkey" FOREIGN KEY (idtyperoom) REFERENCES "TypeRoom"(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

