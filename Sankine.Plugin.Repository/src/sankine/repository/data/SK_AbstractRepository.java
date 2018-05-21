/*******************************************************************************
Copyright © 2017 Sankine Corporation Inc. All rights reserved.
Author: Hoang Van Que
Email: quehvbg@gmail.com
Phone : 0983.138.328
Description: 
Modifier :
Version : 1.0.0.1
********************************************************************************/

package sankine.repository.data;

import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;
import sankine.plugin.base.SK_BaseEntity;
import sankine.plugin.core.SK_Application;
import sankine.repository.interfaces.SK_IRepositoryAsync;
import sankine.repository.interfaces.SK_Parameter;
import sankine.repository.interfaces.SK_Specification;

public abstract class SK_AbstractRepository<T extends SK_BaseEntity> implements SK_IRepositoryAsync<T> {

	private Class<T> type;
	private EntityManagerFactory emf;
	private SessionFactory sf;

	public SK_AbstractRepository(Class<T> type) {
		this.type = type;
		SK_Application app = SK_Application.getInstance();
		emf = app.getEntityManager();
		sf = app.getSessionFactory();
	}

	@Override
	public Set<T> get() {
		List<T> resultList = run(entityManager -> {
			final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			final CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);

			final Root<T> root = criteria.from(type);
			criteria.select(root);

			final TypedQuery<T> query = entityManager.createQuery(criteria);
			return query.getResultList();
		});

