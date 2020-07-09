package jp.kobespiral.todo.exception;

import lombok.Data;

@Data
public class UidNotYetExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;// なにこれ珍百景

    public UidNotYetExistException(String message) {
        super(message);
    }

}