# 《搭建自己的私人邮件服务器》

## 1.完成后端部署

部署对应的yml文件，完成后端程序

## 2.下载hmailserver

https://www.hmailserver.com/download

### 注意事项：
1. 由于hmailserver是32位程序，如果mysql是64位，需要更改hmailserver\bin里的libmysql.dll为32位
2. mysql8.0后更新了身份认证插件，hmailserver刚好属于不兼容的程序，此时可以通过修改mysql用户账户的认证插件
```sql
-- 1. 切换到 mysql 数据库
USE mysql;

-- 2. 修改 root 用户的认证插件和密码（请将 '你的密码' 替换为实际密码）
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'yourpassword';

-- 3. 刷新权限，使更改立即生效
FLUSH PRIVILEGES;
```
这里只需要更改 root 和 yourpassword 即可

3. mysql8.4 以上版本不支持mysql_native_password
- **找到 MySQL 配置文件：** 文件通常名为 my.ini (Windows) 或 my.cnf (Linux/macOS)。
- **编辑配置文件：** 在 [mysqld] 这个章节下方，添加一行配置：
```ini
[mysqld]
mysql_native_password=ON
```
- **重启 MySQL 服务**
- **再次执行命令：**
```sql
-- 1. 切换到 mysql 数据库
USE mysql;

-- 2. 修改 root 用户的认证插件和密码（请将 '你的密码' 替换为实际密码）
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'yourpassword';

-- 3. 刷新权限，使更改立即生效
FLUSH PRIVILEGES;
```

## 3.配置hmailserver并测试
- **Domains 创建域名：** example.com
- **Domains/example.com/Accounts：** 创建用户 
- **Java测试邮件发送**
