# VERSION1 內容
以最簡單的方式，撰寫 Spring Boot 的 CRUD

## 主要檔案
- user (物件)
- UserRepository (DAO)
- UserService (Service)
- UserController  (Controller)

## 使用的依賴 (dependency)
```javascript
<!-- 新增 開啟 swagger 功能 ，網址為 : localhost:8081/swagger-ui.html-->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.9</version>
</dependency>
```

## 整體流程
1. 以 Controller 為對外的入口，實際要執行的內容轉交給 Service
2. Service 為實際要處理的內容，本次內容以 CRUD 為主，因此 Service 為呼叫 DAO 執行 CRUD
3. DAO 為自己撰寫的 CURD 方法


## 介紹
- Controller
  - 使用 RESTful 的方式
  - 由於 CRUD 的操作無法直接用網頁進行，因此需要新增一個 swagger 的依賴，方便操作 CRUD
  - [RESTful參考](https://tw.alphacamp.co/blog/rest-restful-api)
  
- Service

- DAO
  
- User 為物件
  - 為整個系統傳遞的資料
    
    
## annotation 介紹
- @Repository
  - 用法：使用者標註資料訪問層元件（Dao層） 
  - 作用：實現Dao訪問；將類識別為Bean，同時它將所標註的類中丟擲的資料訪問異常封裝為 Spring 的資料訪問異常型別。
- @Service
  - 用法：用於標註業務層元件(Service層)上 
  - 作用：標註於業務層元件上表示定義一個bean，自動根據所標註的元件名稱例項化一個首字母為小寫的bean。
- @PostConstruct
- @RestController
- @RequestMapping  
- @RequiredArgsConstructor

- [annotation 參考資料](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/12317/)
- [annotation 參考資料](https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/488347/)
