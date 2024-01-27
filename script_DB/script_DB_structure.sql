-- Creating database db_armazem
create database if not exists db_armazem
	default character set utf8mb4
    default collate utf8mb4_general_ci;
    
-- Criação da tabela cliente
create table tbl_customer (
	customer_id varchar(40) not null,
    customer_name varchar(50) not null,
    nif varchar(18) not null,
    balance_to_pay float,
    phone_number varchar(9),
    primary key(customer_id)
) charset = utf8mb4;

-- Criação da tabela de funcionários
create table tbl_employee (
	employee_id varchar(40) not null,
    emp_name varchar(40) not null,
    last_login datetime not null,
    username varchar(30),
    password_hash varchar(60) not null,
    permissions enum('Maneger', 'Administer'),
	primary key(employee_id)
) charset = utf8mb4;

-- Criação da tabela de produtos
create table tbl_product (
	shipment_id varchar(40) not null,
    shipment_date date not null,
    product_name varchar(25) not null,
    prod_description text,
    intial_quantity int not null,
    actual_quantity int not null,
    price float,
    order_id varchar(40) not null,
    foreign key (order_id) references tbl_order (order_id) on delete cascade,
    primary key (shipment_id)
) charset = utf8mb4;

-- Criação da tabela de vendas
create table tbl_order (
	order_id varchar(40) not null,
    order_date datetime not null,
    sale_status enum('Paid', 'N/Paid') not null,
    total_payment float not null,
    payment_made float not null,
    employee_id varchar(40) not null,
    product_id varchar(40) not null,
    foreign key (employee_id) references tbl_employee (employee_id) on delete cascade,
    foreign key (product_id) references tbl_product (shipment_id) on delete cascade,
    primary key (order_id)
) charset = utf8mb4;