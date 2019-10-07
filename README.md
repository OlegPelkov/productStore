# ProductStore 
## Микросервис с использованием SpringBoot/Hibernate/MongoDB

## Команды Docker для запуска готового образа

### 1. Запуск контейнера с MongoDB
```
docker run -d -p 27017:27017 mongo
```
### 2. Запуск контейнера с сервисом
```
docker run -p 9005:9005 --name olegpelkov/spring-mongo --link=mongo olegpelkov/spring-mongo
```

## Команды Docker для создания и запуска образа

### 1. Скомпилировать jar
```
gradle clean build
```
### 2 Создать образ 
```
docker build -t spring-mongo:latest .
```
### 3 Запуск контейнера с MongoDB
```
docker run -d -p 27017:27017 mongo
```
### 4 Запуск контейнера с сервисом
```
docker run -p 9005:9005 --name spring-mongo --link=mongo spring-mongo
```
## REST API методы:
### Значение параметра host инициализировать через команду
```
docker-machine ip
```
### Создать новый товар (в response body будет JSON c ID товара)
##### REST метод:
```
http://host:9005/createProduct
```
##### Пример JSON:
```
{"productDTO":{"name":"phone-A","description":"A phone","properties":{"battarySize":150,"weight":"2500"}}}
```

### Поиск товара по названию
##### REST метод:
```
http://host:9005/findProduct
```
##### Пример JSON:
```
{"productDTO":{"name":"phone"},"findOnlyByName":true}
```

### Поиск товара выбранному параметру и его значению
##### REST метод:
```
http://host:9005/findProduct
```
##### Пример JSON:
```
{"productDTO":{"properties":{"battarySize":150,"weight":"2500"}},"findOnlyByProperties":true}
```

### Получить детали товара по ID
##### REST метод:
```
http://host:9005/findProductById
```
##### Пример JSON:
```
{"id": "5d99c63d1019162d8a38b521"}
```
## Команды утилиты curl for Windows
### Создать новый товар (в response body будет JSON c ID товара)
```
curl.exe -X POST ^
-H "Content-Type: application/json" ^
-d "{\"productDTO\":{\"name\":\"phone-B\",\"description\":\"B phone\",\"properties\":{\"battarySize\":250,\"weight\":\"3500\"}}}" ^
"http://host:9005/createProduct"
```
### Поиск товара по названию
```
curl.exe -X POST ^
-H "Content-Type: application/json" ^
-d "{\"productDTO\":{\"name\":\"phone\"},\"findOnlyByName\":true}" ^
"http://host:9005/findProduct"
```
### Поиск товара выбранному параметру и его значению
```
curl.exe -X POST ^
-H "Content-Type: application/json" ^
-d "{\"productDTO\":{\"properties\":{\"battarySize\":250,\"weight\":\"2500\"}},\"findOnlyByProperties\":true}" ^
"http://host:9005/findProduct"
```
### Получить детали товара по ID
```
curl.exe -X POST ^
-H "Content-Type: application/json" ^
-d "{\"id\":\"5d9aff0769549e78c450da49\"}" ^
"http://host:9005/findProductById"

```

## Команды утилиты curl for Linux
### Создать новый товар (в response body будет JSON c ID товара)
```
curl -X POST -H "Content-Type: application/json" \
 -d '{"productDTO":{"name":"phone-A","description":"A phone","properties":{"battarySize":150,"weight":"2500"}}}' \
http://host:9005/createProduct
```
### Поиск товара по названию
```
curl -X POST -H "Content-Type: application/json" \
 -d '{"productDTO":{"name":"phone"},"findOnlyByName":true}' \
http://host:9005/findProduct
```
### Поиск товара выбранному параметру и его значению
```
curl -X POST -H "Content-Type: application/json" \
 -d '{"productDTO":{"properties":{"battarySize":150,"weight":"2500"}},"findOnlyByProperties":true}' \
http://host:9005/findProduct
```
### Получить детали товара по ID
```
curl -X POST -H "Content-Type: application/json" \
 -d '{"id": "5d99c63d1019162d8a38b521"}' \
http://host:9005/findProductById
```

