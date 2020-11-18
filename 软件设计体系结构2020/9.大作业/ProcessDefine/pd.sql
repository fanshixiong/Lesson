create table `leave`
(
    id         varchar(10) not null
        primary key,
    createTime date        null,
    creator    varchar(20) null,
    reason     varchar(30) null,
    modifyDate date        null,
    teacher1   varchar(20) null,
    teacher2   varchar(20) null
);

create table student
(
    id        varchar(10) not null
        primary key,
    stuName   varchar(20) null,
    stuGender varchar(10) null,
    stuAge    int         null
);

create table teacher
(
    id        varchar(10) not null
        primary key,
    teaName   varchar(20) null,
    teaGender varchar(10) null,
    teaAge    int         null,
    post      int         null
);

create table user
(
    id           varchar(20) not null
        primary key,
    userName     varchar(20) null,
    userPassword varchar(20) null,
    identity     int         null
);

