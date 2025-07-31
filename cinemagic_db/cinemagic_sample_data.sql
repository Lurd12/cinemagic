
-- Insert data into `branch`
INSERT INTO branch (inter_number, id_branch, country, direction, state, town) VALUES
(101, 1, 'Mexico', 'Av. Reforma 123', 'CDMX', 'Mexico City'),
(102, 2, 'Mexico', 'Calle Hidalgo 456', 'Jalisco', 'Guadalajara');

-- Insert data into `cinema_user`
INSERT INTO cinema_user (id_viewer, password, role, username) VALUES
(1, 'pass1', 'USER', 'john_doe'),
(2, 'pass2', 'USER', 'jane_doe'),
(3, 'adminpass', 'ADMIN', 'admin_user');

-- Insert data into `movie`
INSERT INTO movie (id_movie, duration, synopsis, title) VALUES
(1, 120, 'Sci-fi adventure in space', 'Galaxy Quest'),
(2, 90, 'Romantic drama with twists', 'Love & Lies');

-- Insert data into `theater`
INSERT INTO theater (id_theater, total_seats, id_branch) VALUES
(1, 100, 1),
(2, 150, 2);

-- Insert data into `showing`
INSERT INTO showing (id_show, price, date_time, id_movie, id_theater) VALUES
(1, 100.0, '2025-08-01 18:00:00', 1, 1),
(2, 120.0, '2025-08-01 20:00:00', 2, 2);

-- Insert data into `ticket`
INSERT INTO ticket (id_ticket, seat_number, id_show, id_viewer) VALUES
(1, 10, 1, 1),
(2, 11, 1, 2),
(3, 1, 2, 1);

-- Insert data into `review`
INSERT INTO review (id_review, calification, date, id_movie, id_user, content) VALUES
(1, 5, '2025-07-25 14:00:00', 1, 1, 'Amazing movie!'),
(2, 3, '2025-07-25 15:00:00', 2, 2, 'Could be better.');

-- Update AUTO_INCREMENT values
ALTER TABLE branch AUTO_INCREMENT = 3;
ALTER TABLE cinema_user AUTO_INCREMENT = 4;
ALTER TABLE movie AUTO_INCREMENT = 3;
ALTER TABLE theater AUTO_INCREMENT = 3;
ALTER TABLE showing AUTO_INCREMENT = 3;
ALTER TABLE ticket AUTO_INCREMENT = 4;
ALTER TABLE review AUTO_INCREMENT = 3;

INSERT INTO va
