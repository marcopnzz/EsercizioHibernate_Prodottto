package com.accenture.myFirstHb.dao;


import java.util.List;

public interface IDettaglioProdotto<T, Id extends Integer> {

		public void persist(T entity);
		
		public void update(T entity);
		
		public T findById(Id id);
		
		public void delete(T entity);
		
		public List<T> findAll();
		
		public void deleteAll();
		
}
