package exceptions;

//Custom exception
public class DuplicatedDependencyFoundException extends Exception {
    public DuplicatedDependencyFoundException(){
        super("Dependency already exists");
    }
}
