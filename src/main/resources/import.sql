INSERT INTO users (email, name, password, creation_date) VALUES ('Chris_Heilmann@example.com', 'Chris_Heilmann','$2y$10$AdKYDnXYVdVu7yjukbShyu/Td0Br7H6yGjtDotyvtkQKzW7vyBuu.', '2023-12-27'); //pass: 10011010010
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('Java is to JavaScript what Car is to Carpet.', '2023-12-27T07:42:35.233','2023-12-27T07:42:35.233', 1);

INSERT INTO users (email, name, password, creation_date) VALUES ('Harold_Abelson@example.com', 'Harold_Abelson','$2y$10$AdKYDnXYVdVu7yjukbShyu/Td0Br7H6yGjtDotyvtkQKzW7vyBuu.', '2023-12-27');
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('Programs must be written for people to read, and only incidentally for machines to execute.', '2023-12-27T07:44:43.137','2023-12-27T07:44:43.137', 2);

INSERT INTO users (email, name, password, creation_date) VALUES ('Louis_Srygley@example.com', 'Louis_Srygley','$2y$10$AdKYDnXYVdVu7yjukbShyu/Td0Br7H6yGjtDotyvtkQKzW7vyBuu.', '2023-12-27');
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('Without requirements or design, programming is the art of adding bugs to an empty text file.', '2023-12-27T07:45:52.547','2023-12-27T07:45:52.547', 3);

INSERT INTO users (email, name, password, creation_date) VALUES ('John_Woods@example.com', 'John_Woods','$2y$10$AdKYDnXYVdVu7yjukbShyu/Td0Br7H6yGjtDotyvtkQKzW7vyBuu.', '2023-12-27');
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('Always code as if the guy who ends up maintaining your code will be a violent psychopath who knows where you live.', '2023-12-27T07:46:43.634','2023-12-27T07:46:43.634', 4);

INSERT INTO users (email, name, password, creation_date) VALUES ('John_Romero@example.com', 'John_Romero','$2y$10$AdKYDnXYVdVu7yjukbShyu/Td0Br7H6yGjtDotyvtkQKzW7vyBuu.', '2023-12-27');
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('You might not think that programmers are artists, but programming is an extremely creative profession. It’s logic-based creativity.', '2023-12-27T07:47:31.345','2023-12-27T07:47:31.345', 5);

INSERT INTO users (email, name, password, creation_date) VALUES ('Bill_Gates@example.com', 'Bill_Gates','$2y$10$AdKYDnXYVdVu7yjukbShyu/Td0Br7H6yGjtDotyvtkQKzW7vyBuu.', '2023-12-27');
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('Measuring programming progress by lines of code is like measuring aircraft building progress by weight.', '2023-12-27T07:48:50.971','2023-12-27T07:48:50.971', 6);
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('A great lathe operator commands several times the wage of an average lathe operator, but a great writer of software code is worth 10,000 times the price of an average software writer', '2023-12-27T07:50:02.487','2023-12-27T07:50:02.487', 6);

INSERT INTO users (email, name, password, creation_date) VALUES ('John_Carmack@example.com', 'John_Carmack','$2y$10$AdKYDnXYVdVu7yjukbShyu/Td0Br7H6yGjtDotyvtkQKzW7vyBuu.', '2023-12-27');
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('Programming is not a zero-sum game. Teaching something to a fellow programmer doesn’t take it away from you. I’m happy to share what I can, because I’m in it for the love of programming.', '2023-12-27T07:51:10.375','2023-12-27T07:51:10.375', 7);
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('If you want to set off and go develop some grand new thing, you don’t need millions of dollars of capitalization. You need enough pizza and Diet Coke to stick in your refrigerator, a cheap PC to work on and the dedication to go through with it.', '2023-12-27T07:51:53.625','2023-12-27T07:51:53.625', 7);
INSERT INTO quotes (content, creation_date, update_date, user_id) VALUES ('Low-level programming is good for the programmer’s soul.', '2023-12-27T07:53:05.433','2023-12-27T07:53:05.433', 7);

INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (1, 2, 1, '2023-12-27T08:16:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (1, 4, 1, '2023-12-27T08:17:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (1, 6, 1, '2023-12-27T08:18:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (1, 8, 1, '2023-12-27T08:19:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (1, 10, 1, '2023-12-27T08:20:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (2, 1, 1, '2023-12-27T08:21:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (2, 3, 1, '2023-12-27T08:22:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (2, 4, 1, '2023-12-27T08:23:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (2, 5, 1, '2023-12-27T08:24:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (2, 6, 1, '2023-12-27T08:25:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 1, -1, '2023-12-27T08:26:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 2, -1, '2023-12-27T08:27:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 4, -1, '2023-12-27T08:28:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 5, -1, '2023-12-27T08:29:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 6, -1, '2023-12-27T08:30:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 7, -1, '2023-12-27T08:31:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 8, -1, '2023-12-27T08:32:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 9, -1, '2023-12-27T08:33:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (3, 10, -1, '2023-12-27T08:34:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (4, 10, -1, '2023-12-27T08:35:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (4, 1, 1, '2023-12-27T08:36:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (4, 2, 1, '2023-12-27T08:37:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (4, 3, 1, '2023-12-27T08:38:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (4, 9, -1, '2023-12-27T08:39:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (5, 10, 1, '2023-12-27T08:40:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (5, 9, -1, '2023-12-27T08:41:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (5, 8, 1, '2023-12-27T08:42:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (5, 7, 1, '2023-12-27T08:43:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (5, 6, -1, '2023-12-27T08:44:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (6, 9, 1, '2023-12-27T08:45:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (6, 4, -1, '2023-12-27T08:46:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (6, 5, 1, '2023-12-27T08:47:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (6, 3, 1, '2023-12-27T08:48:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (6, 1, -1, '2023-12-27T08:49:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (7, 1, 1, '2023-12-27T08:50:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (7, 2, 1, '2023-12-27T08:51:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (7, 3, 1, '2023-12-27T08:52:05.433');
INSERT INTO votes (user_id, quote_id, rate, rate_date) VALUES (7, 4, 1, '2023-12-27T08:53:05.433');

INSERT INTO roles (name) VALUES ('ROLE_USER');
INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (4, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (5, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (6, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (7, 1);