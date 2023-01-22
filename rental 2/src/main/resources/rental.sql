create database rental;
use rental;

create table user_details(
id bigint unsigned NOT NULL AUTO_INCREMENT,
user_uuid varchar(64) NOT NULL,
name varchar(64) NOT NULL,
phone varchar(32) NOT NULL,
email varchar(32) NOT NULL,
role varchar(16) default "USER" NOT NULL,
created_at      timestamp default CURRENT_TIMESTAMP NOT NULL,
updated_at     timestamp default CURRENT_TIMESTAMP NOT NULL on update CURRENT_TIMESTAMP,
PRIMARY KEY (id),
constraint user_details_phone unique (phone),
constraint unique_user_uuid_index unique (user_uuid)
);
create index user_details_phone_index on user_details (phone);


create table otp(
id bigint unsigned NOT NULL AUTO_INCREMENT,
otp_uuid varchar(64) NOT NULL,
phone varchar(32) NOT NULL,
otp varchar(4) NOT NULL,
created_at      timestamp default CURRENT_TIMESTAMP NOT NULL,
updated_at     timestamp default CURRENT_TIMESTAMP NOT NULL on update CURRENT_TIMESTAMP,
PRIMARY KEY (id),
constraint otp_phone unique (phone),
constraint unique_otp_uuid_index unique (otp_uuid)
);
create index otp_phone_index on otp (phone);

create table stations(
id bigint unsigned NOT NULL AUTO_INCREMENT,
station_uuid varchar(64) NOT NULL,
location varchar(255) NOT NULL,
capacity bigint unsigned NOT NULL,
created_at      timestamp default CURRENT_TIMESTAMP NOT NULL,
updated_at     timestamp default CURRENT_TIMESTAMP NOT NULL on update CURRENT_TIMESTAMP,
PRIMARY KEY (id),
constraint unique_station_uuid_index unique (station_uuid)
);
create index stations_id_index on stations (id);
create index stations_location_index on stations (location);

create table vehicle(
id bigint unsigned NOT NULL AUTO_INCREMENT,
vehicle_uuid varchar(64) NOT NULL,
vehicle_number varchar(16) NOT NULL,
availability varchar(32) NOT NULL,
at_station varchar(255) NOT NULL,
qr_code varchar(255) NOT NULL,
created_at      timestamp default CURRENT_TIMESTAMP NOT NULL,
updated_at     timestamp default CURRENT_TIMESTAMP NOT NULL on update CURRENT_TIMESTAMP,
PRIMARY KEY (id),
constraint unique_vehicle_uuid_index unique (vehicle_uuid),
constraint unique_vehicle_number_index unique (vehicle_number),
constraint unique_qr_code_index unique (qr_code)
);
create index vehicle_vehicle_number_index on vehicle (vehicle_number);
create index vehicle_qr_code_index on vehicle (qr_code);