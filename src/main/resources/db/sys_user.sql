prompt PL/SQL Developer import file
prompt Created on 2021年3月10日 by Mr.Tong
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
  is '用户表';
comment on column SYS_USER.id
  is '用户ID';
comment on column SYS_USER.code
  is '用户编码';
comment on column SYS_USER.name
  is '用户名称';
comment on column SYS_USER.login_name
  is '登录用户名';
comment on column SYS_USER.login_password
  is '登录密码';
comment on column SYS_USER.type
  is '用户类型：管理员用户（0），普通用户（1）';
comment on column SYS_USER.phone
  is '用户手机号';
comment on column SYS_USER.email
  is '用户邮箱';
comment on column SYS_USER.create_user
  is '添加用戶';
comment on column SYS_USER.create_time
  is '添加时间';
comment on column SYS_USER.update_user
  is '修改用戶';
comment on column SYS_USER.update_time
  is '修改日期';
comment on column SYS_USER.is_delete
  is '删除flag：有效(0)，逻辑删除(1)';
comment on column SYS_USER.comments
  is '备注';
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
