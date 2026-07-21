/*

In this file you can find violation of Single Responsibility Principle.
You should refactor this file.
You can remove this file completely, because it will not be used during the evaluation of the solution.

*/
package solid;

class UserDataManager {

    public static void main(String[] args) {
        UserClass user = new UserClass("john_doe", "Password123");
        LoginClass loginClass = new LoginClass(user, new UserNameValidator(), new PasswordNameValidator());
        RegisterClass registerClass = new RegisterClass(user, new UserNameValidator(), new PasswordNameValidator());
        loginClass.loginUser();
        registerClass.registerUser();
    }
}

class UserClass {
    String username;
    String password;

    public UserClass(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

interface Validator {
    boolean validate(String string);
}

class UserNameValidator implements Validator {

    @Override
    public boolean validate(String string) {
        // Validate username (e.g., length, characters allowed)
        return string.length() >= 5 && string.matches("[a-zA-Z_0-9]+");
    }
}

class PasswordNameValidator implements Validator {

    @Override
    public boolean validate(String string) {
        // Validate username (e.g., length, characters allowed)
        return string.length() >= 8 && string.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
    }
}

class LoginClass {
    UserClass user;
    Validator userNameValidator;
    Validator passwordValidator;

    LoginClass(UserClass user, Validator userNameValidator, Validator passwordValidator) {
        this.user = user;
        this.userNameValidator = userNameValidator;
        this.passwordValidator = passwordValidator;
    }

    public void loginUser() {
        // Validate username and password
        if (userNameValidator.validate(user.username) && passwordValidator.validate(user.password)) {
            // Authenticate user
            System.out.println("User logged in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}

class RegisterClass {
    UserClass user;
    Validator userNameValidator;
    Validator passwordValidator;

    RegisterClass(UserClass user, Validator userNameValidator, Validator passwordValidator) {
        this.user = user;
        this.userNameValidator = userNameValidator;
        this.passwordValidator = passwordValidator;
    }

    public void registerUser() {
        // Validate username and password
        if (userNameValidator.validate(user.username) && passwordValidator.validate(user.password)) {
            // Register user in the database
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}