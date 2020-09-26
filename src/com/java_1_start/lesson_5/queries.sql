-- подключение к БД
\connect jaegers;

-- вывод всей таблицы
SELECT * FROM robots;

-- вывод только не уничтоженных роботов
SELECT * FROM robots WHERE status <> 'Destroyed';

-- вывод роботов нескольких серий
SELECT * FROM robots WHERE mark = 'Mark-1' OR mark = 'Mark-6';

-- вывод таблицы с сортировкой
SELECT * FROM robots ORDER BY mark DESC;

-- вывод самого старого робота
SELECT * FROM robots
WHERE launch = (SELECT MIN(launch) FROM robots)
LIMIT 1;

-- вывод  роботов, которые уничтожили меньше всех kaiju
SELECT * FROM robots
WHERE kaijuKill = (SELECT MIN(kaijuKill) FROM robots);

-- вывод  роботов, которые уничтожили больше всех kaiju
SELECT * FROM robots
WHERE kaijuKill = (SELECT MAX(kaijuKill) FROM robots);

-- вывод среднего веса роботов
SELECT AVG(weight) FROM robots;

-- увеличение на единицу количества уничтоженных kaiju у роботов, которые целые
UPDATE robots
SET kaijuKill = kaijuKill + 1
WHERE status <> 'Destroyed';

-- вывод всей таблицы
SELECT * FROM robots;

-- удаление уничтоженных роботов
DELETE FROM robots WHERE status = 'Destroyed';

-- вывод всей таблицы
SELECT * FROM robots;