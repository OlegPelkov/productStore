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

### 1. Создать образ 
```
docker build -t spring-mongo:latest .
```
### 2. Запуск контейнера с MongoDB
```
docker run -d -p 27017:27017 mongo
```
### 3. Запуск контейнера с сервисом
```
docker run -p 9005:9005 --name spring-mongo --link=mongo spring-mongo
```

## REST API методы:
### Создать новый товар (в response body будет JSON c ID товара)
##### REST метод:
```
/createProduct
```
##### Пример JSON:
```
{"productDTO":{"name":"phone-A","description":"A phone","properties":{"battarySize":150,"weight":"2500"}}}
```

### Поиск товара по названию
##### REST метод:
```
/findProduct
```
##### Пример JSON:
```
{"productDTO":{"name":"phone"},"findOnlyByName":true}
```

### Поиск товара выбранному параметру и его значению
##### REST метод:
```
/findProduct
```
##### Пример JSON:
```
{"productDTO":{"properties":{"battarySize":150,"weight":"2500"}},"findOnlyByProperties":true}
```

### Получить детали товара по ID
##### REST метод:
```
/findProductById
```
##### Пример JSON:
```
{"id": "5d99c63d1019162d8a38b521"}
```
## Команды утилиты curl
### Создать новый товар (в response body будет JSON c ID товара)
```
curl -H "Content-Type: application/json" -X POST -d {"productDTO":{"name":"phone-B","description":"B phone","properties":{"battarySize":250,"weight":"3500"}}} http://192.168.99.100:9005/createProduct
```
### Поиск товара по названию
```
curl -H "Content-Type: application/json" -X POST -d {"productDTO":{"name":"phone"},"findOnlyByName":true}  http://192.168.99.100:9005/findProduct
```
### Поиск товара выбранному параметру и его значению
```
curl -H "Content-Type: application/json" -X POST -d {"productDTO":{"properties":{"battarySize":150,"weight":"2500"}},"findOnlyByProperties":true} http://192.168.99.100:9005/findProduct
```
### Получить детали товара по ID
```
curl -H "Content-Type: application/json" -X POST -d {"id": "5d99c63d1019162d8a38b521"} http://192.168.99.100:9005/findProductById
```

