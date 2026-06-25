package com.example.news.controller;

import com.example.news.entity.News;
import com.example.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    // 3. Hiển thị Form thêm mới: GET /news/add [cite: 397]
    @GetMapping("/add")
    public String showAddForm(Model model) {
        News news = new News(); // Tạo object rỗng để bọc vào Form [cite: 397]
        model.addAttribute("news", news);
        return "news/form"; // Trả về trang form [cite: 313]
    }

    // 4. Xử lý lưu Form (Cả Add và Edit): POST /news/save
    @PostMapping("/save")
    public String saveNews(@ModelAttribute("news") News news) {
        if (news.getId() == null) {
            // Nếu là bài mới thì tự động set thời gian hiện tại
            news.setCreatedDate(java.time.LocalDateTime.now());
        }
        newsService.saveNews(news); // Gọi tầng service lưu xuống DB
        return "redirect:/news"; // Lưu xong quay về trang danh sách
    }

    // 5. Hiển thị Form chỉnh sửa: GET /news/edit/{id}
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        News news = newsService.getNewsById(id); // Lấy dữ liệu bài cũ
        model.addAttribute("news", news); // Đổ ngược dữ liệu vào form
        return "news/form";
    }

    // 6. Xử lý Xóa bài viết: GET /news/delete/{id}
    @GetMapping("/delete/{id}")
    public String deleteNews(@PathVariable("id") Long id) {
        newsService.deleteNewsById(id); // Xóa trong DB
        return "redirect:/news"; // Quay lại trang danh sách
    }
}