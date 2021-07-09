# Spring : JPA 範例檔案

此次內容包含 :
- version1 : 使用 @Repository 的 annotation 設定 DAO 
- version2 : 使用 JpaRepository interface 介面設計 DAO，以及添加 H2 DB 資料庫
- version3 : 以及相關 swagger 設定
- version4 : H2 DB 相關設定與 Entity 繼承關係
- version5 : 預計 Entity 與 request 與 response 中間新增一層物件，並使用 Mapper 進行轉換

## 環境相關設定
* Java 11
* H2 DB


## 共用設定

- 因為使用 RESTful 的方式操作 CRUD，因此皆會使用到 swagger 的方式進行操作


## 整組專案建置方法

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
    
## version2 介紹
- 撰寫 Spring boot 的 CRUD 例子，並新增 :
  - 添加實體資料庫(Entity)
  - JpaRepository
  - Controller 接收的參數形式
  - application.properties 的初步設定  

## version3 介紹
- 以 Spring boot 的 CRUD 例子上，新增 :
  - 添增在 swagger 上面的顯示註解
  - DAO 改成使用 interface 抽象方法撰寫
  - Controller 皆已 ResponseEntity 的方式回復 

## version4 介紹
- 以 Spring boot 的 CRUD 例子上，新增 :
  - 新增 Entity 的關係、Entity 的相關設定
  - DAO 改用 @query 來設計
  - H2 DB 在 application.properties 的設定
  - application.properties 的其他設定

## version5 介紹
- 以 Spring boot 的 CRUD 例子上，新增資料夾購 :
  - request -> dto -> entity
  - Entity -> dto -> response
  - Exception 處理  
- 解釋相關資訊
- [POJO、PO、DTO、VO、BO](https://hackmd.io/@MonsterLee/HJyAdgRBB)

## 參考資料
- [新手工程師程式教室](https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-create-project.html)
  - Spring boot 共 20 文章
- [十分鐘快速掌握 Markdown](https://wcc723.github.io/development/2019/11/23/ten-mins-learn-markdown/#%E5%AD%B8%E7%BF%92-Markdown)
- [Markdown 編輯方式，it邦](https://ithelp.ithome.com.tw/articles/10203758?sc=iThelpR)












    
   - [參考1](https://www.javacodemonk.com/difference-between-getone-and-findbyid-in-spring-data-jpa-3a96c3ff)
   - [參考2](https://www.wuzhongyue.com/2018/2018-08-19-spring-data-jpa-getone-nosession.html)

