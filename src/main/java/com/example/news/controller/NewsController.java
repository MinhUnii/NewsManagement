package com.example.news.controller;

import com.example.news.entity.News;
import com.example.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/news") // Định nghĩa gốc URL là /news
public class NewsController {

    @Autowired
    private NewsService newsService;

    // 1. Trang danh sách tin tức: GET /news
    @GetMapping
    public String listNews(Model model) {
        List<News> list = newsService.getAllNews();
        model.addAttribute("newsList", list); // Đổ dữ liệu vào Model để Thymeleaf hứng
        return "news/list";
    }

    // 2. Trang chi tiết tin tức: GET /news/{id}
    @GetMapping("/{id}")
    public String viewDetail(@PathVariable("id") Long id, Model model) {
        News news = newsService.getNewsById(id);
        model.addAttribute("newsItem", news);
        return "news/detail";
    }
}