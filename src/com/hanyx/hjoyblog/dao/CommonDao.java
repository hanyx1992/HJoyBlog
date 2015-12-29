package com.hanyx.hjoyblog.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public abstract class CommonDao<T> {

	
	private MongoTemplate mongoTemplate;

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}
	@Autowired
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public void save(T t) {
		this.mongoTemplate.save(t);
	}

	public T queryById(String id) {
		Query query = new Query();
		Criteria criteria = Criteria.where("_id").is(id);
		query.addCriteria(criteria);
		return this.mongoTemplate.findOne(query, this.getEntityClass());
	}

	public List<T> queryList(Query query) {
		return this.mongoTemplate.find(query, this.getEntityClass());
	}

	public T queryOne(Query query) {
		return this.mongoTemplate.findOne(query, this.getEntityClass());
	}

	public List<T> getPage(Query query, int start, int size) {
		query.skip(start);
		query.limit(size);
		List<T> lists = this.mongoTemplate.find(query, this.getEntityClass());
		return lists;
	}

	public Long getPageCount(Query query) {
		return this.mongoTemplate.count(query, this.getEntityClass());
	}

	public void deleteById(String id) {
		Criteria criteria = Criteria.where("_id").in(id);
		if (null != criteria) {
			Query query = new Query(criteria);
			if (null != query && this.queryOne(query) != null) {
				this.delete(query);
			}
		}
	}

	public void delete(Query query) {
		this.mongoTemplate.remove(query);
	}

	public void delete(T t) {
		this.mongoTemplate.remove(t);
	}

	public void updateFirst(Query query, Update update) {
		this.mongoTemplate.updateFirst(query, update, this.getEntityClass());
	}

	public void updateMulti(Query query, Update update) {
		this.mongoTemplate.updateMulti(query, update, this.getEntityClass());
	}

	public void updateInser(Query query, Update update) {
		this.mongoTemplate.upsert(query, update, this.getEntityClass());
	}

	protected abstract Class<T> getEntityClass();
}
