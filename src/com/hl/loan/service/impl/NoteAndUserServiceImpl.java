package com.hl.loan.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.hl.loan.dao.NoteAndUserDao;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.service.NoteAndUserService;
import com.hl.loan.util.PageModel;

@Service("noteAndUserService")
public class NoteAndUserServiceImpl implements NoteAndUserService {
	@Resource
	private NoteAndUserDao noteAndUserDao;

	@Override
	public void addNote(NoteAndUser nau) {
		noteAndUserDao.addNote(nau);
	}

	@Override
	public List<NoteAndUser> getNoteByUser(int userId) {
		return noteAndUserDao.getNoteByUser(userId);
	}

	@Override
	public PageModel<NoteAndUser> showNoteAndUser(PageModel<NoteAndUser> pm, NoteAndUser noteAndUser) {
		return noteAndUserDao.showNoteAndUser(pm, noteAndUser);
	}

	@Override
	public List<NoteAndUser> getAllNoteAndUser() {
		return noteAndUserDao.getAllNoteAndUser();
	}

	@Override
	public NoteAndUser getNoteAndUserById(String id) {
		return noteAndUserDao.getNoteAndUserById(id);
	}

	@Override
	public List<NoteAndUser> getNoteAndUserByStatus(int status) {
		return noteAndUserDao.getNoteAndUserByStatus(status);
	}

	@Override
	public void delNoteAndUser(NoteAndUser noteAndUser) {
		noteAndUserDao.delNoteAndUser(noteAndUser);
	}

	@Override
	public NoteAndUser getNoteByUser(int userId, int status) {
		return noteAndUserDao.getNoteByUser(userId, status);
	}
}