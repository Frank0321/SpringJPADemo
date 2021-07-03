# VERSION2 內容
使用 JpaRepository interface 介面設計 DAO，以及添加 H2 DB 資料庫

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
  - @RequiredArgsConstructor : 生成一個包含 final 變量的建構子
  - Page<T> 用法 : 參考範例程式

- DAO (interface)
  - 使用 JpaRepository (interface) 進行操作
  - 使用到 JpaRepository 時，同時也需要建置一個實體的資料庫 (Entity)，因此需要將物件改成 Entity，並標註 @Entity

- UserEntity 為物件
    - 為整個系統傳遞的資料

- application.properties
  - 修改 port 
  - 顯示 H2
    - spring.h2.console.enabled 必須設為 true 開啟 web console 功能
  - 設定 H2
    - 注意 Spring Boot 2.3.0 開始 spring.datasource.generate-unique-name 預設為 true，
      因此H2資料庫名稱是亂數產生，不再為預設的 testdb，
      所以設定 spring.datasource.url=jdbc:h2:mem:testdb 指定資料庫名稱為 testdb

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
  