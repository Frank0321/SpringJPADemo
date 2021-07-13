package tw.com.softleader.SpringJpaVersion2;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/version2")
@RequiredArgsConstructor
public class UserController {
    /**
     * https://matthung0807.blogspot.com/2018/08/spring-autowired.html
     */
    final UserService userService;

    @PostConstruct
    public void init(){
        for (int i = 1; i <= 1000; i++) {
            userService.save(UserEntity
                    .builder().name("name" + i).mail("email").phone("0987654321").build());
        }
    }
    @Operation(summary = "查詢全部資料，已分頁呈現")
    @GetMapping
    public Page<UserEntity> findAll(Pageable pageable){
        return userService.findAll(pageable);
    }
    @Operation(summary = "查詢單一筆資料")
    @GetMapping("/findById")
    public UserEntity findOne (@RequestParam(value = "id", required = false, defaultValue = "10") Long id){
        return userService.findById(id);
    }
    @Operation(summary = "以物件的 name 進行查詢，並以分頁呈現結果")
    @GetMapping("/by")
    public Page<UserEntity> getAllByCondition (UserEntity userEntity, Pageable pageable){
        return userService.getAllByCondition(userEntity, pageable);
    }
    @Operation(summary = "修改資料")
    @PutMapping("/{id}")
    public UserEntity modifyEmpoly (@PathVariable("id") Long id, @RequestBody UserEntity userEntity){
        return userService.modifyEmpoly(id, userEntity);
    }
    @Operation(summary = "新增一筆資料")
    @PostMapping
    public long creatEmpoly (@RequestBody UserEntity userEntity){
        return userService.creatEmpolyee(userEntity);
    }
    @Operation(summary = "刪除一筆資料")
    @DeleteMapping("/{id}")
    public void deleteEmpoly (@PathVariable("id") long id){
        userService.deleteEmpoly(id);
    }





}
