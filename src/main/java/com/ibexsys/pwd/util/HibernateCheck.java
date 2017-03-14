package com.ibexsys.pwd.util;


import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration
                            .getProperties());
        SessionFactory sessionFactory = configuration
                            .buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
        Session session = sessionFactory.openSession();
        
        
        Transaction tx = null;
        
        try {
        	tx = session.beginTransaction();
        	
            tx.commit();
            tx = null;
        
        } catch (HibernateException e){
        	if (tx != null) tx.rollback();
        	e.printStackTrace();
        } 
        finally {
        	session.close();
        }
        
        //Display Tables
        HibernateUtil.checkData("select * from AppUser");
        HibernateUtil.checkData("select * from Category");
        HibernateUtil.checkData("select * from Site");
    
	}

}
