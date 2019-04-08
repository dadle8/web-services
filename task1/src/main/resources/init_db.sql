CREATE TABLE "country" (
    id serial PRIMARY KEY NOT NULL,
    name character varying(200),
    fullname character varying(200),
    population integer,
    capital character varying(200)
);

INSERT INTO country(name, fullname, population, capital) values ('Китай', 'Китайская Народная Республика', 1395814000, 'Пекин');
INSERT INTO country(name, fullname, population, capital) values ('Индия', 'Республика Индия', 1359741000, 'Дели');
INSERT INTO country(name, fullname, population, capital) values ('США', 'Соединённые Штаты Америки', 333336805, 'Вашингтон');
INSERT INTO country(name, fullname, population, capital) values ('Индонезия', 'Республика Индонезия', 270252812, 'Джакарта');
INSERT INTO country(name, fullname, population, capital) values ('Пакистан', 'Исламская Республика Пакистан', 214003184, 'Исламабад');
INSERT INTO country(name, fullname, population, capital) values ('Бразилия', 'Федеративная Республика Бразилия', 209737010, 'Бразилиа');
INSERT INTO country(name, fullname, population, capital) values ('Нигерия', 'Федеративная Республика Нигерия', 201184694, 'Абуджа');
INSERT INTO country(name, fullname, population, capital) values ('Бангладеш', 'Народная Республика Бангладеш', 168386593, 'Дакка');
INSERT INTO country(name, fullname, population, capital) values ('Россия', 'Российская Федерация', 146781095, 'Москва');
INSERT INTO country(name, fullname, population, capital) values ('Мексика', 'Мексиканские Соединенные Штаты', 133140936, 'Мехико');
INSERT INTO country(name, fullname, population, capital) values ('Япония', 'Япония', 126220000, 'Токио');