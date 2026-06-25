package com.example.news.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "News") // Định nghĩa tên bảng dưới Database
@Data // Tự động sinh Getter, Setter, toString, equals, hashCode từ Lombok
@NoArgsConstructor // Tự động sinh Constructor không tham số (Bắt buộc cho JPA)
@AllArgsConstructor // Tự động sinh Constructor đầy đủ tham số
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng (Identity) trong SQL Server
    private Long id;

    @Column(nullable = false, length = 255) // Tiêu đề tin tức (Không được để trống)
    private String title;

    @Column(columnDefinition = "NVARCHAR(MAX)") // Tóm tắt ngắn gọn
    private String summary;

    @Column(columnDefinition = "NVARCHAR(MAX)", nullable = false) // Nội dung bài viết
    private String content;

    @Column(name = "created_date")
    private LocalDateTime createdDate; // Ngày tạo bài viết

    @Column(length = 50)
    private String status; // Trạng thái bài viết (Ví dụ: DRAFT, PUBLISHED)
}