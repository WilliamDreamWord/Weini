package com.paopao.controller.common;


import com.paopao.common.JsonResponse;
import com.paopao.exception.ParamException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
@ResponseBody
public class ExceptionResolver extends ResponseEntityExceptionHandler {



    @ExceptionHandler(value=ParamException.class)
    public ResponseEntity<Object> handleParamException(Exception ex){


        JsonResponse responseBody = JsonResponse.createByErrorMsg(
                String.format("parameter error ：%s", ex.getMessage()));

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(responseBody, headers,  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value=RuntimeException.class)
    public ResponseEntity<Object> handleRuntionException(Exception ex){


        JsonResponse responseBody = JsonResponse.createByErrorMsg(
                String.format("system error ：%s", ex.getMessage()));

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(responseBody, headers,  HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value=Exception.class)
    public ResponseEntity<Object> handleOtherException(Exception ex){


        JsonResponse responseBody = JsonResponse.createByErrorMsg(
                String.format("system error ：%s", ex.getMessage()));

        HttpHeaders headers = new HttpHeaders();

        return new ResponseEntity<>(responseBody, headers,  HttpStatus.INTERNAL_SERVER_ERROR);
    }





    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body,
                                                             HttpHeaders headers,
                                                             HttpStatus status,
                                                             WebRequest request) {

        JsonResponse responseBody = JsonResponse.createByErrorMsg(
                String.format("other error ： %s", ex.getMessage()));


        return super.handleExceptionInternal(ex, responseBody, headers, status, request);
    }


}
