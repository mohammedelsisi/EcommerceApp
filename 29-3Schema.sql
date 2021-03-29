-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema naseejstore
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `naseejstore` ;

-- -----------------------------------------------------
-- Schema naseejstore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `naseejstore` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `naseejstore` ;

-- -----------------------------------------------------
-- Table `naseejstore`.`user_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`user_details` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`user_details` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `birthday` DATE NULL DEFAULT NULL,
  `credit_limit` DOUBLE NULL DEFAULT NULL,
  `email` VARCHAR(60) NOT NULL,
  `image` VARCHAR(45) NULL DEFAULT NULL,
  `job` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_4d9rdl7d52k8x3etihxlaujvh` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`address` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`address` (
  `address` VARCHAR(255) NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `address`),
  CONSTRAINT `FKrwotaprx8ssixvsn96a9k2s9q`
    FOREIGN KEY (`user_id`)
    REFERENCES `naseejstore`.`user_details` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`products` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`products` (
  `product_id` BIGINT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `color` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `first_img` VARCHAR(45) NOT NULL,
  `price` DOUBLE NOT NULL,
  `quantity` BIGINT NOT NULL,
  `second_img` VARCHAR(45) NULL DEFAULT NULL,
  `size` VARCHAR(45) NOT NULL,
  `type` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 21
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`cart` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`cart` (
  `product_id` BIGINT NOT NULL,
  `user_id` BIGINT NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`, `user_id`),
  INDEX `FK9emn16ynibhj9673bim4jt5s0` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FK9emn16ynibhj9673bim4jt5s0`
    FOREIGN KEY (`user_id`)
    REFERENCES `naseejstore`.`user_details` (`id`),
  CONSTRAINT `FKpu4bcbluhsxagirmbdn7dilm5`
    FOREIGN KEY (`product_id`)
    REFERENCES `naseejstore`.`products` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`colors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`colors` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`colors` (
  `color_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`color_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`interests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`interests` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`interests` (
  `interest` VARCHAR(255) NOT NULL,
  `user_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `interest`),
  CONSTRAINT `FKkjr3tlhn505ki4ypr0r13ojfa`
    FOREIGN KEY (`user_id`)
    REFERENCES `naseejstore`.`user_details` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`orders` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`orders` (
  `order_id` BIGINT NOT NULL AUTO_INCREMENT,
  `purchaseDate` DATE NOT NULL,
  `selected_address` VARCHAR(100) NOT NULL,
  `userdetails_id` BIGINT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `FK92if12lowb8cvo9doufowxyvm` (`userdetails_id` ASC) VISIBLE,
  CONSTRAINT `FK92if12lowb8cvo9doufowxyvm`
    FOREIGN KEY (`userdetails_id`)
    REFERENCES `naseejstore`.`user_details` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`orders_has_products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`orders_has_products` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`orders_has_products` (
  `orders_order_id` BIGINT NOT NULL,
  `products_product_id` BIGINT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`orders_order_id`, `products_product_id`),
  INDEX `FKthiu93bxmhfhct0d1g89sjb9m` (`products_product_id` ASC) VISIBLE,
  CONSTRAINT `FKhxxv5ithg9tvmh03qryq634xt`
    FOREIGN KEY (`orders_order_id`)
    REFERENCES `naseejstore`.`orders` (`order_id`),
  CONSTRAINT `FKthiu93bxmhfhct0d1g89sjb9m`
    FOREIGN KEY (`products_product_id`)
    REFERENCES `naseejstore`.`products` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`sizes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`sizes` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`sizes` (
  `sizeName` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`sizeName`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

DROP USER IF EXISTS iti41;
CREATE USER 'iti41' IDENTIFIED BY 'iti41';
GRANT ALL ON `naseejstore`.* TO 'iti41';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
