-- Table: public.procedure

-- DROP TABLE public.procedure;

CREATE SEQUENCE public.procedure_id_seq;

CREATE TABLE public.procedure
(
    id bigint NOT NULL DEFAULT nextval('procedure_id_seq'),
    decription character varying(255) COLLATE pg_catalog."default",
    is_authorizationm boolean NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT procedure_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE public.procedure
    OWNER to postgres;
    
ALTER SEQUENCE procedure_id_seq OWNED BY procedure.id;