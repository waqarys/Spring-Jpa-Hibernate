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
	- spring-jdbc.jar
- driverClassName
	- com.mysql.jdbc.Driver
- url
	- jdbc:mysql://localhost:3306/fitnessTracker?autoReconnect=true
- username
	- root
- password
	- password
	
JPA
===
- Actually just a specification 
- Thought of as an Object Relational Mapping tool (ORM)
	- An ORM is an implementation of Jpa
- A specification for accessing, persisting, and managing data between Java objects/classes and a relational database
- It is no SQL
	- Uses JPQL instead
- Heavy focus on POJO's

Entity Annotations
==================
- `@Entity` - Declares the object as an Entity
- `@Table` - Describes more specific details about DB, i.e: name, schema
- `@Id` - Identifier attribute for a simple primary key type
- `@GeneratedValue` - Used in conjunction with @Id
	- IDENTITY - Used to specify a database identity column
	- AUTO - Automatically chooses an implementation based off of the underlying database
	- SEQUENCE - Works with a sequence (if the database supports them), see
		`@SequenceGenerator`
	- TABLE - Specifies that a database will use an identity table and column to ensure uniqueness, see `@TableGenerator`
	
Persistence Context
===================
- `@PersistenceContext`
	- Injects the Entity Manager in our code
- `@Service`
	- Spring service where business logic is located
- `@Repository`
	- Spring DAO object, where database interaction occurs
- `@Transactional`
	- Used to start a transaction
	
Join Types
==========
- Essentially four join types:
	- `@OneToOne`
	- `@OneToMany`
	- `@ManyToOne`
	- `@ManyToMany`
- Can be used in various configurations:
	- Unidirectional
	- Bidirectional
	- Cascade 
	
@OneToMany
==========
```
@OneToMany(mappedBy="goal", cascade=CascadeType.ALL)
private List<Exercise> exercises = new ArrayList<Exercise>();
```