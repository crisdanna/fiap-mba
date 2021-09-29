-- Table: public.person

-- DROP TABLE public.person;

CREATE TABLE public.person
(
    person_type integer NOT NULL,
    id bigint NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    lastname character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT person_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.person
    OWNER to postgres;