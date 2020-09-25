-- создание БД
CREATE DATABASE jaegers;

-- подключение к БД
\connect jaegers;

-- создание таблицы
CREATE TABLE robots (
	id SERIAL PRIMARY KEY,
	modelName TEXT,
	mark CHAR(6),
	height REAL,
	weight REAL,
	status TEXT,
	origin TEXT,
	launch DATE,
	kaijuKill INTEGER);