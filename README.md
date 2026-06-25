# Dự Án Quản Lý Tin Tức Nội Bộ - Spring Boot & Thymeleaf

## 🛠️ Công nghệ sử dụng
- Backend: Java Spring Boot (Spring Web, Spring Data JPA)
- Frontend: Thymeleaf Layout, Fragment & Bootstrap 5
- Database: MS SQL Server

## Hướng dẫn cài đặt và khởi chạy

### 1. Cấu hình Cơ sở dữ liệu
- Mở SQL Server và chạy toàn bộ nội dung file `script.sql` đính kèm để khởi tạo cấu trúc bảng và dữ liệu mẫu.
- Vào file `src/main/resources/application.properties`, chỉnh sửa lại `spring.datasource.username` và `spring.datasource.password` cho đúng với cấu hình máy của bạn.

### 2. Chạy ứng dụng
- Mở project bằng IntelliJ IDEA, đợi Maven tải xong các thư viện.
- Tìm file `NewsManagementApplication.java` và nhấn nút **Run**.
- Truy cập vào trình duyệt theo đường dẫn chính thức: `http://localhost:8080/news`