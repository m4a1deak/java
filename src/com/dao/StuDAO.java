package com.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.Czjl;
import com.model.Sjjl;
import com.model.Stu;

/**
 * Data access object (DAO) for domain model class TAdmin.
 * 
 * @see com.model.TAdmin
 * @author MyEclipse Persistence Tools
 */

public class StuDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(StuDAO.class);

	protected void initDao() {
		// do nothing
	}

	public void save(Stu transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveCzjl(Czjl transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void saveSjjl(Sjjl transientInstance) {
		log.debug("saving TAdmin instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Stu persistentInstance) {
		log.debug("deleting TAdmin instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Stu findById(java.lang.Integer id) {
		log.debug("getting TAdmin instance with id: " + id);
		try {
			Stu instance = (Stu) getHibernateTemplate().get(
					"com.model.Stu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}



	public List findAll() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Stu ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAllSjjl(int sid) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Sjjl as model where model.sid="+sid+" order by id desc ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllSfbz() {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Sfbz as model where 1=1 order by model.id desc ";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	
	public List findAll(String stuno,String cardno,String realname) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Stu as model where 1=1 ";
			if(stuno!=null&&!stuno.equals("")){
				queryString+=" and stuno like '%"+stuno+"%'";
			}
			if(cardno!=null&&!cardno.equals("")){
				queryString+=" and cardno like '%"+cardno+"%'";
			}
			if(realname!=null&&!realname.equals("")){
				queryString+=" and realname like '%"+realname+"%'";
			}
				
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllCzjl(int sid) {
		log.debug("finding all TAdmin instances");
		try {
			String queryString = "from Czjl as model where 1=1 and model.sid="+sid;
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Stu merge(Stu detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			Stu result = (Stu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public Sjjl mergeSjjl(Sjjl detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			Sjjl result = (Sjjl) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	public Stu mergeStu(Stu detachedInstance) {
		log.debug("merging TAdmin instance");
		try {
			Stu result = (Stu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public static StuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StuDAO) ctx.getBean("StuDAO");
	}
}