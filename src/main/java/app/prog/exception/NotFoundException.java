package app.prog.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class NotFoundException {

    public ResponseEntity<String> throwNotFound () {

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Resource Not Found");
    }
}
