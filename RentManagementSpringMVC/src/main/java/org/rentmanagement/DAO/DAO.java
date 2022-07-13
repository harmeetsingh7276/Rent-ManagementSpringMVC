package org.rentmanagement.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rentmanagement.model.Tenants;

public final class DAO {
	public DAO() {
		
	}

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Tenants.class)
			.buildSessionFactory();

	public List<Tenants> listTenantsDetails() {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		List<Tenants> lst = session.createQuery("from tenants").getResultList();
		// session.getTransaction().commit(); not required while reading
		return lst;
	}
}
