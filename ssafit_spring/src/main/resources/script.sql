  -- MySQL Workbench Forward Engineering

  SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
  SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
  SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

  -- -----------------------------------------------------
  -- Schema mydb
  -- -----------------------------------------------------
  CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
  -- -----------------------------------------------------
  -- Schema pjt_05
  -- -----------------------------------------------------
  USE `mydb` ;

  -- -----------------------------------------------------
  -- Table `mydb`.`user`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `mydb`.`user` (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `id` VARCHAR(45) NOT NULL,
    `password` VARCHAR(45) NOT NULL,
    `name` VARCHAR(16) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `status` INT NOT NULL DEFAULT 1,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`),
    UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC) ,
    UNIQUE INDEX `id_UNIQUE` (`id` ASC));


  -- -----------------------------------------------------
  -- Table `mydb`.`video`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `mydb`.`video` (
    `video_id` VARCHAR(45) NOT NULL,
   `title` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `part` VARCHAR(45) NULL,
    `channel_name` VARCHAR(45) NOT NULL,
    `url` TEXT NOT NULL,
    `thumbnail` TEXT NULL,
    `views` INT NOT NULL DEFAULT 0,
    `status` INT NULL DEFAULT 1,
    PRIMARY KEY (`video_id`),
    UNIQUE INDEX `video_id_UNIQUE` (`video_id` ASC) 
  )ENGINE = InnoDB;



  -- -----------------------------------------------------
  -- Table `mydb`.`review`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `mydb`.`review` (
    `review_id` INT NOT NULL AUTO_INCREMENT,
    `video_id` VARCHAR(255) NOT NULL,
    `user_id` VARCHAR(45) NOT NULL,
    `content` TEXT NOT NULL,
    `parent` INT ZEROFILL NOT NULL,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modified_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `user_user_id` INT NOT NULL,
    `video_video_id` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`review_id`, `user_user_id`, `video_video_id`),
    UNIQUE INDEX `review_id_UNIQUE` (`review_id` ASC) ,
    INDEX `fk_review_user_idx` (`user_user_id` ASC) ,
    INDEX `fk_review_video1_idx` (`video_video_id` ASC) ,
    CONSTRAINT `fk_review_user`
      FOREIGN KEY (`user_user_id`)
      REFERENCES `mydb`.`user` (`user_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT `fk_review_video1`
      FOREIGN KEY (`video_video_id`)
      REFERENCES `mydb`.`video` (`video_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);


  -- -----------------------------------------------------
  -- Table `mydb`.`favorite`
  -- -----------------------------------------------------
  CREATE TABLE IF NOT EXISTS `mydb`.`favorite` (
    `user_id` INT NOT NULL,
    `video_id` VARCHAR(45) NOT NULL,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `user_user_id` INT NOT NULL,
    `video_video_id` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`user_id`, `video_id`, `user_user_id`, `video_video_id`),
    INDEX `fk_favorite_user1_idx` (`user_user_id` ASC) ,
    INDEX `fk_favorite_video1_idx` (`video_video_id` ASC) ,
    CONSTRAINT `fk_favorite_user1`
      FOREIGN KEY (`user_user_id`)
      REFERENCES `mydb`.`user` (`user_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT `fk_favorite_video1`
      FOREIGN KEY (`video_video_id`)
      REFERENCES `mydb`.`video` (`video_id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

  -- -----------------------------------------------------
  -- Insert data into `user`
  -- -----------------------------------------------------
  INSERT INTO `mydb`.`user` (`id`, `password`, `name`, `email`, `status`)
  VALUES
  ('user1', 'password123', 'Alice', 'alice@example.com', 1),
  ('user2', 'password456', 'Bob', 'bob@example.com', 1),
  ('user3', 'password789', 'Charlie', 'charlie@example.com', 1),
  ('user4', 'passwordabc', 'David', 'david@example.com', 1),
  ('user5', 'passworddef', 'Eve', 'eve@example.com', 1),
  ('user6', 'passwordghi', 'Frank', 'frank@example.com', 1),
  ('user7', 'passwordjkl', 'Grace', 'grace@example.com', 1),
  ('user8', 'passwordmno', 'Heidi', 'heidi@example.com', 1),
  ('user9', 'passwordpqr', 'Ivan', 'ivan@example.com', 1),
  ('user10', 'passwordstu', 'Judy', 'judy@example.com', 1);

  -- -----------------------------------------------------
  -- Insert data into `review`
  -- -----------------------------------------------------
  INSERT INTO `mydb`.`review` (`video_id`, `user_id`, `content`, `parent`, `user_user_id`, `video_video_id`)
  VALUES
  ('video1', 'user1', 'Great video!', 0000000000, 1, 'video1'),
  ('video2', 'user2', 'Very informative.', 0000000000, 2, 'video2'),
  ('video3', 'user3', 'Loved the content.', 0000000000, 3, 'video3'),
  ('video4', 'user4', 'Not bad.', 0000000000, 4, 'video4'),
  ('video5', 'user5', 'Could be better.', 0000000000, 5, 'video5'),
  ('video6', 'user6', 'Excellent!', 0000000000, 6, 'video6'),
  ('video7', 'user7', 'Pretty good.', 0000000000, 7, 'video7'),
  ('video8', 'user8', 'Well done!', 0000000000, 8, 'video8'),
  ('video9', 'user9', 'Nice video.', 0000000000, 9, 'video9'),
  ('video10', 'user10', 'Amazing work.', 0000000000, 10, 'video10');

  -- -----------------------------------------------------
  -- Insert data into `favorite`
  -- -----------------------------------------------------
  INSERT INTO `mydb`.`favorite` (`user_id`, `video_id`, `user_user_id`, `video_video_id`)
  VALUES
  (1, 'video1', 1, 'video1'),
  (2, 'video2', 2, 'video2'),
  (3, 'video3', 3, 'video3'),
  (4, 'video4', 4, 'video4'),
  (5, 'video5', 5, 'video5'),
  (6, 'video6', 6, 'video6'),
  (7, 'video7', 7, 'video7'),
  (8, 'video8', 8, 'video8'),
  (9, 'video9', 9, 'video9'),
  (10, 'video10', 10, 'video10');


 -- -----------------------------------------------------
 -- Insert data into `video`
 -- -----------------------------------------------------
 INSERT INTO `mydb`.`video` (`video_id`, `title`, `part`, `channel_name`, `url`, `thumbnail`, `views`, `status`) VALUES
 ('50WCSpZtdmA', 'Shim EuDdeum 10 Minute Morning Stretch Everydayㅣ2023 Renewal', '전신', '힘으뜸', 'https://www.youtube.com/watch?v=50WCSpZtdmA', 'https://img.youtube.com/vi/50WCSpZtdmA/maxresdefault.jpg', 0, 1),
 ('Kk7TQGqQ3nA', '하루 두 번🧘🏻‍♀️반드시 해야하는 20분 전신순환 스트레칭 Ep.08 - 피로회복, 디톡스, 심신안정, 혈액순환, 라인정리 효과 (Whole body stretch)', '전신', '빵느', 'https://www.youtube.com/watch?v=Kk7TQGqQ3nA', 'https://img.youtube.com/vi/Kk7TQGqQ3nA/maxresdefault.jpg', 0, 1),
 ('MTU4iCDntjs', '4 Minute OFFICE STRETCHING(full body)', '전신', 'Allblanc TV', 'https://www.youtube.com/watch?v=MTU4iCDntjs', 'https://img.youtube.com/vi/MTU4iCDntjs/maxresdefault.jpg', 0, 1),
 ('D3yExRi7EME&t=791s', '뭉친 어깨, 뻣뻣한 골반 풀어주는 요가 | 앉아서 하는 요가 스트레칭 | 어깨 근육 풀기, 골반풀기', '상체', 'Mindful Yoga with Eileen', 'https://www.youtube.com/watch?v=D3yExRi7EME&t=791s', 'https://img.youtube.com/vi/D3yExRi7EME&t=791s/maxresdefault.jpg', 0, 1),
 ('02K-k6daPb4', '15 MIN Fat Burning Cardio - 서서하는 유산소 - 다이어트 운동', '전신', '빅씨스 Bigsis', 'https://www.youtube.com/watch?v=02K-k6daPb4', 'https://img.youtube.com/vi/02K-k6daPb4/maxresdefault.jpg', 0, 1),
 ('gMaB-fG4u4g', '전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]', '전신', 'ThankyouBUBU', 'https://www.youtube.com/embed/gMaB-fG4u4g', 'https://img.youtube.com/vi/gMaB-fG4u4g/maxresdefault.jpg', 0, 1),
 ('swRNeYw1JkY', '하루 15분! 전신 칼로리 불태우는 다이어트 운동', '전신', 'ThankyouBUBU', 'https://www.youtube.com/embed/swRNeYw1JkY', 'https://img.youtube.com/vi/swRNeYw1JkY/maxresdefault.jpg', 0, 1),
 ('54tTYO-vU2E', '상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]', '상체', 'ThankyouBUBU', 'https://www.youtube.com/embed/54tTYO-vU2E', 'https://img.youtube.com/vi/54tTYO-vU2E/maxresdefault.jpg', 0, 1),
 ('QqqZH3j_vH0', '상체비만 다이어트 최고의 운동 [상체 핵매운맛]', '상체', 'ThankyouBUBU', 'https://www.youtube.com/embed/QqqZH3j_vH0', 'https://img.youtube.com/vi/QqqZH3j_vH0/maxresdefault.jpg', 0, 1),
 ('tzN6ypk6Sps', '하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]', '하체', '김강민', 'https://www.youtube.com/embed/tzN6ypk6Sps', 'https://img.youtube.com/vi/tzN6ypk6Sps/maxresdefault.jpg', 0, 1),
 ('u5OgcZdNbMo', '저는 하체 식주의자 입니다', '하체', 'GYM종국', 'https://www.youtube.com/embed/u5OgcZdNbMo', 'https://img.youtube.com/vi/u5OgcZdNbMo/maxresdefault.jpg', 0, 1),
 ('PjGcOP-TQPE', '11자복근 복부 최고의 운동 [복근 핵매운맛]', '복부', 'ThankyouBUBU', 'https://www.youtube.com/embed/PjGcOP-TQPE', 'https://img.youtube.com/vi/PjGcOP-TQPE/maxresdefault.jpg', 0, 1),
 ('7TLk7pscICk', '(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)', '복부', 'SomiFit', 'https://www.youtube.com/embed/7TLk7pscICk', 'https://img.youtube.com/vi/7TLk7pscICk/maxresdefault.jpg', 0, 1);

 SET SQL_MODE=@OLD_SQL_MODE;
 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

