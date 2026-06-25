package com.example.news.service;

import com.example.news.entity.News;
import java.util.List;

public interface NewsService {
    List<News> getAllNews();
    News getNewsById(Long id);
}