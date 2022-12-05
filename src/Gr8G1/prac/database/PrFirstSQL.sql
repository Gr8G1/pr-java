-- 데이터베이스 설계 연습

DROP DATABASE IF EXISTS instagram;
CREATE DATABASE instagram;

USE instagram;

CREATE TABLE Users
(
  user_id       CHAR(40) NOT NULL,
  email         VARCHAR(40) NOT NULL,
  password      VARCHAR(40) NOT NULL,
  name          CHAR(10) NOT NULL,
  profile       TINYTEXT,
  c_date        DATETIME,

  PRIMARY KEY (user_id)
);

CREATE TABLE Posts
(
    post_id             INT AUTO_INCREMENT NOT NULL,
    title               CHAR(255) NOT NULL,
    post_text           MEDIUMTEXT,
    like_count          INT,
    c_date              DATETIME,

    user_id             CHAR(40) NOT NULL,

    PRIMARY KEY (post_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);

CREATE TABLE Photos
(
    user_id         CHAR(40) NOT NULL,
    target_id       INT NOT NULL,
    photo           VARBINARY(8000),
    type            TINYTEXT,

    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);

CREATE TABLE Likes
(
    user_id         CHAR(40) NOT NULL,
    traget_id       INT NOT NULL,

    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);

CREATE TABLE Comments
(
    user_id             CHAR(40) NOT NULL,
    target_id           INT NOT NULL,
    comment_parent_id   INT,
    comment_text        TINYTEXT,
    like_count          INT,
    c_date              DATETIME,

    PRIMARY KEY (user_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);

CREATE TABLE Tags
(
    tag_id        INT AUTO_INCREMENT NOT NULL,
    tag           VARCHAR(100) NOT NULL,
    c_date        DATETIME,

    user_id       CHAR(40) NOT NULL,

    PRIMARY KEY (tag_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
