package jp.kobespiral.todo.controller;

import java.io.FileNotFoundException;
import org.springframework.http.HttpStatus;

import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import jp.kobespiral.todo.exception.UidAlreadyExistException;
import jp.kobespiral.todo.exception.UidNotYetExistException;

@ControllerAdvice
public class ToDoExceptionHandler {
    /**
     * NullPointerExceptionが発生した場合のエラー処理を行う
     * 
     * @param exception 発生した例外
     * @return NullPointerExceptionが発生した場合のエラー画面
     */
    @ExceptionHandler(NullPointerException.class)
    public String nullError(NullPointerException exception, Model model) {
        model.addAttribute("errMsg", exception);
        return "error_null";
    }

    /**
     * FileNotFoundExceptionが発生した場合のエラー処理を行う HttpStatus.NOT_FOUND(404)をステータスとして返す
     * 
     * @param exception 発生した例外
     * @return FileNotFoundExceptionが発生した場合のエラー画面
     */
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String noFileError(FileNotFoundException exception, Model model) {
        model.addAttribute("errMsg", exception.getMessage());
        return "error_no_file";
    }

    /**
     * 自作例外が発生した場合のエラー処理を行う
     * 
     * @param exception 発生した例外
     * @return HelloExceptionExceptionのエラー画面
     */
    @ExceptionHandler(UidAlreadyExistException.class)
    public String uidAlreadyExistException(UidAlreadyExistException exception, Model model) {
        model.addAttribute("errMsg", exception);
        return "error_uid_exist";
    }

    /**
     * 自作例外が発生した場合のエラー処理を行う
     * 
     * @param exception 発生した例外
     * @return HelloExceptionExceptionのエラー画面
     */
    @ExceptionHandler(UidNotYetExistException.class)
    public String uidNotYetExistException(UidNotYetExistException exception, Model model) {
        model.addAttribute("errMsg", exception);
        return "error_uid_not_exist";
    }

    /**
     * 上記以外の例外が発生した場合のエラー処理を行う
     *
     * @param exception 発生した例外
     * @return デフォルトのエラー画面
     */
    @ExceptionHandler(Exception.class)
    public String occurOtherException(Exception exception) {
        return "error";
    }

    /**
     * FormのValidationに対する例外処理 デフォルトではBindExceptionが発生する
     * 
     * @return 入力フォームのエラー画面
     */
    @ExceptionHandler(BindException.class)
    public String inputError(BindException exception, Model model) {
        model.addAttribute("errMsg", exception.getMessage());
        return "error_input";
    }

}