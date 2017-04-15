package com.hl.loan.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hl.loan.dao.CityDao;
import com.hl.loan.dao.RoleDao;
import com.hl.loan.dao.impl.BaseDaoImpl;
import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.pojo.Team;
import com.hl.loan.service.CityService;
import com.hl.loan.service.RoleService;
import com.hl.loan.service.TeamService;
import com.hl.loan.util.PageModel;

@Service("teamDao")
public class TeamServiceImpl  implements TeamService{
	@Autowired
	private CityDao cityDao;

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
