package com.app.myDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.pojos.Admin;

@Repository
public class ClassDao implements InterfaceDao {

@Autowired
private SessionFactory sf;
	
		public ClassDao() {
		System.out.println("in class dao CTOR");
		}
	@Override
	public Admin ValidateAdmin(String em, String ps) {
		String jpql = "select a from Admin a where a.email=:em and a.pass=:pa";

		return sf.getCurrentSession().createQuery(jpql, Admin.class).setParameter("em", em).setParameter("pa", ps)
				.getSingleResult();

	}

}
