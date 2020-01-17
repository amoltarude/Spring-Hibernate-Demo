package com.sunbeaminfo.sh.hib;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

public class BookDao {
	public Book getBook(int id) {
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManager();
			return em.find(Book.class, id);
		} finally {
			if(em!=null)
				em.close();
		}
	}

	/*
	// Only Hibernate -- Deprecated in Hibernate 5.2 -- Not supported in JPA.
	public List<Book> getBooksBySubject1(String subject) {
		String hql = "select b.id, b.name, b.price from Book b where b.subject=:p_subject";
		Session session = HbUtil.getSession();
		Query q = session.createQuery(hql);
		q.setParameter("p_subject", subject);
		q.setResultTransformer(new ResultTransformer() {
			@Override
			public Object transformTuple(Object[] tuple, String[] aliases) {
				Book b = new Book();
				b.setId((Integer)tuple[0]);
				b.setName((String)tuple[1]);
				b.setPrice((Double)tuple[2]);
				return b;
			}
			@Override
			public List transformList(List collection) {
				return collection;
			}
		});
		return q.getResultList();
	}
	 */

	public List<Book> getBooksBySubject2(String subject) {
		EntityManager em = null;
		try {
			String hql = "select new Book(b.id, b.name, b.price) from Book b where b.subject=:p_subject";
			em = JpaUtil.getEntityManager();
			Query q = em.createQuery(hql);
			q.setParameter("p_subject", subject);
			return q.getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
	}

	public Map<String, Double> getSubjectwiseTotalPrice() {
		EntityManager em = null;
		try {
			String hql = "select b.subject, sum(b.price) from Book b group by b.subject";
			em = JpaUtil.getEntityManager();
			Query q = em.createQuery(hql);
			List<Object[]> list = q.getResultList();
			Map<String, Double> map = new HashMap<>();
			for (Object[] tuple : list) 
				map.put((String)tuple[0], (Double)tuple[1]);
			return map;
		} finally {
			if(em != null)
				em.close();
		}
	}

	// Named Query
	public List<String> getSubjects() {
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManager();		
			Query q = em.createNamedQuery("qrySubjects");
			return q.getResultList();
		} finally {
			if(em!=null)
				em.close();
		}
	}

	// Criteria Query -- SELECT
	public List<Book> getBooksByAuthor(String author) {
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManager();

			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Book> crQuery = builder.createQuery(Book.class);
			Root<Book> table = crQuery.from(Book.class);
			crQuery
			.select(table)
			.where(builder.equal(table.get("author"), author));
			return em.createQuery(crQuery).getResultList();

		}finally {
			if(em!=null)
				em.close();
		}
	}
	// Criteria Query -- UPDATE
	public int updateBookPriceOfSubjectBy5Percent(String subject) {
		int cnt = -1;
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaUpdate<Book> crUpdate = builder.createCriteriaUpdate(Book.class);
			Root<Book> table = crUpdate.from(Book.class);
			crUpdate.set(table.<Number>get("price"),
					builder.sum(table.<Number>get("price"), builder.quot(table.<Number>get("price"), 5)))
			.where(builder.equal(table.get("subject"), subject));
			cnt = em.createQuery(crUpdate).executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			if(em!=null)
				em.close();
		}
		return cnt;
	}
	// Criteria Query -- DELETE
	public int deleteBooksBySubject(String subject) {
		int cnt = -1;
		EntityManager em = null;
		try {
			em = JpaUtil.getEntityManager();
			em.getTransaction().begin();
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaDelete<Book> crDelete = builder.createCriteriaDelete(Book.class);
			Root<Book> table = crDelete.from(Book.class);
			crDelete.where(builder.equal(table.get("subject"), subject));
			cnt = em.createQuery(crDelete).executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			if(em != null)
				em.close();
		}
		return cnt;
	}	

}
