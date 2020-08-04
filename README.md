# Final_project_TMS

##### API онлайн-магазина спиртных напитков

## Установка

Для клонирования репозитория выберите директорию на ПК и перейдите в неё. Запустите Git Bash [ссылка на скачивание Git Bash]{https://git-scm.com/downloads} и введите следующую команду:
git clone https://github.com/tolstiachok123/Final_project_TMS.git

Запустите Intellij IDEA [ссылка на скачивание Intellij IDEA]{https://www.jetbrains.com/ru-ru/idea/} и откройте загруженый проект. 

В проекте используется база данных MySQL [ссылка на скачиваниее MySQL]{https://dev.mysql.com/downloads/}. Запустите MySQL Workbench, создайте пустую базу данных с именем alcoholmarket [пример создания новой БД]{https://streletzcoder.ru/mysql-workbench-sozdanie-bazyi-dannyih/}. Далее нажмите Server -> Data Import -> Import from Dump Project Folder. В облисти ввода рядом введите полный путь папки "src/main/resources/dump" из дерева проекта. Всё ещё в окне MySQL Workbench перейдите во вкладку Import Progress и нажмите кнопку Start Import. Поздравляю, база данных для работы с проектом создана.

Перейдите в Intellij IDEA. В дере проекта найдите файл "src/main/resources/application.properties" и откройте его.
В строке "server.port=..." укажите порт на котором хотите запустить приложение или оставьте значение 8085 по умолчанию если уверены что такой порт свободен.
В строках "spring.datasource.username=..." и "spring.datasource.password=..." укажите имя пользователя и пароль которые используются для работы с базой данных созданной ранее.
В строке "spring.datasource.url=..." укажите путь базы данных или просто замените "AlcoholMarket" на имя созданной базы данных ("jdbc:mysql://localhost:3306/~~AlcoholMarket~~?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false).
Закройте файл.

Нажмите сочитание клавиш "Shift+F10".

## Использование

После успешного запуска можно перейти в браузер, набрать в поисковой строке "http://localhost:8085" и начать работу с API, но есть варианты удобнее. Рекомендую использовать Postman [ссылка на скачивание Postman]{https://www.postman.com/downloads/}. Запустите Postman, создайте вкладку с POST-запросом по адресу "localhost:8085/registration" и заполните значения JSON по аналогии с изображением ниже:


