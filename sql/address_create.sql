-- Table: public.address

-- DROP TABLE public.address;

CREATE TABLE public.address
(
    id bigint NOT NULL,
    city character varying(255) COLLATE pg_catalog."default",
    district character varying(255) COLLATE pg_catalog."default",
    "number" integer NOT NULL,
    state character varying(255) COLLATE pg_catalog."default",
    street character varying(255) COLLATE pg_catalog."default",
    zip_code character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT address_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.address
    OWNER to postgres;