# VERSION1 內容
以簡單的方式，撰寫 Spring Boot 的 CRUD



## 主要檔案
- user (物件)
- UserRepository (DAO)
- UserService (Service)
- UserController  (Controller)

## 使用的依賴 (dependency)
```xml
<!-- 新增 開啟 swagger 功能 ，網址為 : localhost:8081/swagger-ui.html-->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.9</version>
</dependency>
```

或是考慮使用 PostMan 進行 API 操作



## 整體流程

1. 以 Controller 為對外的入口，實際要執行的內容轉交給 Service
2. Service 為實際要處理的內容，本次內容以 CRUD 為主，因此 Service 為呼叫 DAO 執行 CRUD
3. DAO 為自己撰寫的 CURD 方法




## 介紹
- Controller
  - 使用 RESTful 的方式
  - 由於 CRUD 的操作無法直接用網頁進行，因此需要新增一個 swagger 的依賴，方便操作 CRUD
  - TODO : 補充 RESTful 介紹
  - [RESTful參考](https://tw.alphacamp.co/blog/rest-restful-api)
  
- Service

- Repository (DAO)
  - Repository : 習慣稱作為 DAO 
  - 以 class 的方式撰寫實際使用方法
  
- User 為物件
  - 為整個系統傳遞的資料



## 依賴注入
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
    //set 方法注入
    private UserRepository userRepository;
  
    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }
  ```
  <br>
  
- [元件的運用與交互關係，元件的注入](https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-bean-introduction.html)

- [三種注入的方式介紹](https://blog.csdn.net/zhangjingao/article/details/81094529)     



## RESTful

- Representational State Transfer 的縮寫，可譯為「具象狀態傳輸」
- 符合 REST 風格的網站架構可以稱為 RESTful
- 溝通的方法與規則 :
  - GET 讀取資源*
  - POST 新增資源*
  - PUT 替換資源*
  - PATCH 更換資源部分內容*
  - DELETE 刪除資源*
  - OPTIONS 回傳該資源所支援的所有 HTTP 請求方法
  - CONNECT 將連線請求轉換至 TCP/IP 隧道
- router : 路由器，負責幫每個資料封包 (packet) 選擇傳輸路徑，扮演類似交通指揮的角色。而本身 API 的功能，就是為了做資料傳輸
- 如何設計路由 : 們會採用一套 REST 的架構風格來設計路由，RESTful 的設計以「資源」為中心，再搭配 HTTP method 的動詞，以及 CRUD 等資料操作
  - 瀏覽全部資料：GET + 資源名稱
  - 瀏覽特定資料：GET + 資源名稱 + :id
  - 新增一筆資料：POST + 資源名稱
  - 修改特定資料：PUT + 資源名稱 + :id
  - 刪除特定資料：DELETE + 資源名稱 + :id



## annotation 介紹
- @Repository
  - 用法：使用者標註資料訪問層元件（Dao層） 
  - 作用：實現Dao訪問；將類識別為Bean，同時它將所標註的類中丟擲的資料訪問異常封裝為 Spring 的資料訪問異常型別。
- @Service
  - 用法：用於標註業務層元件(Service層)上 
  - 作用：標註於業務層元件上表示定義一個bean，自動根據所標註的元件名稱例項化一個首字母為小寫的bean。
- @PostConstruct : 當此 Java 被建立時，則自動執行該方法
- @RestController : 標記為 RESTFul 的 Controller，回傳 json/xml 類型的資料。等同於 @ResponseBody + @Controller
- @RequestMapping :
  - 用來對應請求的方法，標在 class 上面，表示根目錄。而常見的 CRUD 可以用 GetMapper 等方式取代
  - @GetMapping("/{id}") : @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  - @PostMapping : @RequestMapping(method = RequestMethod.POST)
  - @PutMapping("/{id}") : @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  - @DeleteMapping("/{id}") :@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
- @RequiredArgsConstructor : 生成一個包含 “特定參數” 的 constructor，特定參數指的是那些有加上 final 修飾詞的變量們



## 參考資料

- [annotation 參考資料](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/12317/)
- [annotation 參考資料](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/488347/)
- [五分鐘學會 Lombok 用法](https://kucw.github.io/blog/2020/3/java-lombok/)
