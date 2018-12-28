package com.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

import com.dao.TAdminDAO;
import com.model.TAdmin;

public class loginService {
	private TAdminDAO adminDAO;

	public TAdminDAO getAdminDAO() {
		return adminDAO;
	}

	public void setAdminDAO(TAdminDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	public String login(String userName, String userPw, int userType) {
		System.out.println("userType" + userType);
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String result = "no";

		if (userType == 0)// ϵͳ����Ա��½
		{
			String sql = "from TAdmin where username=? and password=?";
			Object[] con = { userName, userPw };
			List adminList = adminDAO.getHibernateTemplate().find(sql, con);
			if (adminList.size() == 0) {
				result = "no";
			} else {
				WebContext ctx = WebContextFactory.get();
				HttpSession session = ctx.getSession();
				TAdmin admin = (TAdmin) adminList.get(0);
				session.setAttribute("userType", 0);
				session.setAttribute("admin", admin);
				result = "yes";
			}
		}
		if (userType == 1)// ��ʦ��½
		{

		}
		if (userType == 2)// ѧ���½
		{

		}
		return result;
	}

	public String adminPwEdit(String userPwNew) {
		System.out.println("DDDD");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebContext ctx = WebContextFactory.get();
		HttpSession session = ctx.getSession();

		TAdmin admin = (TAdmin) session.getAttribute("admin");
		admin.setPassword(userPwNew);

		adminDAO.getHibernateTemplate().update(admin);
		session.setAttribute("admin", admin);

		return "yes";
	}

	public String jiance(String userName) {
		System.out.println("DDDD");
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "from TUser where userName='" + userName + "'";
		List list = adminDAO.getHibernateTemplate().find(sql);
		if (list.size() > 0) {
			return "no";
		} else {
			return "yes";
		}
	}

}
