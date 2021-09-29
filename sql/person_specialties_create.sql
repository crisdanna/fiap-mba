-- Table: public.person_specialties

-- DROP TABLE public.person_specialties;

CREATE TABLE public.person_specialties
(
    professional_id bigint NOT NULL,
    specialties_id bigint NOT NULL,
    CONSTRAINT uk_nqsav6show52otq5w4yu5d59f UNIQUE (specialties_id),
    CONSTRAINT fk59gn425s8uve412pbjrq23ou9 FOREIGN KEY (professional_id)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkflv90huk2lv8n8fmd4fxxk7ov FOREIGN KEY (specialties_id)
        REFERENCES public.procedure (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.person_specialties
    OWNER to postgres;