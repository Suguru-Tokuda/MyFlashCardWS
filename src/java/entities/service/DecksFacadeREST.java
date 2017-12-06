/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Decks;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author it354f715
 */
@Stateless
@Path("entities.decks")
public class DecksFacadeREST extends AbstractFacade<Decks> {

    @PersistenceContext(unitName = "MyFlashCardWSPU")
    private EntityManager em;

    public DecksFacadeREST() {
        super(Decks.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Decks entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Decks entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Decks find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Decks> findAll() {
        return super.findAll();
    }

    @GET
    @Path("findAllOrderByDeckname")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findAllOrderByDeckname() {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d ORDER BY d.deckname");
        return q.getResultList();
    }

    @GET
    @Path("findByClassid/{classid}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findByClassid(@PathParam("classid") String classid) {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d JOIN Assignments a ON d.id = a.deckid WHERE a.classid = " + classid + " ORDER BY d.deckname");
        return q.getResultList();
    }

    @GET
    @Path("findByClassnumber/{classnumber}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findByClassnumber(@PathParam("classnumber") String classnumber) {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d JOIN Assignments a ON d.id = a.deckid JOIN Classes c ON a.classid = c.id WHERE c.classnumber = :classnumber ORDER BY d.deckname");
        q.setParameter("classnumber", classnumber);
        return q.getResultList();
    }

    @GET
    @Path("findByUsername/{username}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findByUsername(@PathParam("username") String username) {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d JOIN Users u ON d.userid = u.id WHERE u.username = :username ORDER BY d.deckname");
        q.setParameter("username", username);
        return q.getResultList();
    }
    
    @GET
    @Path("findByUseridAndClassidAndDeckname/{userid}/{classid}/{deckname}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findByUseridAndDecknameAndClassid(@PathParam("deckname") String deckname, @PathParam("classid") String classid, @PathParam("userid") String userid) {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d WHERE lower(d.deckname) = lower(:deckname) AND d.classid = " + classid + " AND d.userid = " + userid);
        q.setParameter("deckname", deckname);
        return q.getResultList();
    }

    @GET
    @Path("findByClassnmae/{classname}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findByClassname(@PathParam("classname") String classname) {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d JOIN Assignments a ON d.id = a.deckid JOIN Classes c ON a.classid = c.id WHERE lower(c.classname) LIKE lower(concat('%', :classname, '%')) ORDER BY d.deckname");
        q.setParameter("classname", classname);
        return q.getResultList();
    }
    
    @GET
    @Path("byDeckname/{deckname}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findByWord(@PathParam("deckname") String deckname) {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d WHERE lower(d.deckname) = lower(:deckname)");
        q.setParameter("deckname", deckname);
        return q.getResultList();
    }

    @GET
    @Path("findByKeyword/{keyword}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findBykeyword(@PathParam("keyword") String keyword) {
        Query q = em.createQuery("SELECT DISTINCT d FROM Decks d JOIN Cards c ON d.id = c.deckid WHERE lower(c.answer) LIKE lower(concat('%', :keyword, '%')) OR lower(c.question) LIKE lower(concat('%', :keyword, '%')) ORDER BY d.deckname");
        q.setParameter("keyword", keyword);
        return q.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Decks> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
