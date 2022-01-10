package com.gmail.kutilandrej.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HumanGlobalException {

  @ExceptionHandler
  public ResponseEntity<HumanIncorrectData> handleException(Exception exception) {
    HumanIncorrectData incorrectData = new HumanIncorrectData();
    incorrectData.setInfo(exception.getMessage());
    return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler
  public ResponseEntity<HumanIncorrectData> handleException(NoSuchHumanException exception) {
    HumanIncorrectData incorrectData = new HumanIncorrectData();
    incorrectData.setInfo(exception.getMessage());
    return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
  }
}
