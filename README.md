# Java

Banuprakash C

Full Stack Architect, Corporate Trainer

Co-founder & CTO: Lucida Technologies Pvt Ltd., 

Email: banuprakashc@yahoo.co.in; banuprakash.cr@gmail.com; banu@lucidatechnologies.com

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/Java

===================================

Softwares Required:
1)  openJDK 17
https://jdk.java.net/java-se-ri/17

2) IntelliJ Ultimate edition 
https://www.jetbrains.com/idea/download/?section=mac


3) MySQL on Docker

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

```

OOP : Object Oriented Paradigm

Writing programs which resemble real world.

Thinking in OOP.

Object first approach.
OBject is one which has state and behaviour.
State of the object is changed/mutate only by actions/messages/behaviour

Programming: template for Object 
function as template : JS
class as template: C++/ C# / Java
Type as template: Oracle

```
function Tv() {

}

class Tv {

}

Type Tv

End Tv
```

What messages an object can take is exposed thro its interface.
Remote for Tv
Switch and regulator for Fan
Remote for AC

================

SOLID Design Principle
S ==> Single Responsibility
O ==> Open Close Principle [ Component / Object is closed for change and open for extension]
L ==> Liskov Substitution Principle
Generalization and Specialization; A Specialized one can replace the generalized one to get the action of generalized one
I ==> Interface seggregation ==> Abstraction
Tv: 
HDMI interface to be used by objects like Settopbox, Laptop, Camera
Remote interface to be used by human object

BankingService Object:
Admin interface: can create account, see all transactions, block account
Customer interface: can view balance of account, transaction on his/her account, benificiary...

D ==> Dependency Injection
Inversion Of Control

==========================================

What is Java?
Java --> Technology

(Java Platform + API )--> where bytecodes are executed

Bytecodes are platform independent/ architecture neutral instructions
Example:
can run on my Macbook, windows, mobile, security camera, swipe machines,...

How to generate bytecode?
Generally we use different compilers based on choice of programming langauge
1) Java as programming langauge --> java compiler [javac]
2) Groovy --> groovy compiler
3) Kotlin --> Kotlin compiler

===================================

Account.java
```
    public class Account {
        private double balance; //state, instance variable; prefer making state as private

        // actions / messages/ methods/ behaviour ---> public
        public void deposit(double amt) {
            this.balance += amt;
        }

        public double getBalance() {
            return this.balance;
        }
    }
```

javac Account.java ---> Account.class [bytecode]
Account.class --> is portable [platform independent/ architecture]

AccountExample.java
```
    public class AccountExample {
        public static void main(String[] args) {
            Account rahulAcc = new Account(); 
            Account swethaAcc = new Account();
            rahulAcc.deposit(4500);
            swethaAcc.deposit(3600);

            System.out.println(rahulAcc.getBalance());
        }
    }
```

javac AccountExample.java ---> AccountExample.class [ bytecode ]

=====

Java Runtime Environment [JRE] --> on the target machine

java AccountExample <<return>>

1) Classloader: loads bytecode [.class files] from secondary storage [HDD] or Network [example settop box] to primary storage [RAM]
a) findLoadedClass()
b) loadClass() searchs for .class file in current folder and CLASSPATH 
set CLASSPATH=/users/project;/users/banu/mycode;.;
c) findSystemClass() --> built-in API
d) defineClass(): here .class is converted into platform specific datastructure; output of this is not portable


2) JVM: Java Virtual Machine
Metaspace
Stack
HeapArea

"new" is for DMA like malloc/calloc of "C"

https://www.artima.com/insidejvm/ed2/jvm.html

============

Logically grouping of objects/classes
* Entity classes: represent business data; they generally will be associated with persistent store like database / file / redis,..
Uber as example:
Customer.class
Driver.class
Car.class
Payment.class
Trip.class


Amazon:
Product, Customer, Order, Supplier, Payment, ...

* DAO classes: Data Access Object --> classes to perform CRUD operations on persistent store
CREATE READ UPDATE DELETE

* Service classes: Facade over DAO and business logic

* Exception classes : to represent any abnormal condition in application

* Utility classes : helper classes

* UI classes: User interface

============

in java we uses "packages" to logically group classes. packages are nothing but folders

constructors:
*special methods which has the same name as that of class; they are implicilty called when object is create, used to initialize the object. 
* no explicit return type
*Can't explictly call the constructor.
* can be overloaded; can have more than one
* Compiler creates default constructor, if we don't write any.

=================

Requirement:
need to have the count of how many accounts are created?

instance variable --> state of object
static variable --> state of class [ shared by all objects of a class]

local variables --> on stack
instance variables --> on heap
static variables --> on metaspace

============================================

Relationship between objects:
1) Generalization and Specialization --> IS A, achevied in programming using inheritance
2) Realization
3) Association --> "Has A" Relationship
4) Uses A


Checkstyle / PMD / Sonar / Jenkins ,...

CI / CD


Checkstyle <<static code analyzer>>: Naming Conventions and comments...
PMD / FindBug <<static code analyzer>>: Coding standards --> good programming practices

I keep Mobile in my Pocket which as Tata Sky Mobile app <<TV>>




"3G".equals(getConnectivity()) is preffered over. if connectivity is not set --> "3G".equals(null) --> false

getConnectivity().equals("3G"); --> can lead to NullPointerException if connectivity is not set.

===========

Product p = new Product();

Product p = new Mobile(); // valid ---> UpCasting

Product p = new Tv(); // valid ---> Upcasting


Product p = new Mobile(24, "iPhone 15", 89000.00, "5G"); 
// dynamic binding
p.isExpensive(); // call isExpensive() present in Mobile and not the one present in Product class

p.getName(); // valid

p.getConnectivity(); // Error, because Product can't send the message getConnectivity()

Mobile m = (Mobile)p; // downcasting
m.getConnectivity(); // 5G

===

```
Product p = new Mobile(24, "iPhone 15", 89000.00, "5G"); 

p instanceof Product ===> true

p instanceof Mobile ===> true

p instanceof Object ===> true

p instanceof Tv ===> false

p.getClass() == Mobile.class ===> true
p.getClass() == Product.class ===> false

