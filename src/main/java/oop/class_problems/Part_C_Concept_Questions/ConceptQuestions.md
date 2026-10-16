\# Week 10 — Part C: Concept Questions



\## Q1. Difference between method overloading and method overriding



\*\*Method overloading\*\* occurs when multiple methods have the same name but different parameter lists in the same class. It is resolved at compile time.



\*\*Method overriding\*\* occurs when a subclass provides its own implementation of an inherited method with a compatible signature. The actual method is selected at runtime for overridden instance methods.



\## Q2. Constructor execution order in inheritance



When a subclass object is created, the superclass constructor executes before the subclass constructor. The `super()` statement calls the superclass constructor, and `super(arguments)` passes arguments to it.



For example, creating a `Manager` object may execute constructors in the order `Person`, `Employee`, and `Manager`.



\## Q3. Difference between concrete classes, abstract classes, and interfaces



\- \*\*Concrete class:\*\* Can be instantiated and provides implementations for its required methods.

\- \*\*Abstract class:\*\* Cannot be instantiated directly. It can contain abstract methods, implemented methods, and instance variables.

\- \*\*Interface:\*\* Defines a contract that implementing classes agree to follow. It supports multiple inheritance of type.



Use a concrete class for complete objects, an abstract class for shared base behavior, and an interface for a common capability across different classes.



\## Q4. Two interfaces declare the same abstract method



If a class implements two interfaces that declare the same compatible abstract method signature, one implementation in the class can satisfy both interfaces.



This demonstrates how Java allows a class to implement multiple interfaces. Incompatible return types or other conflicting declarations may require additional consideration.



\## Q5. Relationship between equals() and hashCode()



The `equals()` method determines whether two objects are logically equal. The `hashCode()` method returns an integer used by hash-based collections.



If two objects are equal according to `equals()`, they must have the same hash code. Overriding `equals()` without correctly overriding `hashCode()` can cause problems in collections such as `HashSet` and `HashMap`.



\## Q6. Shallow copy versus deep copy



A \*\*shallow copy\*\* copies an object's fields, but references to nested mutable objects may still be shared.



A \*\*deep copy\*\* also creates independent copies of the relevant nested mutable objects.



For example, two student objects with references to the same mutable address object may affect each other after a shallow copy. A suitable deep copy can keep their address objects independent.



\## Q7. Inner classes versus static nested classes



A non-static inner class is associated with an instance of its outer class. It can access the outer object's instance members.



A static nested class does not require an outer-class object to be instantiated. It can directly access the outer class's static members, but needs an outer instance to access its instance members.



Use an inner class when it needs a particular outer object's state. Use a static nested class when the nested type does not need an outer instance.



\## Q8. Array access, insertion, and deletion complexity



Accessing an array element by index takes O(1) time because the element can be accessed directly.



Inserting or deleting an element in the middle generally takes O(n) time because other elements may need to be shifted. Arrays also have a fixed length after creation in Java, so increasing capacity requires a new array.



\## Q9. Polymorphism using a base-type array



A base-type array can store references to objects of different subclasses. If those subclasses override the same instance method, calling that method through a base-class reference executes the implementation belonging to the actual object.



This is runtime polymorphism. It avoids the need for explicit type-checking conditions for each subclass.



\## Q10. Example scenario for using an interface



The available question text ends after: “Provide an example scenario where an interface would be ...”



The remainder of the original question is not visible, so its exact requirement cannot be confirmed.



A general example is a payment system with a `PaymentMethod` interface. Classes such as `CardPayment` and `UPIPayment` can implement a common `pay()` method. The application can process both types through the same interface without depending on their internal implementations.



