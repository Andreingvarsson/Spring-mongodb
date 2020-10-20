package com.example.demo.services;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    // Acting as a constructor, but running after construct instead of first.
    // Spring related injections finished like @Autowired etc.
    @PostConstruct
    public void initUsers(){
      //  createUser(new User("Moa", 37));
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User createUser(User user){
        return userRepo.save(user);
    }

    public User findById(String id) {
        return userRepo.findById(id).orElse(new User("No user found", 0)); //orElse() = wont save in database just send a returnmessage of "no user found".
    }

    public List<User> findUsers(String name) {
       List<User> users;

    if(name == null){
        users = getAllUsers();
    }else{
        users = userRepo.findByNameOrderByAgeDesc(name);
    }
    return users;
    }

    public String updateUser(String id, User user) {
        // look for user in DB
        var userFromDB = userRepo.findById(id);

        // if there's no user, return error.
        if(userFromDB.isEmpty()){ // isPresent() checks if it exists. isEmpty checks if its empty.
            return "user does not exist";
        }
        user.setId(id);
        // save() will update if an id is present.
        userRepo.save(user);

        return "Success!";
    }

    public String deleteUser(String id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return "OK!";
        }else{
            return "Not OK!";
        }
    }
}
