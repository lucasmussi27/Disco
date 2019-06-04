package com.example.disco.repository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericDAO<T, I> {
    private Class<T> className;
    protected GenericDAO() {}
    protected GenericDAO(Class<T> name) {
        this();
        this.className = name;
    }
    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testedb");
        EntityManager em = emf.createEntityManager();
        return em;
    }
    public void create(T obj) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally { em.close(); }
    }
    public List<T> read() {
        EntityManager em = getEntityManager();
        List<T> list = null;
        try {
            list = em.createQuery("from " + className).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally { em.close(); }
        return list;
    }
    public void update(T obj) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally { em.close(); }
    }
    public void delete(I id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.find(className, id));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally { em.close(); }
    }
}