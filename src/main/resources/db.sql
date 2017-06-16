-- Table users
CREATE TABLE users (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR(255),
  password VARCHAR(255),
  user_role BIT
)
  ENGINE = InnoDB;

-- Table projects
CREATE TABLE projects (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description VARCHAR(255),
  start_date DATE,
  end_date DATE,
  status BIT
)
  ENGINE = InnoDB;

-- Table tasks
CREATE TABLE tasks (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  subject VARCHAR(255),
  assignedToUser_id BIGINT,
  project_id BIGINT,
  description VARCHAR(255),
  date_create DATE,
  date_done DATE,
  done BIT
)
  ENGINE = InnoDB;

-- Insert amin data
INSERT INTO `sfl`.`users` (`id`, `username`, `password`, `user_role`) VALUES ('1', 'admin', '$2a$04$eIn9FZNAhe2fvFMbzwpJueHy5FaO2ZDefsgi0ps.LPAc3HVyuF3pK', 1)