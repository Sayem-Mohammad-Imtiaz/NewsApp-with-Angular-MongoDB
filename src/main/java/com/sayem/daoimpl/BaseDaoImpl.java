package com.sayem.daoimpl;

import com.sayem.dao.BaseDao;
import com.sayem.dao.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by sayem on 2/12/2017.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    @Autowired
    protected MongoTemplate mongoTemplate;

    protected Class<T> clazz;

    public BaseDaoImpl() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getClazz() {
        return clazz;
    }

    @Override
    public boolean save(T t) {
        boolean ret = true;
        try {
            mongoTemplate.save(t);
        } catch (Exception ex) {
            ex.printStackTrace();
            ret = false;
        }
        return ret;
    }

    @Override
    public List<T> getAll() {
        return mongoTemplate.findAll(this.getClazz());
    }
}
