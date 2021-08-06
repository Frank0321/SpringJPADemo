# Spring : JPA 範例檔案

此次內容包含 :
- version1 : 使用 @Repository 的 annotation 設定 DAO，並利用 RESTful 的方式撰寫 CRUD
- version2 : 使用 JpaRepository interface 介面設計 DAO，以及添加 H2 DB 資料庫
- version3 : 以及相關 swagger 設定
- version4 : H2 DB 相關設定與 Entity 繼承關係
- version5 : 預計 Entity 與 request 與 response 中間新增一層物件，並使用 Mapper 進行轉換

## 環境相關設定
* Java 11
* H2 DB


## 共用設定
因為使用 RESTful 的方式操作 CRUD，為了方便進行測試，可以使用

### swagger

- 需要添增依賴
  ```xml
  <dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.9</version>
  </dependency>
  ```
- 然後再網址頁面後端輸入 /swagger-ui.html

- [OpenAPI 的官網](https://www.baeldung.com/spring-rest-openapi-documentation)
- [OpenAPI 的註解](https://springdoc.org/#migrating-from-springfox)
### Postman

- 可以使用網頁板，或是桌面板
- 輸入網址，及請求方式
- TODO ，補充操作方式，以及送 Requestbody 的方式  
  - [安裝介紹](https://ithelp.ithome.com.tw/articles/10201503)
  - [操作介紹](https://tw.alphacamp.co/blog/postman-api-tutorial-for-beginners)
  
### interlliJ 的 Open in HTTP Client
- 使用方法 : 
  1. 啟動專案
  2. 專案旁邊的按鈕，點下去
  3. 就可以模擬網頁輸入
  - 以 post 的方式輸入為(參考) : 
  ```xml
  POST http://example.com:8080/api/html/post 
  Content-Type: application/json 
  
  { "key" : "value", "list": [1, 2, 3] }
  ```
- [參考 1](https://www.jetbrains.com/help/idea/exploring-http-syntax.html#compose-several-requests-in-a-file)
- [參考 2](https://www.jetbrains.com/help/idea/http-client-in-product-code-editor.html)
- [參考 3](https://blog.jetbrains.com/idea/2020/09/at-your-request-use-the-http-client-in-intellij-idea-for-spring-boot-restful-web-services/)

## 整組專案建置方法
1. Project Settings -> Modules 
2. 點選 add -> import Module
3. 點選到下一層的專案 (pom.xml 的上一層)
4. 如果是 maven 專案就以 maven 的方式 import

## Java 物件導向程式設計原則 SOLID Design Principles
- Single Responsibility Principle (SRP) 單一職責原則
- Open/Closed Principle (OCP) 開放封閉原則
- Liskov Substitution Principle (LSP) 里氏替換原則
- Interface Segregation Principle (ISP) 介面隔立原則
- Dependency Inversion Principle (DIP) 依賴反轉原則
- [SOLID](https://matthung0807.blogspot.com/2019/08/java-solid-design-principles.html)

## version1 介紹
- 以簡單的例子，撰寫 Spring boot 的 CRUD 例子
- 會使用到 annotation 來區分各層級 : 
  - @Repository : DAO
  - @Service : Service
  - @RestController : Controller   

- 本章重點 :
  - RESTful 介紹
  - 依賴注入的方式
  - annotation 的介紹
    - @Repository
    - @Service
    - @PostConstruct
    - @RequestMapping 等相關
    
    
## version2 介紹
- 撰寫 Spring boot 的 CRUD 例子，並新增 :
  - 添加實體資料庫(Entity)
  - JpaRepository
  - Controller 接收的參數形式
  - application.properties 的初步設定  
  
- 本章重點 :
  - 常用的 dependency
  - Controller 接收參數的(3+1)模式，最後一種較少使用
  - JPA dependency 注意事項
  - findById、getOne、findOne 這三種比較
  - Entity 中 @Column 的介紹
  - application.properties 關於 H2 DB 簡單設定


## version3 介紹
- 以 Spring boot 的 CRUD 例子上，新增 :
  - 添增在 swagger 上面的顯示註解
  - DAO 改成使用 interface 抽象方法撰寫
  - Controller 皆已 ResponseEntity 的方式回復 

- 本章重點 :
  - Controller 使用 ResponseEntity 的方式傳送資料
  - Controller 用 @Operation 撰寫 swagger 上的註解
  - Repository 使用抽象方法撰寫 interface
  - 改使用 mariadb 設計 Entity


## version4 介紹
- 以 Spring boot 的 CRUD 例子上，新增 :
  - 新增 Entity 的關係、Entity 的相關設定
  - DAO 改用 @query 來設計
  - H2 DB 在 application.properties 的設定
  - application.properties 的其他設定
- 本章重點
  - application.properties 關於資料庫的相關設定
    - 含 hikari 設定 (gary 寫的第二章)
  - @Entity 的繼承關係
  - 統一修改 Entity 的設計方式
  - n + 1 selection 的問題
  - @query 撰寫 DAO 查詢的方式

## version5 介紹
- 以 Spring boot 的 CRUD 例子上，新增資料夾購 :
  - request -> dto -> entity
  - Entity -> dto -> response
  - Exception 處理  

- 本章重點 :
  - 介紹 MapStruct 的使用
  - 
- 解釋相關資訊
- [POJO、PO、DTO、VO、BO](https://hackmd.io/@MonsterLee/HJyAdgRBB)

## 參考資料
- [新手工程師程式教室](https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-create-project.html)
  - Spring boot 共 20 文章

   - [參考1](https://www.javacodemonk.com/difference-between-getone-and-findbyid-in-spring-data-jpa-3a96c3ff)
   - [參考2](https://www.wuzhongyue.com/2018/2018-08-19-spring-data-jpa-getone-nosession.html)

