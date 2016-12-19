create table items(
	id integer primary key,
    name varchar(100) not null,
    description varchar(1000),
    image_uri varchar(200)
);

create table customers(
	id integer primary key,
    given_name varchar(100) not null,
    family_name varchar(100) not null,
    email varchar(100) not null
);

create table orders(
	id integer primary key,
    creation_date timestamp not null default now(),
    last_update timestamp not null default now(),
    cust_id integer,
    status varchar(10) not null default 'open',
    foreign key(cust_id) references customers(id)
);

create table order_items(
	order_id integer,
    item_id integer,
    quanity integer,
    foreign key(order_id) references orders(id),
    foreign key(item_id) references items(id),
    primary key(order_id, item_id)
    
);