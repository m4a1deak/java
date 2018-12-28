package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.KsDAO;
import com.dao.PbDAO;
import com.dao.StuDAO;
import com.dao.UsersDAO;
import com.model.Ks;
import com.model.Pb;
import com.model.Stu;
import com.model.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class PbAction extends ActionSupport {
	private int id;
	private String no;
	private String types;
	private String realname;
	private int uid;
	private Date times;
	private String states;
	private String btimes;
	private String etimes;
	private String message;
	private String path;
	private int index = 1;

	private PbDAO dao;

	public String add() {
		Pb bean = new Pb();
		Users users = dao.findUsersById(uid);
		bean.setNo(users.getNo());
		bean.setRealname(users.getRealname());
		bean.setStates("排班");
		bean.setTimes(times);
		bean.setUid(uid);
		dao.save(bean);
		this.setMessage("添加成功");
		this.setPath("pbmana.action");
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
		p.setPath("pbmana.action");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}

	public String dkqmana() {
		List list = dao.findAllD(realname);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());//
		p.setData(adminListFenye);//
		p.setPath("dkqmana.action");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	public String dkqmana2() {
		
		 Map session = ServletActionContext.getContext().getSession();
		 Users admin = (Users) session.get("admin");
		List list = dao.findAllD2(admin.getId()+"");
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());//
		p.setData(adminListFenye);//
		p.setPath("dkqmana2.action");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String kqmana() {
		List list = dao.findAllKq(realname,btimes,etimes);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());//
		p.setData(adminListFenye);//
		p.setPath("kqmana.action");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	public String kqmana2() {
		Map session = ServletActionContext.getContext().getSession();
		 Users admin = (Users) session.get("admin");
		List list = dao.findAllKq2(admin.getId()+"",btimes,etimes);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());//
		p.setData(adminListFenye);//
		p.setPath("kqmana2.action");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}


	
	
	
	public String modifybefore() {
		List list = dao.findAllUsers();
		Pb bean = dao.findById(id);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("bean", bean);
		request.put("list", list);
		return ActionSupport.SUCCESS;
	}
	
	public String addbefore() {
		List list = dao.findAllUsers();
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("list", list);
		return ActionSupport.SUCCESS;
	}

	public String modify() {
//		Pb bean = dao.findById(id);
//		bean.setKsid(ksid);
//		Ks ks = dao.findKsById(ksid);
//		bean.setKsnames(ks.getNames());
//		bean.setRealname(realname);
//		bean.setTel(tel);
//		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("pbmana.action");
		return "succeed";
	}
	
	public String kqadd() {
		if(types.equals("1")){
			states="出勤";
		}else{
			states="缺勤";
		}
		Pb bean = dao.findById(id);
		bean.setStates(states);
		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("dkqmana.action");
		return "succeed";
	}
	
	public String kqadd2() {
		if(types.equals("1")){
			states="出勤";
		}else{
			states="缺勤";
		}
		Pb bean = dao.findById(id);
		bean.setStates(states);
		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("dkqmana2.action");
		return "succeed";
	}
	
	

	public String del() {
		dao.delete(dao.findById(id));
		this.setMessage("删除成功");
		this.setPath("pbmana.action");
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getTimes() {
		return times;
	}

	public void setTimes(Date times) {
		this.times = times;
	}

	public String getStates() {
		return states;
	}

	public void setStates(String states) {
		this.states = states;
	}

	public PbDAO getDao() {
		return dao;
	}

	public void setDao(PbDAO dao) {
		this.dao = dao;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getBtimes() {
		return btimes;
	}

	public void setBtimes(String btimes) {
		this.btimes = btimes;
	}

	public String getEtimes() {
		return etimes;
	}

	public void setEtimes(String etimes) {
		this.etimes = etimes;
	}


}
