package com.example.demo.repositories;
import com.example.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepo extends MongoRepository<User, String> {
    // @Query("") - Incase you need to create a completely new query that doesnt exist within Spring allready..

    // Best practice to use Optional when returning an optional from repository.
    // Optional<User> findByName(String id)

    // Optional is only required on single objects.
    List<User> findByName(String name); // was created in UserService and with alt shift enter ended up here.


    List<User> findAllByName(String name);

    List<User> findByNameOrderByAgeDesc(String name);

    // SQL - SELECT * FROM users WHERE name = $name ORDER BY age DESC
}


