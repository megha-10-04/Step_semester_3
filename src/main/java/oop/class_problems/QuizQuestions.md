# Week 8 Quiz Questions

## Question 1

A ticketing system manages various event types like concerts, plays, and sports matches. While all events have a title and a scheduled date, concerts also have a performer, and sports matches have competing teams. The system processes tickets for any event type through a common TicketProcessor.

**Which OOP concept allows the TicketProcessor to interact with different event types uniformly?**

- A. Encapsulation
- B. Inheritance
- C. Polymorphism
- D. Aggregation

**Answer: C. Polymorphism**

---

## Question 2

In a social media application, a UserProfile object has a dateOfBirth attribute. The application prevents direct modification of dateOfBirth from outside the UserProfile class, requiring any changes to be made through an updateProfileInfo method that includes validation logic.

**Which OOP principle is being primarily enforced here?**

- A. Inheritance
- B. Abstraction
- C. Encapsulation
- D. Composition

**Answer: C. Encapsulation**

---

## Question 3

A publishing house manages authors and their books. An author can write one or more books, but a book must always have exactly one author.

**Which UML multiplicity best describes the relationship from Author to Book?**

- A. Author 1 --- 1 Book
- B. Author 0..* --- 1 Book
- C. Author 1 --- 1..* Book
- D. Author 1..* --- 0..* Book

**Answer: C. Author 1 --- 1..* Book**

---

## Question 4

A Shopping Cart directly manages a collection of Cart Item objects. If the Shopping Cart is deleted, all its associated Cart Item objects are also destroyed.

**Which UML relationship accurately models this strong ownership and lifecycle dependency?**

- A. Association
- B. Aggregation
- C. Dependency
- D. Composition

**Answer: D. Composition**

---

## Question 5

An online course platform defines a general Course concept. Specific types of courses, such as ProgrammingCourse and DesignCourse, extend this general Course.

**Which UML relationship represents the connection between Course and ProgrammingCourse?**

- A. Realization
- B. Dependency
- C. Aggregation
- D. Generalization

**Answer: D. Generalization**

---

## Question 6

A Printer class needs to interact with various Printable document types. The documents follow a Printable contract that defines a print() method.

**Which UML relationship describes the connection between PdfDocument and the Printable contract?**

- A. Generalization
- B. Composition
- C. Realization
- D. Association

**Answer: C. Realization**

---

## Question 7

A Customer places an Order. There is no strong ownership or lifecycle dependency between them; they are simply related by a transaction.

**Which UML relationship is most suitable?**

- A. Composition
- B. Association
- C. Generalization
- D. Dependency

**Answer: B. Association**

---

## Question 8

A task has statuses such as Pending, InProgress, Completed, and Blocked. The task can move between certain states but cannot return to some previous states.

**Which UML diagram is best suited to model this lifecycle?**

- A. Class diagram
- B. Sequence diagram
- C. State diagram
- D. Component diagram

**Answer: C. State diagram**

---

## Question 9

A reporting module interacts with a generic ReportGenerator interface that defines generate(). The module does not need to know how each report is created.

**Which design concept is primarily demonstrated?**

- A. Encapsulation
- B. Abstraction
- C. Composition
- D. Object identity

**Answer: B. Abstraction**

---

## Question 10

During login, the user enters credentials, AuthenticationService receives them, UserRepository verifies them, and the result is returned.

**Which UML behavioral model is most appropriate for visualizing this order of messages?**

- A. Class diagram
- B. Activity diagram
- C. Sequence diagram
- D. Use case diagram

**Answer: C. Sequence diagram**

---

# Answer Key

| Question | Answer |
|---|---|
| 1 | C — Polymorphism |
| 2 | C — Encapsulation |
| 3 | C — Author 1 --- 1..* Book |
| 4 | D — Composition |
| 5 | D — Generalization |
| 6 | C — Realization |
| 7 | B — Association |
| 8 | C — State diagram |
| 9 | B — Abstraction |
| 10 | C — Sequence diagram |