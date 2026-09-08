package com.zanguetsuinc.gasja_api.api.exceptionHandler;

import com.zanguetsuinc.gasja_api.domain.exceptions.BusinessException;
import com.zanguetsuinc.gasja_api.domain.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex){
        List<String> messages = ex.getBindingResult()
                .getFieldErrors()
                .stream().map(error -> error.getField() + ": " + error.getDefaultMessage())
                .toList();
        ErrorMessage errorMessage = new ErrorMessage(
                    OffsetDateTime.now(),
                400,
                "Erro de validação",
                messages
        );
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handelBusinessException(BusinessException ex){
        ErrorMessage errorMessage = new ErrorMessage(
                OffsetDateTime.now(),
                400,
                "Erro de negócio",
                List.of(ex.getMessage())
        );
        return ResponseEntity.badRequest().body(errorMessage);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotfoundException(ResourceNotFoundException ex){
        ErrorMessage errorMessage = new ErrorMessage(
                OffsetDateTime.now(),
                404,
                "Recurso não encontrado",
                List.of(ex.getMessage())
        );
        return ResponseEntity.status(404).body(errorMessage);
    }

}
