# Spring : JPA 範例檔案

此次內容包含兩種 DAO 的設計  :
- 使用 @Repository 的 annotation
- 使用 JpaRepository interface 介面，便添加 H2 DB 資料庫

以及相關 swagger 設定


---
## 注意事項 :

> - 新增 openapi 的依賴，可以執行 swagger (hocalhost:8080/swagger-ui.html)，方便針對 api 進行操作
> - 新增 h2 DB 的依賴，並在 application.properties 進行相關設定，可以在網頁直接開啟 DB (localhost:8080/h2-console)
