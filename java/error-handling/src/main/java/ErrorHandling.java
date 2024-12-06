import java.io.IOException;
import java.util.Optional;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException("This is the detail message.");
    }

    void handleErrorByThrowingAnyCheckedException() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws IOException {
        throw new IOException("This is the detail message.");
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new ArithmeticException("This is the detail message.");
    }

    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException {
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        Optional<Integer> integerOptional;
        try {
            integerOptional = Optional.of(Integer.valueOf(integer));
        } catch (NumberFormatException e) {
            integerOptional = Optional.empty();
        }
        return integerOptional;
    }

}
