package com.example.demo.controllers;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rest/v1") // to get localhost8080/rest / see your getMapping functions. rest = entities.
public class UserController {


    @Autowired
    UserService userService;
/*
C - @PostMapping
R - @GetMapping
U - @PutMapping
D - @DeleteMapping
*/
/*
node express
app.get("/rest/hello-world"), (req, res) => {
res.send('Hello World')}
 */
/*
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
 */

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id){
        return userService.findById(id);
    }

    // /rest/v1/users = get all users
    // /rest/v1/users?name=Elsa = get users named Elsa.

    @GetMapping("/users") //rest/v1/users?name=Olof
    public List<User> getUserWithName(@RequestParam(required = false) String name){ // can use more @RequestParam in same.
    return userService.findUsers(name);
    }


    //what an json object looks like.
    /*
    {
    "name": "sven",
    "age": 8
    }
     */

    // create more objects with postman for instance.

    @PostMapping("/users")
    public User createNewUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable String id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }


    // some beginning examples of how to do it.
    @GetMapping("/hello-world")
    public String helloWorld(){
    return "Hello World";
    }

    @GetMapping("/greeting")
    public String greeting(){
        return "Another greeting from Spring";
    }

    @GetMapping("/log")
    public String login(){
        return "Another test at this";
    }

}
// No logic in the controller, we only listen for calls in this class. Directs to the service
// instead that have the logic.