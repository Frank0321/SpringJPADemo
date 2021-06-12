# Spring : JPA 範例檔案

此次內容包含 :
- versiov1 : 使用 @Repository 的 annotation 設定 DAO 
- version2 : 使用 JpaRepository interface 介面設計 DAO，以及添加 H2 DB 資料庫
- version3 : 以及相關 swagger 設定

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
> - 在網頁上開啟 H2 頁面

```shell script
spring.datasource.url=jdbc:h2:mem:0805dad6-46fe-47ac-bd27-56efb3b18a28
```
> - 固定 H2 的 JDBC URL

新增 `banner.txt` 新增位置如下
```
├─main      
│ ├─ java             
│ ├─ resource      
│ │ ├─ application.properties
│ │ ├─ banner.txt
```
> - 啟動時，會顯示 banner 的圖案


## 操作方式 
啟動 Spring 之後，
- 開啟 swagger 的方式
```shell script
http://localhost:8080/swagger-ui.html
```
- 開啟 swagger 的方式
```shell script
localhost:8080/h2-console
```

## 注意事項

