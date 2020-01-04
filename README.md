# Oracle Certified Java Programmer Study Codes


## Advanced Class Design  

### Introduction 

This section holds the summary of the first chapter of OCP Java SE 8 Programmer II Study Guide. The OCP exam topics covered are how to use instanceof, implement equals/hashCode/toString, create enumerations, and create nested classes.  

### Virtual Methods
Virtual functions are an important part of the run-time polymorphism in object-oriented programming. They are just non-static methods. When you define a base and child class with the same method, Java looks for an overridden method rather than the one in the derived class. However, instance variables work in a different way. Java uses the one in the derived class. The following example reveals the usage of virtual methods.  

```java
abstract class A {
  String var = "variable A";
  public void print(){ System.out.println(var); } 
  public void start(){
    foo();
 }  
  void foo(){ System.out.println("Class A"); }
}

class B extends A {
  String var = "variable B";
  void foo(){ System.out.println("Class B"); }
}

class C extends B {
  void foo(){ System.out.println("Class C"); }
}

public static void main(String[] args){ 
  A a = new B();
  a.start();
  A c = new C();
  c.start();
  a.print();  
}

Output:  Class B
         Class C
         variable A    
```

### Instanceof
The instanceof operator is commonly used to determine if an instance is a subclass of a particular object before applying an explicit cast. The following code is considered as a bad practice. You shouldn’t use casting with if-else statements. However, it demonstrates the usage of the operator.   

```java
class TVSeries{ 
  void play(){
    System.out.println(“ TVSeries ”);
  }
}

class BlackMirror extends TVSeries{
   void play(){
      System.out.println(“ BlackMirror ”);
   } 
}

class Dark extends TVSeries{
   void play(){
      System.out.println(“ Dark ”);
   } 
} 

public static void main(String[] args){
  playTvSeries(new BlackMirror()); 
  playTvSeries(new Dark());
}

public static void playTvSeries(TVSeries tvSeries){
  if (tvSeries instanceof BlackMirror) {
      BlackMirror blackMirror = (BlackMirror) tvSeries;
      blackMirror.play();
  } else if (tvSeries instanceof Dark) {
      Dark dark = (Dark) tvSeries;
      dark.play();
  }
}
```

### Coding Equals, HashCode, And ToString
All classes in Java implements java.lang.Object. Three of these methods are common for subclasses to override with a custom implementation. toString, equals, and hashCode.  

#### ToString
Overriding toString method provides a nice human-readable output. They can simply print out your object and understand what it represents.  

```java
class Human {
 
 private String name;
 private double weight;
 
 public Human(String name, double weight) {
   this.name = name;
   this.weight = weight;
 }

 @Override
 public String toString() {
   return "Name: " + name + ", Weight: " + weight;
 }

 public static void main(String[] args) {
   Human h = new Human("Suleyman", 70);
   System.out.println(h); // Name: Suleyman, Weight: 70
 }
}
```

#### Equals
equals method checks if two objects are equal. A programmer who compares references to value objects using the equals method expects to find out whether they are logically equivalent. The class TVSeries below implements equals() to say that any two TVSeries objects with the same name are the same TVSeries.  

```java
class TVSeries{
  private String name;
  public TVSeries(String name){
     this.name = name;
  }
  @Override public boolean equals(Object obj) {
    if (!(obj instanceof TVSeries)) return false;
    TVSeries tvSeries = (TVSeries) obj; 
    return this.name == tvSeries.name;
  } 
}
```

If equals(null) is called, the method should return false. If equals() is passed the wrong type, the method should return false 

#### HashCode
The hash code is used when storing the object as a key in a map. You must override hashCode in every class that overrides equals. If you fail to do so, your class will violate the general contract for hashCode (Effective Java, p. 92). The contract at issue boils down to these:  

Within the same program, the result of hashCode() must not change  
If equals() returns true when called with two objects, calling hashCode() on each of those objects must return the same result  
If equals() returns false when called with two objects, calling hashCode() on each of those objects does not have to return a different result  

### Enums
Enumerations are useful when you have things whose types are known at compile time. enum is a type of class that mainly contains static members.  

```java
public enum Days {
   MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

It is easy to access the enum types:  

```java
Days day = Days.MONDAY;
System.out.println(day); // MONDAY
System.out.println(day == Season.MONDAY); 
```

The compiler automatically adds some special methods when it creates an enum, such as static values method. It is commonly used with the for-each loop to iterate the enum types:  

```java
for(Days day: Days.values()) {
  System.out.println(day.name() + " " + day.ordinal());
}
```

You can’t compare an int and enum value directly:  

```java
if ( Days.WEDNESDAY == 2) {} // DOES NOT COMPILE

