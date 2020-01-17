package com.sunbeaminfo.sh.hib;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;

public class DeptDao {
	public List<Dept> getAllDepts() {
		Session session = HbUtil.getSession();
		NativeQuery<Dept> q = session.getNamedNativeQuery("spGetAllDepts");
		return q.getResultList();
	}
	public int updateLoc(int deptno, String loc) {
		Session session = HbUtil.getSession();
		NativeQuery<Dept> q = session.getNamedNativeQuery("spUpdateLoc");
		q.setParameter("p_deptno", deptno);
		q.setParameter("p_loc", loc);
		return q.executeUpdate();
	}
	public String getLoc3(int deptno) {
		Session session = HbUtil.getSession();
		String loc = session.doReturningWork(new ReturningWork<String>() {
			@Override
			public String execute(Connection con) throws SQLException {
				try(CallableStatement stmt = con.prepareCall("CALL SP_DEPTGETLOC(?,?)")) {
					stmt.setInt(1, deptno);
					stmt.registerOutParameter(2, Types.VARCHAR);
					stmt.execute();
					return stmt.getString(2);
				}
			}
		});
		return loc;
	}
	public String getLoc5(int deptno) {
		Session session = HbUtil.getSession();
		ProcedureCall sp = session.createStoredProcedureCall("SP_DEPTGETLOC");
		sp.registerStoredProcedureParameter(0, Integer.class, ParameterMode.IN);
		sp.registerStoredProcedureParameter(1, String.class, ParameterMode.OUT);
		sp.setParameter(0, deptno);
		sp.execute();
		return (String) sp.getOutputParameterValue(1);
	}
}
