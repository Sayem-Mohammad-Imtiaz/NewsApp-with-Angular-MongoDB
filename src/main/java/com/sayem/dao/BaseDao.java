package com.sayem.dao;

import java.util.List;

/**
 * Created by sayem on 2/12/2017.
 */
public interface BaseDao<T> {
    boolean save(T t);
    List<T> getAll();
}
