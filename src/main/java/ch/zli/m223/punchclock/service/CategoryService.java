package ch.zli.m223.punchclock.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ch.zli.m223.punchclock.domain.Category;
import ch.zli.m223.punchclock.service.CategoryService;

@ApplicationScoped
public class CategoryService {
    @Inject
    private EntityManager entityManager;

    public CategoryService() {
    }

    @Transactional 
    public Category createCategory(Category category) {
        entityManager.persist(category);
        return category;
    }

    public Category getSingleCategory(Long id){
        return entityManager.find(Category.class, id);
    }

    @Transactional
    public void deleteCategory(Long id){
        Category categoryToDelete = getSingleCategory(id);
        entityManager.remove(categoryToDelete);
    }

    @Transactional
    public void updateCategory(Category category){
        entityManager.merge(category);
    }

    @SuppressWarnings("unchecked")
    public List<Category> findAll() {
        var query = entityManager.createQuery("FROM Category");
        return query.getResultList();
    }
}