### 图书管理系统

### 技术选型

Servlet + Mybatis + Thymeleaf

### 项目功能

- 管理员
    - 登录
    - 登出
    - remember-me（待完善）
- 页面
    - 借阅管理（借阅列表）
    - 书籍管理（书籍列表）
    - 学生列表
- 图书
    - 归还书籍
    - 新增借阅
    - 新增书籍
    - 删除书籍
- 数据库表
    - 书籍信息表
      - int      bid
      - varchar  title
      - varchar  desc 
      - double   price
    - 借阅信息表
      - int      id
      - int      sid
      - int      bid
      - datetime time
    - 学生信息表
      - int      sid
      - varchar  name
      - varchar  sex
      - varchar  grade
    - 管理员信息表
      - int      id
      - varchar  username
      - varchar  nickname
      - varchar  password