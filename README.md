# ProductStore 
## Микросервис с использованием SpringBoot/SpringData/Postgres

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
{"productDTO":{"name":"phone","findOnlyByName":true}}
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
