package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Entry;

@ApplicationScoped
@RolesAllowed("User")
public class EntryService {
    @Inject
    private EntityManager entityManager;

    public EntryService() {
    }

    @Transactional 
    public Entry createEntry(Entry entry) {
        entityManager.persist(entry);
        return entry;
    }

    public Entry getSingleEntry(Long id){
        return entityManager.find(Entry.class, id);
    }

    @Transactional
    public void deleteEntry(Long id){
        Entry entryToDelete = getSingleEntry(id);
        entityManager.remove(entryToDelete);
    }

    @Transactional
    public void updateEntry(Entry entry){
        entityManager.merge(entry);
    }

    @SuppressWarnings("unchecked")
    public List<Entry> findAll() {
        var query = entityManager.createQuery("FROM Entry");
        return query.getResultList();
    }
}
