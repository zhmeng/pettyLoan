package com.hl.loan.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl.loan.dao.ContactDao;
import com.hl.loan.pojo.Contact;
import com.hl.loan.service.ContactService;
import com.hl.loan.util.PageModel;

@Service("contactDao")
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactDao contactDao;

	@Override
	public List<Contact> getAllContact() {
		return contactDao.getAllContact();
	}

	@Override
	public void addContact(Contact contact) {
		contactDao.addContact(contact);
	}

	@Override
	public PageModel<Contact> showContact(PageModel<Contact> pm, Contact contact) {
		return contactDao.showContact(pm, contact);
	}

	@Override
	public int delContact(String contactID) {
		int result = contactDao.delContact(contactID);
		return result;
	}

	@Override
	public int updateContactByID(String contactID, Contact contact) {
		int result = contactDao.updateContactByID(contactID, contact);
		return result;
	}

	@Override
	public Contact getContactByID(String contactID) {
		return contactDao.load(contactID);
	}
}
