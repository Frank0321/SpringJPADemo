# VERSION5 內容


## 主要檔案
- user (物件)
- UserRepository (DAO)
- UserService (Service)
- UserController  (Controller)
- application.properties (設定檔)
- banner.txt (起始圖示檔，娛樂用 ?!)

## 使用的依賴 (dependency)
```javascript
<!-- 新增 開啟 swagger 功能 ，網址為 : localhost:8081/swagger-ui.html-->
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
- Controller

- Service
  
- DAO (interface)

- UserEntity 為物件

- Mapper 
  - Mapper 使用的版本在 1.4.1.Final(如 1.3.1.Final) 以下時，可能會發生
    Internal error in the mapping processor: java.lang.NullPointerException，
    解決方法 :
    - 將 Mapper dependency 版本設為 1.4.1.Final
    - 在 Complier 的 User-local build process... 中，新增 -Djps.track.ap.dependencies=false
    - [升級版本](https://www.cnblogs.com/viaisi/p/14103878.html)
    - [stackoverflow 解決方法](https://stackoverflow.com/questions/65112406/intellij-idea-mapstruct-java-internal-error-in-the-mapping-processor-java-lang)
  ![image](https://i.stack.imgur.com/QyDMc.png)
  - Mapper dependency :
  ```xml
  <dependency>
      <groupId>org.mapstruct</groupId>
      <artifactId>mapstruct</artifactId>
      <version>1.4.1.Final</version>
  </dependency>
  <dependency>
      <groupId>org.mapstruct</groupId>
      <artifactId>mapstruct-processor</artifactId>
      <version>1.4.1.Final</version>
      <optional>true</optional>
  </dependency>
  ```

- application.properties

- banner.txt
  - 放置位置
    ```
    ├─main      
    │ ├─ java             
    │ ├─ resource      
    │ │ ├─ application.properties
    │ │ ├─ banner.txt
    ```
   - 將檔案放置此，就可以更換啟動的圖示 (好玩用) 
   - [圖案來源](https://www.bootschool.net/ascii-art)

-[Internal error in the mapping processor: java.lang.NullPointerException]()