-- Table: public.appointment

-- DROP TABLE public.appointment;

CREATE TABLE public.appointment
(
    id bigint NOT NULL,
    "date" date,
    "time" time without time zone,
    professional_id bigint,
    CONSTRAINT appointment_pkey PRIMARY KEY (id),
    CONSTRAINT fkqc59pgubeywiag0rl1nf26h1w FOREIGN KEY (professional_id)
        REFERENCES public.professional (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.appointment
    OWNER to postgres;