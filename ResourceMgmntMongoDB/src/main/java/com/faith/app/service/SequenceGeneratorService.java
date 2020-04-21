package com.faith.app.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.faith.app.model.DatabaseSequence;

@Service
public class SequenceGeneratorService implements ISequenceGenerator {

	@Autowired
	MongoOperations mongoOperations;

	// method to create sequence
	public long generateSequence(String seqName) {

		// creating sequence
		DatabaseSequence counter = mongoOperations.findAndModify(
				// get sequence id
				query(where("_id").is(seqName)),
				// increase sequence id by 1
				new Update().inc("seq", 1),
				// return new increased id
				options().returnNew(true).upsert(true), DatabaseSequence.class);

		// if null returns 1 or new sequence id return
		return !Objects.isNull(counter) ? counter.getSeq() : 1;
	}
}
