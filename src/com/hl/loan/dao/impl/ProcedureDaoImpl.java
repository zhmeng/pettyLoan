package com.hl.loan.dao.impl;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import org.springframework.stereotype.Repository;

import com.hl.loan.dao.ProcedureDao;
import com.hl.loan.vi.Procedure;

@Repository
public class ProcedureDaoImpl extends BaseDaoImpl implements ProcedureDao{
	private static final Log LOG = LogFactory.getLog(ProcedureDaoImpl.class);
	@Override
	public void processOa(Procedure proc){
		try {
			Session session = this.getSession();
			Connection con =session.connection();
			String sql = "{call p_loan_oa(?,?,?,?,?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setInt(1, proc.getUserId());
			cs.setLong(2, proc.getApplyId());
			cs.setInt(3, proc.getExamines());
			cs.setInt(4, proc.getBeginoa());
			cs.setInt(5, proc.getEndoa());
			cs.setString(6, proc.getView());
			cs.setInt(7, proc.getNext());
			cs.setInt(8, proc.getMold());
			cs.execute();
		} catch (SQLException e) {
			LOG.debug(e.getMessage());
			//System.out.println(e.getMessage());
		}   
		 
	}
	//还款计划
	@Override
	public int processPayments(Long applyId){
		int result=0;
		try {
			Session session = this.getSession();
			Connection con =session.connection();
			String sql = "{call p_payment(?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			cs.setLong(1, applyId);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.execute();
			result=cs.getInt(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}




