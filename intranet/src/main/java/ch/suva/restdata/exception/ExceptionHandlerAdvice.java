package ch.suva.restdata.exception;

import ch.suva.restdata.entities.Meldung;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.UUID;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {
    
    @ExceptionHandler({HttpMessageNotReadableException.class})
    protected ResponseEntity<Meldung> handleDateTimeParseException(HttpMessageNotReadableException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Meldung.builder()
                .meldungsId(UUID.randomUUID())
                .meldungsTyp(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .meldungsCode("restdata.httpMessageNotReadable")
                .message(request.getDescription(false) + ": "
                    + "Fehlerhaftes Datum: ".concat(ex.getMessage()))
                .build());
    }
    
    @ExceptionHandler({RuntimeException.class})
    protected ResponseEntity<Meldung> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(Meldung.builder()
                .meldungsId(UUID.randomUUID())
                .meldungsTyp(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .meldungsCode("restdata.runtime")
                .message(request.getDescription(false) + ": "
                    + "Laufzeitfehler: ".concat(ex.getMessage()))
                .build());
    }
}
