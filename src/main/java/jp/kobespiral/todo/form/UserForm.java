package jp.kobespiral.todo.form;

import java.util.Date;

import jp.kobespiral.todo.dto.UserDto;
import lombok.Data;

@Data
public class UserForm {
    private String uid;
    private String name;

    public static UserForm toForm(UserDto user) {
        UserForm userForm = new UserForm();
        userForm.setUid(user.getUid());
        userForm.setName(user.getName());
        return userForm;
    }
}