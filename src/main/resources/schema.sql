DROP TABLE IF EXISTS `role_table`;
CREATE TABLE `role_table`
(
    `id`   int(20) NOT NULL AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_table`;
CREATE TABLE `user_table`
(
    `id`       int(20) NOT NULL AUTO_INCREMENT,
    `login`    varchar(50)  NOT NULL,
    `password` varchar(500) NOT NULL,
    `role_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_role_id` (`role_id`),
    CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `role_table` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE UNIQUE INDEX `user_table_login_uindex` on user_table(login);

insert into role_table(name) values ('ROLE_ADMIN');
insert into role_table(name) values ('ROLE_USER');

