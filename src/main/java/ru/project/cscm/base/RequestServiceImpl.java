package ru.project.cscm.base;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ru.project.cscm.model.Request;

@Service
@Repository
@Transactional
public class RequestServiceImpl implements RequestService {

	private AtomicInteger currentId;

	@PostConstruct
	private void init() {
		currentId = new AtomicInteger(getLastId());
	}

	private int getLastId() {
		return (int) em.createNativeQuery("SELECT COALESCE(MAX(id), 0) FROM requests")
				.getSingleResult();
	}

	@Autowired
	private EntityManager em;
	
	@Override
	public Collection<Request> getRequests() {
		return em.createNamedQuery("find.all", Request.class).getResultList();
	}

	@Override
	public Request getRequest(Integer id) {
		return em.find(Request.class, id);
	}

	@Override
	public void save(Request request) {
		int tries = 5;

		while (tries > 0) {
			try {
				request.setId(currentId.incrementAndGet());
				saveWithTransaction(request);
				tries = 0;
			} catch (ConstraintViolationException e) {
				currentId.set(getLastId());
			}
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void saveWithTransaction(Request request) {
		em.persist(request);
	}

	@Override
	public void update(Request request) {
		em.refresh(request);
	}

	@Override
	public void remove(Request request) {
		em.remove(request);
	}

	@Override
	public void remove(Integer id) {
		em.createQuery("DELETE FROM request WHERE id = " + id).executeUpdate();
	}

	@Override
	public Collection<Request> getActualRequestsByFilter(Integer filterId) {
		final TypedQuery<Request> query = em.createNamedQuery("find.actuals.by.filter", Request.class);
		query.setParameter("filterId", filterId);
		return query.getResultList();
	}

	@Override
	public Collection<Request> getActualRequests() {
		return em.createNamedQuery("find.actuals", Request.class).getResultList();
	}
}
