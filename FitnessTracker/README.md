spring_mvc_base
===============

Base project used for my Pluralsight Spring JPA and Spring Security courses among others.

http://pluralsight.com/training/Courses/TableOfContents/maven-fundamentals

http://pluralsight.com/training/Courses/TableOfContents/springmvc-intro


persistence.xml
===============
- Need a persistence xml under the following directory
`src/main/resources/META-INF/persistence.xml`

jpaContext.xml
==============
- Used in place of persistence.xml
- Loaded from Classpath
	`src/main/resources/jpaContext.xml`
- Contains:
	-  EntityManagerFatory
		- Jpa Vendor
		- Jpa Properties
	- Transaction Manager
	- Annotation configuration
	- Datasource configuration or lookup
	
Entity Manager Factory
======================
- `LocalContainerEntityManagerFactoryBean` 
	- Located in spring-orm.jar
	- References our persistence unit
	- Injecte Datasource if one isn't defined in the persistence unit
	- Defines what Vendor (provider) we are using
	- Vendor specific JPA properties
	
Transaction Manager
===================
- JpaTransactionManager
	- Takes the entityManagerFactory as a ref
- Annotation driven
- spring-tx.jar

Datasoure
=========
- DriverManagerDataSource
	-	spring-jdbc.jar
- driverClassName
	- com.mysql.jdbc.Driver
- url
	- jdbc:mysql://localhost:3306/fitnessTracker?autoReconnect=true
- username
	- root
- password
	- password