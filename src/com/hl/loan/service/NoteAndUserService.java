package com.hl.loan.service;

import java.util.List;
import com.hl.loan.pojo.NoteAndUser;
import com.hl.loan.util.PageModel;

public interface NoteAndUserService {

	public void addNote(NoteAndUser nau);

	public List<NoteAndUser> getNoteByUser(int userId);
	
	public PageModel<NoteAndUser> showNoteAndUser(PageModel<NoteAndUser> pm, NoteAndUser noteAndUser);
	
	public List<NoteAndUser> getAllNoteAndUser();
	
	public NoteAndUser getNoteAndUserById(String id);
	
	public List<NoteAndUser> getNoteAndUserByStatus(int status);
	
	public void delNoteAndUser(NoteAndUser noteAndUser);
	
	public NoteAndUser getNoteByUser(int userId, int status);
}
