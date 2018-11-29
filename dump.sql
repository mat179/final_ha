--
-- PostgreSQL database dump
--

-- Dumped from database version 10.0
-- Dumped by pg_dump version 10.5

-- Started on 2018-11-17 00:11:15

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--DROP DATABASE healthappdb;
--
-- TOC entry 2842 (class 1262 OID 362871)
-- Name: healthappdb; Type: DATABASE; Schema: -; Owner: postgres
--

--CREATE DATABASE healthappdb WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';


ALTER DATABASE healthappdb OWNER TO postgres;

--\connect healthappdb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12924)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2845 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 362896)
-- Name: doctor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.doctor (
    id integer NOT NULL,
    speciality_code character varying(20) NOT NULL,
    create_time date DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_updated date NOT NULL,
    user_id integer NOT NULL
);


ALTER TABLE public.doctor OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 362894)
-- Name: doctor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.doctor_id_seq OWNER TO postgres;

--
-- TOC entry 2846 (class 0 OID 0)
-- Dependencies: 198
-- Name: doctor_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.doctor_id_seq OWNED BY public.doctor.id;


--
-- TOC entry 203 (class 1259 OID 362987)
-- Name: public_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.public_user (
    id integer NOT NULL,
    age numeric(19,2),
    email character varying(50) NOT NULL,
    first_name character varying(20) NOT NULL,
    gender numeric(19,2),
    last_name character varying(20),
    password character varying(250) NOT NULL
);


ALTER TABLE public.public_user OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 362985)
-- Name: public_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.public_user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.public_user_id_seq OWNER TO postgres;

--
-- TOC entry 2847 (class 0 OID 0)
-- Dependencies: 202
-- Name: public_user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.public_user_id_seq OWNED BY public.public_user.id;


--
-- TOC entry 201 (class 1259 OID 362909)
-- Name: rx; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rx (
    id integer NOT NULL,
    user_id integer NOT NULL,
    doctor_id integer NOT NULL,
    symptoms character varying(250),
    medicine character varying(250),
    create_time date DEFAULT CURRENT_TIMESTAMP NOT NULL,
    last_updated date NOT NULL
);


ALTER TABLE public.rx OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 362907)
-- Name: rx_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rx_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rx_id_seq OWNER TO postgres;

--
-- TOC entry 2848 (class 0 OID 0)
-- Dependencies: 200
-- Name: rx_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rx_id_seq OWNED BY public.rx.id;


--
-- TOC entry 197 (class 1259 OID 362874)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(250) NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20),
    age numeric,
    gender numeric
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 362872)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 2849 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- TOC entry 2691 (class 2604 OID 362899)
-- Name: doctor id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor ALTER COLUMN id SET DEFAULT nextval('public.doctor_id_seq'::regclass);


--
-- TOC entry 2695 (class 2604 OID 362990)
-- Name: public_user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_user ALTER COLUMN id SET DEFAULT nextval('public.public_user_id_seq'::regclass);


--
-- TOC entry 2693 (class 2604 OID 362912)
-- Name: rx id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rx ALTER COLUMN id SET DEFAULT nextval('public.rx_id_seq'::regclass);


--
-- TOC entry 2690 (class 2604 OID 362877)
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- TOC entry 2832 (class 0 OID 362896)
-- Dependencies: 199
-- Data for Name: doctor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.doctor (id, speciality_code, create_time, last_updated, user_id) VALUES (1, 'PHYSICIST', '2018-11-16', '2018-11-16', 1);


--
-- TOC entry 2836 (class 0 OID 362987)
-- Dependencies: 203
-- Data for Name: public_user; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2834 (class 0 OID 362909)
-- Dependencies: 201
-- Data for Name: rx; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2830 (class 0 OID 362874)
-- Dependencies: 197
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."user" (id, email, password, first_name, last_name, age, gender) VALUES (1, 'test@gmail.com', 'test', 'user', 'tester', 26, 1);


--
-- TOC entry 2850 (class 0 OID 0)
-- Dependencies: 198
-- Name: doctor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.doctor_id_seq', 1, true);


--
-- TOC entry 2851 (class 0 OID 0)
-- Dependencies: 202
-- Name: public_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.public_user_id_seq', 1, false);


--
-- TOC entry 2852 (class 0 OID 0)
-- Dependencies: 200
-- Name: rx_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rx_id_seq', 1, false);


--
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 1, true);


--
-- TOC entry 2699 (class 2606 OID 362901)
-- Name: doctor pk_doctor_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT pk_doctor_id PRIMARY KEY (id);


--
-- TOC entry 2701 (class 2606 OID 362917)
-- Name: rx pk_rx_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rx
    ADD CONSTRAINT pk_rx_id PRIMARY KEY (id);


--
-- TOC entry 2703 (class 2606 OID 362992)
-- Name: public_user public_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.public_user
    ADD CONSTRAINT public_user_pkey PRIMARY KEY (id);


--
-- TOC entry 2697 (class 2606 OID 362882)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


--
-- TOC entry 2704 (class 2606 OID 362902)
-- Name: doctor fk_doctor_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.doctor
    ADD CONSTRAINT fk_doctor_user_id FOREIGN KEY (user_id) REFERENCES public."user"(id) ON DELETE CASCADE;


--
-- TOC entry 2706 (class 2606 OID 362923)
-- Name: rx fk_rx_doctor_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rx
    ADD CONSTRAINT fk_rx_doctor_id FOREIGN KEY (doctor_id) REFERENCES public.doctor(id) ON DELETE CASCADE;


--
-- TOC entry 2705 (class 2606 OID 362918)
-- Name: rx fk_rx_user_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rx
    ADD CONSTRAINT fk_rx_user_id FOREIGN KEY (user_id) REFERENCES public."user"(id) ON DELETE CASCADE;


--
-- TOC entry 2707 (class 2606 OID 362998)
-- Name: rx fkjt8sjb5er5cqtxibg9qdvx9b4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

/*ALTER TABLE ONLY public.rx
    ADD CONSTRAINT fkjt8sjb5er5cqtxibg9qdvx9b4 FOREIGN KEY (user_id) REFERENCES public.public_user(id) ON DELETE CASCADE;
*/

--
-- TOC entry 2844 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2018-11-17 00:11:15

--
-- PostgreSQL database dump complete
--

