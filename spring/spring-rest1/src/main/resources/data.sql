
insert into users(id, join_date, name, password, ssn)
values
    (210000000, now(), 'user 1', 'test1', '123456-1234567'),
    (210000001, now(), 'user 2', 'test1', '123456-1234567'),
    (210000002, now(), 'user 3', 'test1', '123456-1234567');

insert into post(description, user_id)
values
    ('first post', 210000000),
    ('second post', 210000002);
