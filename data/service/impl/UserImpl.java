package com.trungphap.backend.service.impl;
import lombok.AllArgsConstructor;


import org.springframework.stereotype.Service;
import com.trungphap.backend.entity.User;
import com.trungphap.backend.repository.UserRepository;
import com.trungphap.backend.service.UserService;
import java.util.Optional;
import java.util.List;

@Service
@AllArgsConstructor

public class UserImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }
    @Override
    public User getUserById(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId); 
        return optionalUser.get();
    }
    @Override
    public List<User>getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    public User updateUser(User user) {
User existingUser = userRepository.findById(user.getId()).get();
existingUser.setFullname(user.getFullname());
existingUser.setEmail(user.getEmail());
existingUser.setPhone_number(user.getPhone_number());
existingUser.setAddress(user.getAddress());
existingUser.setPassword(user.getPassword());
existingUser.setCreated_at(user.getCreated_at());
existingUser.setUpdated_at(user.getUpdated_at());
existingUser.setDeleted(user.getDeleted());
User updatedUser = userRepository.save(existingUser);
return updatedUser;
}
@Override
public void deleteUser(Long userId){
    userRepository.deleteById(userId);
}

}