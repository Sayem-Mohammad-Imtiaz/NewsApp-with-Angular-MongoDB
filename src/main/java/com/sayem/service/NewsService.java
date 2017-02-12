package com.sayem.service;

import com.sayem.model.News;
import java.util.List;

/**
 * Created by sayem on 2/12/2017.
 */
public interface NewsService {
    boolean saveNews(News news);
    List<News> getAllNews();
}
