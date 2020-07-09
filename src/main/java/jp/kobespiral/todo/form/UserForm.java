package jp.kobespiral.todo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import jp.kobespiral.todo.dto.UserDto;
import lombok.Data;

@Data
public class UserForm {
    @Pattern(regexp = "[0-9a-zA-Z]+")
    private String uid;

    @NotBlank
    private String name;

    public static UserForm toForm(UserDto user) {
        UserForm userForm = new UserForm();
        userForm.setUid(user.getUid());
        userForm.setName(user.getName());
        return userForm;
    }
}