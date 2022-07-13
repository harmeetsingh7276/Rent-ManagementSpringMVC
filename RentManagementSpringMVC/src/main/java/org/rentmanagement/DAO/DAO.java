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

	public void createTenant(Tenants tenant) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		if(session.get(Tenants.class,tenant.getMobileNumber())==null) {
			session.save(tenant);
			System.out.println("Added Details for " + tenant.getName());
		}
		else {
			session.merge(tenant);
			System.out.println("Updated Details for " + tenant.getName());
		}
		session.getTransaction().commit();
		
	}

	public void deleteTenant(String mobileNumber) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Tenants tenant=session.get(Tenants.class, mobileNumber);
		session.delete(tenant);
		session.getTransaction().commit();
	}

	public Tenants getTenantByMobileNumber(String mobileNumber) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Tenants tenant=session.get(Tenants.class, mobileNumber);
		return tenant;
	}

}
