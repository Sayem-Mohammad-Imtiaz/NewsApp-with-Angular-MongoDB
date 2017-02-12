package com.sayem.daoimpl;

import com.sayem.dao.NewsDao;
import com.sayem.model.News;
import org.springframework.stereotype.Repository;

/**
 * Created by sayem on 2/12/2017.
 */
@Repository
public class NewsDaoImpl extends BaseDaoImpl<News> implements NewsDao<News> {
}
