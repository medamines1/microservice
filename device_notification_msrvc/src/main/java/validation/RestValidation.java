package validation;

import ReqNResp.ResponseModel;
import ReqNResp.response_status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.reflect.Array;
import java.util.Arrays;


@ControllerAdvice
@RestController
@Slf4j
public class RestValidation extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseModel> handleAllExceptions(Exception ex) {

        ResponseModel   exceptionResponse =
                new ResponseModel<>(response_status.fail,"general failure   ",ex.getMessage());
       log.error(Arrays.toString(ex.getStackTrace()) + "  \n" + ex.getMessage() + "\n" + ex.getCause()+ "\n" + ex.getLocalizedMessage() + "\n" + ex.getSuppressed() );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_ACCEPTABLE);
    }


}
