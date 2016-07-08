package com.arabsoft.mySTKE.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import org.hibernate.criterion.Criterion;
import org.springframework.transaction.annotation.Transactional;

public interface IDao {

	public List findAll(Class paramClass);

	List<Object> findByCriteria(Class clazz, Criterion criteria);

	public List<Object> findByProprieties(Class clazz, Properties properties);
	
	public List findByPropriety(String clazz, String proprietyName, String value);
	public List findByPropriety(String clazz, String proprietyName1, String value1, String proprietyName2, String value2);
	
	public Object findById(Class clazz, Serializable id);
	
	public Object findLastObject(String clazz, String column);

	public Object get(Class paramClass, Serializable paramSerializable);

	public Object save(Object paramObject);

	@Transactional(readOnly = true)
	public Object remove(Object paramObject);

	public Object update(Object entity);

	public Object saveOrUpdate(Object entity);
	
	
	
}