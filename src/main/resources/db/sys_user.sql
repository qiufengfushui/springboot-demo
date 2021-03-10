prompt PL/SQL Developer import file
prompt Created on 2021��3��10�� by Mr.Tong
set feedback off
set define off
prompt Creating SYS_USER...
create table SYS_USER
(
  id             VARCHAR2(64) not null,
  code           VARCHAR2(64) not null,
  name           VARCHAR2(64) not null,
  login_name     VARCHAR2(64) not null,
  login_password VARCHAR2(64) not null,
  type           NUMBER not null,
  phone          VARCHAR2(11),
  email          VARCHAR2(32),
  create_user    VARCHAR2(20) not null,
  create_time    DATE not null,
  update_user    VARCHAR2(20) not null,
  update_time    DATE not null,
  is_delete      NUMBER,
  comments       VARCHAR2(200)
)
tablespace DANGAN
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on table SYS_USER
  is '�û���';
comment on column SYS_USER.id
  is '�û�ID';
comment on column SYS_USER.code
  is '�û�����';
comment on column SYS_USER.name
  is '�û�����';
comment on column SYS_USER.login_name
  is '��¼�û���';
comment on column SYS_USER.login_password
  is '��¼����';
comment on column SYS_USER.type
  is '�û����ͣ�����Ա�û���0������ͨ�û���1��';
comment on column SYS_USER.phone
  is '�û��ֻ���';
comment on column SYS_USER.email
  is '�û�����';
comment on column SYS_USER.create_user
  is '����Ñ�';
comment on column SYS_USER.create_time
  is '���ʱ��';
comment on column SYS_USER.update_user
  is '�޸��Ñ�';
comment on column SYS_USER.update_time
  is '�޸�����';
comment on column SYS_USER.is_delete
  is 'ɾ��flag����Ч(0)���߼�ɾ��(1)';
comment on column SYS_USER.comments
  is '��ע';
alter table SYS_USER
  add constraint PK_SYS_USER_ID primary key (ID)
  using index 
  tablespace DANGAN
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for SYS_USER...
alter table SYS_USER disable all triggers;
prompt Deleting SYS_USER...
delete from SYS_USER;
commit;
prompt Loading SYS_USER...
insert into SYS_USER (id, code, name, login_name, login_password, type, phone, email, create_user, create_time, update_user, update_time, is_delete, comments)
values ('1', '2021-01-15-000001', 'admin', 'admin', '21232f297a57a5a743894a0e4a801fc3', 0, null, 'zxt_0310@163.com', 'admin', to_date('15-01-2021 01:00:00', 'dd-mm-yyyy hh24:mi:ss'), 'admin', to_date('15-01-2021 01:00:00', 'dd-mm-yyyy hh24:mi:ss'), 0, null);
commit;
prompt 1 records loaded
prompt Enabling triggers for SYS_USER...
alter table SYS_USER enable all triggers;
set feedback on
set define on
prompt Done.
