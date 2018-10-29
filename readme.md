http://localhost:8080/greeting

```json
{
  "content": "Hello, World!",
  "_links": {
    "self": {
      "href": "http://localhost:8080/greeting?name=World"
    }
  }
}
```

## Hal Browser

Adding the compile("org.springframework.data:spring-data-rest-hal-browser") dependency allows us to use the HAL Browser.

http://localhost:8080/browser/index.html#http://localhost:8080/greeting?name=World
