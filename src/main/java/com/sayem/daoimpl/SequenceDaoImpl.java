package com.sayem.daoimpl;

import com.sayem.dao.SequenceDao;
import com.sayem.model.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by sayem on 2/20/2017.
 */
@Repository
public class SequenceDaoImpl implements SequenceDao {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Long getNextSequence(String collectionName) {
        Query query = new Query(Criteria.where("_id").is(collectionName));
        Update update = new Update();
        update.inc("next", 1);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);
        options.upsert(true);
        Sequence sequence = mongoTemplate.findAndModify(query, update, options, Sequence.class);
        if (sequence == null)
            throw new RuntimeException("Unable to get sequence id for key : " + collectionName);
        return sequence.getNext();
    }
}
