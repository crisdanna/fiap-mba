-- Table: public.procedure

-- DROP TABLE public.procedure;

CREATE TABLE public.procedure
(
    id bigint NOT NULL,
    decription character varying(255) COLLATE pg_catalog."default",
    is_authorizationm boolean NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT procedure_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.procedure
    OWNER to postgres;