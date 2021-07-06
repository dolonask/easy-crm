package kg.easy.easycrm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class WrongCredentials extends RuntimeException {

    public WrongCredentials(String message) {
        super(message);
    }
}