...

Days day = Days.MONDAY; 
switch (day) {
  case 0: // DOES NOT COMPILE
     System.out.println("MONDAY...");
  break;
}
```

You can’t extend an enum:  

```java
class Weeks extends Days {} // DOES NOT COMPILE
A semicolon is required if enums are declared with values

EARTH(12756), MARS(6792), JUPITER(142984); //Semicolon is required here
For the enum constructor; only private is permitted. Others will not compile

public enum Planets {
  EARTH(12756), MARS(6792), JUPITER(142984); //Semicolon is required here
  private int diameter;
  private Planets(int diameter) { // only private is permitted
    this.diameter = diameter;
  }
  public void printDiameters(){
    System.out.println(diameter);
  }
}
```

### Creating Nested Classes
In this section, we are going to discuss the nested classes in Java. The Java programming language allows you to define a class within another class. Such a class is called a nested class. Nested classes are divided into two categories: static and non-static. Nested classes that are declared static are called static nested classes. Non-static nested classes are called inner classes, The Java Tutorials. There are four types of nested classes:  

Member Inner Class  
Local Inner Class  
Anonymous Inner Class  
Static Nested Class  

Inner classes are not allowed to contain static methods or static variables. Only nested static classes are permitted to contain the statics  

#### Member Inner Class
A member inner class is defined at the member level of a class (the same level as the methods, instance variables, and constructors).

```java
class OuterClass {    
   private int a = 5;
   class InnerClass {
        public void foo(){
          System.out.println("Hello! I am an inner class function");  
      }
   }
} 
```
An instance of InnerClass can exist only within an instance of OuterClass and has direct access to the methods and fields of its enclosing instance.  

```java
public static void main(String[] args) {
  OuterClass outer = new OuterClass();
  InnerClass inner = outer.new InnerClass(); // create the inner class
  inner.foo();
}
```
#### Local Inner Class
Local classes are classes that are defined in the body of a method. Local inner classes are just like local variables, they go out of scope when the method returns. Let’s look at the example below. InnerClass’s scope ends where the foo method ends.

```java
class OuterClass {    
   private int a = 5;
   public void foo(){
     class InnerClass {
       public void doSomething(){
         System.out.println("Hello! I am a local inner class function");  
       }
     } 
     InnerClass inner = new InnerClass();
     inner.doSomething();
  } // scope of the Inner class ends here

  public static void main(String[] args) {
     OuterClass outer = new OuterClass();
     outer.foo();
  }
} 
```

They also do not have access to local variables of a method unless those variables are final or effectively final. A variable that is not declared as final but whose value is never changed after initialization is effectively final.

#### Anonymous Inner Class
Anonymous inner classes enable you to declare and instantiate a class at the same time. They are useful when you need to use a local class only once. They are required to extend an existing class or implement an existing interface:  

**Extend an abstract class**  

public class Calculator {
   abstract class Numeric {
     abstract int addNumbers();
   }
   public int calculate(int a, int b){
      Numeric numeric = new Numeric(){
        int addNumbers() { return a + b ;}
      }
      return numeric.addNumbers();
   } 
}

**Implement an interface**  

As you see, little has changed. We had to declare an interface and add a public access modifier to the addNumbers method. Remember, all Java interface methods are implicitly public and abstract.  

```java
public class Calculator {
   interface Numeric {
     int addNumbers();
   }
   public int calculate(int a, int b){
      Numeric numeric = new Numeric(){
        public int addNumbers() { return a + b ;} // 
      }
      return numeric.addNumbers();
   } 
}
```

Anonymous classes are often used in graphical user interface (GUI) applications. This technique gives the event handler access to the instance variables in the class with which it goes. It works well for simple event handling.  

```java
Button btn = new Button();
btn.setText("Say 'Hello World'");   
btn.setOnAction(new EventHandler<ActionEvent>() {
   @Override
   public void handle(ActionEvent event) {
     System.out.println("Hello World!");
  }});
```

#### Static Nested Class
A static nested class is associated with its outer class. And like static class methods, a static nested class cannot refer directly to instance variables or methods defined in its enclosing class: it can use them only through an object reference.  

```java
public class OuterClass{
   static class NestedClass {
       private int value = 10;
   }
   public static void main(String[] args) {
       NestedClass nested = new NestedClass();
       System.out.println(nested.value);
   }
}
```
