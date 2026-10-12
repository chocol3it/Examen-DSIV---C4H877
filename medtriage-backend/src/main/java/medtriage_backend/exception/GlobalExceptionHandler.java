package medtriage_backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail manejarError(RuntimeException error) {
        ProblemDetail problema = ProblemDetail.forStatusAndDetail(
                HttpStatus.BAD_REQUEST, error.getMessage());
        problema.setTitle("Error en la solicitud");
        problema.setProperty("error", error.getClass().getSimpleName());
        return problema;
    }
}
