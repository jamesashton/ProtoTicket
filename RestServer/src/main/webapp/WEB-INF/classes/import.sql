
insert into User (id,login,password,email,firstname,lastname) values (1,'admin','admin123','admin@nowhere.xom','admin','istrator')

insert into Role (id, role) values (1,'ROLE_ADMIN')

insert into UserRole (user_id, role_id) values (1,1)