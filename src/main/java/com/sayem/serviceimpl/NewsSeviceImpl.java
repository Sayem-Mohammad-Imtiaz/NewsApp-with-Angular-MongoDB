package com.sayem.serviceimpl;

import com.sayem.dao.NewsDao;
import com.sayem.dao.SequenceDao;
import com.sayem.model.News;
import com.sayem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sayem on 2/12/2017.
 */
@Service
public class NewsSeviceImpl implements NewsService {
    @Autowired
    NewsDao newsDao;
    @Autowired
    protected SequenceDao sequenceDao;

    @Override
    public boolean saveNews(News news) {
        news.setId(sequenceDao.getNextSequence("news"));
        return newsDao.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsDao.getAll();
    }
}
