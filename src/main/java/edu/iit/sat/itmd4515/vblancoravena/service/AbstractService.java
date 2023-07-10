/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.vblancoravena.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author virginiablancoravena
 */
//T generic type, we have to specify the type of class when using it
public abstract class AbstractService<T> {
    @PersistenceContext(name="itmd4515PU")
    protected EntityManager em;
    
    protected final Class<T> entityClass;
    
    public AbstractService(Class<T> entityClass){
        this.entityClass = entityClass;
    }
    
    public void create(T entity){
        em.persist(entity);
    }
    public T read(Long id){
        return em.find(entityClass, id);
    }
    public void update(T entity){
        em.merge(entity);
    }
    public void delete(T entity){
        em.remove(em.merge(entity));
    }
//    public List<Seller> findAll(){
//        return em.createNamedQuery("Seller.findAll", Seller.class).getResultList();
//    }
    abstract public List<T> findAll();
}
