package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.UsersDAO;
import com.model.Ks;
import com.model.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class UsersAction extends ActionSupport {
	private int id;
	private String no;
	private String realname;
	private String password;
	private String tel;
	private int ksid;
	private String ksnames;
	private String message;
	private String path;
	private int index = 1;

	private UsersDAO dao;

	public String add() {
		Users bean = new Users();
		bean.setKsid(ksid);
		Ks ks = dao.findKsById(ksid);
		bean.setKsnames(ks.getNames());
		bean.setNo(no);
		bean.setRealname(realname);
		bean.setPassword(password);
		bean.setTel(tel);
		dao.save(bean);
		this.setMessage("添加成功");
		this.setPath("usersmana.action");
		return "succeed";
	}

	public String mana() {
		List list = dao.findAll(realname);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());//
		p.setData(adminListFenye);//
		p.setPath("usersmana.action");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}

	public String modifybefore() {
		List list = dao.findAllKs();
		Users bean = dao.findById(id);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("bean", bean);
		request.put("list", list);
		return ActionSupport.SUCCESS;
	}
	
	public String addbefore() {
		List list = dao.findAllKs();
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("list", list);
		return ActionSupport.SUCCESS;
	}
	
	

	public String modify() {
		Users bean = dao.findById(id);
		bean.setKsid(ksid);
		Ks ks = dao.findKsById(ksid);
		bean.setKsnames(ks.getNames());
		bean.setRealname(realname);
		bean.setPassword(password);
		bean.setTel(tel);
		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("usersmana.action");
		return "succeed";
	}

	public String del() {
		dao.delete(dao.findById(id));
		this.setMessage("删除成功");
		this.setPath("usersmana.action");
		return "succeed";
	}

	public String getMessage() {
		return message;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getKsid() {
		return ksid;
	}

	public void setKsid(int ksid) {
		this.ksid = ksid;
	}

	public String getKsnames() {
		return ksnames;
	}

	public void setKsnames(String ksnames) {
		this.ksnames = ksnames;
	}

	public UsersDAO getDao() {
		return dao;
	}

	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
