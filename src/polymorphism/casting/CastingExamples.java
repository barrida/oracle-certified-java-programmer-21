package polymorphism.casting;

class Parent { }
class Child extends Parent{}

public class CastingExamples {

    public static void main(String args[]){

        Parent p = new Child(); // valid upcasting
        Child c = (Child) p; // Valid downcasting

        Parent p1 = new Parent();
        Child c1 = (Child) p1; // Compiles but throws java.lang.ClassCastException

    }
}
