package com.accenture.myFirstHb.dao;
import com.accenture.myFirstHb.model.DettaglioProdotto;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DettaglioProdottoDao implements IDettaglioProdotto<DettaglioProdotto, Integer> {
	
	private Session currentSession;
	
	private Transaction currentTransaction;
	
	public DettaglioProdottoDao() {
		
	}
	
	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	//Metodi implementati da interfaccia

	@Override
	public void persist(DettaglioProdotto entity) {
		// TODO Auto-generated method stub
		getCurrentSession().save(entity);
	}

	@Override
	public void update(DettaglioProdotto entity) {
		// TODO Auto-generated method stub
		getCurrentSession().update(entity);
	}

	@Override
	public DettaglioProdotto findById(Integer id) {
		// TODO Auto-generated method stub
		DettaglioProdotto  dettaglioProd= (DettaglioProdotto) getCurrentSession().get(DettaglioProdotto.class, id);
		return dettaglioProd;
	}

	@Override
	public void delete(DettaglioProdotto entity) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DettaglioProdotto> findAll() {
		// TODO Auto-generated method stub
		List<DettaglioProdotto> listDettagli = (List<DettaglioProdotto>) getCurrentSession().createQuery("from dettaglioProdotto").list();
		return listDettagli;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		List<DettaglioProdotto> entityList = findAll();
		for(DettaglioProdotto entity : entityList) {
			delete(entity);
		}
	}

}