```

abstract class
1) such a object doesn't exist in real world, just meant for generalization
like Account, Product
2) we can't instantiate abstract class

abstract methods: pure virtual functions [C++]
1) method without body; no implementation
2) when a base class has abstract methods, all inherited classes should compulsorily provide definitions of the abstract method; else that class also should be marked as abstract

Note:
1) abstract class need not have abstract methods.
2) if one of the method is abstract then class has to be declared as abstract

=============================

Realization relationship: based on contract

A component will realize the behavior specfied by other in order to communicate.

Realization relationship in OOP is acheived using interfaces

```
// contract
interface CustomerDao {
    void addCustomer(Customer c); // abstract methods
    Customer getCustomer(int id); // abstract method
}

all methods in interface are public and abstract by default
interfaces are like complete abstract class

// realization of contract <<implements>>

public class CustomerDaoMySQLImpl implements CustomerDao {
    // other state and behaviour

    public void addCustomer(Customer c) {
        // insert into ... SQL
    }

    public Customer getCustomer(int id) {
        ... SELECT from custoemrs ...
    }
}

// realization of contract <<implements>>
public class CustomerDaoFileImpl implements CustomerDao {
    // other state and behaviour

    public void addCustomer(Customer c) {
        // save to file
    }

    public Customer getCustomer(int id) {
        ... get from file ...
    }
}
```


Why Program to interface / contract?
1) DESIGN
based on user stories we create interface
register, login, home page should get all products, add to cart
2) IMPLEMENTATION
3) TESTING
4) INTEGRATION
5) LOOSE COUPLING

Entity --> interface --> implementation

entities and interfaces are shared to developers who implement them and call them.

Issues with below code:
  MobileDao mobileDao = new MobileDaoFileImpl();
     OR
  MobileDao mobileDao = new MobileDaoMySqlImpl();

  1) changes are done in client code, there could be many types of clients like standalone, web, mobile, Tv,....
  2) No abstraction. Why should client know about type of persistence

Solution:
Use factory methods

Using Configuration files for factory
========================

Classloader loads the class if its referenced directly in code

RealizationClient 
    loads String, MobileDao, MobileDaoFactory, Mobile, System


Programatically loading the class:

Class.forName("java.lang.String"); // loads String class into metaspace

Class.forName("java.util.Date");

Class.forName("com.adobe.prj.dao.MobileDaoMySQLImpl"); // loads the class into metaspace

----

Creating objects
1) if we know the class name in advance
String s = new String();

2) if we load class dynamically
Class.forName("com.adobe.prj.dao.MobileDaoMySQLImpl").getConstructor().newInstance();

```
    interface Swimable {
        swim();
    }

    interface Danceable {
        dance();
    }

    interface Fightable {
        fight();
    }

    // all actors are capable to dance
    class Actor implmenents Danceable {
         // state and behaviour
        dance() {
            ...
        }
    }

    // hero is a actor, and capable to dance, swim and fight
    class Hero extends Actor implements Swimable, Fightable {
        // state and behaviour
        fight() {

        }
        swim() {

        }
    }

// hero object is created, referenced by Fight interface
// just like Product p = new Mobile();
Fightable f = new Hero();
f.fight(); // valid
f.swim(); // Not valid; Stunt Master can direct only fight sequence of Hero

Swimable s = (Swimable) f;
s.swim(); // makes hero swim --> Swim Instructor

Danceble d = (Danceable) s;
d.dance(); // Choregrapher is directing dance sequence of Hero

```

* Java doesn't support multiple inheritance
* Object is the root class. every class extends Object
* class can implement multiple interfaces [ realization ]

=========================================================

Generic classes.

```
public class Rectangle {
    int width;
    int breadth;
    ///
}
Rectangle r1 = new Rectangle(3,5);

public class DRectangle {
    double width;
    double breadth;
    ///
}

DRectangle r1 = new DRectangle(3.3,1.5); 
Issue: too many classes, one for each type of data 

Solution: use generics

public class Rectangle<T> {
    T width;
    T breadth;
    ///
}

Rectangle<Integer> r1 = new Rectangle<Integer>(3,5);
Rectangle<Double> r2 = new Rectangle<Double>(1.3,4.5);
Rectangle<String> r3 = new Rectangle<String("A","B");

Note: Generics can't be primitive type
Rectangle<int> r1 = new Rectangle<int>(3,5); // error

Type Wrapper classes are used to convert primitive to Object type.
Integer is a type wrapper for int
Double is a type wrapper class for double.

int x = 100;
Integer iX = x; // boxing or wrapping

int y = iX; // unboxing or  unwrapping

```

Narrowing of the types:
```
public class Rectangle<T extends Number> {
    T width;
    T breadth;
    ///
}


Rectangle<Integer> r1 = new Rectangle<Integer>(3,5); //valid
Rectangle<Double> r2 = new Rectangle<Double>(1.3,4.5); // valid
Rectangle<String> r3 = new Rectangle<String("A","B"); // error
```

Generic method:

```
    public interface Computation<T> {
        T compute(T v1, T v2);
    }

    public class IntegerComputation implements Computation<Integer> {
        public Integer compute(Integer v1, Integer v2) {
            ...
        }
    }

     public class DoubleComputation implements Computation<Double> {
        public Double compute(Double v1, Double v2) {
            ...
        }
    }

```
interface, data containers, exception handling

Tasks for the Day:
1) Different types of Comments in Java
2) Naming conventions for Java: field, class, constants, methods

==========================================================================

Day 1 Recap:
OOP, JRE, Classloader, JVM, Stack, Metaspace, HeapArea
local variables --> stack
instance variables --> heap
static variables --> Metaspace where class definition is stored

new keyword is used to DMA --> instantiate objects and arrays
in heap area memory is allocated not only for state, it also contains header part --> hashcode, lock, classInfo,..

classInfo can be obtained using getClass() method of Object class.

Generalization and Specialization relationship --> Inheritance <<extends>>

super() to chain base class constructor, Overriding --> base class class already contains the method, we are not happy with the definition --> we override

Overloading is different from overriding
```
class Base {
    public int add(int x, int y) {
        return x + y;
    }
    // overloading
     public int add(int x) {
        return x + x;
    }
}

