# REST API Automation Testing with Rest Assured

## SetUp of Rest Assured jars in Eclipse Project :
               1. Setting up Java, Eclipse,TestNG.
               2. Creating a Maven Project in Eclipse.
               3. Create a pom.xml file add rest assured and other dependency .
##   Example: 
```
<dependency>
    <groupId>com.jayway.restassured</groupId>
    <artifactId>rest-assured</artifactId>
    <version>3.1.0</version>
    <scope>test</scope>
</dependency>

```
### Usage :
We are using REST Assured to write @Test annotation to automate the following.
## Example :

```
@Test
public void className(){  
 	given().
 	   contentType("application/json").
                 expect().
                 statusCode(200).
                 when().
                 get("https://maps.googleapis.com/maps/api/place/nearbysearch/json");
}
```

## Project Details :
### 1. Package :   com.automation.commonfunctionalites
  In this package we have multiple classes :

### ApiBase data class :

1. Reading data from properties file
2. Retrieving the data in key-value pairs from json object response.

## 2. ListnerTest Class :
          Implementation of Log4Jj.

### 3. Payload class :
         Here we are converting json response to String format.

### 4. Resource File Class:
         Here we storing API unique url .

### 5.  Reusable Methods Class:
Here we declaring all the reusable method which is going use in the project.

1. Creation of random name
2. Creation of random number
3. Reading the file.

### 6.Soft Assertions Class:
      For creation of customised reports.

### 7. Credentialvalue.properties :
      For storing of User specific credentials.

### 8. Enviorments.properties:
     Storing base url for project.

## 2. Package :   com.automation.restassured
     In this package we store all  the test classes for execution .

## 3. TestNg xml :
     In testng.xml is for batch execution for all test cases.

## 4. POM xml :
     Here we are adding all the maven project specific dependency.

## 5. TestOutPut Folder :
      Here we can get auto generated reports, once the test execution is completed.
      
## Maven Switching Profile for regression and smoke test case        
       in terminal command :  mvn test -PRegression
                           :  mvn test -PSmoke
## 6. Jenkin Set Up 
        1.Download Generic java package (.war) file
        2.in terminal move to file path
        3.java -jar jenkins.war -httpPort-8080
        4.Open local:8080
        5.set jdk path
        6.set maven path
                                   











 
