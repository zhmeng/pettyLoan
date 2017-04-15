package com.hl.loan.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.Contact;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.service.ContactService;
import com.hl.loan.util.PageModel;
import com.hl.loan.util.SystemSettings;
import com.hl.loan.vi.Buttons;

@Namespace("/action/contact")
@ResultPath("/")
public class ContactAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	
	SysUser sysUser = (SysUser) this.getRequest().getSession().getAttribute(SystemSettings.SESSION_USER);

	@Autowired
	private ContactService contactService;
	private Contact contact;
	private PageModel<Contact> pm;
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public PageModel<Contact> getPm() {
		return pm;
	}

	public void setPm(PageModel<Contact> pm) {
		this.pm = pm;
	}

	/*
	 * 按条件查找相应联系人信息
	 */
	@Action(value = "goContactList", results = { @Result(name = "success", location = "/contact/contact_list.jsp") })
	public String goProductList() {
		List<Buttons> blist=this.getUrlRight(1);//权限控制
		Contact contact = getContact();
		PageModel<Contact> pm = new PageModel<>();
		if (getPm() != null) {
			pm = getPm();
		}
		pm = contactService.showContact(pm, contact);
		this.getRequest().setAttribute("pm", pm);
		this.getRequest().setAttribute("product", contact);
		this.getRequest().setAttribute("blist", blist);
		return "success";
	}

	/*
	 * 跳转到添加联系人页面
	 */
	@Action(value = "toAddContact", results = { @Result(name = "success", location = "/contact/contact_add.jsp") })
	public String toAddContact() {
		this.getUrlRight(2);
		return "success";
	}

	/*
	 * 添加联系人信息
	 */
	@Action(value = "addContact")
	public void addContact() {
		String contactName = this.getRequest().getParameter("contactName");
		String contactPost = this.getRequest().getParameter("contactPost");
		String contactTel = this.getRequest().getParameter("contactTel");
		String contactEmail = this.getRequest().getParameter("contactEmail");
		String contactRemark = this.getRequest().getParameter("contactRemark");
		try {
			Contact contact = new Contact();
			contact.setContactName(contactName);
			contact.setContactPost(contactPost);
			contact.setContactTel(contactTel);
			contact.setContactEmail(contactEmail);
			contact.setContactRemark(contactRemark);
			contact.setCreateById(sysUser.getUserID().longValue());
			contact.setCreateTime(new Date());
			contactService.addContact(contact);
			writeResult(true, "保存成功！", this.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 根据ID删除联系人
	 */
	@Action(value = "delContact")
	public void delContact() {
		this.getUrlRight(4);
		String contactID = this.getRequest().getParameter("contactID");
		try {
			int result = contactService.delContact(contactID);
			if (result == 1) {
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 跳转到修改联系人页面
	@Action(value = "toUpdateContact", results = { @Result(name = "success", location = "/contact/contact_update.jsp") })
	public String toUpdateContact() {
		this.getUrlRight(8);//权限判断
		String contactID = this.getRequest().getParameter("contactID");
		Contact contact = contactService.getContactByID(contactID);
		this.getRequest().setAttribute("contact", contact);
		return "success";
	}

	// 修改联系人信息
	@Action(value = "updateContact")
	public void updateContact() {
		String contactID = this.getRequest().getParameter("contactID");
		String contactName = this.getRequest().getParameter("contactName");
		String contactPost = this.getRequest().getParameter("contactPost");
		String contactTel = this.getRequest().getParameter("contactTel");
		String contactEmail = this.getRequest().getParameter("contactEmail");
		String contactRemark = this.getRequest().getParameter("contactRemark");
		
		try {
			Contact contact = contactService.getContactByID(contactID);
			contact.setContactName(contactName);
			contact.setContactPost(contactPost);
			contact.setContactTel(contactTel);
			contact.setContactEmail(contactEmail);
			contact.setContactRemark(contactRemark);
			contact.setUpdateById(sysUser.getUserID().longValue());
			contact.setUpdateTime(new Date());
			int result = contactService.updateContactByID(contactID, contact);
			if (result == 1) {
				writeResult(true, "修改成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}