class Derived extends Base {
    // overloading
     public int add(int x, int y, int z) {
        return x + y + z;
    }
    // override
     public int add(int x, int y) {
        // code
        return x + y;
    }
}
```
abstract class and abstract methods, Reflection API {get methods of an object and invoke, create object without knowing class name}
Realization relationship --> interface <<implements>>

==============================

Day 2:

interface
* Anonymous class --> class created by JRE for abstract classes and interfaces

```
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    String name;
    int age;
    // methods

    public void fly() {
        // logic
    }
}

class AeroPlane implements Flyable {
    String engine;
    String name;
    int capacity;
    // state and behaviour

    public void fly() {
        // logic
    }
}

class SomeClass1 implements Flyable {
    public void fly() {
        System.out.println("Jump from 12th floor with wings");
    }
}

class SomeClass2 implements Flyable {
    public void fly() {
        System.out.println("Jump from 24th floor with wings");
    }
}

```

Problem: too many classes in source code as well as in JVM: can lead to OutOfMemoryError <<too many classes loaded by classloader in Metaspace of JVM>>

Solution: Using Anonymous class or Lambda expression

```
    Flyable f1 = new Flyable(); // error, can't instantiate interface << also for abstract class>>

    Flyable f1 = new Flyable() {
        public void fly() {
            System.out.println("Jump from 24th floor with wings");
        };
    };
    // within JVM an anonymous class is created and object is created for anonymous class
    // once object is created, anonymous class is destroyed

    f1.fly(); // works fine

```

Functional Interface: interface with only one method to be implemented
Lambda expression can be used for FunctionalInterface.

Prefer Lambda if interface has only one method instead of Anonymous class from Java 8 version onwards.

=============

Built-in interface Comparable. 
Objects implementing this interface we can sort objects, find max, find min,...

==============================

Java Collection Frameworks --> provides data structures / containers
* interface
* implementation
* Algorithm classes

JCF can be used instead of arrays
Array has to be the first choice for data container.
Issues with array:
1) Size is fixed
2) can't grow nor shrink
3) adding / removing from arbitrary position is difficult --> O(n)
4) Contiguous memory

Comparable vs Comparator

Comparable is used to compare objects based on natural logic and logic is a part of object itself.

String --> has compareTo() based on which we compare strings --> Lexical
Product --> has compareTo() based on which we compared products ==> price

Comparator is used to compare objects based on clients requirements and logic is part of client.


Arrays: built in algorthim class can be used to find max, min, sort, ... operations on array type of a container based on Comparable or Comparator interface --> Similar to Util.java what we wrote.

List vs Set
List:
1) ordered collection
2) can contain duplicate elements
3) supports index based operation --> add(5, "a"), get(6);, remove(10); ...
4) can be re-ordered --> sort, shuffle, reverse, ...

Set:
1) unique collection
2) not suppors re-ordering or index based operations

List is preffered over array to overcome the limitations of array

Vector and Stack are legacy implemnetations of List interface, not supposed to be used because operations are very slow.
Reason: every operation needs a thread to acquire a lock

for List preffered implmentation classes are 
1) ArrayList --> Java
2) LinkedList --> Java
3) Apache Collections
4) VAVR collection

ArrayList (95% usage) vs LinkedList
ArrayList is like Array but can grow or shrink
LinkedList is doubly linked list

-----------

Different ways of using List data container
1) ArrayList list = new ArrayList(); 
// avoid --> heterogenous container --> Not type safe
list.add("A");
list.add(34);
list.add(new Date());

to access we need to do type checking

if(list.get(i) instanceof Date) {
    Date d = (Date) list.get(i);
}

// always program to interface

2) List<String> list = new ArrayList<>();  // use genrerics for type safety
list.add("Anna"); // works
list.add(new Date()); // compilation error
// typesafe

String s = list.get(0);

===

Stream --> introduced in Java 8 version
A stream represents a sequence of elements and supports different operations (Filter, Sort, Map, and Collect) from a collection or file or network or database stream source.

HOF --> High Order Functions (filter, map, reduce, collect, limit, skip, forEach, ...)
* HOF is one which can take function as argument
* HOF is also a function which can return a function

filter --> to get sub-set
map --> to transform the data
reduce --> to get aggregate like [sum, count, avg, total]
collect --> to collect the output of stream in other container
forEach --> traverse thro output of stream operation

```
filter(predicateFn) {
    container;
    for every elem in source
        if(predicateFn(elem))
            add to container
    end for

    return container
}
```

We can have many HOF chained for a stream, but the last operation has to be a terminal operation [collect, forEach, reduce]


https://rxmarbles.com/

=======================================

Set 
 |
 HashSet
 |
 TreeSet

HashSet data container is a implementation of Set interface, for unique collection.
HashSet uses hashCode() and equals() to identify duplicate elements and also for ordering elements.

What is HashCode?
* Numerical value of object generally based on state of object
* if 2 objects are similar then their hashcodes has to be same
* possibility is 2 dissimilar objects can also have same hashcode.

Hashcode of every object is stored in header part [heap area] 

public class Object {
    int hashCode(); // gives address of object; not good; we need to override
}
// Bad hashCode example
```
public class Rectangle {
    w, b;

    @Override
    public int hashCode() {
        return w * b;
    }
}
lots of collision
Rectangle r1 = new Rectangle(4,5); // hashcode --> 20
Rectangle r2 = new Rectangle(5,4); // hashcode --> 20
Rectangle r3 = new Rectangle(10,2); // hashcode --> 20
Rectangle r4 = new Rectangle(20,1); // hashcode --> 20
Rectangle r5 = new Rectangle(1,20); // hashcode --> 20
```

Hashbased data containers uses HashCode
HashSet, Hashtable, HashMap uses it


Map is a data container which stores data in the form of Key/value pair
Examples: Dictionary, registry
key has to be unique, can have duplicate values

=====================================

Annotation [@] --> Metadata: data about data
@Override

Who uses the Annotations?
* Compiler
* Classloader
* Runtime

Where can i use annotation?
* TYPE --> class , interface , annotation
* Method --> example is @Override
* Field 
* Parameters
* Constructor

Example of who uses it?

1) @Override is used by Compiler, checks the base class if signature matches,
if match compile the class, else compiler throws error.
Compiled code won't have the metadata [ .class file doesn;t contain]
```
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(name, product.name);
    }

