# productStore 
## Микросервис с использованием SpringBoot/Hibernate/MongoDB

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
{"productDTO":{"name":"phone-A","findOnlyByName":true}
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
curl -H "Content-Type: application/json" -X POST -d {"productDTO":{"name":"phone-A","findOnlyByName":true}  http://192.168.99.100:9005/findProduct
```
### Поиск товара выбранному параметру и его значению
```
curl -H "Content-Type: application/json" -X POST -d {"productDTO":{"properties":{"battarySize":150,"weight":"2500"}},"findOnlyByProperties":true} http://192.168.99.100:9005/findProduct
```
### Получить детали товара по ID
```
curl -H "Content-Type: application/json" -X POST -d {"id": "5d99c63d1019162d8a38b521"} http://192.168.99.100:9005/findProductById
```

