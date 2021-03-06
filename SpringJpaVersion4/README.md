# VERSION4 內容
H2 DB 相關設定與 Entity 繼承關係等其他設定

## 主要檔案
- UserEntity  (父)
- TestEntity  (子)
- EmployEntity  (子)
- NewTableEntity  (修改名稱)
<br></br>  
- application.properties (設定)

## 介紹
- Entity 繼承關係
  - UserEntity 為主要的 Entity
  - EmployEntity extends UserEntity 時，
    並`有標註 @Entity` ，則會在 UserEntity 的資料庫中，
    新增 EmployEntity 所擁有的欄位 (employNo, employEmail)
  - TestEntity extends UserEntity 時，  
    並`沒有標註 @Entity` ，則不會新增欄位在 UserEntity 中。
  - @Builder 與 @SuperBuilder 
    - 當沒有繼承，可以使用 @Builder
    - 當有繼承關係時，使用 @Builder 時，專案在 Build 的時候，就會產生錯誤
    - [錯誤參考](https://github.com/projectlombok/lombok/issues/1401)
    - 解決方法 : 父類別與子類別都要使用 @SuperBuilder
    - [@SuperBuilder 用法](https://matthung0807.blogspot.com/2020/04/lombok-superbuilder-parent-builder.html)
- 修改 Entity 對應欄位的名稱 (@Column 內的參數)
  - name : name屬性定義了被標註欄位在資料庫表中所對應欄位的名稱。
  - unique : unique屬性表示該欄位是否為唯一標識，默認為false。如果表中有一個欄位需要唯一標識，則既可以使用該標記，也可以使用@Table標記中的@UniqueConstraint。
  - nullable : nullable屬性表示該欄位是否可以為null值，默認為true。
  - insertable : insertable屬性表示在使用「INSERT」腳本插入數據時，是否需要插入該欄位的值。
  - updatable : updatable屬性表示在使用「UPDATE」腳本插入數據時，是否需要更新該欄位的值。insertable和updatable屬性一般多用於只讀的屬性，例如主鍵和外鍵等。這些欄位的值通常是自動生成的。
  - columnDefinition : columnDefinition屬性表示創建表時，該欄位創建的SQL語句，一般用於通過Entity生成表定義時使用。（也就是說，如果DB中表已經建好，該屬性沒有必要使用。）
  - length : length屬性表示欄位的長度，當欄位的類型為varchar時，該屬性才有效，默認為255個字符。
  - precision和scale : precision屬性和scale屬性表示精度，當欄位類型為double時 :
    - precision表示數值的總長度
    - scale表示小數點所占的位數
- @Embedded 的用法

- @MappedSuperclass 的介紹
  - 抽出共用的屬性
  - 不是一個完整的實體類別，不會產生這一個 table，但屬性接反映到繼承的 entity 上
  - 標註 @MappedSuperclass 則不能再標註 @Entity (因為他不是 Entity)

- @SuperBuilder
  - 對於繼承父類別的子類別，若要建構父類別成員的方法，則需要使用 @SuperBuilder
  
- project : 
  - 不同 package 底下，只有繼承才可以使用 
  - 保護 AbstractEntity ，只有繼承該 class 才可以使用他的原件

  - [參考1](https://ithelp.ithome.com.tw/articles/10194906)
  - [@Column 參數](https://kknews.cc/zh-tw/code/2bv6v5y.html)
  - [@Column 參數，官方文件](https://docs.oracle.com/javaee/5/api/javax/persistence/Column.html)
  - [Hibernate中@Embedded和@Embeddable注解的使用](https://blog.csdn.net/lmy86263/article/details/52108130)
  - [@MappedSuperclass的作用](https://www.cnblogs.com/zouhong/p/13450688.html)
  - [Lombok 使用@SuperBuilder產生繼承類別的Builder](https://matthung0807.blogspot.com/2020/04/lombok-superbuilder-parent-builder.html)
  
## application.properties 的相關設定
- 資料庫相關設定 (H2 為範例)
  - spring.datasource.driver-class-name=org.h2.Driver
    - 設定為使用 H2 DB (有些時候可能會不只有一個DB)
  - spring.h2.console.enabled=true
    - 設定可以網頁上，開啟 H2 DB
  - spring.datasource.url=jdbc:h2:mem:spring-boot-demo
    - 固定 DB 連線的網址(url)
  - spring.jpa.show-sql=true
    - 啟動 spring 時，底下 console 會秀出 SQL 指令
  - spring.datasource.username=frank 
    - 設定帳號
   - spring.datasource.password=12345
     - 設定密碼
- 設定 connection pool
  - spring boot 2.x 之後，預計的連線池為 hikariCP 連線池
     - 位置在 
       spring-boot-starter-data-jpa -> 
       spring-boot-starter-jdbc ->
       HikariCP。
       使用 Maven helper 才能清楚看到目錄
  - hikariCP 相關依賴可參考官網的連結，常見的設定如下 : 
    - spring.datasource.hikari.minimum-idle=10                  
      - 最小空閒連線
    - spring.datasource.hikari.maximum-pool-size=20             
      - 最大連線數
    - spring.datasource.hikari.idle-timeout=500000              
      - 空閒連線超時時間，預設值600000（10分鐘）
    - spring.datasource.hikari.max-lifetime=540000              
      - 連線最大存活時間，不等於0且小於30秒
    - spring.datasource.hikari.connection-timeout=60000         
      - 連線超時時間：毫秒
    - spring.datasource.hikari.connection-test-query=SELECT 1   
      - 用於測試連線是否可用的查詢語句
  
    
  - [spring boot 預設連線池 菜鳥工程師](https://matthung0807.blogspot.com/2021/01/spring-boot-default-jdbc-connection-pool.html)
  - [Hikari的配置詳解](https://www.gushiciku.cn/pl/p44q/zh-tw)
  - [springBoot默认HikariDataSource配置](http://www.lanxinbase.com/?p=2482)
  - [HikariCP 官網介紹](https://github.com/brettwooldridge/HikariCP)
- 主鍵聲明
  - @Id : 聲明此屬性為主鍵
  - @GeneratedValue : 自動新增數值
  
- 關聯關係  
  - @OneToMany
  - @ManyToOne
  - @OneToOne
  - @JoinColumn
  - @ManyToMany
  - @JoinTable
  
## 突發錯誤
###  entities share the same JPA entity name
- 在檔案移動到內部資料夾時，可能因為先前建立的 target 的關係，導致會有 class 衝突，先用 maven clean 清除

### Object [id=null] was not of the specified subclass
- 一樣 maven clean
- 或是加上關聯性 
- [satckoverflow 解法(翻譯成中文)](https://www.coder.work/article/1332641)
- [satckoverflow 解法](https://stackoverflow.com/questions/43848721/wrongclassexception-object-id-null-was-not-of-the-specified-subclass)