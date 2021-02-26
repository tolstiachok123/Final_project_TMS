# Final_project_TMS

### API онлайн-магазина спиртных напитков

## Установка

Данный продукт позволяет развернуть его двумя способами на Вашем компьютере. 

Первый способ

Запустите терминал вашего компьютера. Убедитесь что у Вас установлен Docker [ссылка на скачивание Docker Win10]{https://hub.docker.com/editions/community/docker-ce-desktop-windows/} выполнив команду:
docker --version

Скачайте образ и запустите программу выполнив в терминале команду:
docker run tolstiachok123/tms_final_project:v2.0

Второй способ 

Для клонирования репозитория выберите директорию на ПК и перейдите в неё. Запустите Git Bash [ссылка на скачивание Git Bash]{https://git-scm.com/downloads} и введите следующую команду:
git clone https://github.com/tolstiachok123/Final_project_TMS.git

Запустите Intellij IDEA [ссылка на скачивание Intellij IDEA]{https://www.jetbrains.com/ru-ru/idea/} и откройте загруженный проект. 

В проекте используется база данных MySQL [ссылка на скачивание MySQL]{https://dev.mysql.com/downloads/}. Запустите MySQL Workbench, создайте пустую базу данных с именем alcoholmarket [пример создания новой БД]{https://streletzcoder.ru/mysql-workbench-sozdanie-bazyi-dannyih/}. Далее нажмите Server -> Data Import -> Import from Dump Project Folder. В облисти ввода рядом введите полный путь папки "src/main/resources/dump" из дерева проекта. Всё ещё в окне MySQL Workbench перейдите во вкладку Import Progress и нажмите кнопку Start Import. Поздравляю, база данных для работы с проектом создана.

Перейдите в Intellij IDEA. В дереве проекта найдите файл "src/main/resources/application.properties" и откройте его.
В строке "server.port=..." укажите порт на котором хотите запустить приложение или оставьте значение 8085 по умолчанию если уверены что такой порт свободен.
В строках "spring.datasource.username=..." и "spring.datasource.password=..." укажите имя пользователя и пароль которые используются для работы с базой данных созданной ранее.
В строке "spring.datasource.url=..." укажите путь базы данных или просто замените "AlcoholMarket" на имя созданной базы данных ("jdbc:mysql://localhost:3306/~~AlcoholMarket~~?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false).
В строке "logging.file.path=..." укажите полный путь папки "app.log"
Закройте файл.

Настройте соединение с базой данных используя следующую инструкцию [ссылка на подключение MySQL БД к Intellij IDEA]{https://javastudy.ru/webapp/create-mysql-connect-intellij-idea/}. 

Нажмите сочетание клавиш "Shift+F10".

## Использование

После успешного запуска можно перейти в браузер, набрать в поисковой строке "http://localhost:8085" и начать работу с API, но есть варианты удобнее. Рекомендую использовать Postman [ссылка на скачивание Postman]{https://www.postman.com/downloads/}. 

Конечные точки для USER и ADMIN:
1. localhost:8085/registration (PUT) - регистрация нового пользователя
2. localhost:8085/login (POST) - авторизация пользователя
3. localhost:8085/drinks (GET) - список всех алкогольных напитков
4. localhost:8085/drinks/{id} (GET) - информация о конкретном алкогольном напитке
5. localhost:8085/drinks/{id}/basket (POST) - добавление конкретного алкогольного напитка в корзину
6. localhost:8085/manufacturers (GET) - список всех производителей
7. localhost:8085/manufacturers/{id} (GET) - информация о конкретном производителе
8. localhost:8085/order/current (GET) - текущий заказ (пустой если Вы ничего не заказывали)
9. localhost:8085/order/{id} (GET) - информация о конкретном заказе
10. localhost:8085/order/current/pay (GET) - оплата и завершение текущего заказа
11. localhost:8085/user (GET) - информация о текущем пользователе (о Вас)

Конечные точки только для ADMIN:
1. localhost:8085/users (GET) - список всех пользователей
2. localhost:8085/users/{id} (GET) - информация о конкретном пользователе
3. localhost:8085/users/{id} (DELETE) - удаление пользователя
4. localhost:8085/drinks (PUT) - добавление нового алкогольного напитка
5. localhost:8085/drinks/{id} (POST) - изменение конкретного алкогольного напитка
6. localhost:8085/drinks/{id} (DELETE) - удаление алкогольного напитка
7. localhost:8085/manufacturer (PUT) - добавление нового производителя
8. localhost:8085/manufacturers/{id} (POST) - изменение конкретного производителя
9. localhost:8085/manufacturers/{id} (DELETE) - удаление производителя
10. localhost:8085/order/{id} (DELETE) - удаление заказа

Запустите Postman. 
Создайте вкладку с PUT-запросом по адресу "localhost:8085/registration", выберите Body -> raw -> JSON и заполните все пары своими данными:
{
    "username": "Username",
    "email": "user@gmail.com",
    "phone": "+37529...",
    "password": "user password"
}
Нажмите кнопку Send. 

Поздравляю, Вы зарегистрированы, но ещё не авторизованы. Создайте вкладку с POST-запросом по адресу "localhost:8085/login", выберите Body -> form-data. В таблице в столбце KEY создайте 2 строки username и password. В соседнем столбце VALUE введите соответствующие значения профиля который Вы зарегистрировали ранее. Нажмите кнопку Send. Поздравляю, Вы авторизованы как USER.

Если Вы хотите авторизоваться с ролью ADMIN - перезапустите приложение, создайте POST-запрос по адресу "localhost:8085/login", но сейчас в столбце VALUE введите значения "Roman" и "123". Нажмите кнопку Send. Поздравляю, Вы авторизованы как USER и ADMIN.

Воспользуйтесь функционалом для ADMIN и измените значения алкогольного напитка следующим образом. Создайте вкладку с POST-запросом по адресу "localhost:8085/drinks/2", выберите Body -> raw -> JSON и заполните все пары своими данными:
{
    "photoPath":"...",
    "type":"BITTER",
    "quantity":"3",
    "name":"Angostura",
    "cost":"30",
    "adv":"45"
}
Нажмите кнопку Send. 

Запросы GET и DELETE не требуют заполнения JSON, просто создайте новую вкладку, укажите нужный тип запроса и конечную точку.


