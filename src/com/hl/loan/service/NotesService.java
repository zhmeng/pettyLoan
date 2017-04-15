package com.hl.loan.service;

import java.util.List;

import com.hl.loan.pojo.Notes;

public interface NotesService {

	public int getlastNote(Long applyID);

	public Notes getNotesByApplyID(Long applyID, int notClass);

	public List<Notes> getOaNotes(Long applyID, int notClass);
}
