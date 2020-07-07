package jp.kobespiral.todo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.kobespiral.todo.dto.UserDto;
import jp.kobespiral.todo.entity.User;
import jp.kobespiral.todo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    //uidでとってくる
    public UserDto getUserById(String uid){
        
        return UserDto.toDtoFromEntity(userRepository.findUserByNameLike(uid));

    }   

    //全部のユーザをとってくる
    public ArrayList<UserDto> getAllUsers(){
        Iterable<User> userList = userRepository.findAll();
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();
        for(User user: userList){
            userDtoList.add(UserDto.toDtoFromEntity(user));
        }
        return userDtoList;
    }

    //userのクリエイト
    public UserDto createUser(UserDto userDto){
    
        return UserDto.toDtoFromEntity(userRepository.save(User.toEntity(userDto)));
        // return userRepository.save(User.toEntity(userDto));
        // return this.getUserById(userDto.getUid());
    }


}