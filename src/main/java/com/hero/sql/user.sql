use herodemo;
create table userBo(
    #通用字段
    id bigint not null auto_increment,  #自增ID
    state int not null,                 #状态
    #业务字段
    account varchar(50) not null unique,   #账号（唯一键）
    password varchar(50) not null,         #密码
    addtime datetime null,               #添加时间
    uptime datetime null,                #更新时间
    primary key(id)                          #主键
)engine=InnoDB DEFAULT CHARSET=utf8;