```

2) we can write annotations for Classloaders also, but we need to write our own classloader to process it.

Custom annotations: --> Re-create ORM Object relational mapping 
ORM --> we do the mapping of Object to RDBMS table.
DDL and DML SQLs are generated based on mapping.

Annotations can't have fields and methods, only properties can be there

Never use String Contactination

String s = "Hello";
s += " World";
s += " 123";
s += "!";
String is immutable.
StringBuilder and StringBuffer are muttable

==========================================

Introduction to Exception:
Any abnormal condition during program execution is an exception.
Exception is an object which gives info:
1) What went wrong
2) Where did it go wrong
3) Why did it go wrong

exceptions broadly classified into "Error" and "Exception"
Error: can't have any solution during program exection
StackOverflowError, OutOfMemoryError, JvmError, ...

Exception: we can have alternate solution

Exception type of exceptions can be classified into "Checked type" and "unchecked type"

* Unchecked type of exceptions
1) These exceptions are a result of something going wrong with JVM
2) Compiler will not enforce you to handle it.
FirstExample.java
3) it is suggested that we handle it using conditional statements
```
int index = 5;
 int[] elems = {4,21};
 if(index >= 0 and index < elems.length) {
        System.out.println(elems[index]);
 }

 Product p;
 p.getName(); // throws NullPointerException

 Handle
 if(p != null) {
    p.getName();
 }
```

* Checked type
1) these exceptions are a result of abnormal conditions outside of JVM like OS / Network/ Database
2) Compiler enforces you to handle them using try/catch syntax


Install Docker and MySQL on Docker

=====


Docker is a set of platform as a service products that use OS-level virtualization to deliver software.

Image --> software

Container --> running application

docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

mysql --> image
install on docker platform and run it as "local-mysql" container
username is root and password as Welcome123

% docker exec -it local-mysql bash
```
# mysql -u root -p
Enter  Password: Welcome123
```

mysql> create database TRG;
Query OK, 1 row affected (0.01 sec)

mysql> use TRG;
mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double);


mysql> insert into products values (0, 'iPhone 15', 89000.00);

mysql> insert into products values (0, 'Samsung OLED', 249000.00);

mysql> select * from products;
```
+----+--------------+--------+
| id | name         | price  |
+----+--------------+--------+
|  1 | iPhone 15    |  89000 |
|  2 | Samsung OLED | 249000 |
+----+--------------+--------+
2 rows in set (0.01 sec)
```

Java build tools:
1) Maven / Gradle --> build automation tool
* Compile
* package
* deploy
* manage dependencies [most important part]

2) Sonar /Checkstyle and PMD: --> Static code analysis
3) Jenkins --> CI / CD

3rd party libraries are available in different "repositories" in the form of "jar" files, we need those libraries for building application
Example:
* spring
* hibernate
* jackson
* servlet-api
....

Database application ==> convert it into web application.

JDBC: Java Database Connectivity --> Integration libarary to connect Java to database

Java provides interfaces, implementation classes are provided by database vendors [like Oracle, SQLServer, MySQL]

String --> VARCHAR for MYSQL, VARCHAR2 for Oracle, Text for SQLServer

Steps:

1) Establish a database connection

Connection con = DriverManager.getConnection(URL , USERNAME, PASSWORD);
URL examples:
jdbc:oracle:thin:@178.44.11.20:1521/TRG for Oracle
jdbc:mysql://178.44.11.20:3306/TRG for MySQL

Connection is a interface
getConnection() is a factory method, based on URL it creates OracleConnection / SQLServerConnection / MySQLConnection


2) Send SQL statements 
2.1) Statement
    if SQL is same for every request
    select * from products
2.2) PreparedStatement
    if SQL depends on IN parameter

    select * from users where username = ? and password = ?
    select * from products where id = ?

2.3) CallableStatement
    to invoke stored procedures of database

In database we have:
```
CREATE PROCEDURE SelectAllCustomers @City nvarchar(30)
AS
SELECT * FROM Customers WHERE City = @City
GO;
```

from Java: {call SelectAllCustomers('Delhi')}

Advantage: we can hide table and column names from application, more secure
we can have multiple SQLs executed

Methods:
1) int executeUpdate(SQL)
use this for INSERT, DELETE, UPDATE SQL
returned int specifies how many records are affected
2) ResultSet executeQuery(SQL)
use this for SELECT statement


3) ResultSetMetaData can be used to get column count, type of column, any metadata

4) Always close connection in finally block.
finally block is a compulsory execute code. get called if no exception or exception

```
try {
    // code
} catch(SQLException ex) {
    ...
} finally {
    con.close(); // guaranteed execution
}
```

Day 2 Recap:
* Data Containers / DataStructure
* Comparable vs Comparator
* Arrays and Collections --> Algorithms like sort, max, min, binarySearch... work based on contract
* List vs Set
* Map and HashMap [key / value ] pairs
* Exception handling
* Docker, docker container, create database and table. insert records.
* Maven

Day 3:

groupId --> qualified project like com.adobe.aem
artifactId --> module like "customer"
version --> different version

```

public class ProductDaoMongoDbImpl implements  ProductDao{
    @Override
    public void addProduct(Product p) throws  PersistenceException{
        try {
       // code
        } catch(MongoException ex) {
            throw new PersisentenceException("Unable to add Product", ex);
        }
    }

``
Client:

try {
    ProductDao productDao = new ProductDaoJdbcImpl(); 
    Product p = new Product(...);
    productDao.addProduct(p);
} catch(PersistenceException ex) {
    // print the message
}

Problems:
1) Exception messages are complicated for end users like
ORA9001 unique key constraint voilation exception ...
2) Not abstracted. Why should the client know that we are using RDBMS in the backend
3) Tightly coupled


===========

Web application development

Web server
A web server is software that delivers web content to clients, such as web browsers, using the HTTP protocol. It's primarily responsible for delivering static content like HTML, images, and videos. 
Servlet engine
Also known as a servlet container or web container, a servlet engine is a Java technology that runs on a web server or application server to deliver dynamic content.

Servlet's are special type of objects which execute within Servlet engine to server dynamic content


request: encapsulates all the data from client [form data , browser, os]

response: is used to write data back to client

Servlet engines : tomcat / jetty / netty ,...

