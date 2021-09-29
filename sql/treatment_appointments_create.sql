-- Table: public.treatment_appointments

-- DROP TABLE public.treatment_appointments;

CREATE TABLE public.treatment_appointments
(
    treatment_id bigint NOT NULL,
    appointments_id bigint NOT NULL,
    CONSTRAINT uk_1kj4tl23uv1a8v1s82ocynn7q UNIQUE (appointments_id),
    CONSTRAINT fk1lxm8qcsydtc2pbsg9b2j7oio FOREIGN KEY (treatment_id)
        REFERENCES public.treatment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fknwtxldskfdq35h9s1knh2vo3r FOREIGN KEY (appointments_id)
        REFERENCES public.appointment (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.treatment_appointments
    OWNER to postgres;