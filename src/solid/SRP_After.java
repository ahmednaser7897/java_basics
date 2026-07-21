/*
===============================================================================
            SINGLE RESPONSIBILITY PRINCIPLE (SRP) - AFTER
===============================================================================

Definition
----------
A class should have only one reason to change.

Idea
----
Instead of putting everything inside the User class,
we split each responsibility into its own class.

Classes in this example:

1- User            -> Holds user data.
2- UserRepository  -> Saves user.
3- EmailService    -> Sends emails.
4- UserPrinter     -> Prints user information.

Now every class has ONE responsibility only.

Benefits
--------
✔ Easy to maintain.
✔ Easy to test.
✔ Easy to reuse.
✔ Easy to modify.

===============================================================================
*/
package solid;
public class SRP_After {

    public static void main(String[] args) {

        // Create a user object
        User user = new User(
                "Ahmed",
                "ahmed@gmail.com"
        );

        /*
        Instead of asking User to do everything,
        each specialized class performs its own job.
        */

        UserRepository repository = new UserRepository();
        EmailService emailService = new EmailService();
        UserPrinter printer = new UserPrinter();

        // Save user
        repository.save(user);

        // Send welcome email
        emailService.sendWelcomeEmail(user);

        // Print user information
        printer.print(user);
    }
}

/*
===============================================================================
                                USER
===============================================================================

Responsibility
--------------
Store user information ONLY.

Notice:

No database.
No printing.
No email.

This class now has only ONE reason to change:

"If user information changes."

===============================================================================
*/

class User {

    private String name;
    private String email;

    public User(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}

/*
===============================================================================
                            USER REPOSITORY
===============================================================================

Responsibility
--------------
Database operations ONLY.

If tomorrow:

- MySQL changes
- PostgreSQL changes
- MongoDB changes
- API replaces Database

ONLY this class changes.

User class remains untouched.

===============================================================================
*/

class UserRepository {

    public void save(User user) {

        System.out.println("\n========== DATABASE ==========");

        System.out.println("Connecting to database...");

        System.out.println("Saving user : " + user.getName());

        System.out.println("User saved successfully.");

    }

}

/*
===============================================================================
                            EMAIL SERVICE
===============================================================================

Responsibility
--------------
Sending emails ONLY.

If tomorrow:

- Gmail API changes
- SMTP changes
- Outlook is used
- SMS replaces Email

Only this class changes.

===============================================================================
*/

class EmailService {

    public void sendWelcomeEmail(User user) {

        System.out.println("\n========== EMAIL ==========");

        System.out.println("Connecting to mail server...");

        System.out.println("Sending welcome email to:");

        System.out.println(user.getEmail());

        System.out.println("Email sent successfully.");

    }

}

/*
===============================================================================
                            USER PRINTER
===============================================================================

Responsibility
--------------
Display user information ONLY.

If tomorrow:

Console output changes
PDF is required
HTML report is required

Only this class changes.

===============================================================================
*/

class UserPrinter {

    public void print(User user) {

        System.out.println("\n========== USER ==========");

        System.out.println("Name  : " + user.getName());

        System.out.println("Email : " + user.getEmail());

    }

}

/*
===============================================================================
                                SUMMARY
===============================================================================

Before SRP

User Class
-----------
❌ Store Data
❌ Save Data
❌ Send Email
❌ Print Data

Too many responsibilities.

-------------------------------------------------------------------------------

After SRP

User
✔ Store data

UserRepository
✔ Save data

EmailService
✔ Send email

UserPrinter
✔ Print data

Each class has ONE responsibility.

-------------------------------------------------------------------------------

Interview Question

Q: Why is this design better?

Answer:

Because every class has only one responsibility.
A change in the database, email, or printing logic
will not affect the User class.

This follows the Single Responsibility Principle.

===============================================================================
*/