jetty: minature web server with servlet container

Servlet engines needs packages to be done as "war"
jar --> java Archive
war --> Web archive
ear --> Enterprise archive

WAR different from jar in the way folders are created / organized

```
    myapplication
        WEB-INF
            classes
                pkg.LoginServlet.class
                pkg.RegisterServlet.class
                pkg.ProductServlet.class
            web.xml
```

web.xml ---> deployment descriptor --> information to the servlet engine
```
Using below entries Servlet engine instantiates servlets
<servlet>
    <servlet-name>First</servlet-name>
    <servlet-class>pkg.LoginServlet</servlet-class>
</servlet>

Mapping
<servlet-mapping>
    <servlet-name>First</servlet-name>
    <url-pattern>/login</ulr-pattern>
</servlet-mapping>
```

every servlet extends HttpServlet or implements Servlet interface <<rare>>
HTTP Methods: GET , POST , PUT , DELETE ,PATCH, TRACE, OPTIONS

```
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) {
        ...
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) {
        ...
    }
}
```

Instead of web.xml we can use Annotation as deployment descriptor
```
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
}
```

webapp folder --> for static resources like html / js / jsp ...


war --> given to devops person --> deploy it on actual web server....

Run maven goal
mvn jetty:run

===============

POST method, Session and Filter 

mvn package ==> creates a "war" file which can be deployed on any web server instead of running it on embedded server

========
SOLID : 
S --> Single Responsibility

Preffered Architectural pattern --> MVC: Model View Controller

Model : business data and logic
View: Presentation logic --> Templates [JSP, Thymeleaf,...]
Controller: Application logic --> Flow of your application

Issue with our existing code:
Servlet is working both as View and controller.


JSP is a combination of static + dynamic content --> prefer this for presentation

======================

Spring Framework and ORM Framework


Spring Framework: Light weight framework which helps in life cycle management of beans and dependency injection while building enterprise application.

Bean: --> any object managed by spring framework

```
public interface EmployeeDao {
    void addEmployee(Employee e);
}

public class EmployeeDaoJdbcImpl implements EmployeeDao {
    public void addEmployee(Employee e) {
        "INSERT INTO ..."
    }
}

public class EmployeeDaoMongoImpl implements EmployeeDao {
    public void addEmployee(Employee e) {
       db.employess.add(e);...
    }
}

public class AppService {
    private EmployeeDao empDao;
    public void setEmpDao(EmployeeDao dao) {
        this.empDAo = dao;
    }

    public void insert(Employee e) {
        empDao.addEmployee(e);
    }
}

XML as Metadata: beans.xml
<beans>
    <bean id="jdbc" class="pkg.EmployeeDaoJdbcImpl" />
    <bean id="mongo" class="pkg.EmployeeDaoMongoImpl" />
    <bean id="appService" class="pkg.AppService">
        <property name="empDao" ref="jdbc" />
    </bean>
</beans>

setEmpDao(jdbc);

ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

ctx.getBean("appService", AppService.class);

```

Annotation as metadata:
Spring Container instantiates classes which has one of these annotations at class level:
1) @Component
2) @Repository
3) @Service
4) @Configuration
5) @Controller
6) @RestController
7) @ControllerAdvice

```
```
public interface EmployeeDao {
    void addEmployee(Employee e);
}

@Repository
public class EmployeeDaoJdbcImpl implements EmployeeDao {
    public void addEmployee(Employee e) {
        "INSERT INTO ..."
    }
}

@Service
public class AppService {
    @Autowired
    private EmployeeDao empDao;
  
    public void insert(Employee e) {
        empDao.addEmployee(e);
    }
}

```

Spring Boot: Framework on top of Spring Framework
* Highly opiniated framework
--> if we want to build web application, tomcat is configured out of box
--> if we are connecting to database. Pool of database connections is created for you.
We should not use DriverMananger.getConnection(), prefer DB connection
* removes a lot of boilerplate code

Spring Boot 2.x is built on top of Spring Framework 5.x
Spring Boot 3.x is built on top of Spring Framework 6.x



SpringApplication.run() is similar to ApplicationContext ctx = new AnnotationConfigApplicationContext();

@SpringBootApplication is 3 in one
1) @ComponentScan
it scans for classes with above "7" annotations in com.adobe.springdemo; and sub-packages and creates objects
2) @EnableAutoConfiguration : create embedded tomcat server, database connection pool==> based on type application
3) @Configuration

Field employeeDao in com.adobe.springdemo.service.AppService required a single bean, but 2 were found:
	- employeeDaoJdbcImpl:
	- employeeDaoMongoImpl:


profile resolving:
command line arguments --> environment variable --> application.properties

==============

How does Spring manage objects of 3rd party classes, because we can't add any of above "7" annotations
Solution: Factory method --> @Bean

DataSource is a pool of database connection

==========================================

Day 3 Recap:

Database and Web application:
Part 1:
```
JDBC: Integration library to connect to database
DriverManager.getConnection() factory method gets connection based on URL
JDBC classes are provided by database vendors --> used Maven to manage dependency
Servlets run within Servlet engine [Tomcat / Jetty / Netty ...]
HttpServletRequest and HttpServletResponse objects are created by the servlet engine for every request from client, they are injected to Servlet's method based on type of Method request: GET / POST / PUT / DELETE / PATCH / ...
doXXX() like doGet() and doPost() ..
HttpServletRequest encapsulates data from client [ form data, browser data , OS data]
HttpServletResponse is used to write response back to client.
MVC Architectural pattern where : HTML + JSP are used for View, Servlet is for Controller. Model : business data and logic
```

Part 2:
```
Spring Framework: Container for life cycle management of beans and wiring dependencies --> loose coupling
Metadata: XML or Annotation
@Component, @Repository, @Service, @Controller, @RestController, @Configuration, @ControllerAdvice

@Autowired ---> wiring dependencies
to resolve ambiquity : @Primary, @Qualifier, @Profile, @ConditionalOnMissingBean

Spring Container can be accessed using ApplicationContext interface

```
===========

Day 4:
ORM : Object Relational Mapping:
Objects / class <---> Relational database tables
fields/ instance variables <-----> columns of table

Once Mapping is DONE, ORM are going to generate DDL {create, alter, drop } and DML {insert, delete, update, select} operations

Java Class:
```
@Entity
@Table(name="customers")
public class Customer {
    @Id
    private String email;

