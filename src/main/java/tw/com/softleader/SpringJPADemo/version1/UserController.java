package tw.com.softleader.SpringJPADemo.version1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

// 因為要使用 RESTful，需要使用 @RESTful 這一個，否則無法使用 Mapping
@RestController
//這個其實不太重要
@RequestMapping("/usersVesion1")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @Operation(summary = "查詢全部")
    @GetMapping
    public Collection<User> getAll(){
        return userService.getAll();
    }

    @Operation(summary = "查詢一筆資料")
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") long id){
        return userService.findOne(id);
    }

    @Operation(summary = "建立新資料")
    @PostMapping
    public long createUser (@RequestBody User user){
        return userService.creatUser(user);
    }

    @Operation(summary = "修改資料")
    @PutMapping("/{id}")
    public User modifyUser(@PathVariable("id") long id, @RequestBody User user){
        return userService.modifyUser(id, user);
    }

    @Operation(summary = "刪除資料")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }
}
