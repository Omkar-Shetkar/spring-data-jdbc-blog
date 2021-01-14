create TABLE IF NOT EXISTS customer (
    id INTEGER IDENTITY PRIMARY KEY,
    first_name VARCHAR(200),
    dob date
);