# Spring : JPA 範例檔案

此次內容包含 :
- 使用 @Repository 的 annotation 設定 DAO 
- 使用 JpaRepository interface 介面設計 DAO，以及添加 H2 DB 資料庫
- 以及相關 swagger 設定

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
	
    <!-- 加入 JUnit、Mockito -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
```

## 特殊設定
設定於 `application.properties`
```shell script
pring.h2.console.enabled=true
```
> - 在網頁上開啟 H2 葉面





## 注意事項 :

> - 新增 openapi 的依賴，可以執行 swagger (hocalhost:8080/swagger-ui.html)，方便針對 api 進行操作
> - 新增 h2 DB 的依賴，並在 application.properties 進行相關設定，可以在網頁直接開啟 DB (localhost:8080/h2-console)
