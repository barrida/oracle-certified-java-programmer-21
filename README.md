# Java SE 8 Programmer II Certification | 1Z0-809

This repository is created to provide documentation and code samples for Oracle Certified Java SE 8 Programmer II exam.


# Table of Contents
[Advanced Class Design](#1)  
[Design Patterns and Principles](#2)  
[Generics and Collections](#3)  
[References](#99)


<a name="1">
  
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
class Weeks extends Days {} // DOES NOT COMPILE A semicolon is required if enums are declared with values

EARTH(12756), MARS(6792), JUPITER(142984); // Semicolon is required here For the enum constructor; only private is permitted.

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

```java
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
```

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
<a name="2">  

<!-- wp:heading -->
<h2>Introduction</h2>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>This section covers the OCP Java SE 8 Programmer II exam objectives: design an interface, define functional interfaces, implement polymorphism, create and use singleton classes and immutable classes.</p>
<!-- /wp:paragraph -->

<!-- wp:heading -->
<h2>Designing an Interface</h2>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>Let's revise the interface rules in Java 8. </p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>An interface may extend another interface, and in doing so it inherits all of the abstract methods</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>All interface methods are public and abstract by default, except for all non‐static and non‐default methods. On the other hand, the class implementing the interface must provide the proper modifiers. </p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>An interface may include constant public static final variables, default methods, and static methods. </p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>Default methods are optionally overridden in concrete classes. When you extend an interface that contains a default method, you can do the following (<a href="https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html"><em>Java Docs</em></a>):</p>
<!-- /wp:paragraph -->

<!-- wp:list -->
<ul><li>Not mention the default method at all, which lets your extended interface inherit the default method.</li><li>Redeclare the default method, which makes it&nbsp;<code>abstract</code>.</li><li>Redefine the default method, which overrides it.</li></ul>
<!-- /wp:list -->

<!-- wp:paragraph -->
<p>Interfaces cannot extend classes, nor can classes extend interfaces. They cannot be marked final or instantiated directly. </p>
<!-- /wp:paragraph -->

<!-- wp:heading -->
<h2>Functional Interfaces</h2>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>The goal of this section is to identify valid and invalid functional interfaces. First, let's look at the definition of a functional interface:</p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p><em>Each functional interface has <strong>a</strong> <strong>single abstract method</strong> to which the lambda expression's parameter and return types are matched or adapted, <a href="https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html">Java Docs</a>. </em></p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>In this example, <code>BodyMassIndex</code> is a valid interface as it has<em><strong> a single abstract method</strong></em>.</p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted"> //User defined functional interface 
 @FunctionalInterface
 interface BodyMassIndex  { 
    double calculate(double weight, double height); 
 }</pre>
<!-- /wp:preformatted -->

<!-- wp:paragraph -->
<p><em>@FunctionalInterface </em>annotation is used to ensure that the functional interface can’t have more than one abstract method. Applying the annotation to an interface, which has two abstract methods, would result in a compiler error</p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">@FunctionalInterface interface BodyMassIndex  
{ 
  double getCalories();
  double calculate(double weight, double height);
}</pre>
<!-- /wp:preformatted -->

<!-- wp:paragraph -->
<p><strong>Valid and invalid functional Interfaces</strong></p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>Interface A is a functional interface as it has a single abstract method</p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>@FunctionalInterface
interface A {
    int run();
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p>B is also a functional interface. It inherits run() method from the interface A. Therefore, it has a single abstract method.</p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>@FunctionalInterface
   interface B extends A {
}</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p>D is a valid functional interface for the same reasons above</p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>@FunctionalInterface
interface D extends A, B { }</code></pre>
<!-- /wp:code -->

<!-- wp:paragraph -->
<p>C is not a functional interface as it has "two" abstract methods: run() and lift(). run() is inherited from the interface A. If it is marked with the @FunctionalInterface, this will result in a compile error.</p>
<!-- /wp:paragraph -->

<!-- wp:code -->
<pre class="wp-block-code"><code>interface C extends A {
    void lift();
}</code></pre>
<!-- /wp:code -->

<!-- wp:heading -->
<h2>Polymorphism</h2>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>Polymorphism is the ability of a single interface to support multiple underlying forms. It enables one object to take on many different forms. </p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>Java object may be accessed using a reference with the same type as the object, a reference that is a superclass of the object, or a reference that defines an interface that the object implements, either directly or through a superclass. </p>
<!-- /wp:paragraph -->

<!-- wp:paragraph -->
<p>Rules to distinguish between object and reference:</p>
<!-- /wp:paragraph -->

<!-- wp:list {"ordered":true} -->
<ol><li>The type of an object determines which properties exist within the object in memory.</li><li>The type of the reference to the object determines which methods and variables are accessible to the Java program.</li></ol>
<!-- /wp:list -->

<!-- wp:heading {"level":3} -->
<h3><strong>Casting</strong></h3>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>Here are some basic rules to keep in mind when casting variables:</p>
<!-- /wp:paragraph -->

<!-- wp:list {"ordered":true} -->
<ol><li>Casting an object from a subclass to a superclass doesn’t require an explicit cast.</li><li>Casting an object from a superclass to a subclass requires an explicit cast.</li><li>The compiler will not allow casts to unrelated types.</li><li>Even when the code compiles without issue, an exception may be thrown at runtime if the object being cast is not actually an instance of that class</li></ol>
<!-- /wp:list -->

<!-- wp:paragraph -->
<p>Let's have a look at the third rule, which is quite important for the exam</p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">Parent p = new Child(); // valid upcasting
Child c = (Child) p; // Valid downcasting

Parent p1 = new Parent();
Child c1 = (Child) p1; // Compiles but throws java.lang.ClassCastException</pre>
<!-- /wp:preformatted -->

<!-- wp:paragraph -->
<p>Casting is not without its limitations. Even though two classes share a related hierarchy, that doesn’t mean an instance of one can automatically be cast to another</p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">class Child extends Parent{}

Parent p = new Child();
Child c = (Child) p; // Valid downcasting
 
Parent p = new Parent();
Child c = (Child) p; // Compiles but throws ClassCastException</pre>
<!-- /wp:preformatted -->

<!-- wp:heading -->
<h2>Design Patterns</h2>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>In this section, we will cover two design patterns: <em>immutable object pattern</em> and <em>singleton pattern</em>. You need to be able to create and use singleton classes and immutable classes for the OCP 8 exam.</p>
<!-- /wp:paragraph -->

<!-- wp:heading {"level":3} -->
<h3>Immutable Object Pattern</h3>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>An object is considered&nbsp;<em>immutable</em>&nbsp;if its state cannot change after it is constructed.  Since they cannot change state, they are thread-safe.  The following rules define a simple strategy for creating immutable objects. </p>
<!-- /wp:paragraph -->

<!-- wp:list {"ordered":true} -->
<ol><li><em>Use a constructor to set all properties of the object </em></li><li> <em>Mark all of the instance variables private and final </em> </li><li> <em>Don’t define any setter methods</em></li><li> <em>If the instance fields include references to mutable objects, don't allow those objects to be changed</em> </li><li> <em>Prevent methods from being overridden </em> </li></ol>
<!-- /wp:list -->

<!-- wp:paragraph -->
<p>Let's create a mutable class and transform it into an immutable class. In this example, all rules are passed except for <em>rule 4</em>. Since the <em>List&lt;&gt;</em> interface is mutable,  the client of the function can modify the state of the list. Note that the <em>String </em>class is immutable. Therefore, we don't have to worry about <em>rule 4</em>.</p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">public final class WorkoutMutable {

    private final String type;
    private final List&lt;String&gt; exercises;

    public WorkoutMutable(String type, List&lt;String&gt; exercises) {
        if (type.isEmpty() &amp;&amp; exercises == null)
            throw new RuntimeException("Workout type and exercise list are    required");
        this.type = type;
        this.exercises = new ArrayList&lt;String&gt;(exercises);
    }

    //String class is immutable so we don't have to worry about rule 4
    public String getType() {
        return type;
    }
     
    //rule 4 failed
    public List&lt;String&gt; getExercises() {
        return exercises;
    }

}</pre>
<!-- /wp:preformatted -->

<!-- wp:paragraph -->
<p>We need to make sure that no references to the "exercises" object are publicly available. If the user does need access to the data in the List, we can create a one‐time copy of the data that is returned to the user. We can replace the <em>getExercises </em>with <em>getCopyOfExercises</em>.</p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">public List&lt;String&gt; getCopyOfExercises() {
    List&lt;String&gt; copyOfExercises = new ArrayList&lt;&gt;(exercises);
    Collections.<em>copy</em>(copyOfExercises, exercises);
    return copyOfExercises;
}</pre>
<!-- /wp:preformatted -->

<!-- wp:heading {"level":3} -->
<h3>Singleton Pattern</h3>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>A singleton is simply a class that is instantiated exactly once. The main reason to use singleton is that we want a single instance of a particular object in the memory.  The common approaches are based on creating three main elements in the class:</p>
<!-- /wp:paragraph -->

<!-- wp:list -->
<ul><li><strong>private constructor</strong> to guarantee exactly one instance will exist once the class is initialized</li><li><strong>private static member </strong>to make sure that the instance is only  accessible only within its own class</li><li><strong>public static function</strong> to access the single instance</li></ul>
<!-- /wp:list -->

<!-- wp:heading {"level":4} -->
<h4>Approach 1:  Instantiate the singleton object directly in the definition of the instance reference </h4>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>In this approach, we create a private static final variable in the class, usually name it as "instance". All calls to <em>Workout.getInstance</em> return the same object reference, and no other <em>Workout </em>instance will be created. </p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">public class Workout {

    //Create private static final variable in the class
    private static final Workout <em>instance </em>= new Workout();

    //Create private constructor
    private Workout() { }

    //Access the instance via static method, name it as getInstance()
    public static Workout getInstance() {
        return <em>instance</em>;
    }

    public static void main(String[] args) {
        Workout w1 = Workout.<em>getInstance</em>();
        Workout w2 = Workout.<em>getInstance</em>();
        System.<em>out</em>.println(w1.equals(w2));
    }
}</pre>
<!-- /wp:preformatted -->

<!-- wp:heading {"level":4} -->
<h4>Approach 2: Static initialization block</h4>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>In this approach, we create a singleton using a static initialization block instead of using private constructor. A static initialization block allows additional steps to be taken to set up the singleton after it has been created.</p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">public class Workout {

    private static final Workout <em>instance</em>;

    //Create a singleton using a static initialization block
    static {
        <em>instance </em>= new Workout();
    }

    //Access the instance via static method
    public static Workout getInstance() {
        return <em>instance</em>;
    }

    public static void main(String[] args) {
        Workout w1 = Workout.<em>getInstance</em>();
        Workout w2 = Workout.<em>getInstance</em>();
        System.<em>out</em>.println(w1.equals(w2));
    }
}</pre>
<!-- /wp:preformatted -->

<!-- wp:heading {"level":4} -->
<h4>Approach 3: Lazy Instantiation</h4>
<!-- /wp:heading -->

<!-- wp:paragraph -->
<p>Lazy instantiation is different from previous approaches in that we delay the creation of the singleton until it is requested by the client. In other words, we do not create the singleton object when the class is loaded. </p>
<!-- /wp:paragraph -->

<!-- wp:preformatted -->
<pre class="wp-block-preformatted">public class Workout {

    private static Workout <em>instance</em>;
    private Workout(){ }

    public static Workout getInstance() {
        if (<em>instance </em>== null) {
            <em>instance </em>= new Workout();
        }
        return <em>instance</em>;
    }

    public static void main(String[] args) {
        Workout w1 = Workout.<em>getInstance</em>();
        Workout w2 = Workout.<em>getInstance</em>();
        System.<em>out</em>.println(w1.equals(w2));
    }
}</pre>
<!-- /wp:preformatted -->

<a name="3">  

# Generics And Collections
This section mentions about the Generics, and Java Collections Framework (List, Set, Map, and Queue).  

## Generics 
Generics enable types (classes and interfaces) to be parameters when defining classes, interfaces and methods. It enables you to re-use the same code.  

### Type Parameter Naming Conventions  
By convention, type parameter names are single, uppercase letters. The most commonly used type parameter names are:

    E - Element (used extensively by the Java Collections Framework)
    K - Key
    N - Number
    T - Type
    V - Value
    S,U,V etc. - 2nd, 3rd, 4th types

### Generic Classes  
Generic classes are very useful if you need to use different classes as the type parameter. You can create a generic class with a generic data type T. For example, the *Food* class has a generic type variable declared after the name of the class. It means that you can create Food instances using different data types   

    public class Food<T> {
        private T ingredients;    
        public T getIngredients(){
            return ingredients;
        }
        public void setIngredients(T ingredients) {
            this.ingredients = ingredients;
        }
    }

Let's create a food instance with String data type  

    Food<String> food = new Food<>();
    food.setIngredients("protein: 200 gr; carb: 300, fat: 75");

Maybe you changed your mind and decided to create another class that holds the ingredients  

    class Ingredients {
        private String name;
        private int calories;
    
        Ingredients(String name, int calories) {
            this.name = name;
            this.calories = calories;
        }
    }
    
Then, you can create a food instance using *Ingredients* data type  

    Ingredients ingredients = new Ingredients("protein", 200);
    Food<Ingredients> ingredientsFood = new Food<>();
    ingredientsFood.setIngredients(ingredients);

Let's look at the next example. Why don't we create a food instance with Map data type? Don't worry if you don't understand the syntax. We will cover Map interface in the next section  

    Food<Map<String, Integer>> foodAsMap = new Food<>();
    Map<String, Integer> foods = new HashMap<String,Integer>();
    foods.put("protein", 200);
    foods.put("carb", 300);
    foods.put("fat", 75);
    foodAsMap.setIngredients(foods);

Generic classes can have two type parameters as well. In this example, we defined FoodMultipleType generic class that has two parameters. K for a map key, V for a map value 
    
    public class FoodMultipleType<K, V> implements FoodPair<K, V> {
        private K name;
        private V calories;
    
        public FoodMultipleType(K name, V value) {
            this.name = name;
            this.calories = value;
        }
    
        @Override
        public K getName() { return name; }
    
        @Override
        public V getCalories() { return calories; }
    }
    
To use this class, we can implement the following:  

     FoodPair<String, Integer> tuna = new FoodMultipleType<String, Integer>("tuna", 205);
     FoodPair<String, Integer> brownRice = new FoodMultipleType<String, Integer>("brown rice", 214);

### Generic Interfaces  

An interface can also declare a formal type parameter. For example, List interface uses a generic type. 

    public interface List<E> extends Collection<E> {
        int size();
        boolean isEmpty();
        boolean contains(Object var1);
        ...
    }

You can also define your own interface. Let's create a Diet interface. There are three approaches implementing Diet interface.  

    public interface Diet<T> {
        void printDietList(T t);
    }
    
**Approach 1: Specify the generic type in the class**  
The following concrete class says that it deals only with LowCarbHighProtein class  

    class LowCarbDiet implements Diet<LowCarbHighProtein> {
        @Override
        public void printDietList(LowCarbHighProtein t) {
            //do something with t
        }
    }
**Approach 2: Create a generic class**  
The following concrete class allows the caller to specify the type of the generic  

    class LowCarbAbstractDiet<U> implements Diet<U> {
        @Override
        public void printDietList(U u) { // do something}
    }
    
**Approach 3: Not use generics at all**  
This is the old way of writing code. It generates a compiler warning about Shippable being a raw type, but it does compile  

    class LowCarbDietSimple implements Diet {
        @Override
        public void printDietList(Object o) {}
    }

### Generic Methods
Generic methods are methods that introduce their own type parameters. This generic method compares two FoodMultipleType objects  

    class Util {
        public static <K, V> boolean compare(FoodMultipleType<K, V> p1, FoodMultipleType<K, V> p2) {
            return p1.getName().equals(p2.getName()) &&
                    p1.getCalories().equals(p2.getCalories());
        }
    }

Let's see how we use the compare method  

     FoodPair<String, Integer> tuna = new FoodMultipleType<String,Integer>("tuna",205);
     FoodMultipleType<String, Integer> brownRice = new FoodMultipleType<String,Integer>("brown rice",214);
     Util.<String,Integer>compare((FoodMultipleType<String, Integer>) tuna,brownRice);

### Bounds

**Unbounded**  
The unbounded wildcard type is specified using the wildcard character (?), for example, List<?>. This is called a list of unknown type. This method prints a list of any type.

    private static void unboud(List<?> list) {
        for (Object elem : list)
            System.out.print(elem + " ");
        System.out.println();
    }

**Lower Bound**  
A lower bounded wildcard is expressed using List<? super ClassName>, such as List<? super Integer>. This method works on lists of Integer and the supertypes of Integer, such as Integer, Number, and Object

    private static void lowerBound(List<? super Integer> list) {
        for (int i = 0; i < 10 ; i++) {
            list.add(i);
        }
        System.out.println(list);
    }
     

 **Upper Bound**  
 An upper bounded wildcard is specified using List<? extends ClassName>, List<? extends Number>. This method works on lists of Number and the subtypes of Number, such as Integer, Double, and Float.  
 
     private static double upperBound(List<? extends Number> list) {
         double s = 0.0;
         for (Number n : list)
             s += n.doubleValue();
         return s;
     }

Let's look at how these methods are called. Note that we can pass Integer and Double list to the upperBound method. On the other hand, lowerBound method only accepts Integer and its super classes. The undound method doesn't have a restriction.

     List<Integer> intList = Arrays.<Integer>asList(1, 2, 3);
     System.out.println(upperBound(intList)); // Output: 6.0

     List<Double> doubleList = Arrays.<Double>asList(4.3, 7.1, 2.4);
     System.out.println(upperBound(doubleList)); // Output: 13.799999999999999

     lowerBound(intList); // Output: 0 1 2
     //lowerBound(doubleList); // compile error

     unboud(intList); // Output: 1 2 3
     unboud(doubleList); // Output: 4.3 7.1 2.4 

## Java Collections Framework
In this section, we will cover four main interfaces in the Java Collections Framework: List, Set, Map, and Queue.  

### List
You usually use a list when you want an ordered collection that can contain duplicate entries. All list methods are ordered and allow duplicates.

**ArrayList**  
When to use: Use ArrayList, when you are not sure which collection to use  
Look up is constant time, O(1), adding/removing is slower  
Use when you are reading more often than writing to the ArrayList  

    List<String> list = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    ...

**LinkedList**  
When to use: LinkedList is usually used as a Queue  
Pros: You can access, add, and remove from the beginning and end of the list in constant time, O(1)  
Cons: Dealing with an arbitrary index takes linear time, O(n)  

    LinkedList<String> linkedList = new LinkedList<String>();  

**Stack**  
A Stack is a data structure that you add and remove elements from the top of the stack. If you need a stack, use an ArrayDeque  

    Deque<String> stack = new ArrayDeque<>();
    stack.push("1");
    stack.push("2");
    stack.pop(); // 2

**List methods**  
The List methods that you need to know are listed below:  

    void add(E element)           
    void add(int index, E element)      
    E get(int index)                  
    int indexOf(Object o)               
    int lastIndexOf(Object o)           
    void remove(int index)            
    E set(int index, E e)  

This example shows the usage of list methods:  

      List<String> list = new ArrayList<>();
      list.add("suleyman"); // suleyman
      list.add(1,"yildirim"); // [suleyman, yildirim]
      list.get(1); //yildirim
      //list.set(2, "asd"); // java.lang.IndexOutOfBoundsException
      list.set(1, "DDD"); //[suleyman, DDD]
      list.indexOf("DDD"); // 1
      list.lastIndexOf("suleyman"); // 1
      list.remove(0); // [DDD]
      list.remove("DDD"); // []

### Set  
You use a set when you don’t want to allow duplicate entries

**HashSet**  

A HashSet stores its elements in a hash table  
Pros: Adding elements and checking if an element is in the set both have constant time
Cons: You lose the order in which you inserted the elements  

    Set<String> hashSet = new HashSet<>();
    hashSet.add("suleyman");
    hashSet.add("canan");
    hashSet.add("fatma");
    hashSet.add("omur");
    hashSet.add("fatma");

    System.out.println("HashSet values:");
    for (String value : hashSet) {
        System.out.print(value + " ");
    }
    
    // HashSet values: Canan Suleyman Fatma Omur 

**TreeSet**  

A TreeSet stores its elements in a sorted tree structure. It implements the NavigableSet interface    
Pros: The set is always in sorted order
Cons: Adding and checking if an element is present are both O(log n)

    Set<String> treeSet = new TreeSet<>();
    treeSet.add("suleyman");
    treeSet.add("canan");
    treeSet.add("fatma");
    treeSet.add("omur");
    treeSet.add("fatma");

    System.out.println("TreeSet values:");
    for (String value : treeSet) {
        System.out.print(value + " ");
    }
    // TreeSet values: Canan Fatma Omur Suleyman 

### Queue

**LinkedList**  
LinkedList implements both the List and Queue interfaces. It is a double ended queue 
    
    LinkedList<String> linkedList = new LinkedList<String>();  

**ArrayDeque**  
A “pure” double-ended queue and more efficient than LinkedList  

    Deque<String> stack = new ArrayDeque<>();
    stack.push("1");
    stack.push("2");

**Queue Methods**  
You need to know the methods below in addition to the ones inherited from Collection interface. These methods are shown below  

    boolean add(E e)  
    E element()  
    boolean offer(E e)  
    E remove()  
    void push(E e)  
    E poll()  
    E peek()  
    E pop() 

This example shows the usage of Queue methods:  

    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(1); // [1]
    queue.add(2); // [1, 2]
    queue.offer(3); // [1, 2, 3]
    queue.offer(4); // [1, 2, 3, 4]
    queue.poll(); // [2, 3, 4]
    queue.peek(); // [2, 3, 4]
    queue.poll(); // 3, 4]

### Map
You use a map when you want to identify values by a key    

**HashMap**  
A HashMap stores the keys in a hash table  

Pros: Adding elements and retrieving the element by key both have constant time  
Cons: You lose the order in which you inserted the elements. If you are concerned with this, use LinkedHashMap   

    Map<String, Integer> hashMap = new HashMap<>();
    hashMap.put("11", 10);
    hashMap.put("gfds", 20);
    hashMap.put("gnh", 30);
    hashMap.put("100", 30);
    hashMap.put("567", 40);
    hashMap.put("hjk", 50);
    hashMap.put("aa", 60);
    hashMap.put("bf", 70);
    System.out.println(hashMap); // {11=10, gnh=30, aa=60, 100=30, bf=70, 567=40, hjk=50, gfds=20}

**TreeMap**  
A TreeMap stores the keys in a sorted tree structure  

Pros: The keys are always in sorted order  
Cons: Adding and checking if a key is present are O(log n)  

Note that Integer keys are tricky in TreeMap. That's why the element (100,30) showed up before (11,10):  

    Map<String, Integer> treeMap = new TreeMap<>();
    treeMap.put("11", 10);
    treeMap.put("gfds", 20);
    treeMap.put("gnh", 30);
    treeMap.put("100", 30);
    treeMap.put("567", 40);
    treeMap.put("hjk", 50);
    treeMap.put("aa", 60);
    treeMap.put("bf", 70);
    System.out.println(treeMap); // {100=30, 11=10, 567=40, aa=60, bf=70, gfds=20, gnh=30, hjk=50}

**Map Methods**  

You need to know the following methods below:  

    void clear()
    boolean isEmpty() 
    int size() 
    V get(Object key) 
    V put(K key, V value)
    V remove(Object key) 
    containsKey(Object key)
    containsValue(Object)
    Set<K> keySet()
    Collection<V> values()

In this example, we use some of the Map methods to calculate the frequency of each word in a String list  

    String[] str = {"aaa", "bb", "aaa", "c", "bb", "aaa"};
    Map<String, Integer> map = new HashMap<>();
    for (String value : str) {
        if (!map.containsKey(value)) {
            map.put(value, 1);
        } else {
            int frequency = map.get(value);
            map.put(value, ++frequency);
        }
    }

    for (String key : map.keySet()) {
        System.out.print(key + ", "); //aaa, bb, c,
    }

    for (Integer value : map.values()) {
        System.out.print(value + ", "); // 3, 2, 1,
    }

<a name="99">  

# References  
1) OCP: Oracle Certified Professional Java SE 8 Programmer II Study Guide, by Jeanne Boyarsky  
2) Effective Java, Third Edition, by Joshua Bloch  
3) <a href="https://docs.oracle.com/javase/tutorial/java/">The Java Tutorials</a>  