		return new HashSet<T>(resultList);
	}

	@Override
	public Set<T> getRange(int[] range) {
		List<T> resultList = run(entityManager -> {
			final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			final CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);

			final Root<T> root = criteria.from(type);
			criteria.select(root);

			final TypedQuery<T> query = entityManager.createQuery(criteria);
			query.setMaxResults(range[1] - range[0] + 1);
			query.setFirstResult(range[0]);
			return query.getResultList();
		});

		return new HashSet<T>(resultList);
	}

	@Override
	public Optional<T> get(UUID id) {
		return Optional.ofNullable(run(entityManager -> {
			return entityManager.find(type, id);
		}));
	}

	@Override
	public void persist(T entity) {
		runInTransaction(entityManager -> {
			entityManager.merge(entity);
		});
	}

	@Override
	public void persist(Collection<T> entities) {
		runInTransaction(entityManager -> {
			entities.forEach(entityManager::merge);
		});
	}

	@Override
	public void remove(T entity) {
		remove(entity.getId());
	}

	@Override
	public void remove(UUID id) {
		runInTransaction(entityManager -> {
			final T managedEntity = entityManager.find(type, id);
			if (managedEntity != null) {
				entityManager.remove(managedEntity);
			}
		});
	}

	@Override
	public void remove(Collection<T> entities) {
		runInTransaction(entityManager -> {
			entities.stream().map(SK_BaseEntity::getId).map(id -> entityManager.find(type, id)).filter(Objects::nonNull)
					.forEach(entityManager::remove);
		});
	}

	@Override
	public void remove(Predicate<T> predicate) {
		remove(get(predicate));
	}

	private <R> R run(Function<EntityManager, R> function) {
		final EntityManager entityManager = emf.createEntityManager();
		try {
			return function.apply(entityManager);
		} finally {
			entityManager.close();
		}
	}

	@SuppressWarnings("unused")
	private void run(Consumer<EntityManager> function) {
		run(entityManager -> {
			function.accept(entityManager);
			return null;
		});
	}

	private <R> R runInTransaction(Function<EntityManager, R> function) {
		return run(entityManager -> {
			entityManager.getTransaction().begin();

			final R result = function.apply(entityManager);

			entityManager.getTransaction().commit();

			return result;
		});
	}

	private void runInTransaction(Consumer<EntityManager> function) {
		runInTransaction(entityManager -> {
			function.accept(entityManager);
			return null;
		});
	}

	@Override
	public void removeAll(SK_Specification specification) {
		final EntityManager entityManager = emf.createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<T> query = criteriaBuilder.createCriteriaDelete(type);
		Root<T> root = query.from(type);
		query.where(root.isNotNull());
		Query queryDelete = entityManager.createQuery(query);
		if (specification.onePara != null) {
			queryDelete.setParameter(specification.onePara.getPara(), specification.onePara.getValue());
		}
		entityManager.getTransaction().begin();
		queryDelete.executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public void removeAll() {
		final EntityManager entityManager = emf.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaDelete<T> query = criteriaBuilder.createCriteriaDelete(type);
		Root<T> root = query.from(type);
		query.where(root.isNotNull());
		entityManager.getTransaction().begin();
		entityManager.createQuery(query).executeUpdate();
		entityManager.getTransaction().commit();
	}

	@Override
	public List<T> query(SK_Specification para) {
		final EntityManager entityManager = emf.createEntityManager();
		TypedQuery<T> query = entityManager.createQuery(para.SqlQuery, type);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> executeProcedure(SK_Specification sqlAdvance) {
		try {
			if (!sf.getCurrentSession().getTransaction().isActive()) {
				sf.getCurrentSession().getTransaction().begin();
				ProcedureCall call = sf.getCurrentSession().createStoredProcedureCall(sqlAdvance.SqlQuery);
				if (sqlAdvance.listPara != null && sqlAdvance.listPara.size() > 0) {
					for (SK_Parameter para : sqlAdvance.listPara) {
						if(para.getValue() instanceof String){
							call.registerParameter(para.getPara(), String.class,para.getMode())
							.bindValue((String) para.getValue());
						}else if(para.getValue() instanceof Integer){
							call.registerParameter(para.getPara(), Integer.class,para.getMode())
							.bindValue((Integer) para.getValue());
						}
						else if(para.getValue() instanceof BigInteger){
							call.registerParameter(para.getPara(), BigInteger.class,para.getMode())
							.bindValue((BigInteger) para.getValue());
						}
						else if(para.getValue() instanceof Date){
							call.registerParameter(para.getPara(), Date.class,para.getMode())
							.bindValue((Date) para.getValue());
						}
						else if(para.getValue() instanceof Boolean){
							call.registerParameter(para.getPara(), Boolean.class,para.getMode())
							.bindValue((Boolean) para.getValue());
						}
					}
				} else if (sqlAdvance.onePara != null) {
					if(sqlAdvance.onePara.getValue() instanceof String){						
						call.registerParameter(sqlAdvance.onePara.getPara(), String.class,sqlAdvance.onePara.getMode())
						.bindValue((String) sqlAdvance.onePara.getValue());
					}else if(sqlAdvance.onePara.getValue() instanceof Integer){
						call.registerParameter(sqlAdvance.onePara.getPara(), Integer.class,sqlAdvance.onePara.getMode())
						.bindValue((Integer) sqlAdvance.onePara.getValue());
					}	
					else if(sqlAdvance.onePara.getValue() instanceof BigInteger){
						call.registerParameter(sqlAdvance.onePara.getPara(), BigInteger.class,sqlAdvance.onePara.getMode())
						.bindValue((BigInteger) sqlAdvance.onePara.getValue());
					}
					else if(sqlAdvance.onePara.getValue() instanceof Date){
						call.registerParameter(sqlAdvance.onePara.getPara(), Date.class,sqlAdvance.onePara.getMode())
						.bindValue((Date) sqlAdvance.onePara.getValue());
					}
					else if(sqlAdvance.onePara.getValue() instanceof Boolean){
						call.registerParameter(sqlAdvance.onePara.getPara(), Boolean.class,sqlAdvance.onePara.getMode())
						.bindValue((Boolean) sqlAdvance.onePara.getValue());
					}
				}
				List<Object[]> result = call.getResultList();						
				sf.getCurrentSession().getTransaction().commit();				
				return result;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public String runProcedure(SK_Specification sqlAdvance) {
		try {
			if (!sf.getCurrentSession().getTransaction().isActive()) {
				sf.getCurrentSession().getTransaction().begin();
				ProcedureCall call = sf.getCurrentSession().createStoredProcedureCall(sqlAdvance.SqlQuery);
				if (sqlAdvance.listPara != null && sqlAdvance.listPara.size() > 0) {
					for (SK_Parameter para : sqlAdvance.listPara) {
						if(para.getValue() instanceof String){
							call.registerParameter(para.getPara(), String.class,para.getMode())
							.bindValue((String) para.getValue());
						}else if(para.getValue() instanceof Integer){
							call.registerParameter(para.getPara(), Integer.class,para.getMode())
							.bindValue((Integer) para.getValue());
						}
						else if(para.getValue() instanceof BigInteger){
							call.registerParameter(para.getPara(), BigInteger.class,para.getMode())
							.bindValue((BigInteger) para.getValue());
						}
						else if(para.getValue() instanceof Date){
							call.registerParameter(para.getPara(), Date.class,para.getMode())
							.bindValue((Date) para.getValue());
						}
						else if(para.getValue() instanceof Boolean){
							call.registerParameter(para.getPara(), Boolean.class,para.getMode())
							.bindValue((Boolean) para.getValue());
						}
					}
				} else if (sqlAdvance.onePara != null) {
					if(sqlAdvance.onePara.getValue() instanceof String){						
						call.registerParameter(sqlAdvance.onePara.getPara(), String.class,sqlAdvance.onePara.getMode())
						.bindValue((String) sqlAdvance.onePara.getValue());
					}else if(sqlAdvance.onePara.getValue() instanceof Integer){
						call.registerParameter(sqlAdvance.onePara.getPara(), Integer.class,sqlAdvance.onePara.getMode())
						.bindValue((Integer) sqlAdvance.onePara.getValue());
					}	
					else if(sqlAdvance.onePara.getValue() instanceof BigInteger){
						call.registerParameter(sqlAdvance.onePara.getPara(), BigInteger.class,sqlAdvance.onePara.getMode())
						.bindValue((BigInteger) sqlAdvance.onePara.getValue());
					}
					else if(sqlAdvance.onePara.getValue() instanceof Date){
						call.registerParameter(sqlAdvance.onePara.getPara(), Date.class,sqlAdvance.onePara.getMode())
						.bindValue((Date) sqlAdvance.onePara.getValue());
					}
					else if(sqlAdvance.onePara.getValue() instanceof Boolean){
						call.registerParameter(sqlAdvance.onePara.getPara(), Boolean.class,sqlAdvance.onePara.getMode())
						.bindValue((Boolean) sqlAdvance.onePara.getValue());
					}
				}
				call.execute();						
				sf.getCurrentSession().getTransaction().commit();				
				return "Ok";
			}
			return "Ok";
		} catch (Exception e) {			
			return e.getMessage();
		}
	}
}
