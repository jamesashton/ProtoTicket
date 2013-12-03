insert into User (id,login,password) values (1,'admin','admin123')

insert into Role (id, role) values (1,'ROLE_ADMIN')

insert into UserRole (user_id, role_id) values (1,1)