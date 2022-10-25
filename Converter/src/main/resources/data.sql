INSERT INTO category(title) VALUES('Длина');
INSERT INTO category(title) VALUES('Площадь');
INSERT INTO category(title) VALUES('Объём');
INSERT INTO category(title) VALUES('Валюта');
INSERT INTO category(title) VALUES('Масса');
INSERT INTO category(title) VALUES('Время');

INSERT INTO convertation(from_quantity, to_quantity, multiplier, category_id)
VALUES('Метр', 'Сантиметр', 100, 1);
INSERT INTO convertation(from_quantity, to_quantity, multiplier, category_id)
VALUES('Кв. метр', 'Гектар', 0.0001, 2);
INSERT INTO convertation(from_quantity, to_quantity, multiplier, category_id)
VALUES('Куб. метр', 'Литр', 1000, 3);
INSERT INTO convertation(from_quantity, to_quantity, multiplier, category_id)
VALUES('Гривна', 'Доллар', 0.027, 4);
INSERT INTO convertation(from_quantity, to_quantity, multiplier, category_id)
VALUES('Доллар', 'Евро', 1.01, 4);
INSERT INTO convertation(from_quantity, to_quantity, multiplier, category_id)
VALUES('Килограмм', 'Грамм', 1000, 5);
INSERT INTO convertation(from_quantity, to_quantity, multiplier, category_id)
VALUES('Час', 'Минута', 60, 6);