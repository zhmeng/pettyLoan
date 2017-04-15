package com.hl.loan.dao;

import java.util.List;

import com.hl.loan.pojo.Notes;

public interface NotesDao {

	public int getlastNote(Long applyID);

	public Notes getNotesByApplyID(Long applyID, int notClass);

	public List<Notes> getOaNotes(Long applyID, int notClass);
}
