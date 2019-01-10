CREATE TABLE public.restcustomer
(
    cust_id serial NOT NULL,
    lastname text NOT NULL,
    cust_dstrict text NOT NULL,
    discount integer NOT NULL,
    PRIMARY KEY (cust_id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.restcustomer
    OWNER to postgres;


INSERT INTO public.restcustomer(
	lastname, cust_district, discount)
	VALUES ('Anton1', 'Autoplane1', 91);

INSERT INTO public.restcustomer(
	lastname, cust_district, discount)
	VALUES ('Anton2', 'Autoplane2', 91);

INSERT INTO public.restcustomer(
	lastname, cust_district, discount)
	VALUES ('Anton3', 'Autoplane2', 91);

INSERT INTO public.restcustomer(
	lastname, cust_district, discount)
	VALUES ('Anton4', 'Autoplane2', 91);

INSERT INTO public.restcustomer(
	lastname, cust_district, discount)
	VALUES ('Anton5', 'Autoplane2', 91);