package com.example.news.service;

import com.example.news.entity.News;
import com.example.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll(); // Lấy toàn bộ danh sách tin
    }

    @Override
    public News getNewsById(Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bài viết với ID: " + id));
    }

    @Override
    public void saveNews(News news) {
        newsRepository.save(news); // JpaRepository tự động biết thêm mới hoặc update dựa vào id [cite: 138, 955]
    }

    @Override
    public void deleteNewsById(Long id) {
        newsRepository.deleteById(id); // Xóa theo khóa chính [cite: 138, 955]
    }
}