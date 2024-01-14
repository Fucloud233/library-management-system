drop table if exists Record;
drop table if exists Reader;
drop table if exists Admin;
drop table if exists Reader_Role;
drop table if exists Book;


CREATE TABLE Reader (
    -- id 不需要手动设置，会自增 从21300000开始
    -- 读者账号创建后就不会删除
    id int unsigned not null auto_increment,
    name varchar(30) not null,
    phone varchar(15) not null,
    role_id int unsigned not null,

    PRIMARY KEY(id)
) auto_increment=21300000;

CREATE TABLE Admin (
   id int unsigned not null auto_increment,
   name varchar(30) not null,
   phone varchar(15) not null,
    -- 1 根管理员 2 超级管理员 3 普通管理员
   privilege tinyint unsigned not null,

   primary key(id)
) auto_increment=10000000;

CREATE TABLE Reader_Role (
    id int unsigned not null auto_increment,
    -- 必须保证名字不能相同
    name varchar(10) unique not null ,
    number int not null,
    duration int not null,

    PRIMARY KEY(id)
);

CREATE TABLE Book (
    id int unsigned not null,
    isbn bigint not null,
    name varchar(20) not null,
    author varchar(20) not null,
    price	float(2),
    -- 图书状态默认为1 说明图书在架
    status tinyint unsigned DEFAULT 1,

    PRIMARY KEY(id)
);


create table Record (
    id int unsigned not null auto_increment,
    reader_id int unsigned not null,
    book_id int unsigned not null,

    borrow_admin_id int unsigned not null,
    borrow_time datetime,

    return_admin_id int unsigned not null,
    return_time datetime,

    is_renewed BOOLEAN DEFAULT false,
    -- 这个字段需要根据后面具体实现进行优化
    is_violated BOOLEAN DEFAULT false,

    primary key (id)
);


-- 外键约束

alter table Reader add CONSTRAINT fk_reader_role foreign KEY (role_id)
    REFERENCES Reader_Role(id);

alter table Record add CONSTRAINT fk_record_reader foreign KEY (reader_id)
    REFERENCES Reader(id);

alter table Record add CONSTRAINT fk_record_book foreign KEY (book_id)
    REFERENCES Book(id);

alter table Record add CONSTRAINT fk_record_borrow_admin foreign KEY (borrow_admin_id)
    REFERENCES Admin(id);

alter table Record add CONSTRAINT fk_record_return_admin foreign KEY (return_admin_id)
    REFERENCES Admin(id);

