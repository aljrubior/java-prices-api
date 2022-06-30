# Prices API

Open API: [api.yaml](https://github.com/aljrubior/java-prices-api/blob/main/src/main/resources/api/api.yaml)

Note: You can use https://editor.swagger.io/ to view the Prices Open API definition.

### Retrieve a price

```
GET /api/prices
```

**Query Params**

| Name      | Type   | Description                        | Example             |
|-----------|--------|------------------------------------|---------------------|
| date      | String | date and time the price is applied | 2020-06-14-10.00.00 |
| productId | long   | product identifier                 | 35455               |
| brandId   | int    | brand identifier                   | 1                   |

**Response**

| Name      | Description                                                   | Example             |
|-----------|---------------------------------------------------------------|---------------------|
| productId | The product identifier                                        | 35455               |
| brandId   | The brand identifier                                          | 1                   |
| priceList | The identifier of the applicable price rate                   | 1                   | 
| startDate | The start date and time that applies the indicated rate price | 2020-06-14-00.00.00 |
| endDate   | The end date and time that applies the indicated rate price   | 2020-12-31-23.59.59 |
| price     | The final sale price                                          | 35.5                |

### Curl Command

```
curl -X GET 'http://localhost:8080/api/prices?date=2020-06-14-15.00.00&brandId=1&productId=35455'
```

---

## Requirements

| Id  | Tasks                                                                                                                                     | Status |
|-----|-------------------------------------------------------------------------------------------------------------------------------------------|--------|
| 1   | Build a SpringBoot application/service that provides a rest query endpoint                                                                | Done   |
| 2   | The endpoint must accept as input parameters: Application Date, Product Identifier, String Identifier                                     | Done   |
| 3   | The endpoint must return: product identifier, string identifier, the applicable tax rate, the application dates and the final sales price | Done   |
| 4   | An in-memory database (type h2) must be used                                                                                              | Done   |
| 5   | The database must be initialized with the data from the example                                                                           | Done   |
| 6   | Develop some tests to the rest endpoint that validate the following requests to the service with the example data                         |        |
| 6.1 | Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)                                                         | Done   |
| 6.2 | Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)                                                         | Done   |
| 6.3 | Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)                                                         | Done   |
| 6.4 | Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)                                                         | Done   |
| 6.5 | Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)                                                         | Done   |

