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

