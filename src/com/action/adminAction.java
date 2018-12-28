package com.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.model.Stu;
import com.model.TAdmin;
import com.model.Users;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class adminAction extends ActionSupport {
	private int id;
	private String username;
	private String password;
	private String newpwd;
	private String message;
	private String path;

	private int index = 1;

	private TAdminDAO adminDAO;

	public String login() {
		String result = "";
		String sql = "from TAdmin where username=? and password=?";
		Object[] con = { username, password };
		List adminList = adminDAO.getHibernateTemplate().find(sql, con);
		if (adminList.size() != 0) {//
			Map session = ServletActionContext.getContext().getSession();
			TAdmin admin = (TAdmin) adminList.get(0);
			session.put("userType", 1);
			session.put("admin", admin);
			result = "yes";
		} else {
			 sql = "from Users where no=? and password=?";
			 adminList = adminDAO.getHibernateTemplate().find(sql, con);
			 if (adminList.size() != 0) {//
			 Map session = ServletActionContext.getContext().getSession();
			 Users admin = (Users) adminList.get(0);
			 session.put("userType", 2);
			 session.put("admin", admin);
			 result = "yes";
			 } else {
			result = "no";
			 }
		}
		return ActionSupport.SUCCESS;
	}

	public String loginout() {
		Map session = ServletActionContext.getContext().getSession();
		session.put("userType", "");
		session.put("admin", null);
		return ActionSupport.SUCCESS;
	}

	public String adminupdatepwd() {
		Map session = ServletActionContext.getContext().getSession();
		TAdmin admin = (TAdmin) session.get("admin");
		admin.setPassword(newpwd);
		adminDAO.merge(admin);
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("ok", "ok");
		return ActionSupport.SUCCESS;
	}

	public String adminupdatepwd2() {
		Map session = ServletActionContext.getContext().getSession();
		// Yg admin = (Yg) session.get("admin");
		// admin.setPassword(newpwd);
		// adminDAO.mergeYg(admin);
		// HttpServletRequest req = ServletActionContext.getRequest();
		// req.setAttribute("ok", "ok");
		return ActionSupport.SUCCESS;
	}

	public String adminAdd() {
		TAdmin admin = new TAdmin();

		adminDAO.save(admin);
		this.setMessage("添加成功");
		this.setPath("adminManage.action");
		return "succeed";
	}

	public String adminManage() {
		List adminList = adminDAO.findAll();
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("adminList", adminList);
		return ActionSupport.SUCCESS;
	}

	public String adminManageFenye() {
		List adminList = adminDAO.findAll();
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, adminList.size());
		List adminListFenye = adminList.subList(fromIndex, toIndex);

		Pagination p = new Pagination();//
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(adminList.size());//
		p.setData(adminListFenye);//
		p.setPath("adminManageFenye.action?");//

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}

	public String adminDel() {
		adminDAO.delete(adminDAO.findById(id));
		this.setMessage("删除成功");
		this.setPath("adminManage.action");
		return "succeed";
	}

	public TAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpwd() {
		return newpwd;
	}

	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}

}
