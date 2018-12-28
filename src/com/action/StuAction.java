package com.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.StuDAO;
import com.model.Czjl;
import com.model.Sfbz;
import com.model.Sjjl;
import com.model.Stu;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class StuAction extends ActionSupport {
	private int id;
	private int sid;
	private String username;
	private String password;
	private String newpwd;
	private String stuno;
	private String cardno;
	private String cardpassword;
	private String realname;
	private String tel;
	private double ye;
	private String cardstates;
	private String sc;
	private String message;
	private String path;

	private int index = 1;

	private StuDAO dao;

	public String add() {
		Stu bean = new Stu();
		bean.setCardno(cardno);
		bean.setCardpassword(cardpassword);
		bean.setCardstates("正常");
		bean.setPassword(password);
		bean.setRealname(realname);
		bean.setSc("0");
		bean.setStuno(stuno);
		bean.setTel(tel);
		bean.setUsername(username);
		bean.setYe(0);
		dao.save(bean);
		this.setMessage("添加成功");
		this.setPath("stumana.action");
		return "succeed";
	}


	public String mana() {
		List list = dao.findAll(stuno,cardno,realname);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();// 
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());// 
		p.setData(adminListFenye);// 
		p.setPath("stumana.action");// 

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	public String czjlmana() {
		List list = dao.findAllCzjl(sid);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();// 
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());// 
		p.setData(adminListFenye);// 
		p.setPath("stumana.action");// 

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		request.put("sid", sid);
		return ActionSupport.SUCCESS;
	}
	
	public String sjjlmana() {
		List list = dao.findAllSjjl(sid);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();// 
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());// 
		p.setData(adminListFenye);// 
		p.setPath("stumana.action");// 

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		request.put("sid", sid);
		return ActionSupport.SUCCESS;
	}
	
	
	public String stucardmana() {
		List list = dao.findAll(stuno,cardno,realname);
		int pageSize = 10;
		int fromIndex = (index - 1) * pageSize;
		int toIndex = Math.min(fromIndex + pageSize, list.size());
		List adminListFenye = list.subList(fromIndex, toIndex);

		Pagination p = new Pagination();// 
		p.setIndex(index);//
		p.setPageSize(pageSize);
		p.setTotle(list.size());// 
		p.setData(adminListFenye);// 
		p.setPath("cardmana.action");// 

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("page", p);
		return ActionSupport.SUCCESS;
	}
	
	
	public String modifybefore() {
		Stu bean = dao.findById(id);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("bean", bean);
		return ActionSupport.SUCCESS;
	}
	
	
	public String stucx() {
		Stu bean = dao.findById(id);
		bean.setCardstates("撤销");
		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("stucardmana.action");
		return "succeed";
	}
	
	public String stuqy() {
		Stu bean = dao.findById(id);
		bean.setCardstates("正常");
		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("stucardmana.action");
		return "succeed";
	}
	
	public String stucz() {
		Stu bean = dao.findById(id);
		double hasjine = bean.getYe();
		double tar = hasjine+ye;
		bean.setYe(tar);
		dao.merge(bean);
		//充值记录
		Czjl bean2 = new Czjl();
		bean2.setJine(ye);
		bean2.setSid(id);
		bean2.setTimes(new Date());
		dao.saveCzjl(bean2);
		this.setMessage("操作成功");
		this.setPath("stucardmana.action");
		return "succeed";
	}
	public String stucardpwdupdate() {
		
		Map session = ServletActionContext.getContext().getSession();
		Stu bean = (Stu) session.get("admin");
		String oldpwd = bean.getCardpassword();
		if(!oldpwd.equals(password)){
			this.setMessage("原密码错误");
		}else{
			bean.setCardpassword(newpwd);
			dao.merge(bean);
			this.setMessage("操作成功");
		}
		this.setPath("/admin/updatecardpwd.jsp");
		return "succeed";
	}
	
	public String modify() {
		Stu bean = dao.findById(id);
		bean.setCardpassword(cardpassword);
		bean.setPassword(password);
		bean.setRealname(realname);
		bean.setTel(tel);
		dao.merge(bean);
		this.setMessage("操作成功");
		this.setPath("stumana.action");
		return "succeed";
	}
	/**
	 * 上机开始
	 * @return
	 */
	public String sjbegin() {
		
		Map session = ServletActionContext.getContext().getSession();
		Stu stu = (Stu) session.get("admin");
		System.out.println("#####################################################");
		Sjjl bean = new Sjjl();
		bean.setBtimes(new Date());
		bean.setSid(stu.getId());
		dao.saveSjjl(bean);
		this.setMessage("操作成功");
		this.setPath("stumana.action");
		return "succeed";
	}
	/**
	 * 上机结束
	 * @return
	 */
	public String sjend() {
		Map session = ServletActionContext.getContext().getSession();
		Stu stu = (Stu) session.get("admin");
		int sid = stu.getId();
		List list = dao.findAllSjjl(sid);
		Sjjl bean = (Sjjl)list.get(0);
		Date now  = new Date();
		long chaju = now.getTime()-bean.getBtimes().getTime();
		System.out.println("chaju====  "+chaju);
		long miao =chaju/1000;
		System.out.println("miao====  "+miao);
		List sfbzlist = dao.findAllSfbz();
		Sfbz sfbz = (Sfbz)sfbzlist.get(0);
		double xf = sfbz.getJine()*miao;
		System.out.println("sfbz.getJine()====  "+sfbz.getJine());
		System.out.println("xf====  "+xf);
		bean.setEtimes(now);
		bean.setJine(xf);
		dao.mergeSjjl(bean);
		//余额减少
		double myye = stu.getYe();
		double mynowye = myye-xf;
		stu.setYe(mynowye);
		dao.mergeStu(stu);
		session.put("admin", stu);
		this.setMessage("操作成功");
		this.setPath("stumana.action");
		return "succeed";
	}
	
	
	public String del() {
		dao.delete(dao.findById(id));
		this.setMessage("删除成功");
		this.setPath("stumana.action");
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

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardpassword() {
		return cardpassword;
	}

	public void setCardpassword(String cardpassword) {
		this.cardpassword = cardpassword;
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

	public double getYe() {
		return ye;
	}

	public void setYe(double ye) {
		this.ye = ye;
	}

	public String getCardstates() {
		return cardstates;
	}

	public void setCardstates(String cardstates) {
		this.cardstates = cardstates;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public StuDAO getDao() {
		return dao;
	}

	public void setDao(StuDAO dao) {
		this.dao = dao;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}

}
