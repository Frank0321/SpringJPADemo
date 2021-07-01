package tw.com.softleader.SpringJpaVersion3;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/version3")
@RequiredArgsConstructor
public class UserController {

    //ref : https://spring.io/projects/spring-data
    final UserService userService;

    @Operation(summary = "查詢全部")
    @GetMapping
    public Collection<User> getAll(){
        return userService.getAll();
    }

    @Operation(summary = "查詢一筆資料", parameters = {@Parameter(
            in = ParameterIn.PATH, name = "id", required = true, description = "請輸入 id",
            allowEmptyValue = false, allowReserved = true
    )})
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") long id){
        return userService.findOne(id);
    }

    @Operation(summary = "建立新資料", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "要建議新的資料內容", required = true,
            content = {@Content(mediaType = APPLICATION_JSON_VALUE, schema = @Schema(implementation = User.class, accessMode = Schema.AccessMode.READ_WRITE))}
    ))
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
