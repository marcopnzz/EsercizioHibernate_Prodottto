package com.accenture.myFirstHb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.accenture.myFirstHb.model.Prodotto;

public class ProdottoDao implements IProdotto<Prodotto, Integer> {
private Session currentSession;
	
	private Transaction currentTransaction;

	public ProdottoDao() {
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
	public void persist(Prodotto entity) {
		// TODO Auto-generated method stub
		getCurrentSession().save(entity);
	}

	@Override
	public void update(Prodotto entity) {
		// TODO Auto-generated method stub
		getCurrentSession().update(entity);
	}

	@Override
	public Prodotto findById(Integer id) {
		// TODO Auto-generated method stub
		Prodotto prodotto = (Prodotto) getCurrentSession().get(Prodotto.class, id);
		return prodotto;
	}

	@Override
	public void delete(Prodotto entity) {
		// TODO Auto-generated method stub
		getCurrentSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Prodotto> findAll() {
		// TODO Auto-generated method stub
		List<Prodotto> prodotti = (List<Prodotto>) getCurrentSession().createQuery("from prodotto").list();
		return prodotti;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		List <Prodotto> prodotti = findAll();
		for(Prodotto entity : prodotti) {
			delete(entity);
		}
	}


}
