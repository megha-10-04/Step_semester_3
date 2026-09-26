# Week 8 Concept Questions

## Question 1 — Encapsulation

### Question

A user registration system requires users to provide an email address. The User object has an email attribute. To ensure data integrity, the system prevents direct modification of the email attribute. Instead, any email changes must go through a changeEmail method that includes validation to check for a valid format and uniqueness before updating the email.

Explain how encapsulation is applied in this User object design. Describe what state should be controlled by the User object, why unrestricted access to the email could lead to invalid states, and how controlled access through methods helps maintain valid object state.

### Answer

Encapsulation means keeping the internal state of an object protected from direct outside access and allowing controlled access through methods.

The `email` attribute should be private:

```java
private String email;

The User object should control its own email state. It should ensure that the email is valid and unique before allowing it to be changed.

If the email were directly accessible, another part of the program could assign an invalid or duplicate email:

user.email = "invalid";

This could make the object enter an invalid state.

Instead, the user should change the email through a method such as:

public void changeEmail(String newEmail) {
    // validate email format
    // check uniqueness
    // update email
}

This method can perform all necessary validation before modifying the internal state.

Therefore, encapsulation protects the object's data and ensures that the User object remains in a valid state.

Question 2 — Inheritance vs Composition
Question

Consider a ReportingService that can generate various types of reports. Some reports might require DataExport capabilities, such as exporting to CSV, while others might require DataVisualization capabilities, such as generating charts. Not every report needs all capabilities.

Explain when inheritance might be considered and when composition would be more suitable for incorporating these optional DataExport and DataVisualization capabilities into the reporting system. Discuss how forcing all capabilities into a single inheritance hierarchy for all report types could lead to design rigidities and make the system harder to extend with new report features.

Answer

Inheritance can be considered when there is a clear is-a relationship between the classes.

For example:

Report
   |
   +-- SalesReport
   +-- InventoryReport
   +-- EmployeeReport

The specialized reports inherit common behavior from the general Report class.

However, DataExport and DataVisualization are optional capabilities. A report may need exporting, visualization, both, or neither.

Composition is more suitable for such optional capabilities because the capabilities can be added independently.

For example:

Report
  |
  +-- DataExport
  |
  +-- DataVisualization

A report can use the capabilities that it actually requires.

Forcing every capability into one inheritance hierarchy can make the design rigid. As more features are introduced, the number of subclasses and combinations can grow significantly.

Composition makes the system easier to extend because new capabilities can be added without creating a large inheritance hierarchy.

Therefore, inheritance is useful for genuine is-a relationships, while composition is more suitable for optional or interchangeable capabilities.

Question 3 — Abstraction and Runtime Polymorphism
Question

An application has a NotificationService responsible for sending messages to users. It supports sending notifications via EmailNotification, SMSNotification, and PushNotification. The NotificationService should be able to trigger a notification without explicit conditional logic for each specific notification type.

Explain how abstraction, method overriding, and runtime polymorphism work together to achieve this flexible notification system. Describe what happens when a new notification implementation, such as InAppNotification, is introduced, and how the existing NotificationService remains largely unaffected.

Answer

Abstraction can be provided using an interface or abstract class that defines a common notification operation.

For example:

interface Notification {
    void send();
}

Different notification classes can implement the interface:

Notification
    |
    +-- EmailNotification
    +-- SMSNotification
    +-- PushNotification

Each class overrides the send() method with its own implementation.

For example:

class EmailNotification implements Notification {

    public void send() {
        System.out.println("Sending Email");
    }
}

The NotificationService can work with the common Notification type:

class NotificationService {

    public void sendNotification(Notification notification) {
        notification.send();
    }
}

When the program runs, Java determines which send() implementation should execute based on the actual object.

This is runtime polymorphism.

If a new notification type is introduced:

class InAppNotification implements Notification {

    public void send() {
        System.out.println("Sending In-App Notification");
    }
}

the existing NotificationService does not need separate conditional logic for InAppNotification.

It can simply receive an InAppNotification object through the Notification interface.

Therefore, abstraction provides the common contract, method overriding provides specific behavior, and runtime polymorphism allows the service to work with different notification types uniformly.

Question 4 — Composition vs Aggregation
Question

An Organization is composed of several Departments. Each Department has a collection of Employees. When an Organization ceases to exist, its Departments are also dissolved. However, if a Department is dissolved, its Employees might still exist and could be reassigned to other departments or become independent. Similarly, Employees can move between Departments throughout their career.

Explain the differences between composition and aggregation based on this scenario. Justify which UML relationship is more appropriate for Organization and Department, and which is more appropriate for Department and Employee, based on their respective ownership and lifecycle dependencies.

Answer

Composition represents strong ownership and a strong lifecycle dependency between the whole and its parts.

In this scenario, when the Organization ceases to exist, its Departments are also dissolved.

Therefore, the relationship between Organization and Department is composition.

Organization ◆── Department

The filled diamond represents composition.

Aggregation represents a weaker ownership relationship where the contained objects can exist independently of the whole.

Employees can continue to exist even if their Department is dissolved. They can also be reassigned to another Department.

Therefore, the relationship between Department and Employee is aggregation.

Department ◇── Employee

The hollow diamond represents aggregation.

Summary
Organization ◆── Department
Composition

Department ◇── Employee
Aggregation

The key difference is the lifecycle dependency:

Composition → the part's lifecycle is strongly dependent on the whole.
Aggregation → the part can exist independently of the whole.
Question 5 — Student and Course Multiplicity
Question

An educational platform has Courses and Students. A Course can be taken by many Students, and a Student can enroll in multiple Courses. A specific business rule states that a student cannot be enrolled in the same course more than once, meaning there should be no duplicate enrollment records for a student-course pair.

Explain the UML multiplicity that correctly describes the relationship between Student and Course in this scenario. Furthermore, clarify why the business rule preventing duplicate enrollment is distinct from, and not directly expressed by, the multiplicity itself, but rather enforced by other mechanisms in the system's logic.

Answer

The relationship between Student and Course is many-to-many.

A Student can enroll in multiple Courses, and a Course can have multiple Students.

Therefore, the UML multiplicity can be represented as:

Student 0..* -------- 0..* Course

This means that multiple students can be associated with multiple courses.

However, multiplicity alone does not express the rule that a student cannot enroll in the same course more than once.

The no-duplicate rule is a business constraint.

It must be enforced through application logic or a database constraint.

For example, an Enrollment entity could ensure that the combination of:

Student ID + Course ID

is unique.

Therefore:

Multiplicity describes how many objects can participate in a relationship.
Business constraints enforce additional rules such as preventing duplicate enrollment.

The many-to-many relationship and the no-duplicate-enrollment rule are therefore separate concepts.