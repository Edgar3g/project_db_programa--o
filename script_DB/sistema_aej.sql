SET check_function_bodies = false
;

CREATE TYPE public.permissions AS ENUM('Manager', 'Administer');

CREATE TYPE public.sale_status AS ENUM('Paid', 'N/Paid');

CREATE TABLE public.customer(
  id uuid NOT NULL,
  customer_name varchar(50) NOT NULL,
  nif varchar(18) NOT NULL,
  balance_to_pay money NOT NULL,
  phone_number text NOT NULL,
  CONSTRAINT customer_pkey PRIMARY KEY(id)
);

CREATE TABLE public.employee(
  id uuid NOT NULL,
  emp_name varchar(50) NOT NULL,
  last_login timestamp NOT NULL,
  username varchar(30) NOT NULL,
  password_hash varchar(12) NOT NULL,
  permission permissions NOT NULL,
  CONSTRAINT employee_pkey PRIMARY KEY(id)
);

CREATE TABLE public."order"(
  id uuid NOT NULL,
  order_date date NOT NULL,
  total_payment money NOT NULL,
  payment_made date NOT NULL,
  sale_status sale_status NOT NULL,
  customer_id uuid NOT NULL,
  employee_id uuid NOT NULL,
  product_id uuid NOT NULL,
  CONSTRAINT order_pkey PRIMARY KEY(id)
);

CREATE TABLE public.product(
  id uuid NOT NULL,
  shipment_date date NOT NULL,
  product_name varchar(20) NOT NULL,
  description text NOT NULL,
  initial_quantity integer NOT NULL,
  actual_quantity integer NOT NULL,
  price money NOT NULL,
  CONSTRAINT product_pkey PRIMARY KEY(id)
);

ALTER TABLE public."order"
  ADD CONSTRAINT order_customer_id_fkey
    FOREIGN KEY (customer_id) REFERENCES public.customer (id);

ALTER TABLE public."order"
  ADD CONSTRAINT order_employee_id_fkey
    FOREIGN KEY (employee_id) REFERENCES public.employee (id);

ALTER TABLE public."order"
  ADD CONSTRAINT order_product_id_fkey
    FOREIGN KEY (product_id) REFERENCES public.product (id);
