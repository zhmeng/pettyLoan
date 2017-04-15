package com.hl.loan.service;

import java.util.List;

import com.hl.loan.dao.BaseDao;
import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.pojo.Team;
import com.hl.loan.util.PageModel;



public interface TeamService {
	
	public PageModel<Team> showTeam(PageModel<Team> pm, Team team);

	// 根据ID查出 团队信息
	public List<Team> getTeamByID(String teamID);

	// 根据ID修改团队信息
	public int updateTeamByID(String teamID, Team team);

	// 增加团队信息
	public void addTeam(Team team);

	// 根据ID删除团队
	public int deleteTeam(String teamID);

}
