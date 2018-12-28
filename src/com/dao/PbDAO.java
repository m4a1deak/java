package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Ks;
import com.model.Pb;
import com.model.Users;

/**
 * Data access object (DAO) for domain model class TAdmin.
 * 
 * @see com.model.TAdmin
 * @author MyEclipse Persistence Tools
 */

public class PbDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(PbDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Pb transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Pb persistentInstance) {
		log.debug("deleting TAdmin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Pb findById(java.lang.Integer id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			Pb instance = (Pb) getHibernateTemplate().get("com.model.Pb", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Users findUsersById(java.lang.Integer id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			Users instance = (Users) getHibernateTemplate().get("com.model.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public List findAllUsers() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Users ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	

	public List findAll() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Pb ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAll(String names) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Pb as model where 1=1 ";
			if(names!=null&&!names.equals("")){
				queryString+=" and model.realname like '%"+names+"%'";
			}
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllD(String names) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Pb as model where 1=1 and states='排班' ";
			if(names!=null&&!names.equals("")){
				queryString+=" and model.realname like '%"+names+"%'";
			}
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllD2(String id) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Pb as model where 1=1 and model.uid="+id+" and states='排班' ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllKq(String names,String btimes,String etimes) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Pb as model where 1=1 and states<>'排班' ";
			if(names!=null&&!names.equals("")){
				queryString+=" and model.realname like '%"+names+"%'";
			}
			if(btimes!=null&&!btimes.equals("")){
				queryString+=" and model.times >='"+btimes+"'";
			}
			if(etimes!=null&&!etimes.equals("")){
				queryString+=" and model.times <='"+etimes+"'";
			}
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllKq2(String id,String btimes,String etimes) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Pb as model where 1=1 and model.id="+id;
			if(btimes!=null&&!btimes.equals("")){
				queryString+=" and model.times >='"+btimes+"'";
			}
			if(etimes!=null&&!etimes.equals("")){
				queryString+=" and model.times <='"+etimes+"'";
			}
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}


	public Pb merge(Pb detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			Pb result = (Pb) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public static PbDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PbDAO) ctx.getBean("PbDAO");
	}
}