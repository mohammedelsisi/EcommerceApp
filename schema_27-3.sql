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
-- Table `naseejstore`.`userdetails`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`userdetails` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`userdetails` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(60) NOT NULL,
  `user_name` VARCHAR(60) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  `credit_limit` DECIMAL(10,3) NULL DEFAULT NULL,
  `image` VARCHAR(45) NULL DEFAULT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  `job` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `birthday` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`address` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`address` (
  `user_id` INT NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`user_id`, `address`),
  CONSTRAINT `address_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `naseejstore`.`userdetails` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`products` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`products` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(60) NOT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `quantity` INT NOT NULL,
  `size` VARCHAR(45) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  `first_img` VARCHAR(45) NOT NULL,
  `second_img` VARCHAR(45) NULL DEFAULT NULL,
  `price` DECIMAL(10,3) NOT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`cart`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`cart` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`cart` (
  `user_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `quantity` INT NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`, `product_id`),
  INDEX `fk_userdetails_has_products_products1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_userdetails_has_products_userdetails1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_userdetails_has_products_products1`
    FOREIGN KEY (`product_id`)
    REFERENCES `naseejstore`.`products` (`product_id`),
  CONSTRAINT `fk_userdetails_has_products_userdetails1`
    FOREIGN KEY (`user_id`)
    REFERENCES `naseejstore`.`userdetails` (`id`))
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
  `user_id` INT NOT NULL,
  `interest` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`, `interest`),
  CONSTRAINT `interest_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `naseejstore`.`userdetails` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`orders` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`orders` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `selected_address` VARCHAR(100) NOT NULL,
  `purchaseDate` DATE NOT NULL,
  `userdetails_id` INT NOT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `fk_orders_userdetails1_idx` (`userdetails_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_userdetails1`
    FOREIGN KEY (`userdetails_id`)
    REFERENCES `naseejstore`.`userdetails` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`sizes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`sizes` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`sizes` (
  `size_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`size_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `naseejstore`.`orders_has_products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `naseejstore`.`orders_has_products` ;

CREATE TABLE IF NOT EXISTS `naseejstore`.`orders_has_products` (
  `orders_order_id` INT NOT NULL,
  `products_product_id` INT NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`orders_order_id`, `products_product_id`),
  INDEX `fk_orders_has_products_products1_idx` (`products_product_id` ASC) VISIBLE,
  INDEX `fk_orders_has_products_orders1_idx` (`orders_order_id` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_products_orders1`
    FOREIGN KEY (`orders_order_id`)
    REFERENCES `naseejstore`.`orders` (`order_id`),
  CONSTRAINT `fk_orders_has_products_products1`
    FOREIGN KEY (`products_product_id`)
    REFERENCES `naseejstore`.`products` (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
DROP USER IF EXISTS iti41;
CREATE USER 'iti41' IDENTIFIED BY 'iti41';
GRANT ALL ON `naseejstore`.* TO 'iti41';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
