package ch.zli.m223.punchclock.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.User;

@ApplicationScoped
public class RegistrationService {
    @Inject
    private EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    public User getSingleUser(Long id){
        return entityManager.find(User.class, id);
    }

    @Transactional
    public void deleteUser(Long id){
        User userToDelete = getSingleUser(id);
        entityManager.remove(userToDelete);
    }

    @Transactional
    public void updateUser(User user){
        entityManager.merge(user);
    }
}
