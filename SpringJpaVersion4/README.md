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
  - [參考1](https://ithelp.ithome.com.tw/articles/10194906)
  - [@Column 參數](https://kknews.cc/zh-tw/code/2bv6v5y.html)
  - [@Column 參數，官方文件](https://docs.oracle.com/javaee/5/api/javax/persistence/Column.html)
  
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
  