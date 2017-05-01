# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table authorised_user (
  id                            bigserial not null,
  user_name                     varchar(255),
  constraint pk_authorised_user primary key (id)
);

create table authorised_user_security_role (
  authorised_user_id            bigint not null,
  security_role_id              bigint not null,
  constraint pk_authorised_user_security_role primary key (authorised_user_id,security_role_id)
);

create table authorised_user_user_permission (
  authorised_user_id            bigint not null,
  user_permission_id            bigint not null,
  constraint pk_authorised_user_user_permission primary key (authorised_user_id,user_permission_id)
);

create table mediciones (
  referencia                    bigint not null,
  estado                        varchar(255),
  frecuencia                    varchar(255),
  estres                        varchar(255),
  presion                       varchar(255),
  fecha                         date,
  paciente_documento            bigint,
  constraint pk_mediciones primary key (referencia)
);
create sequence MedicionEntity;

create table medico (
  id_medico                     bigint not null,
  nombre_medico                 varchar(255),
  especialidad_medico           varchar(255),
  descripcion_medico            varchar(255),
  constraint pk_medico primary key (id_medico)
);
create sequence MedicoEntity;

create table paciente (
  documento                     bigint not null,
  nombre                        varchar(255),
  tipo_sangre                   varchar(255),
  pais                          varchar(255),
  ciudad                        varchar(255),
  telefono                      bigint,
  celular                       bigint,
  tratamientos                  varchar(255),
  examenes                      varchar(255),
  medico_id_medico              bigint,
  constraint pk_paciente primary key (documento)
);
create sequence PacienteEntity;

create table registro (
  id                            bigint not null,
  sensor_id                     bigint,
  creado_a                      date,
  dato                          float,
  constraint pk_registro primary key (id)
);
create sequence RegistroEntity;

create table security_role (
  id                            bigserial not null,
  name                          varchar(255),
  constraint pk_security_role primary key (id)
);

create table sensores (
  id                            bigint not null,
  paciente_documento            bigint,
  tipo                          integer,
  fecha_asignacion              varchar(255),
  constraint ck_sensores_tipo check (tipo in (0,1,2)),
  constraint pk_sensores primary key (id)
);
create sequence SensorEntity;

create table urgencia (
  id                            bigint not null,
  latitud                       bigint,
  longitud                      bigint,
  constraint pk_urgencia primary key (id)
);
create sequence UrgenciaEntity;

create table user_permission (
  id                            bigserial not null,
  permission_value              varchar(255),
  constraint pk_user_permission primary key (id)
);

alter table authorised_user_security_role add constraint fk_authorised_user_security_role_authorised_user foreign key (authorised_user_id) references authorised_user (id) on delete restrict on update restrict;
create index ix_authorised_user_security_role_authorised_user on authorised_user_security_role (authorised_user_id);

alter table authorised_user_security_role add constraint fk_authorised_user_security_role_security_role foreign key (security_role_id) references security_role (id) on delete restrict on update restrict;
create index ix_authorised_user_security_role_security_role on authorised_user_security_role (security_role_id);

alter table authorised_user_user_permission add constraint fk_authorised_user_user_permission_authorised_user foreign key (authorised_user_id) references authorised_user (id) on delete restrict on update restrict;
create index ix_authorised_user_user_permission_authorised_user on authorised_user_user_permission (authorised_user_id);

alter table authorised_user_user_permission add constraint fk_authorised_user_user_permission_user_permission foreign key (user_permission_id) references user_permission (id) on delete restrict on update restrict;
create index ix_authorised_user_user_permission_user_permission on authorised_user_user_permission (user_permission_id);

alter table mediciones add constraint fk_mediciones_paciente_documento foreign key (paciente_documento) references paciente (documento) on delete restrict on update restrict;
create index ix_mediciones_paciente_documento on mediciones (paciente_documento);

alter table paciente add constraint fk_paciente_medico_id_medico foreign key (medico_id_medico) references medico (id_medico) on delete restrict on update restrict;
create index ix_paciente_medico_id_medico on paciente (medico_id_medico);

alter table registro add constraint fk_registro_sensor_id foreign key (sensor_id) references sensores (id) on delete restrict on update restrict;
create index ix_registro_sensor_id on registro (sensor_id);

alter table sensores add constraint fk_sensores_paciente_documento foreign key (paciente_documento) references paciente (documento) on delete restrict on update restrict;
create index ix_sensores_paciente_documento on sensores (paciente_documento);


# --- !Downs

alter table if exists authorised_user_security_role drop constraint if exists fk_authorised_user_security_role_authorised_user;
drop index if exists ix_authorised_user_security_role_authorised_user;

alter table if exists authorised_user_security_role drop constraint if exists fk_authorised_user_security_role_security_role;
drop index if exists ix_authorised_user_security_role_security_role;

alter table if exists authorised_user_user_permission drop constraint if exists fk_authorised_user_user_permission_authorised_user;
drop index if exists ix_authorised_user_user_permission_authorised_user;

alter table if exists authorised_user_user_permission drop constraint if exists fk_authorised_user_user_permission_user_permission;
drop index if exists ix_authorised_user_user_permission_user_permission;

alter table if exists mediciones drop constraint if exists fk_mediciones_paciente_documento;
drop index if exists ix_mediciones_paciente_documento;

alter table if exists paciente drop constraint if exists fk_paciente_medico_id_medico;
drop index if exists ix_paciente_medico_id_medico;

alter table if exists registro drop constraint if exists fk_registro_sensor_id;
drop index if exists ix_registro_sensor_id;

alter table if exists sensores drop constraint if exists fk_sensores_paciente_documento;
drop index if exists ix_sensores_paciente_documento;

drop table if exists authorised_user cascade;

drop table if exists authorised_user_security_role cascade;

drop table if exists authorised_user_user_permission cascade;

drop table if exists mediciones cascade;
drop sequence if exists MedicionEntity;

drop table if exists medico cascade;
drop sequence if exists MedicoEntity;

drop table if exists paciente cascade;
drop sequence if exists PacienteEntity;

drop table if exists registro cascade;
drop sequence if exists RegistroEntity;

drop table if exists security_role cascade;

drop table if exists sensores cascade;
drop sequence if exists SensorEntity;

drop table if exists urgencia cascade;
drop sequence if exists UrgenciaEntity;

drop table if exists user_permission cascade;

