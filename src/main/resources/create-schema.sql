create TABLE IF NOT EXISTS customer (
    id INTEGER IDENTITY PRIMARY KEY,
    first_name VARCHAR(200),
    dob date
);

-------------------------------------------------------------
create table if not exists purchase_order (
id integer identity primary key,
shipping_address varchar(200),
);

create table if not exists order_item (
    quantity INTEGER,
    product VARCHAR(50),
    purchase_order INTEGER REFERENCES purchase_order(id)
);

-------------------------------------------------------------

create TABLE IF NOT EXISTS "book" (
    id INTEGER IDENTITY PRIMARY KEY,
    title VARCHAR(100)
);

create TABLE "book_author" (
    book integer,
    author integer,
    primary key (book, author)
);

create TABLE IF NOT EXISTS "author" (
    id INTEGER IDENTITY PRIMARY KEY,
    name VARCHAR(100)
);

-------------------------------------------------------------