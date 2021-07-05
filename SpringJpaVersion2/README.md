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
  - 讀取參數的方式有三種 : @RequestParam、@PathVariable、@RequestBody
  - @RequestParam : 會在網址後面面多一個名稱與問號
    - http://localhost:8082/version2/findById?id=10
  - @PathVariable : 直接連載網址後面
    - http://localhost:8082/version2/50
  - @RequestBody : 類似用 post 的方式傳入參數
    - http://localhost:8082/version2
  <br></br>
      
- 依賴注入
  - 使用 @Autowired 標記可以將該類別的物件載入進來，正式的說法是「注入」（inject）。
    若以 Windows 作業系統來比喻注入，就像是對檔案「建立捷徑」。
    捷徑能放到不同資料夾，而資料夾中的捷徑都指向同一個檔案實體。
  - 常見的依賴注入可分為三種 : 變量注入、建構子注入、set 方法注入
  - 變量注入 : UserServiceAutowired.java
    - 較為精簡，但不能明確指定依賴
  ```java
  // 變量 (file) 注入
    @Autowired
    UserRepository userRepository;
  ```
  <br>
  
  - 建構子注入 : UserServiceConstructor.java
    - 已經顯示註明必須強制注入
    - 常會搭配 class 標註為 @Service、@RestController 等方式，
      省略 @Autowired ，並搭配 @RequiredArgsConstructor 來完成注入
  ```java
    //Constructor 注入
    final UserRepository userRepository;

    @Autowired
    public UserServiceConstructor(UserRepository userRepository){
        this.userRepository = userRepository;
    }
  ```    
  <br>
  
  - set 方法注入 : UserServiceSetter.java
    - 已經顯示註明必須強制注入
    - 實際上較少見
  ```java
    //sest方法注入
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }
  ```
  <br>
  
  - [元件的運用與交互關係，元件的注入](https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-bean-introduction.html)
  - [三種注入的方式介紹](https://blog.csdn.net/zhangjingao/article/details/81094529)  
  <br></br>
- Service
  - @RequiredArgsConstructor : 生成一個包含 final 變量的建構子
  - Page<T> 用法 : 參考範例程式，常使用到三個參數 :
    - root 用來定義跟哪個欄位比對
    - query : top level query 通常用不到，先忽略
    - criteriaBuilder 用來定義 where 的比對條件，如 eq、lt、gt 之類的
  - 修改資料的流程 : 
    - 需要在資料庫內找到待修改的資料
    - 將資料進行更新
    - 更新完之後，重新存回資料庫
  <br></br>

- DAO (interface)
  - 使用到 JPA dependency 的時候，會自動配置 DataSource，否則會 :
    org.springframework.boot.autoconfigure.jdbc.DataSourceProperties$DataSourceBeanCreationException，
  - 錯誤訊息如下
    - Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
    - Reason: Failed to determine a suitable driver class
  - 建議的解決方法如下 : 
    - If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
    - If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).
  - 最快的解決方法 : 
    - 添加 H2 DB 的 dependency
  - [baeldung 解決方法](https://www.baeldung.com/spring-boot-failed-to-configure-data-source)
  - [stackoverflow 解決方法](https://stackoverflow.com/questions/24074749/spring-boot-cannot-determine-embedded-database-driver-class-for-database-type)
  <br></br>
  - 找尋一筆資料的方式可分成 : findById、getOne、findOne 這三種
  - findById() : 會立刻訪問資料庫，回傳指定 ID 的實體物件(Optional<T>)，如果沒有資料則回傳 Optional.empty()
  - getOne() : 是一個延遲加載的方法，並不會立刻訪問資料庫，而是回傳一個代理對象，
    只有當代理對象訪問屬性時，才會連線資料庫，找不到則會回傳一個 EntityNotFoundException
  - findOne() : 用於動態購艦多條件查詢的場景中，為立即連線資料庫，並回傳 Optional 的物件
  - Optional 物件，需處理 null 的問題，常見的處理方式為添加 orElse() 如範例 : 
    - userRepository.findById(id).orElse(null)
  - 禁止使用 getOne()，需要使用到延遲加載時，才會使用到
  - [findById、getOne、findOne 的差異](https://www.cnblogs.com/ktgu/p/13772236.html)
  - [stackoverfloww 解釋 getOne & findOne](https://stackoverflow.com/questions/24482117/when-use-getone-and-findone-methods-spring-data-jpa)
  

- UserEntity 為物件
    - 為整個系統傳遞的資料
    - 標註 @Entity ，則會自動產生一個實體的資料庫
    - 標註為 Entity 之後，一定要有 @Id ，標明主鍵的欄位
    - 可使用 @GeneratedValue 自動依順序產生編號
  

- application.properties
  - 修改 port 
  - 顯示 H2
    - spring.h2.console.enabled 必須設為 true 開啟 web console 功能
  - 設定 H2
    - 注意 Spring Boot 2.3.0 開始 spring.datasource.generate-unique-name 預設為 true，
      因此H2資料庫名稱是亂數產生，不再為預設的 testdb，
      所以設定 spring.datasource.url=jdbc:h2:mem:testdb 指定資料庫名稱為 testdb
<br></br>
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
  
