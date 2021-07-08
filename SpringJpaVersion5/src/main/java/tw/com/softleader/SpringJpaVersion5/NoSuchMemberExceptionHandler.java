package tw.com.softleader.SpringJpaVersion5;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoSuchMemberExceptionHandler {
    //可能有 RuntimeException 都會被抓起來
    @ExceptionHandler(RuntimeException.class)
    public Object exceptionHandler(RuntimeException e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
