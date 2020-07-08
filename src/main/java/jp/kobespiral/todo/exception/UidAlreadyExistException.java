package jp.kobespiral.todo.exception;

import lombok.Data;

@Data
public class UidAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;// なにこれ珍百景

    public UidAlreadyExistException(String message) {
        super(message);
    }

}