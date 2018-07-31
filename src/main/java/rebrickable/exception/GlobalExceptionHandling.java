package rebrickable.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandling {

    // dont forget @ResponseBody to tell response that we're changing the body
    @ExceptionHandler(Exception.class)
    public @ResponseBody
    ExceptionPojo handleError(HttpServletRequest req, Exception ex) {
        System.out.println("Request: " + req.getRequestURL() + "raised " + ex);

        ExceptionPojo retVal = new ExceptionPojo(ex.getMessage(), 400);
        return retVal;
    }
}
