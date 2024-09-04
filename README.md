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


products: [....]

