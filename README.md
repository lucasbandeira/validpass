# Validpass

This project uses 
- Quarkus
- Java 15
- Maven 

This project aims to validate a password input.
The output it's a boolean that validates the password with the following rules:

Nine or more characters
- At least 1 digit
- At least 1 lowercase letter
- At least 1 capital letter
- At least 1 special character (!@#$%^&*()-+)
- Do not have duplicates characters

Ex:
```
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  http://localhost:8080/validpass/

### POST /validpass
Example

Request Body *required*
Value | Schema:
```
{
    "password":"Lbs1235890*"
}
```
Response | Value
```
true
```


> **_END-POINTS_** http://localhost:8080/q/swagger-ui/

Images:

Swagger-UI: https://drive.google.com/file/d/1FX8D--c6l2nQ2x1X72SRXTSc5O9XRCMN/view?usp=sharing

Postman: https://drive.google.com/file/d/17Tyeo2XdQbL-UND4KYSBbb9vRjNB4MAX/view?usp=sharing


