package jp.kobespiral.todo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jp.kobespiral.todo.dto.UserDto;
import jp.kobespiral.todo.form.UserForm;
import jp.kobespiral.todo.service.UserService;

@Controller
public class UserController {
    // /user POST: addUser(UserForm)
    // /user/uid GET: showUser(uid)
    // /user GET: showAllUser()
    @Autowired
    UserService userService;

    @GetMapping("/user/{uid}")
    // 該当すうIDから引っ張ってくる
    public String showUser(@PathVariable String uid, Model model) {
        UserDto p = userService.getUserById(uid);
        model.addAttribute("p", p);
        return "userinfo";
    }

    @GetMapping("/users")
    // //全部のユーザをとってくる
    public String showAllUsers(Model model) {
        List<UserDto> p = userService.getAllUsers();
        model.addAttribute("p", p);
        // for(UserDto userDto: userList){
        // UserForm p = UserForm.toForm(userDto);
        // model.addAttribute("ulist", p);
        // }
        return "alluserlist";

    }

    @PostMapping("/user")
    public String createUser(@Validated UserForm userForm, Model model) {
        Date now = new Date();
        UserDto userDto = new UserDto();
        userDto.setUid(userForm.getUid());
        userDto.setName(userForm.getName());
        userDto.setCreatedAt(now);
        // UserDto userDto = UserDto.toDtoFromForm(userForm);

        UserDto userDtoReturn = userService.createUser(userDto);

        model.addAttribute("uid", userDtoReturn.getUid());
        model.addAttribute("name", userDto.getName());
        model.addAttribute("createdAt", userDto.getCreatedAt());
        return "success";
    }

}