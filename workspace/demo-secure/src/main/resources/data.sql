insert into users (username, password, enabled) values ('roger','$2a$12$OGspJyBBHLKCM8dy2TH6oeHAF21WPPv8vYHzJ.Q77zi01KC6IDZmO', 1);
insert into users (username, password, enabled) values ('smitha', '$2a$12$XSoHfxUOhGaxolKBCrb/0ubG4bwwhoWtgFtwG4rAgCdpuuuAsUJMe', 1);
insert into users (username, password, enabled) values ('anna', '$2a$12$FlXmIJA.qHt8dYfQ0XTe.uhN0M8qq2y8DunYHbHWrWB.wvw3oJH8.', 1);

insert into authorities (username, authority) values ('roger', 'ROLE_USER');
insert into authorities (username, authority) values ('smitha', 'ROLE_USER');
insert into authorities (username, authority) values ('smitha', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('anna', 'ROLE_READ');