    @Column(name="FNAME")
    private String firstName;

    @Column(name="LNAME")
    private String lastName;
}

@Id ---> Primary KEY

table
customers
email (PK) | FNAME | LNAME

```

Spring Data JPA: Spring module simplifies the way we use ORM.
Spring boot is highly opinated, it configures lot of things out of box:
If we we choose to use Spring Data JPA
1) Configures DataSource to use HikariCP 
2) It uses Hibernate as default JPA Vendor
3) It provides JpaRepository interfaces, we don't need to write Implentation classes [ no need for @Repository];
Spring data jpa is going to generate implementation classes

DDL: create , alter, drop operations

1) spring.jpa.hibernate.ddl-auto=update
* map to existing table, if required alter it to add columns, change datatype of column,...
* create table if not exists
--> top to down approach and hybrid

2) spring.jpa.hibernate.ddl-auto=create
* Application start --> create tables
* on application temination --> drop tables
Note: Used only for test environment

3) spring.jpa.hibernate.ddl-auto=validate
* map to existing tables, altering tables and creating new tables not supported
--> Bottom to Top Approach [ DBA has provided you the tables]


JpaRepositories:
```
public interface ProductDao extends JpaRepository<Product, Integer> {
}
public interface CustomerDao extends JpaRepository<Customer, String> {
}

no need for implmentation classes; Spring Data jpa is going to generate classes for ProductDao & CustomerDao
Note: no @Repository classes
```
Spring Boot
CommandLineRunner --> run() method --> gets called as soon as spring container is created and initialized

update products set qty = 100 where 1 = 1;

====================

Mapping Associations:
1) One to One
2) One to many
3) Many to one
4) many to many

----

DDD: Domain Driven Design ==> need to find root aggregate
https://martinfowler.com/bliki/DomainDrivenDesign.html
https://martinfowler.com/tags/domain%20driven%20design.html

```
    With Many to one --> @JoinColumn will come in the owning table <<orders>>
  @ManyToOne
  @JoinColumn(name="customer_fk")
  private Customer customer;
 
 With one to many --> @Joincolumn will introduce the FK in child side <<items>>
    @OneToMany
    @JoinColumn(name = "order_fk")
    private List<LineItem> items = new ArrayList<>();

```

Without cascade: assume 1 order has 4 items;
```
Save:
    save(order);
    save(i1);
    save(i2);
    save(i3);
    save(i4);
Delete:
    delete(order);
    delete(i1);
    delete(i2);
    delete(i3);
    delete(i4);
```

With Cascade:assume 1 order has 4 items;

```
  @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_fk")
    private List<LineItem> items = new ArrayList<>();

Save:
 save(order); --> save order and it's line items also
Delete:
 delete(order); --> delete order and it's line items
```

Fetch operations:
a) by default One to Many association will lazy fetch association

orderDao.findAll(); // select * from orders

here items are not fetched from database

let's take there are 3 orders, we need to do explictly

itemDao.getItemForOrder(1);
itemDao.getItemForOrder(2);
itemDao.getItemForOrder(3);


b) by making assocation as EAGER fetching
```
 @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
 @JoinColumn(name = "order_fk")
 private List<LineItem> items = new ArrayList<>();
```
orderDao.findAll(); // select * from orders and also get items of orders by joining ...

By making CASCADE and FETCH.EAGER --> no need for ItemDao

c) By default ManyToOne is EAGER fetching

 @Transactional ===> method is atomic, everything commits else rollback

Payload from client to place an order looks like:
```
XML:
    <order>
        <customer>
            <email>anna@adobe.com</email>
        </customer>
        <items>
                <item>
                    <product id="5"></product>
                    <qty>2</qty>
                </item>
                 <item>
                    <product id="2"></product>
                    <qty>1</qty>
                </item>
        </items>
    </order>
JSON:
    {
        "customer": {
            "email": "anna@adobe.com"
        },
        "items": [
            {
                "product": {
                    "id": 5
                },
                qty: 2
            },
            {
                "product": {
                    id: 2
                },
                qty: 1
            }
        ]
    }
```
In Order:
total has to be computed
orderdate --> system date
item amount needs to be calculated [ discount, tax]
Each Product added to item --> sending only product id, not it's price, name

DIRTY CHECKING:
Within Transactional boundary if an entity becomes dirty, automatically UPDATE is sent to DB

======
Custom Queries --> JPQL Projection

SQL vs JPQL

========

Task: 

```
new Spring Initilizer /boot project 
a) name: vehiclerental
b) dependencies: mysql, jpa, lombok

Create the following entities

Vehicle: String regNo <<PK>>, fuelType, costPerDay
Client: email, firstName
Rental: 
rental_id <<PK>> | vehilce_fk | client_fk | rent_from_date | rent_to_date

Part 1: 
insert vehicles

Part 2:
insert clients

Part 3:
rent a vehicle
rental_id <<PK>> | vehilce_fk | client_fk           | rent_from_date | rent_to_date
1                   KA12E341    harry@gmail.com       1-SEP-2024        NULL

Part 4:
return a vehicle

rent a vehicle
rental_id <<PK>> | vehilce_fk | client_fk           | rent_from_date | rent_to_date
1                   KA12E341    harry@gmail.com       1-SEP-2024        4-SEP-2024


```

Day 4 Recap:

```
ORM --> JPA --> Spring Data JPA
JpaRepository --> create interface, implementation classes having CRUD operations are created by Spring Data Jpa for the methods
present in JpaRepository.
We can add custom methods in interface.
@Query can be used to write SQL of JP-QL query.

@Entity --> compulsory
@Id --> A must to specify Primary Key
@Column --> Mapping field to a table column [ optional]
@Table --> optional; mapping class to table

Association Mapping:
1) one-to-one
2) one-to-many
3) many-to-one
4) many-to-many

@JoinColumn: to introduce Foreign Key, where FK is introduced is dependent on OneToMany, or ManyToOne
ManyToOne introduces FK in owning table/entiry
OneToMany introduces FK in child table/entity

