# Final_project_TMS

### API онлайн-магазина спиртных напитков

## Установка

Для клонирования репозитория выберите директорию на ПК и перейдите в неё. Запустите Git Bash [ссылка на скачивание Git Bash]{https://git-scm.com/downloads} и введите следующую команду:
git clone https://github.com/tolstiachok123/Final_project_TMS.git

Запустите Intellij IDEA [ссылка на скачивание Intellij IDEA]{https://www.jetbrains.com/ru-ru/idea/} и откройте загруженый проект. 

В проекте используется база данных MySQL [ссылка на скачиваниее MySQL]{https://dev.mysql.com/downloads/}. Запустите MySQL Workbench, создайте пустую базу данных с именем alcoholmarket [пример создания новой БД]{https://streletzcoder.ru/mysql-workbench-sozdanie-bazyi-dannyih/}. Далее нажмите Server -> Data Import -> Import from Dump Project Folder. В облисти ввода рядом введите полный путь папки "src/main/resources/dump" из дерева проекта. Всё ещё в окне MySQL Workbench перейдите во вкладку Import Progress и нажмите кнопку Start Import. Поздравляю, база данных для работы с проектом создана.

Перейдите в Intellij IDEA. В дере проекта найдите файл "src/main/resources/application.properties" и откройте его.
В строке "server.port=..." укажите порт на котором хотите запустить приложение или оставьте значение 8085 по умолчанию если уверены что такой порт свободен.
В строках "spring.datasource.username=..." и "spring.datasource.password=..." укажите имя пользователя и пароль которые используются для работы с базой данных созданной ранее.
В строке "spring.datasource.url=..." укажите путь базы данных или просто замените "AlcoholMarket" на имя созданной базы данных ("jdbc:mysql://localhost:3306/~~AlcoholMarket~~?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false).
В строке "logging.file.path=..." укажите полный путь папки "app.log"
Закройте файл.

Настройте соединение с базой данных используя следующую инструкцию [ссылка на подключение MySQL БД к Intellij IDEA]{https://javastudy.ru/webapp/create-mysql-connect-intellij-idea/}. 

Нажмите сочитание клавиш "Shift+F10".

## Использование

После успешного запуска можно перейти в браузер, набрать в поисковой строке "http://localhost:8085" и начать работу с API, но есть варианты удобнее. Рекомендую использовать Postman [ссылка на скачивание Postman]{https://www.postman.com/downloads/}. 

Конечные точки для USER и ADMIN:
1. localhost:8085/registration (POST) - регистрация нового пользователя
2. localhost:8085/login (POST) - авторизация пользователя
3. localhost:8085/drinks (GET) - список всех алкогольных напитков
4. localhost:8085/drinks/{id} (GET) - информация о конкретном алкогольном напитке
5. localhost:8085/drinks/{id}/basket (POST) - добавление конкретного алкогольного напитка в корзину
6. localhost:8085/manufacturers (GET) - список всех производителей
7. localhost:8085/manufacturers/{id} (GET) - информация о конкретном производителе
8. localhost:8085/order/current (GET) - текущий заказ (пустой если Вы ничего не заказывали)
9. localhost:8085/order/{id} (GET) - информация о конкретном заказе
10. localhost:8085/order/current/pay (POST) - оплата и завершение текущего заказа
11. localhost:8085/user (GET) - информация о текущем пользователе (Вас)

Конечные точки только для ADMIN:
1. localhost:8085/users (GET) - список всех пользователей
2. localhost:8085/users/{id} (GET) - информация о конкретном пользователе
3. localhost:8085/users/{id} (DELETE) - удаление пользователя
4. localhost:8085/drinks (POST) - добавление нового алкогольного напитка
5. localhost:8085/drinks/{id} (PUT) - изменение конкретного алкогольного напитка
6. localhost:8085/drinks/{id} (DELETE) - удаление алкогольного напитка
7. localhost:8085/manufacturer (POST) - добавление нового производителя
8. localhost:8085/manufacturers/{id} (PUT) - измменение конкретного производителя
9. localhost:8085/manufacturers/{id} (DELETE) - удаление производителя
10. localhost:8085/order/{id} (DELETE) - удаление заказа

Запустите Postman, создайте вкладку с POST-запросом по адресу "localhost:8085/registration" и заполните значения JSON по аналогии с изображением ниже:


