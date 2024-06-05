START TRANSACTION;

--
-- Datenbank: `jdbc`
--
CREATE DATABASE IF NOT EXISTS `jdbc` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `jdbc`;

-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS households (
    household_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE IF NOT EXISTS h_persons (
person_id INT AUTO_INCREMENT PRIMARY KEY,
first_name VARCHAR(50) NOT NULL,
household_id INT,
FOREIGN KEY (household_id) REFERENCES households(household_id) ON DELETE CASCADE);

CREATE TABLE IF NOT EXISTS pets (
pet_id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(50) NOT NULL,
person_id INT,
FOREIGN KEY (person_id) REFERENCES h_persons(person_id) ON DELETE CASCADE);

COMMIT;