Cascade, EAGER / LAZY fetch operations
```

Day 5:

Building RESTful WebServices.

Rendering ---> data to presentation

* Server Side Rendering
Cons:
-> We can't have heterogenous clients like Web / Standalone/ Mobile / Tv
-> Heavy payload

Pros:
--> SEO
--> Faster

* Client Side Rendering
Pros:
-> We can have heterogenous clients like Web / Standalone/ Mobile / Tv
-> payload is light; between client and server only representation is passed in various formats like JSON / XML

Cons:
-> Thick clients
-> Not SEO
-> Compromise wrt SPEED


RESTful: REpresentational State Transfer

Resource: anything which can be named and present on server like file, database, printer,..
Representation: State of resource at a given point of time
Content Negotiation: representation served in various formats like JSON / XML/ CSV

REST uses HTTP URI to refer to a resource [ plural nouns]

http://server.com:port/api/products
http://server.com:port/api/customers
http://server.com:port/api/vehicles

HTTP methods : verbs --> CRUD operations

1) POST --> CREATE a new sub resource under a resource
CREATE:
POST http://server.com:port/api/products
payload: new product

2) GET --> READ resources
GET http://server.com:port/api/products
get all products

Use PathParameter/PathVariable to get a resource based on PK field
GET http://server.com:port/api/products/4
get a product whose PK is "4"

Use QueryParameter/RequestParam to get a subset of resources
GET http://server.com:port/api/products?low=500&high=5000
get all products whose price is between 500 and 5000
GET http://server.com:port/api/products?page=1&size=20
paginated data: 20 records from 1 page

GET http://server.com:port/api/customers/banu@gmail.com/orders
get all orders of "banu@gmail.com"

3) PUT/PATCH --> UPDATE
PUT http://server.com:port/api/products/3
payload: new product data to update a product whose id is "3"

4)  DELETE --> DELETE

DELETE http://server.com:port/api/products/5
delete a product identified by "5" as PK

Note: GET and DELETE --> No Payload --> Safe methods --> IDEMPOTENT

===============================

Spring MVC Module: for building RESTful WS and Traditional Web application

```
    @RestController
    @RequestMapping("/products")
    public class ProductController {
        @Autowired
        OrderService service;
        @GetMapping()
        public List<Product> getProducts() {
            return service.getProducts();
        }

        @PostMapping()
        m2(@RequestBody Product p) {
            ...
        }
    }


    @RestController
    @RequestMapping("/orders")
    public class OrderController {
        @Autowired
        OrderService service;

```

ContentNegotiationHandler

HTTP Header:
Accept: application/json
Java <--> data formats [JSON/ XML]

Spring BOOT 
1) for MVC by default adds Jackson library for Java <--> JSON
If we want to Java <---> XML we need to explicitly configure
2) Embedded Tomcat Container
3) DispatcherServlet: intercpets all HTTP requests [URL-pattern is "*"]
=========

Exception Handling in Controller and RestController

@Controller: Not covering --> Traditional web application
@RestController --> for RESTful WS

@ControllerAdvice is used as GlobalException handler

Changes:
1) EntityNotFoundException.java
2) OrderService:  Product getProduct(int id) , Product changePrice(int id, double price),  public String placeOrder(Order order) throws EntityNotFoundException

3) ProductController: Product getProduct(@PathVariable("pid") int id) throws EntityNotFoundException, updateProduct(),,

4) OrderController: String placeOrder()...

5) ProductClient:  void modifyPrice() 

6) OrderClient:
 try {
            service.placeOrder(order);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }

7) GlobalExecptionHandler

===========================================

Validation 
https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/constraints/package-summary

```

 <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull(message = "Name is required")
    private String name;
    
    @Min(value = 10, message = "Price has to be {value}, you entered ${validatedValue}")
    private double price;

    @Min(value = 1, message = "Quantity has to be {value}, you entered ${validatedValue}")
    @Column(name = "qty")
    private int quantity;
}

ProductController:
public @ResponseBody Product addProduct(@RequestBody @Valid Product p) {

```
MethodArgumentNotValidException: 
```
Validation failed with 2 errors: 

[Field error in object 'product' on field 'quantity': default message [Quantity has to be 1, you entered -300]] 

[Field error in object 'product' on field 'price': [Price has to be 10, you entered -287000.0]] ]

```

Task:
1) CustomerController
2) VehicleRentalApp --> Restful WS

Testing and other bits and pieces

```

@WebAppConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes = OrderappApplication.class)
// or without security
//@WebMvcTest(ProductController.class)
public class ProductControllerTest {

```

API Documentation
* RAML https://raml.org/ --> we need to "YML" file
* OpenAPI --> Swagger

  <!-- OpenAPI -->
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.5.0</version>
        </dependency>

Once this is added, Documentation is created for @Controller and @RestController classes. No Need to write any code.

We can do the customization.
http://localhost:8080/swagger-ui/index.html

=================================

Testing
* Unit Testing
* Integration Testing
* E2E Testing [ next week along with React]

Unit testing for Controller only.

What does Spring Boot provide?
* JUnit as Unit testing framework. TestNG is the alternate
* Mockito --> to mock depenencies. To create mock objects
* JSONPath -> to validate JSON data returned from Controller
https://jsonpath.com/
```
$
$.firstName
$.age
$.address.city
$.phoneNumbers[0].type
```

* Hamcrest --> assertion matchers 
https://hamcrest.org/JavaHamcrest/tutorial

====
For testing We don't need the server to be running
@WebMvcTest(ProductController.class) does:
1) creates a minature spring container and gives TestDispatcherServlet to handle REQUESTS
2) loads ProductController onto the container. Now within Spring contianer only ProductController is availabe.
No OrderController, OrderService, DAO code...

  private MockMvc mvc; ==> to perform GET / POST/ PUT/DELETE operations on end point

===============

OneToMany
ManyToOne
Aggregate ==> relationship

mappedBy: 
What if we need bi-directional relationship? // AVOID as much as possibile

```
@Entity
@Table(name="orders")
public class Order {
 
    @ManyToOne
    @JoinColumn(name="customer_fk") // Foreign key column
    private Customer customer;
..
}

@Entity
@Table(name="customers")
public class Customer {
    @Id
    private  String email;

    @Column(name="FNAME", length = 100)
    private String firstName;

