package jp.kobespiral.todo.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import jp.kobespiral.todo.entity.User;
import lombok.Data;

@Data
public class UserDto {
    @Pattern(regexp = "[0-9a-zA-Z]+")
    private String uid;

    @NotBlank
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
    // UserDto userDto = new UserDto();
    // userDto.setUid(userForm.getUid());
    // userDto.setName(userForm.getName());
    // userDto.setCreatedAt(userForm.getCreatedAt());
    // return userDto;
    // }

}
