CREATE TABLE `problems` (
    `problem_id` char(30) NOT NULL,
    `title` varchar(100),
    `level` int,
    `point` int,
    `problem_statement` text,
    `answer` int,
    PRIMARY KEY (`problem_id`)
);

CREATE TABLE `users` (
    `user_id` char(26),
    `user_name` char(16), 
    `password` char(128), 
    `profile` text,
    PRIMARY KEY (`user_id`)
);

CREATE TABLE `submissions` (
    `submission_id` char(26),
    `submission_datetime` datetime NOT NULL,
    `user_id` char(26) REFERENCES `users` (`user_id`),
    `problem_id` char(26) REFERENCES `problem` (`problem_id`),
    `answer` int,
    `judge_result` char(3),
    PRIMARY KEY (`submission_id`)
);