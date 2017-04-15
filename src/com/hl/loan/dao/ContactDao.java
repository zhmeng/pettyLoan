package com.hl.loan.dao;

import java.util.List;
import com.hl.loan.pojo.Contact;
import com.hl.loan.util.PageModel;

public interface ContactDao {

	// 查出所有联系人
	public List<Contact> getAllContact();

	// 增加联系人
	public void addContact(Contact contact);

	public PageModel<Contact> showContact(PageModel<Contact> pm, Contact contact);
	
	// 根据ID删除联系人
	public int delContact(String contactID);
	
	// 根据ID修改联系人信息
	public int updateContactByID(String contactID, Contact contact);
	
	public Contact load(String contactID);
}
