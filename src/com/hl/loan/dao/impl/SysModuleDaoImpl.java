package com.hl.loan.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.hl.loan.dao.SysModuleDao;
import com.hl.loan.pojo.SysModule;
import com.hl.loan.pojo.SysRole;
import com.hl.loan.pojo.SysUser;
import com.hl.loan.util.PageModel;

@Repository
public class SysModuleDaoImpl extends BaseDaoImpl<SysModule> implements SysModuleDao{
	@Override
	public List<SysModule> showAllModel(int ModFlag,SysUser sysUser){
		List<SysModule> pareList=new ArrayList<>();
		StringBuffer sb=new StringBuffer();  //from SysModule where ModFlag=? and ModMenuView=?
		Session session = this.getSession();
		Connection con =session.connection();
		int pd=1;
		if(sysUser.getUserRights()==1){
			if(sysUser.getUserState()!=1){
				pd=2;
			}else{
				pd=1;
			}
		}else{
			int roleId=sysUser.getUserisRole();
			Query query=this.getSession().createQuery("from SysRole where roleId=?");
			query.setParameter(0, roleId);
			List<SysRole> list=query.list();
			if(list!=null){
				SysRole sysr=list.get(0);
				if(sysr.getRoleState()!=0){
					pd=2;
				}else{
					pd=1;
				}
			}else{
				pd=2;
			}
		}
	if(pd==1){
		if(sysUser.getUserRights()==1){
			sb.append("SELECT sm.ModID,sm.ModTag,sm.ModName,sm.ModURL,sm.ModIcon,sm.ModFlag,sm.ModMenuOpen,sm.ModMenuView,sm.ModTabPage,"
				+ "sm.ModOrder,sm.ModRightFlag,sm.ModData,sm.ModLog,sm.ModBtnList,sm.isSecurity,sm.pagename,sm.ModUPRight,sm.BranchField,sm.ModDate,sm.PartId,sr.rightsModCtrl"
				+ " from sysmodule sm LEFT JOIN sysrights sr on sm.ModID=sr.RightsModID  where sm.ModFlag="+ModFlag
				+ " and sm.ModMenuView=1 and sr.IsRight=1 and sr.RightsRoleOrUser=1 and  sr.RightsUserID="+sysUser.getUserID());
		}else if(sysUser.getUserRights()==2){
			sb.append("SELECT sm.ModID,sm.ModTag,sm.ModName,sm.ModURL,sm.ModIcon,sm.ModFlag,sm.ModMenuOpen,sm.ModMenuView,sm.ModTabPage,"
				+ "sm.ModOrder,sm.ModRightFlag,sm.ModData,sm.ModLog,sm.ModBtnList,sm.isSecurity,sm.pagename,sm.ModUPRight,sm.BranchField,sm.ModDate,sm.PartId,sr.rightsModCtrl"
				+ " from sysmodule sm LEFT JOIN sysrights sr on sm.ModID=sr.RightsModID  where sm.ModFlag="+ModFlag
				+" and sm.ModMenuView=1 and sr.IsRight=1 and sr.RightsRoleOrUser=2 and sr.RightsRoleID="+sysUser.getUserisRole());
		}else if(sysUser.getUserRights()==3){
			sb.append("SELECT sm.ModID,sm.ModTag,sm.ModName,sm.ModURL,sm.ModIcon,sm.ModFlag,sm.ModMenuOpen,sm.ModMenuView,sm.ModTabPage,"
				+ "sm.ModOrder,sm.ModRightFlag,sm.ModData,sm.ModLog,sm.ModBtnList,sm.isSecurity,sm.pagename,sm.ModUPRight,sm.BranchField,sm.ModDate,sm.PartId,sr.rightsModCtrl"
				+ " from sysmodule sm LEFT JOIN sysrights sr on sm.ModID=sr.RightsModID  where sm.ModFlag="+ModFlag
				+" and sm.ModMenuView=1 and sr.IsRight=1 and (sr.RightsRoleOrUser=2 or sr.RightsRoleOrUser=1) and "
				+"(sr.RightsRoleID="+sysUser.getUserisRole()+" or sr.RightsUserID="+sysUser.getUserID()+")");
		}
	
		try {
		   PreparedStatement ps=  con.prepareStatement(sb.toString());       
	       ResultSet rs = ps.executeQuery();
	       while(rs.next()){
	    	   SysModule module=new SysModule();
	    	   String s=rs.getString("ModID");
	    	   module.setModID(rs.getString("ModID"));
	    	   module.setModTag(rs.getString("ModTag"));
	    	   module.setModName(rs.getString("ModName"));
	    	   module.setModUrl(rs.getString("ModURL"));
	    	   module.setModIcon(rs.getString("ModIcon"));
	    	   module.setModFlag(rs.getInt("ModFlag"));
	    	   module.setModMenuOpen(rs.getString("ModURL"));
	    	   module.setModMenuView(rs.getInt("ModMenuView"));
	    	   module.setModTabPage(rs.getString("ModTabPage"));
	    	   
	    	   module.setModOrder(rs.getInt("ModOrder"));
	    	   module.setModRightFlag(rs.getInt("ModRightFlag"));
	    	   module.setModDate(rs.getInt("ModDate"));
	    	   module.setModLog(rs.getInt("ModLog"));
	    	   module.setModBtnList(rs.getString("ModBtnList"));
	    	   module.setIsSecurity(rs.getInt("isSecurity"));
	    	   module.setPagename(rs.getString("pagename"));
	    	   module.setModUPRight(rs.getString("ModUPRight"));
	    	   module.setBranchField(rs.getString("BranchField"));
	    	   module.setModData(rs.getInt("ModData"));
	    	   module.setPartId(rs.getString("PartId"));
	    	   //System.out.println(module.getModID());
	    	   if((rs.getInt("rightsModCtrl") & 1)==1){
	    		   pareList.add(module);
	    	   }
	       }
		} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e.getMessage());
		}finally{
			try{
				con.close(); 
			}catch(Exception ce){
				ce.printStackTrace();
			}
		} 
	}else{
		pareList=null;
	}
		return pareList;
	}

	@Override
	public List<SysModule> getAllSysModule() {
		return this.getHibernateTemplate().find(" from SysModule");
	}

	@Override
	public List<SysModule> getAllSysModuleByModID(String modID) {
		Query query=this.getSession().createQuery(" from SysModule where modID=?");
		query.setParameter(0, modID);
		return query.list();
	}
	//根据url得到菜单信息
	@Override
	public List<SysModule> getByUrl(String url){
		Query query=this.getSession().createQuery(" from SysModule where modUrl=?");
		query.setParameter(0, url);
		return query.list();
	}

}




