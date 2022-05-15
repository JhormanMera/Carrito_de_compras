package exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("El usuario no ha sido creado aún");
    }
}
