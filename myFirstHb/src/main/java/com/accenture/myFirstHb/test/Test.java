package com.accenture.myFirstHb.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.accenture.myFirstHb.model.*;
import com.accenture.myFirstHb.utility.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction =session.beginTransaction();
		
		
		//Prodotti
		Prodotto p1 = new Prodotto();
		Prodotto p2 = new Prodotto();
		Prodotto p3 = new Prodotto();
		
		p1.setCategoria("Caso");
		p1.setNome("Cosa inutile");
		p1.setPrezzo(10.90);
		
		p2.setCategoria("Tecnologia");
		p2.setNome("NotebookName");
		p2.setPrezzo(1000.10);
		
		p3.setCategoria("Verròmodificato");
		p3.setNome("Prodotto");
		p3.setPrezzo(0.10);
		
		
		//Dettaglio prodotto
		DettaglioProdotto dett1 = new DettaglioProdotto();
		DettaglioProdotto dett2 = new DettaglioProdotto();
		DettaglioProdotto dett3 = new DettaglioProdotto();
		
		dett1.setDescrizione("Bah");
		dett1.setFornitore("Wish");
		dett1.setQuantita(1.43);
		dett1.setProdotto(p1);
		
		dett2.setDescrizione("Costo medio");
		dett2.setFornitore("Mediaworld");
		dett2.setQuantita(100.00);
		dett2.setProdotto(p2);
		
		dett3.setDescrizione("Test modifica");
		dett3.setFornitore("FornitoreModificatore");
		dett3.setQuantita(100.00);
		
		//Inserimento
		session.save(p1);
		session.save(dett1);
		
		session.save(p2);
		session.save(dett2);
		
		session.save(p3);
		

		dett3.setProdotto(p3);
		session.save(dett3);
		
		//delete
		session.delete(p2);
		session.delete(dett2);
		
		//update
		p3.setNome("Modificato");
		p3.setCategoria("Updatato");
		session.update(p3);
		
		
		transaction.commit();
		
		
		System.out.println(session.get(Prodotto.class, 1).toString());
		System.out.println(session.get(DettaglioProdotto.class, 3).toString());
		transaction.getStatus();
		if((session.get(DettaglioProdotto.class, 4))!=(null)){
			System.out.println(session.get(DettaglioProdotto.class, 4).toString());
		}else {
			System.out.println("La riga non c'è!");
		}
		session.close();
	}

}
