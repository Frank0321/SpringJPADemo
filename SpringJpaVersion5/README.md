# VERSION5 內容


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
<!-- Mapper 的依賴 -->
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct</artifactId>
  <version>${mapstruct.version}</version>
</dependency>
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct-processor</artifactId>
  <version>${mapstruct.version}</version>
  <scope>provided</scope>
</dependency>
```

## 整體流程
1. 以 Controller 為對外的入口，實際要執行的內容轉交給 Service
2. Service 為實際要處理的內容，本次內容以 CRUD 為主，因此 Service 為呼叫 DAO 執行 CRUD
3. DAO 為自己撰寫的 CURD 方法


## 介紹
- Controller

- Service

  - [JPA 使用 Specification 复杂查询和 Criteria 查询](https://blog.wuwii.com/jpa-specification.html)JPA 使用 Specification 复杂查询和 Criteria 查询
  - [Spring Data JPA使用Specification动态构建多表查询、复杂查询及排序示例](https://www.jianshu.com/p/659e9715d01d)
  
- Repository (DAO)
  - 繼承 Specification，並在 service 進行實作
  
- UserEntity 為物件

- Mapper
  - 介紹 : 在操作資料時，為了避免污染資料，或是保護資料，常會對於資料進行轉換
  - 常見的轉換方式 :
    - 相同資料格式進行轉換 (欄位名稱一樣)
    - 部分轉換 (VO)  
    - 不同欄位名稱進行轉換 (id -> policy_id)
    - Collection類型轉換
    - 多來源物件組合進行轉換
  - 使用的 dependency
    ```xml
    <mapstruct.version>1.4.2.Final</mapstruct.version>
    
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${mapstruct.version}</version>
    </dependency>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>${mapstruct.version}</version>
        <!-- -->
        <scope>provided</scope>
    </dependency>
    ```
  - 使用到的功能 :   
    - Mappers.getMapper : 自動生成的介面的實現可以通過 Mapper 的 class 物件獲取，從而讓客戶端可以訪問 Mapper 介面的實現
      - 範例寫法 : CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
    - @Mapping(source="source field name", target="target field name", expression=java(method))
      - source : 來源的欄位，對應抽象方法 input 參數名稱 + "." + 欄位
      - target : 欄位則表示目標物件的欄位名稱
      - expression : 會使用到 Java 寫的 method
      - qualifiedByName : 可以定義一個方法，額外處理數值
        ```java
        @Mapping(source = "pm25", target = "pm25", qualifiedByName = "formatDoubleDef")
        AreaVO areaPO2areaVO(AreaPO areaPO);
        
        @Named("formatDoubleDef")//需要與 qualifiedByName 的內部名稱一樣
        default Double formatDouble(Double source) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");//小数位格式化
            if (source == null) {
                source = 0.0;
            }
            return Double.parseDouble(decimalFormat.format(source));
        }
        ```
      - ignore : ignore = true，表示跳過該欄位
    - @Mappings({...}) : 將多個@Mapping設定包裝起來
    - mapstruct-processor (dependency) : 會自動生成轉換程式碼
      - 在 target 裡面的 Mapper 位置，會自動升成一個 Impl 的 class
    - @Mapper
      - componentModel = "spring" : 自動產生 Impl 的 class，則不需要 Mappers.getMapper 生成 Impl，但會延伸問題 3

  - 遇到問題 1 : java: package org.mapstruct does not exist
    - 解決方法 : 好像不能直接把 version 寫在 dependency 裡面 ?!

  - 遇到問題 2 : Internal error in the mapping processor: java.lang.NullPointerException
  - Mapper 使用的版本在 1.4.1.Final(如 1.3.1.Final) 以下時，可能會發生
    Internal error in the mapping processor: java.lang.NullPointerException，
    - 解決方法 :
      - 將 Mapper dependency 版本設為 1.4.1.Final
      - 在 Complier 的 User-local build process... 中，新增 -Djps.track.ap.dependencies=false
      - [升級版本](https://www.cnblogs.com/viaisi/p/14103878.html)
      - [stackoverflow 解決方法](https://stackoverflow.com/questions/65112406/intellij-idea-mapstruct-java-internal-error-in-the-mapping-processor-java-lang)
  ![image](https://i.stack.imgur.com/QyDMc.png)
      
   - 遇到問題 3 : Could not autowire. No beans of 'xxxxMapper' type found.
     - 當 @Mapper 註解改使用 @Mapper(componentModel = "spring")，則可以需要使用 Mapper 的地方用 @Autowired 注入
     - 但在注入的時候，會跳出 Could not autowire. No beans of 'xxxxMapper' type found. 的問題
     - 解決方法 : 在 mapstruct-processor 的 dependency 底下新增 <scope>provided</scope>，因此整個 dependency 為
       ```xml
       <dependency>
          <groupId>org.mapstruct</groupId>
          <artifactId>mapstruct-processor</artifactId>
          <version>${mapstruct.version}</version>
          <scope>provided</scope>
       </dependency>
       ```
  
  - [昕力 MapStruct 介紹](https://www.tpisoftware.com/tpu/articleDetails/2443) 
  - [昕力 MapStruct sourceCode](https://github.com/memory-0318/sandbox/tree/master/0003_MapStructDemo)  
  - [Mappers.getMapper 說明](https://www.itread01.com/content/1559145662.html)
  - [Mapper 延伸(深)介紹](https://stackoverflow.com/questions/52755301/mapstruct-to-update-values-without-overwriting)
  - [@Mapper(componentModel = "spring") 用法](https://www.jianshu.com/p/cc761b64fedb)
  - [mapstruct test could not autowire](https://stackoverflow.com/questions/53389578/mapstruct-test-could-not-autowire-in-springboot-test)
  - [MapStruct - Using expression](https://www.tutorialspoint.com/mapstruct/mapstruct_using_expression.htm)
  - [use java code instead of mapstruct expression stackoverflow](https://stackoverflow.com/questions/67908244/use-java-code-instead-of-mapstruct-expression)
  - [Ignoring Specific Fields](https://www.baeldung.com/mapstruct-ignore-unmapped-properties)
  - [mapstruct的用法-qualifiedByName](https://blog.csdn.net/u010002184/article/details/85253900)
  - [interface 中，撰寫實作方法](https://www.cnblogs.com/virgosnail/p/10111075.html)
## 補充 :
- @Getter and @Setter 的訪問級別 (AccessLevel)
  - 常見的訪問級別 : PUBLIC、PROTECTED、PACKAGE、PRIVATE、MODULE、NONE
  - 範例 : @Setter(value = AccessLevel.MODULE)
  - MODULE 和 PACKAGE 差別 : 好像沒差 ?!
    - [MODULE 和 PACKAGE 差異 from stackoverfloww](https://stackoverflow.com/questions/47339716/what-is-the-difference-between-accesslevel-package-and-accesslevel-module)
  - AccessLevel.NONE : 手動禁用任何欄位的 getter/setter 生成，並覆蓋類上的@Getter，@Setter或@Data註釋的行為
    - [AccessLevel.NONE 解釋 ](https://www.gushiciku.cn/pl/poFU/zh-tw)
  
- VO 的介紹
