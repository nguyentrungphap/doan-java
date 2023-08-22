package com.trungphap.backend.service;
import java.util.List;

import com.trungphap.backend.entity.User;

public interface UserService {
    
    public User createUser(User user);
    public User getUserById(Long userId);
    public List<User> getAllUsers();
    public User updateUser(User user);
    public void deleteUser(Long userId);


}
