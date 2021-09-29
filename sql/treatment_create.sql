-- Table: public.treatment

-- DROP TABLE public.treatment;

CREATE TABLE public.treatment
(
    id bigint NOT NULL,
    authorization_number integer NOT NULL,
    patient_id bigint,
    procedure_id bigint,
    CONSTRAINT treatment_pkey PRIMARY KEY (id),
    CONSTRAINT fk9eiju36dlnn6aan15ajmmw7fa FOREIGN KEY (procedure_id)
        REFERENCES public.procedure (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkljfp6d2buav9b8pjj6lx4m4qa FOREIGN KEY (patient_id)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.treatment
    OWNER to postgres;