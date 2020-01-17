package com.sunbeaminfo.sh.hib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface DeptDao {
	void addDept(Dept d);
	Dept getDept(int deptno);
	
	static final DeptDao dao = new DeptDaoImpl();
	
	static DeptDao createInstance() {		
		InvocationHandler handler = new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Transaction tx = method.getAnnotation(Transaction.class);
				try {
					if(tx!=null)
						HbUtil.beginTransaction();
					Object res = method.invoke(dao, args);
					if(tx!=null)
						HbUtil.commitTransaction();
					return res;
				} catch (Exception e) {
					if(tx!=null)
						HbUtil.rollbackTransaction();
					throw e;
				}
			}
		};
		
		DeptDao daoProxy = (DeptDao) Proxy.newProxyInstance(
				DeptDao.class.getClassLoader(), 
				new Class[] {DeptDao.class}, 
				handler);
		return daoProxy;
	}
}
