package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Ks;

/**
 * Data access object (DAO) for domain model class TAdmin.
 * 
 * @see com.model.TAdmin
 * @author MyEclipse Persistence Tools
 */

public class KsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(KsDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Ks transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ks persistentInstance) {
		log.debug("deleting TAdmin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ks findById(java.lang.Integer id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			Ks instance = (Ks) getHibernateTemplate().get("com.model.Ks", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Ks ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll(String names) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Ks as model where 1=1 ";
			if(names!=null&&!names.equals("")){
				queryString+=" and model.names like '%"+names+"%'";
			}
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public Ks merge(Ks detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			Ks result = (Ks) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public static KsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (KsDAO) ctx.getBean("KsDAO");
	}
}