SET check_function_bodies = false
;

CREATE TYPE permissions AS ENUM("manager","employee");

CREATE TABLE "Employee"(
  id uuid NOT NULL,
  "name" cstring NOT NULL,
  phone_number cstring NOT NULL,
  permissions permissions NOT NULL,
  created_at date NOT NULL,
  last_login date NOT NULL,
  username cstring NOT NULL,
  "password" cstring NOT NULL,
  CONSTRAINT "Primary key" PRIMARY KEY(id)
);

CREATE TABLE "Order"(
id uuid NOT NULL, employee_id uuid NOT NULL,
  CONSTRAINT "Primary key" PRIMARY KEY(id)
);

ALTER TABLE "Order"
  ADD CONSTRAINT "Employee_Order"
    FOREIGN KEY (employee_id) REFERENCES "Employee" (id);
