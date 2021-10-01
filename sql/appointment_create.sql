-- Table: public.appointment

-- DROP TABLE public.appointment;
CREATE SEQUENCE public.appointment_id_seq;

CREATE TABLE public.appointment
(
    id bigint NOT NULL DEFAULT nextval('appointment_id_seq'),
    "date" date,
    "time" time without time zone,
    professional_id bigint,
    treatment_id bigint,
    CONSTRAINT appointment_pkey PRIMARY KEY (id),
    CONSTRAINT fkqc59pgubeywiag0rl1nf26h1w FOREIGN KEY (professional_id)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkqc59pgubeywiag0rl1nf26h2w FOREIGN KEY (treatment_id)
        REFERENCES public.treatment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.appointment
    OWNER to postgres;
    
ALTER SEQUENCE appointment_id_seq OWNED BY appointment.id;