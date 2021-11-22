package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class LogService {

    @Inject
    private EntityManager entityManager;

    public LogService() {
    }

    @Transactional
    public Log createLog(Log log) {
        entityManager.persist(log);
        return log;
    }

    public Log getSingleLog(Long id){
        return entityManager.find(Log.class, id);
    }

    @Transactional
    public void deleteLog(Long id){
        Log logToDelete = getSingleLog(id);
        entityManager.remove(logToDelete);
    }

    @Transactional
    public void updateLog(Log log){
        entityManager.merge(log);
    }

    @SuppressWarnings("unchecked")
    public List<Log> findAll() {
        var query = entityManager.createQuery("FROM Log");
        return query.getResultList();
    }

}
