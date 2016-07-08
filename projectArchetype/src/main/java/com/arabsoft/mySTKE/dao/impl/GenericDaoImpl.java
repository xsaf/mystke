package com.arabsoft.mySTKE.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.arabsoft.mySTKE.dao.IDao;

@Repository(value = "genericDao")
public class GenericDaoImpl implements IDao {

	final transient protected Log log = LogFactory.getLog(this.getClass());

	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings({ "rawtypes" })
	@Override
	public List findAll(Class clazz) {

		List l;
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from " + clazz.getName());
		;
		l = query.list();
		return l;
	}

	@SuppressWarnings({ "rawtypes" })
	public List findAll(Class clazz, boolean detached) {
		List l;
		Criteria criteres = sessionFactory.getCurrentSession().createCriteria(clazz);
		l = criteres.list();
		if (detached)
			for (Object o : l)
				sessionFactory.getCurrentSession().evict(o);
		return l;
	}

	public List findByCondition(Class clazz, Criterion critere) {
		List l;
		Criteria criteres = sessionFactory.getCurrentSession().createCriteria(clazz);
		criteres.add(critere);
		l = criteres.list();
		return l;
	}

	/*
	 * public T findById(ID id, Class<? extends T> clazz) { return (T)
	 * sessionFactory.getCurrentSession().get(clazz, id); }
	 */

	@SuppressWarnings({ "rawtypes" })
	public Object findById(Class clazz, Serializable id) {
		return sessionFactory.getCurrentSession().get(clazz, id);
	}

	public List findByPropriety(String clazz, String proprietyName, String value) {
		Query q = sessionFactory.getCurrentSession()
				.createQuery("FROM " + clazz + " WHERE " + proprietyName + " = " + value + " ");
		return q.list();
	}

	@Override
	public List<Object> findByCriteria(Class clazz, Criterion criteria) {
		Criteria q = sessionFactory.getCurrentSession().createCriteria(clazz.getName());
		q.add(criteria);
		return q.list();
	}

	public List<Object> findByProprieties(Class clazz, Properties properties) {
		String where = " 1 = 1 ";
		for (Object prop : properties.keySet()) {
			where += " and " + prop.toString() + " " + properties.get(prop);
		}

		Query q = sessionFactory.getCurrentSession()
				.createQuery("SELECT a from " + clazz.getName() + " a WHERE " + where);

		return q.list();
	}

	@Override
	public Object save(Object entity) {
		Session session = sessionFactory.getCurrentSession();
		session.save(entity);

		if (log.isDebugEnabled()) {
			log.debug("Entity created");
		}
		return entity;
	}

	@Override
	public Object update(Object entity) {

		sessionFactory.getCurrentSession().update(entity);
		if (log.isDebugEnabled()) {
			log.debug("Entity updated");
		}
		return entity;
	}

	@Override
	public Object saveOrUpdate(Object entity) throws DataAccessException {

		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		// sessionFactory.getCurrentSession().flush();

		return entity;
	}

	public void merge(Object entity) {
		sessionFactory.getCurrentSession().merge(entity);

	}

	@Override
	public Object get(Class paramClass, Serializable paramSerializable) {
		try {
			Session session = sessionFactory.getCurrentSession();
			return sessionFactory.getCurrentSession().get(paramClass, paramSerializable);

		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			return sessionFactory.getCurrentSession().load(paramClass, paramSerializable);
		} finally {
			// sessionFactory.getCurrentSession().getTransaction().commit();
		}

	}

	@Override
	public Object remove(Object entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
		return entity;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Object findLastObject(String clazz, String column) {
		Query q = sessionFactory.getCurrentSession().createQuery("from " + clazz + " order by " + column + " DESC");
		q.setMaxResults(1);
		return q.uniqueResult();
	}

	@Override
	public List findByPropriety(String clazz, String proprietyName1, String value1, String proprietyName2,
			String value2) {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM " + clazz + " WHERE " + proprietyName1 + " = "
				+ value1 + " and " + proprietyName2 + " = " + value2 + " ");
		return q.list();
	}

}
