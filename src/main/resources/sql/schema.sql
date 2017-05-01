CREATE DATABASE `douban` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

create table film_critics(
`id` bigint not null auto_increment comment '影评id',
`score` TINYINT not null comment '分数',
`title` varchar(100) not null comment '影评标题',
`content` varchar(10000) not null comment '影评正文',
`film_id` bigint not null comment '电影id',
`user_id` bigint not null COMMENT '用户id',
`create_time` DATETIME  not null DEFAULT current_time comment '创建时间',
PRIMARY KEY (id)
) engine=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='长影评';