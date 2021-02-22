### Protobuf Serialization

Put Data 

```shell script
http post http://localhost:8080/lookiero/PARIS/brigitte
http post http://localhost:8080/lookiero/PARIS/carole
http post http://localhost:8080/lookiero/BILBAO/oihane
http post http://localhost:8080/lookiero/PARIS/lucie
http post http://localhost:8080/lookiero/BILBAO/miren
```

Get Data
```shell script
http get http://localhost:8080/lookiero/{id}
```
Example Query
 
```text
FROM lookiero.ProtoPersonalShopper 

FROM lookiero.ProtoPersonalShopper WHERE city='BILBAO'

SELECT p.name FROM lookiero.ProtoPersonalShopper p where p.city='PARIS'

SELECT COUNT(p.city) FROM lookiero.ProtoPersonalShopper p WHERE p.city='BILBAO'
```

