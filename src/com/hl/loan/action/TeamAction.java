package com.hl.loan.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;

import com.hl.loan.pojo.Area;
import com.hl.loan.pojo.City;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.pojo.Team;
import com.hl.loan.service.CityService;
import com.hl.loan.service.RoleService;
import com.hl.loan.service.TeamService;
import com.hl.loan.util.PageModel;

@Namespace("/action/team")
@ResultPath("/")
public class TeamAction extends BaseAction{
	@Autowired
	private TeamService teamService;
	private Team team;
	private PageModel<Team> pm;



	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public PageModel<Team> getPm() {
		return pm;
	}

	public void setPm(PageModel<Team> pm) {
		this.pm = pm;
	}

	/*
	 * 按条件查找相应城市信息
	 */
	@Action(value="goTeamList", results={
			@Result(name="success",location="/SYS/SysTeam/sys_team.jsp")
	})
	public String teamList(){
		Team team=getTeam();
		PageModel<Team> pm=new PageModel<>();
		if(getPm()!=null){
			pm=getPm();
		}
		pm=teamService.showTeam(pm, team);
		this.getSession().setAttribute("pm", pm);
		this.getSession().setAttribute("team", team);
		return "success";	
	}
	
	/*// 跳转到修改城市页面
	 
	@Action(value="toUpdateTeam", results={
			@Result(name="success",location="/SYS/SysTeam/sys_update_team.jsp")
	})
	public String toUpdateTeam(){
		String teamID = this.getRequest().getParameter("teamID");
		List<Team> team = teamService.getTeamByID(teamID);
		this.getRequest().setAttribute("team", team);
		return "success";
	}
	
	
	// 修改城市信息
	 
	@Action(value="UpdateTeam")
	public void UpdateTeam(){
		String teamID= this.getRequest().getParameter("teamID");
		String teamName = this.getRequest().getParameter("teamName");
		Team team = new Team();
		team.setTeamID(teamID);
		team.setTeamName(teamName);
		int result= teamService.updateTeamByID(teamID, city);
		try {
			if(result == 1){
				writeResult(true, "修改成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 // 跳转到增加城市表页面
	 
		@Action(value="toAddCity", results={
				@Result(name="success",location="/SYS/SysCity/city_add.jsp")
		})
		public String toAddCity(){
			List<Area> areas = teamService.getAllArea();
			this.getRequest().setAttribute("areas", areas);
			return "success";
		}
		
		//* 添加城市信息
		 
		@Action(value="AddCity")
		public void AddCity(){
			String areaName= this.getRequest().getParameter("areaName");
			String cityID= this.getRequest().getParameter("cityID");
			String cityName = this.getRequest().getParameter("cityName");
			String cityState = this.getRequest().getParameter("cityState");
			City city = new City();
			city.setCityID(cityID);
			city.setCityName(cityName);
			city.setCityState(Integer.valueOf(cityState));
			city.setFather(areaName);
			teamService.addCity(city);
			try {
				writeResult(true, "保存成功！", this.getResponse());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	  
	 * 修改城市状态
	 
	@Action(value="deleCity")
	public void deleCity(){
		String cityID= this.getRequest().getParameter("cityID");
		int result = teamService.deleteCity(cityID);
		try {
			if(result == 1){
				writeResult(true, "删除成功！", this.getResponse());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/
	
}
