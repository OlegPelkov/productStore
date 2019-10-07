# ProductStore 
## Микросервис с использованием SpringBoot/SpringData/Postgres

## REST API методы:
### Создать новый товар (в response body будет JSON c ID товара)
##### REST метод:
```
http://127.0.0.1:9005/createProduct
```
##### Пример JSON:
```
{"productDTO":{"name":"phone-A","description":"A phone","properties":{"battarySize":150,"weight":"2500"}}}
```

### Поиск товара по названию
##### REST метод:
```
http://127.0.0.1:9005/findProduct
```
##### Пример JSON:
```
{"productDTO":{"name":"phone"},"findOnlyByName":true}
```

### Поиск товара выбранному параметру и его значению
##### REST метод:
```
http://127.0.0.1:9005/findProduct
```
##### Пример JSON:
```
{"productDTO":{"properties":{"battarySize":150,"weight":"2500"}},"findOnlyByProperties":true}
```

### Получить детали товара по ID
##### REST метод:
```
http://127.0.0.1:9005/findProductById
```
##### Пример JSON:
```
{"id": "12"}
```
