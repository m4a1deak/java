package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Ks;
import com.model.Users;

/**
 * Data access object (DAO) for domain model class TAdmin.
 * 
 * @see com.model.TAdmin
 * @author MyEclipse Persistence Tools
 */

public class UsersDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UsersDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Users transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Users persistentInstance) {
		log.debug("deleting TAdmin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.Integer id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			Users instance = (Users) getHibernateTemplate().get("com.model.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Ks findKsById(java.lang.Integer id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			Ks instance = (Ks) getHibernateTemplate().get("com.model.Ks", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findAllKs() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Ks ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public List findAll() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Users ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll(String names) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Users as model where 1=1 ";
			if(names!=null&&!names.equals("")){
				queryString+=" and model.realname like '%"+names+"%'";
			}
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public Users merge(Users detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			Users result = (Users) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public static UsersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UsersDAO) ctx.getBean("UsersDAO");
	}
}