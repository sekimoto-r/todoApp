package jp.kobespiral.todo.dto;

import java.util.Date;

import jp.kobespiral.todo.entity.User;
import jp.kobespiral.todo.form.UserForm;
import lombok.Data;

@Data
public class UserDto {
    private String uid;
    private String name;
    private Date createdAt;


    public static UserDto toDtoFromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.setUid(user.getUid());
        userDto.setName(user.getName());
        userDto.setCreatedAt(user.getCreatedAt());
        return userDto;
    }

    // public static UserDto toDtoFromForm(UserForm userForm) {
    //     UserDto userDto = new UserDto();
    //     userDto.setUid(userForm.getUid());
    //     userDto.setName(userForm.getName());
    //     userDto.setCreatedAt(userForm.getCreatedAt());
    //     return userDto;
    // }

}
