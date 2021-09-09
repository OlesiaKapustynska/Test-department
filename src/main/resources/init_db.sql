CREATE SCHEMA IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8;
USE `test`;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees`  (
                            `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                            `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                            `active` bit(1) NOT NULL DEFAULT b'0',
                            `department_id` bigint(0) UNSIGNED NOT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `FK_department_id`(`department_id`) USING BTREE,
                            CONSTRAINT `FK_department_id` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for departments
-- ----------------------------
DROP TABLE IF EXISTS `departments`;
CREATE TABLE `departments`  (
                                  `id` bigint(0) UNSIGNED NOT NULL AUTO_INCREMENT,
                                  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Test data to DB
-- ----------------------------

INSERT INTO departments (id, name)
VALUES (1, 'FINANCE'), (2, 'HR'), (3, 'TECH');

INSERT INTO employees (name, active, department_id)
VALUES ('Bob1', 1, 1),
       ('Bob2', 1, 1),
       ('Bob3', 1, 1),
       ('Bob4', 1, 2),
       ('Bob5', 1, 2),
       ('Bob6', 1, 2),
       ('Bob7', 1, 3),
       ('Bob8', 1, 3),
       ('Bob9', 1, 3),
       ('Bob10', 1, 1),
       ('Bob11', 1, 1),
       ('Bob12', 1, 1),
       ('Bob13', 1, 2),
       ('Bob14', 1, 2),
       ('Bob15', 1, 2),
       ('Bob16', 1, 3),
       ('Bob17', 1, 3),
       ('Bob18', 1, 3),
       ('Bob19', 1, 3),
       ('Bob20', 1, 2),
       ('Bob21', 1, 1);