package com.example.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewsController {

    // Khi truy cập vào http://localhost:8080/news-test
    @GetMapping("/news-test")
    public String testLayout() {
        return "news/list"; // Đường dẫn đến file templates/news/list.html [cite: 69, 87, 88]
    }
}