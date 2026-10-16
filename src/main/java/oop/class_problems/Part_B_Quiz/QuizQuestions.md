\# Week 10 — Part B: UML and OOP Quiz



\## Q1. Inheritance and access modifiers

\*\*Answer: B\*\*



A subclass can directly access a `protected` member and a `public` method. It cannot directly access a `private` member of its superclass.



\## Q2. Invalid inheritance hierarchy

\*\*Answer: C — Diagram 3\*\*



Java does not support multiple inheritance of classes. A class cannot extend two classes at the same time.



\## Q3. Constructor execution order

\*\*Answer: B — Person → Employee → Manager\*\*



When creating a `Manager` object, the superclass constructor executes first, followed by the intermediate superclass and then the subclass constructor.



\## Q4. Accessing superclass members

\*\*Answer: C — protectedField\*\*



A subclass can access a `protected` field inherited from its superclass. A `private` field is not directly accessible.



\## Q5. Runtime polymorphism

\*\*Answer: B — Bus method is called\*\*



If a `Vehicle` reference points to a `Bus` object, the overridden method in `Bus` executes at runtime.



\## Q6. Method overloading and overriding

\*\*Answer: B\*\*



Defining `print(String)` and `print(int)` is overloading because the parameter lists differ. Redefining `print(String)` in a subclass is overriding.



\## Q7. Reference type and object type

\*\*Answer: A\*\*



A reference can directly access members declared in its reference type. Subclass-specific members may require a suitable cast.



\## Q8. Polymorphism with a Shape array

\*\*Answer: C\*\*



When `Circle` and `Square` objects override `area()`, calling `area()` through a `Shape` reference executes the appropriate subclass implementation.



\## Q9. Downcasting objects

\*\*Answer: B\*\*



Casting a `Current` object to `Savings` fails at runtime if the object is not actually a `Savings` instance. Casting it to `Current` succeeds.



\## Q10. Polymorphism with a Plan array

\*\*Answer: B\*\*



Different plan objects can be processed through a common parent reference. Each object's overridden `bill()` method executes according to its actual type.



\## Q11. Encapsulation

\*\*Answer: A\*\*



A public method such as `printDocument()` exposes the required functionality while private fields and helper methods hide internal implementation details.



\## Q12. Abstract classes

\*\*Answer: B\*\*



An abstract `Vehicle` class cannot be instantiated directly, but a reference of type `Vehicle` can point to a concrete `Car` object.



\## Q13. Implementing abstract methods

\*\*Answer: B\*\*



A concrete subclass must implement all inherited abstract methods. If it does not, the subclass must also be declared `abstract`.



\## Q14. Missing abstract method implementation

\*\*Answer: B\*\*



A concrete subclass such as `MonthlyReport` must implement the inherited abstract method `generateBody()`. Otherwise, compilation fails.



\## Q15. Purpose of interfaces

\*\*Answer: A\*\*



An interface defines a contract that implementing classes agree to follow. It supports abstraction and allows different classes to share a common type.



\## Q16. Interface members

\*\*Answer: B\*\*



Interface fields are implicitly `public static final`. Ordinary abstract interface methods are implicitly `public abstract`.



\## Q17. Implementing multiple interfaces

\*\*Answer: C\*\*



A class implementing both `Serializable` and `Resettable` must satisfy the required `serialize()` and `reset()` contracts, assuming both declare those methods.



\## Q18. Choosing an interface

\*\*Answer: C — Interface\*\*



An interface is suitable when unrelated classes need to follow the same protocol without sharing a class hierarchy or implementation.



\## Q19. Generalization and realization

\*\*Answer: B\*\*



`Dog extends Animal` represents inheritance or generalization. `Eagle implements Flyable` represents interface realization. A dog IS-A animal, while an eagle CAN-DO the Flyable behavior.



\## Q20. Methods inherited from Object

\*\*Answer: A\*\*



`equals()`, `hashCode()`, and `toString()` are commonly overridden to define meaningful object equality, hashing behavior, and text representation.



