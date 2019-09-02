package disco.service;

import java.util.List;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Local
public abstract class GenericService<T> {
    @PersistenceContext(unitName = "DiscoPU")
    private EntityManager em;
    
    private Class<T> entityClass;
    
    public void create(T obj) {
        try {
            em.persist(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<T> read() {
        List<T> list = null;
        try {
            list = em.createNamedQuery("findAll", entityClass).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public void update(T obj) {
        try {
            em.merge(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void delete(int id) {
        try {
            em.remove(em.find(entityClass, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
