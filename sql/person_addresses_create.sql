-- Table: public.person_addresses

-- DROP TABLE public.person_addresses;

CREATE TABLE public.person_addresses
(
    person_id bigint NOT NULL,
    addresses_id bigint NOT NULL,
    CONSTRAINT uk_2nco7cvdsptf08o9nahvw0q25 UNIQUE (addresses_id),
    CONSTRAINT fkecc9xua6492md5768gk9t4p2g FOREIGN KEY (addresses_id)
        REFERENCES public.address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkg4hhg5iayyfbeatys0g0jedu5 FOREIGN KEY (person_id)
        REFERENCES public.person (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.person_addresses
    OWNER to postgres;