# LoveholidaysChallenge

A small api used to look up the street for a given postal code

## Installation and Running instructions in command promt

* Clone repository
* Run gradlew build in project direcotry
* Run java -jar build/libs/api-address-0.1.0.jar
* Naviagte to http://localhost:8080/address/{postalCode} e.g. http://localhost:8080/address/W60LG

## Running instructions in Eclipse IDE

* Clone repository
* Import existing Gradle project
* Run gradle tasks build
* Run Main class
* Naviagte to http://localhost:8080/address/{postalCode} e.g. http://localhost:8080/address/W60LG

## Using CraftClick Api

* Api request example: http://pcls1.craftyclicks.co.uk/json/basicaddress?key=c09aa-0a082-a39bf-01f03&postcode=W60LG&response=data_formatted
* Api response:
  {"thoroughfares":[{"line_1":"HAMMERSMITH GROVE","line_2":""}],"thoroughfare_count":1,"postal_county":"GREATER   LONDON","traditional_county":"MIDDLESEX","town":"LONDON","postcode":"W6 0LG"}
  
* ![Alt text](/PostMan_Example_Of_CraftClick.JPG)
