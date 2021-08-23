# VERSION3 內容


## 主要檔案
- user (物件)
- UserRepository (DAO)
- UserService (Service)
- UserController  (Controller)
- application.properties (設定檔)
- banner.txt (起始圖示檔，娛樂用 ?!)

## 使用的依賴 (dependency)
```javascript
<!-- 新增 開啟 swagger 功能 ，網址為 : localhost:8083/swagger-ui.html-->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.9</version>
</dependency>
<!-- JPA 依賴 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<!-- H2 DB -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
<!-- 縮減 swagger 中 pageable 參數的設定功能 -->
<dependency>
  <groupId>org.springdoc</groupId>
  <artifactId>springdoc-openapi-data-rest</artifactId>
  <version>1.5.9</version>
</dependency>
<!-- use @NotBlank annotation -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
  <version>2.4.1</version>
</dependency>
```

## 整體流程
1. 以 Controller 為對外的入口，實際要執行的內容轉交給 Service
2. Service 為實際要處理的內容，本次內容以 CRUD 為主，因此 Service 為呼叫 DAO 執行 CRUD
3. DAO 為自己撰寫的 CURD 方法



## 介紹

### Controller 

- 回傳資料皆以 ResponseEntity 的形式回傳
  - ResponseEntity : ??
- 使用 @Operation 的方式撰寫在 swaggeer 上的註解
  - summary : API 的標題
  - description : API 的詳細描述
  - [operation 說明](https://waynestalk.com/springdoc-openapi-tutorial/)



### Service



### Repository (DAO) 
- 除了 Repository 這一個 interface 所支援的的抽象方法之外，另外也可以自行撰寫簡單的查詢方法
- 由方法名稱撰寫查詢的方法
  - findBy .... And ...
  - 好像一次回傳，就是傳回一個物件 ?! 或是一個 Collection<T>

- [Spring data JPA](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference)


### UserEntity 為物件 

- 改使用其他 DB 進行轉寫 (mariadb) 
- 新增資料驗證功能 (JSR-303)
  - 需要先加入驗證的 dependency
    ```xml
     <!-- 新增驗證功能 -->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-validation</artifactId>
          <version>2.4.1</version>
      </dependency>
    ```
  - 在欄位前面標註 @NotNull 等
  - 需要 import 的為 javax.validation.constraints
  - 在 import 中的 constraints，用 ctrl + 右鍵，可以進去看看有那些驗證的方法
  - @NotBlank 包含 @NotNull
  - 通常在 Controller 中進行驗證 (在範例的 PostMapping)
  - 在參數前方加上 @Valid 就可以了
  - 可以利用 BindingResult 將錯誤訊息列印出來
  - BindingResult 是用來保存驗證和綁定結果  
  
  - [BindingResult验证框架](https://blog.csdn.net/clypm/article/details/69382766)
  - [BindingResult 說明](https://geek-docs.com/spring/spring-tutorials/bindingresult.html)
- @Enumerated 的功能
  - 若使用的型別為 enum，則需要在 前面新增 @Enumerated(STRING) 否則只會存取數字
  ```Java
  public enum Rating {
    ONE, TWO, THREE, FOUR, FIVE
  }
  
  @Entity
  public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    //在 table 的欄位顯示為 0,1,2,3,4
    private Rating rating;
    ...
   }

  @Entity
  public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String message;
    //在 table 的欄位顯示為 ONE, TWO, THREE, FOUR, FIVE
    @Enumerated(EnumType.STRING)
    private Rating rating;
    ...
   }    

  ```
  - [參考資料](https://thorben-janssen.com/hibernate-enum-mappings/)    

### application.properties

- mariadb 需要注意的設定

### 修改時間格式
- 預設以 JSON 回傳的時間格式為 2021-08-06，是 ISO 的標準格式
- 希望回傳為其他的格式，則需要在 Spring 的啟動程式，加上 :
  ```java
  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
      return builder -> builder
              //修改回傳的時間格式
              .serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern("yyyy/MM/dd")))
              //修改傳入的時間格式
              .deserializers(new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy/MM/dd")));

  }
  ```
- [Spring boot 自定義隱式 json 反射程序](https://segmentfault.com/a/1190000010677072)
- [Jackson2ObjectMapperBuilderCustomizer stackoverflow](https://stackoverflow.com/questions/49237867/how-to-enable-global-default-typing-in-jackson-via-jackson2objectmapperbuilde)

### 修改啟動 Spring 顏色的方法



