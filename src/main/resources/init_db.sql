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

INSERT INTO departments (id, name)
VALUES (1, 'FINANCE'), (2, 'HR'), (3, 'TECH');