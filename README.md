# Prices API

## Retrieve a price

```
GET /api/prices
```

**Query Params**

| Name      | Type   | Description                        | Example               |
|-----------|--------|------------------------------------|-----------------------|
| date      | String | date and time the price is applied | '2020-06-14-10.00.00' |
| productId | long   | product identifier                 | 35455                 |
| brandId   | int    | brand identifier                   | 1                     |

**Response**

```
{
  "productId": 35455,
  "brandId": 1,
  "priceList": 1,
  "startDate": "2020-06-14-00.00.00",
  "endDate": "2020-12-31-23.59.59",
  "price": 35.5
}
```

| Name      | Description                                                   |
|-----------|---------------------------------------------------------------|
| productId | The product identifier                                        |
| brandId   | The brand identifier                                          |
| priceList | The identifier of the applicable price rate                   |
| startDate | The start date and time that applies the indicated rate price |
| endDate   | The end date and time that applies the indicated rate price   |
| price     | The final sale price                                          |




### Curl Command

```
curl -X GET 'http://localhost:8080/api/prices?date=2020-06-14-15.00.00&brandId=1&productId=35455'
```
