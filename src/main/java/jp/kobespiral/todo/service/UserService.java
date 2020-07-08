package jp.kobespiral.todo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.todo.dto.UserDto;
import jp.kobespiral.todo.entity.User;
import jp.kobespiral.todo.exception.UidAlreadyExistException;
import jp.kobespiral.todo.exception.UidNotYetExistException;
import jp.kobespiral.todo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // uidでとってくる
    public UserDto getUserById(String uid) {
        if (userRepository.findUserByNameLike(uid) == null) {
            throw new UidNotYetExistException("ユーザ名" + uid + "が存在しません");
        } else {
            return UserDto.toDtoFromEntity(userRepository.findUserByNameLike(uid));
        }

        // return UserDto.toDtoFromEntity(userRepository.findUserByNameLike(uid));

    }

    // 全部のユーザをとってくる
    public ArrayList<UserDto> getAllUsers() {
        Iterable<User> userList = userRepository.findAll();
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();
        for (User user : userList) {
            userDtoList.add(UserDto.toDtoFromEntity(user));
        }
        return userDtoList;
    }

    // userのクリエイト
    public UserDto createUser(UserDto userDto) {
        // 無かったらnullが返ってくる
        if (userRepository.findUserByNameLike(userDto.getName()) instanceof User) {
            throw new UidAlreadyExistException("ユーザ名が重複しています");
        } else {
            return UserDto.toDtoFromEntity(userRepository.save(User.toEntity(userDto)));
        }
        // return userRepository.save(User.toEntity(userDto));
        // return this.getUserById(userDto.getUid());
    }

}