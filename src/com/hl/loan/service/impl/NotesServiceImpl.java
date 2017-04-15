package com.hl.loan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hl.loan.dao.NotesDao;
import com.hl.loan.pojo.Notes;
import com.hl.loan.service.NotesService;

@Service("notesService")
public class NotesServiceImpl implements NotesService {
	@Resource
	private NotesDao notesDao;

	@Override
	public int getlastNote(Long applyID) {
		return notesDao.getlastNote(applyID);
	}

	@Override
	public Notes getNotesByApplyID(Long applyID, int notClass) {
		return notesDao.getNotesByApplyID(applyID, notClass);
	}
	@Override
	public List<Notes> getOaNotes(Long applyID, int notClass){
		return notesDao.getOaNotes(applyID, notClass);
	}
}
