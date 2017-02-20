package com.sayem.dao;

/**
 * Created by sayem on 2/20/2017.
 */
public interface SequenceDao {
    Long getNextSequence(String collectionName);
}
