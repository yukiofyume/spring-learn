create table public.duty_person
(
    id          serial not null,
    person_name varchar(128),
    duty_place  varchar(128),
    phone_num   varchar(128),
    duty_time   timestamp,
    delete_flag int2,
    create_time timestamp,
    update_time timestamp,
    constraint duty_person_pkey primary key (id)
);