    @Column(name="LNAME", length = 100)
    private String lastName;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders = ArrayList<>();
}

```

=========================

One-to-One: Employee <--> Laptop
```
@Entity
@Table(name="employees")
public class Employee {
    @Id
    String email;
    String firstName;
    ...
}

@Entity
@Table(name="laptops")
public class Laptop {
    @Id
    String serailNo;
    String OS;
    String make;
    ...
    @OneToOne
    @JoinColumn("emp_fk")
    Employee employee;
}

employees
email                   | FNAME
raj@adobe.com           Raj

laptops
serial_no     | os      | make              emp_fk
2lw4qb1         ios     MAC chipset         raj@adobe.com

```

======

Many To Many : rare relationship

Student <---> classes

```
@Entity
@Table(name="students")
public class Student {
    @Id
    int sid;
    String firstName;
   
}

@Entity
@Table(name="classes")
public class Class {
    @Id
    int cid;
    String subject;
   
}

students
sid | FNAME
1       A
2       B
3       C

classes
cid    | subject
23      REACT
24      java
25      C++
26      AWS

many-to-many needs a link table
students_classes
sid     | cid
1           23
1           26
2           23
2           24
2           26

```

When a student is going to enroll for a subject?
we need a link class
Student <-----> StudentClass <---> Class
Student to StundentClass [ one to many]
class to StudentClass [ one to many]

```
@Entity
@Table(name="students")
public class Student {
    @Id
    int sid;
    String firstName;
   
}

@Entity
@Table(name="classes")
public class Class {
    @Id
    int cid;
    String subject;
   
}

@Entity
@Table(name="student_classes")
public class StudentClass {
    @Id
    int id

    @ManyToOne
    @JoinColumn("sid)
    Student s;

    @ManyToOne
    @JoinColumn("cid)
    Class c;
}
```

========

Recap:

OOP, SOLID, Reflection API,..
Generalization and Specialization relationship --> Inheritance --> extends --> IS A
override and overload methods

Realition Relationship --> Contract --> implements --> can have multiple contract

Note:
class can extend a class [ single class]
class can implement  multiple interfaces
interface can extend another interface

Anonymous class, FunctionalInterface --> lambda expression
HOF -> filter, map, reduce, forEach, collect, .. --> function which can accept function as argument

JCF: Comparable and Comparator, Arrays and Collections algorithm classes
List, Set and Map

Exception Handling
try, catch, finally, throws

Maven based project, database connectivity using JDBC, Web based application using Servlet API
Servlet engine --> Tomcat / Jetty / Netty / ...
Servlet and JSP --> MVC architecture

===========

Spring Container: life cycle management of bean, dependency Injection
@Component --> simple utility class
@Repository --> CRUD operations
Note we did'nt write @Repository classes because Spring Data JPA for JpaRepository we create will create @Repository
@Query
@Service --> a facade over @Repository and business logic
@RestController
@Configuration --> @Bean factory method

Other annotations:
@Autowired, @RequestBody, @RequestParam, @PathVariable, @ControllerAdvice, @ExceptionHandler
jakarata.valiadation.constraints like @NotBlank, @Min, @Max, @Past, @Future, ... 
@Valid

==============

ORM and Hibernate with JPA specification
@Entity, @Table, @Id, @GeneratedValue, @Column
@ManyToOne, @OneToMany, @JoinColumn
@OneToOne, @ManyToMany, @JoinTable

===========================================================

Day 6: Spring Security
APIs for Authentication and Authorization

Filter's are like Servlets but not used for application logic but for Interceptor logic
Examples of Filters like logfilter, encoding, encrypt, security --> not a part of main logic, but can be used for main logic

UsernamePasswordAuthenticationFilter

attemptAuthenctication(autherntication:Authentication)

Authentication:
username/principle
credentials/password
isAuthenticated
..

```
<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
</dependency>

```

1) Adding this makes all the resources as protected.
2) Creates a username with "user" and password is generated
Using generated security password: cdafa760-835a-48e4-a8f4-b006e22d6013
3) creates a login and logout pages
http://localhost:8080/logout


SecurityContext is associated with JSESSIONID, it is destroyed when we logout or inactive interval [ 30 min inactive interval]

Session Hijacking: any other uses gets an an access to JSESSIONID --> he can gain access to your account.

How to protect it? HTTPS protocol

===================================

JDBCAcuthentication using Spring Security --> Security Database Schema
https://docs.spring.io/spring-security/reference/servlet/appendix/database-schema.html

spring.sql.init.mode=always

it exustes resources/schema.sql and resources/data.sql are executed
schema.sql ===> DDL
data.sql ==> DML

https://bcrypt-generator.com/

=========================================

Issues with Stateful SecurityContext with JESSIONID
1) Not all clients understands cookies / JESSIONID --> Can't have heterogenous applications like Tv / Mobile / Desktop
2) cookies are best handled only by browsers
3) Scallabity is an issue --> Need to implement Session Stickiness

Solution: using Tokens
https://jwt.io/
JWT: JSON Web Token is used for Authorization in a Stateless implementation of RESTful / GraphQL WS

```
<<eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.
SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c>>

PART 1:
HEADER:ALGORITHM & TOKEN TYPE eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
{
  "alg": "HS256",
  "typ": "JWT"
}
PART 2: PAYLOAD:DATA eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ
contains claims

{
  "sub": "banu@gmail.com",
  "iat": 1516239022,
  "exp": 2314223445,
  "iss": "https://secure.adobe.com",
  "authorites": "ADMIN, USER",
  "roles": "READ, WRITE, MODIFY"
}

PART 3: VERIFY SIGNATURE
HMACSHA256(
  base64UrlEncode(header) + "." +
  base64UrlEncode(payload),
  mySecretSaltValueToGenerateToken
) 

 mySecretSaltValueToGenerateToken --> some salt value should be stored safely, which is used to generate a token and validate it.

 More Secure applications will use "private salt / key" to generate and "public key" to validate
```

* JPA instead of default Spring Security Schema
User <---> Role as ManyToMany relationship

======
Stateful: Server has client data like principle and roles stored in SecurityContext.

* JWT needs to be added
* Registration and Login functionalities using JSON {not using form}
* on Sucessfull login needs to send JSON token to client
* JWT validation needs to be done whenever user access protected resources

=========

