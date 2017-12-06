/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Cards;
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
@Path("entities.cards")
public class CardsFacadeREST extends AbstractFacade<Cards> {
    @PersistenceContext(unitName = "MyFlashCardWSPU")
    private EntityManager em;

    public CardsFacadeREST() {
        super(Cards.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Cards entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Cards entity) {
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
    public Cards find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Cards> findAll() {
        return super.findAll();
    }
    
    @GET
    @Path("findAllCardsOrderByPriority")
    @Produces({"application/xml", "application/json"})
    public List<Cards> findAllCardsOrderByPriority() {
        Query q = em.createQuery("SELECT c FROM Cards c ORDER BY c.priority");
        return q.getResultList();
    }
    
    @GET
    @Path("findByDeckid/{deckid}")
    @Produces({"application/xml", "application/json"})
    public List<Cards> findByDeckid(@PathParam("deckid") String deckid) {
        Query q = em.createQuery("SELECT c FROM Cards c WHERE c.deckid = " + deckid + " ORDER BY c.priority");
        return q.getResultList();
    }

    @GET
    @Path("findByDeckname/{deckname}")
    @Produces({"application/xml", "application/json"})
    public List<Cards> findByDeckname(@PathParam("deckname") String deckname) {
        Query q = em.createQuery("SELECT c FROM Cards c JOIN Decks d ON c.deckid = d.id WHERE d.deckname = :deckname ORDER BY c.priority");
        q.setParameter("deckname", deckname);
        return q.getResultList();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Cards> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
