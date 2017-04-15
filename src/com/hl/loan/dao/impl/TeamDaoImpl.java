package com.hl.loan.dao.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hl.loan.dao.CityDao;
import com.hl.loan.dao.TeamDao;
import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.Team;
import com.hl.loan.util.PageModel;

import org.hibernate.Query;

@Repository
public class TeamDaoImpl extends BaseDaoImpl<Team> implements TeamDao{

	@Override
	public PageModel<Team> showTeam(PageModel<Team> pm, Team team) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Team> getTeamByID(String teamID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateTeamByID(String teamID, Team team) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addTeam(Team team) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteTeam(String teamID) {
		// TODO Auto-generated method stub
		return 0;
	}


}
