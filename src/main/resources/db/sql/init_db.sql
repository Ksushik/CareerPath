INSERT INTO categories (NAME, IS_ROOT) VALUES ('Крупная бытовая техника','Y');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Холодильники','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Стиральные машины','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Газовые плиты','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Мелкая бытовая техника','Y');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Пылесосы','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Электрочайники','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Телевизоры и аксессуары','Y');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Телевизоры','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Акустика Hi-Fi','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Домашние кинотеатры','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('DVD/HD-медиаплееры','N');
INSERT INTO categories (NAME, IS_ROOT) VALUES ('Аксессуары','N');


INSERT INTO manufacturers (NAME) VALUES ('LG');
INSERT INTO manufacturers (NAME) VALUES ('Philips');
INSERT INTO manufacturers (NAME) VALUES ('Tefal');
INSERT INTO manufacturers (NAME) VALUES ('Whirpool');
INSERT INTO manufacturers (NAME) VALUES ('Rowenta');
INSERT INTO manufacturers (NAME) VALUES ('Beko');
INSERT INTO manufacturers (NAME) VALUES ('Braun');


INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(1,1);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(1,2);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(1,3);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(1,5);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(1,6);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(1,8);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(1,9);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(2,5);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,1);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,2);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,3);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,4);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,5);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,6);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,7);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,8);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,9);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,10);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,11);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,12);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(3,13);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(2,6);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(4,1);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(4,2);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(4,3);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,1);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,2);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,3);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,4);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,5);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,6);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,7);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,8);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,9);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,10);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,11);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,12);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(5,13);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,1);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,2);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,3);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,4);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,5);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,6);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,8);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(6,9);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(7,5);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(7,6);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(7,8);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(7,9);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(7,11);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(7,12);
INSERT INTO manufacturers_categories (MANUFACTURER_ID, CATEGORY_ID) VALUES(7,13);


INSERT INTO products (NAME, CATEGORY_ID, MANUFACTURER_ID, PRICE, AVAILABLE, DESCR) VALUES
('Холодильник LG GA-B419SEQL',2, 1, 14499,'Y','Суперсовременная система разморозки Total No Frost обеспечивает отсутствие конденсационных испарений на задней стенке камер и равномерное охлаждение пищевых продуктов. Для поддержания свежести воздуха и правильного микроклимата над каждой полкой холодильника LG установлены отводы для воздуха Multi-Air Flow.');

 INSERT INTO products (NAME, CATEGORY_ID, MANUFACTURER_ID, PRICE, AVAILABLE, DESCR) VALUES
 ('Холодильник BEKO RCSK 340M21 W',2, 6, 8499,'N','Двухкамерный холодильник белого цвета с классом энергопотребления A+. Морозильная камера с общим полезным объемом 87 литров расположена в нижней части. Холодильное отделение объемом 205 литров позволяет разместить и охладить большое количество продуктов.');

 INSERT INTO products (NAME, CATEGORY_ID, MANUFACTURER_ID, PRICE, AVAILABLE, DESCR) VALUES
 ('Посудомоечная машина WHIRLPOOL WFC 3C26',1, 4, 9999,'Y','Тип окремостояча ВxШxГ 85x60x60 см Кількість комплектів посуду 14 Клас енергоспоживання A++ Клас Мийки A Клас Сушки A Споживання води за 1 цикл	9 л Кількість програм 8 Кількість температурних режимів 3 Колір білий Управління кнопкове Дисплей так Таймер відстрочки так Половина завантаження ні Третій ящик для столових приладів так Замок від дітей ні Інд. + наявності солі так Інд. наявності ополіскувача так');

