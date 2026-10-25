-- Dane startowe aplikacji. Tabele tworzy Hibernate z encji, a ten plik Spring Boot uruchamia zaraz potem.
-- LAB 01: dopiszcie tu konta wszystkich osób z zespołu (reguła R1.03).
-- LAB 02: dopiszcie dane do swoich tabel (kolejność: najpierw tabele, na które wskazują klucze obce).
insert into user_account (email, display_name, role, created_at) values
    ('s988234@student.wroclaw.merito.pl',   'Michal',   'USER',    current_timestamp),
    ('s762608@student.wroclaw.merito.pl',  'Kacper',  'USER',    current_timestamp),
    ('s205640@student.wroclaw.merito.pl',  'Oskar',  'USER',    current_timestamp),
    ('firma@example.com',       'Firma', 'PARTNER', current_timestamp),
    ('admin@example.com',       'Admin', 'ADMIN',   current_timestamp);

-- LAB 01: Wasze konta (zmieńcie na swoje dane, rola USER)
-- insert into user_account (email, display_name, role, created_at) values
--     ('imie.nazwisko@student.merito.pl', 'Imię', 'USER', current_timestamp);

-- ===== LAB 02 · board_games =====
insert into board_games (name, publisher, price, rental_price_per_day, min_players, max_players, play_time_minutes, min_age, category, release_year, description) values
    ('Catan',       'Galakta', 169.00, 8.00, 3, 4, 90, 10, 'Strategiczna', 1995, 'Handel i budowa osad na wyspie Catan.'),
    ('Dixit',       'Rebel',   139.00, 6.00, 3, 8, 30, 8,  'Imprezowa',    2008, 'Skojarzenia budowane na ilustracjach.'),
    ('Carcassonne', 'Bard',     99.00, 5.00, 2, 5, 45, 7,  'Rodzinna',     2000, 'Układanie kafelków i zdobywanie punktów.');

-- ===== LAB 02 · game_availability =====
insert into game_availability (board_game_id, quantity_total, quantity_available, updated_at) values
    (1, 3, 2, current_timestamp),
    (2, 2, 2, current_timestamp),
    (3, 4, 3, current_timestamp);
