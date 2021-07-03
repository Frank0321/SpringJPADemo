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