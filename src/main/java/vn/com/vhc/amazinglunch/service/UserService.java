package vn.com.vhc.amazinglunch.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import vn.com.vhc.amazinglunch.entity.User;
import vn.com.vhc.amazinglunch.respository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final ModelMapper mapper;

    public List<User> ListAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(Integer user_id){
        return userRepository.findById(user_id);
    }
    public User save(User user_id){
        return userRepository.save(user_id);
    }
    public void deleteUserById(Integer user_id){
        userRepository.deleteById(user_id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
