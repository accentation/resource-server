package com.accenture.banking.respository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Office;
import com.accenture.banking.model.Transaction;
import com.accenture.banking.respository.TransactionRepository;

public class TransactionRepositoryImpl implements TransactionRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public List<Transaction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Transaction> List<S> save(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Transaction> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Transaction> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Transaction getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Transaction> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Transaction> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Transaction> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Transaction> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Transaction entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends Transaction> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Transaction> S findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Transaction> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Transaction> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Transaction> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Transaction> findAll(String description, Long amountH, Long amountL,  Long officeId, Long accountId, Pageable pageable) {

		 CriteriaBuilder cb = em.getCriteriaBuilder();
	     CriteriaQuery<Transaction> cq = cb.createQuery(Transaction.class);
	     Root<Transaction> iRoot = cq.from(Transaction.class);
	     
	     List<Predicate> predicates = new ArrayList<Predicate>();
	     Join<Transaction, Account>  jAccount=(Join) iRoot.join("account");	     
	     predicates.add((Predicate) cb.equal(jAccount.get("id"), accountId));	     
	     Join<Account, Office>  jOffice=(Join) jAccount.join("office");	     
	     predicates.add((Predicate) cb.equal(jOffice.get("id"), officeId));	     
	     
	 	 if (!StringUtils.isEmpty(description)) {	 		 
	         predicates.add((Predicate) (cb.like(cb.lower(iRoot.<String>get("description")),  "%" + description.toLowerCase() + "%")));
	     }	 	 
	 	 
	 	 if (amountH != null) {
	         predicates.add((Predicate) cb.lessThan(iRoot.get("amount"), amountH));	        
	     }
	 	 
	 	 if (amountL != null) {
	         predicates.add((Predicate) cb.greaterThan(iRoot.get("amount"), amountL));	        
	     }
	 	 		 	
	     Predicate[] predArray = new Predicate[predicates.size()];
	     predicates.toArray(predArray);	     
	    

	     cq.where(cb.and(predArray));  
	     
	     TypedQuery<Transaction> query = em.createQuery(cq);
	     
	     Page<Transaction> result = new PageImpl<Transaction>(query.getResultList(), pageable, query.getMaxResults());

	     return result;
	}

	@Override
	public Double findAvg(String description, Long amountH, Long amountL,  Long officeId, Long accountId) {
		  CriteriaBuilder cb = em.getCriteriaBuilder();
	     CriteriaQuery<Double> cq = cb.createQuery(Double.class);
	     Root<Transaction> iRoot = cq.from(Transaction.class);
	     
	          
	     cq.select( 
	    		    cb.avg(iRoot.<Double>get("amount")).alias("Amount")
	    		);
	     
	     List<Predicate> predicates = new ArrayList<Predicate>();
	     Join<Transaction, Account>  jAccount=(Join) iRoot.join("account");	     
	     predicates.add((Predicate) cb.equal(jAccount.get("id"), accountId));	     
	     Join<Account, Office>  jOffice=(Join) jAccount.join("office");	     
	     predicates.add((Predicate) cb.equal(jOffice.get("id"), officeId));	     
	     
	 	 if (!StringUtils.isEmpty(description)) {	 		 
	         predicates.add((Predicate) (cb.like(cb.lower(iRoot.<String>get("description")),  "%" + description.toLowerCase() + "%")));
	     }	 	 
	 	 
	 	 if (amountH != null) {
	         predicates.add((Predicate) cb.lessThan(iRoot.get("amount"), amountH));	        
	     }
	 	 
	 	 if (amountL != null) {
	         predicates.add((Predicate) cb.greaterThan(iRoot.get("amount"), amountL));	        
	     }
	 	 		 	
	     Predicate[] predArray = new Predicate[predicates.size()];
	     predicates.toArray(predArray);	     
	    
	     cq.where(cb.and(predArray));  
	     
	     TypedQuery<Double> query = em.createQuery(cq);
	     
	     List<Double> result = query.getResultList();
	     
	     
	     Double results;	     
	     
	     
	     if(!(result.isEmpty()) && ( result.get(0) != null))
	     {
	    	 results = (double) result.get(0);
	     }
	     else
	     {
	    	 results =0.0;
	     }
	    	
	     return results;
	}

}
