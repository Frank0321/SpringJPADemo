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

## 新增的依賴
```shell script
    <!-- 新增 開啟 swagger 功能 -->
	<dependency>
		<groupId>org.springdoc</groupId>
		<artifactId>springdoc-openapi-ui</artifactId>
		<version>1.5.9</version>
	</dependency>
    
    <!-- 縮減 swagger 中 pageable 參數的設定功能 -->
	<dependency>
		<groupId>org.springdoc</groupId>
		<artifactId>springdoc-openapi-data-rest</artifactId>
		<version>1.5.9</version>
	</dependency>
    
    <!-- H2 DB -->
	<dependency>
		<groupId>com.h2database</groupId>
		<artifactId>h2</artifactId>
		<scope>runtime</scope>
	</dependency>
	
	<!-- jap 依賴 -->
	<!-- 新增 jpa 依賴後，一定要有 DB 的存在 (常用為 H2) -->
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
```


## 注意事項
1. 有使用到 DB 後，則需要
   - 使用到 @Entity
   -  標註 @Id、@GeneratedValue 在主鍵上

2. Repository : getById() 禁止使用
   - getOne()方法是懒加载的（lazy load）
   - 只有在实体类实际取值的时候才会去查询数据库。如果把查询出来的实体当结果返回，就很容易出现no session的错误，
     返回到上一层就不在事务中，session就会关闭，no session就应运而生啦。
   - 如果要使用的話，要如何使用 ?
   
   - [參考1](https://www.javacodemonk.com/difference-between-getone-and-findbyid-in-spring-data-jpa-3a96c3ff)
   - [參考2](https://www.wuzhongyue.com/2018/2018-08-19-spring-data-jpa-getone-nosession.html)


