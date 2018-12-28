package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.KsDAO;
import com.dao.StuDAO;
import com.model.Ks;
import com.model.Stu;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class KsAction extends ActionSupport {
	private int id;
	private int sid;
	private String names;
	private String message;
	private String path;
	private int index = 1;

	private KsDAO dao;

	public String add() {
		Ks bean = new Ks();
		bean.setNames(names);
		dao.save(bean);
		this.setMessage("添加成功");
		this.setPath("ksmana.action");
		return "succeed";
	}

	public String mana() {
		List list = dao.findAll(names);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());//
		p.setData(adminListFenye);//
		p.setPath("ksmana.action");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}

	public String modifybefore() {
		Ks bean = dao.findById(id);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("bean", bean);
		return ActionSupport.SUCCESS;
	}

	public String modify() {
		Ks bean = dao.findById(id);
		bean.setNames(names);
		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("ksmana.action");
		return "succeed";
	}

	public String del() {
		dao.delete(dao.findById(id));
		this.setMessage("删除成功");
		this.setPath("ksmana.action");
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

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public KsDAO getDao() {
		return dao;
	}

	public void setDao(KsDAO dao) {
		this.dao = dao;
	}

}
