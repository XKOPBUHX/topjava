-- подключение к БД
\connect jaegers;

-- добавление строк в таблицу
INSERT INTO robots (modelName, mark, height, weight, status, origin, launch, kaijuKill)
VALUES
    ('Brawler Yukon',  'Mark-1', '72.25', '1.81',  'Destroyed', 'USA',       '2015-01-30', '2' ),
    ('Gipsy Danger',   'Mark-3', '79.25', '1.98',  'Destroyed', 'USA',       '2017-07-10', '9' ),
    ('Striker Eureka', 'Mark-5', '76.2',  '1.85',  'Destroyed', 'Australia', '2019-11-02', '11'),
    ('Cherno Alpha',   'Mark-1', '85.34', '2.412', 'Destroyed', 'Russia',    '2015-02-02', '6' ),
    ('Gipsy Avenger',  'Mark-6', '81.77', '2.004', 'Destroyed', 'Japan',     '2034-01-12', '1' ),
    ('Coyote Tango',   'Mark-1', '85.34', '2.312', 'Destroyed', 'Japan',     '2015-12-30', '1' ),
    ('Obsidian Fury',  'Mark-7', '83.55', '2.001', 'Destroyed', 'China',     '2035-05-15', '3' ),
    ('Angry Hamster',  'Mark-2', '77.31', '1.88',  'Intact',    'China',     '2016-03-11', '1' ),
    ('Cute cat',       'Mark-4', '87.12', '1.965', 'Intact',    'Russia',    '2017-01-11', '0' ),
    ('Superman',       'Mark-8', '99.99', '9.999', 'Intact',    'Russia',    '2050-01-01', '99');