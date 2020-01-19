## QQ社区

## 资料
[Spring 文档](https://spring.io/)

[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)

[ES社区](https://elasticsearch.cn/)

[BootStrap 文档](https://v3.bootcss.com/components/#navbar)

[GitHub OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

## 工具

##脚本
```sql
create table USER
(
  ID           INTEGER default (NEXT VALUE FOR PUBLIC.SYSTEM_SEQUENCE_03222B85_1AED_4E10_8B95_8AAB13A0DE72)
    primary key,
  ACCOUNT_ID   VARCHAR(100),
  NAME         VARCHAR(50),
  TOKEN        CHAR(36),
  GMT_CREATE   BIGINT,
  GMT_MODIFIED BIGINT
);
```