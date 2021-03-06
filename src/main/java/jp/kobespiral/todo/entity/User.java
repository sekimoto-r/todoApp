package jp.kobespiral.todo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import jp.kobespiral.todo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "[0-9a-zA-Z]+")
    private String uid;

    @NotBlank
    private String name;

    private Date createdAt;

    public static User toEntity(UserDto userDto) {
        User user = new User();
        user.setUid(userDto.getUid());
        user.setName(userDto.getName());
        user.setCreatedAt(userDto.getCreatedAt());
        return user;
    }
}