/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Classes;
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
@Path("entities.classes")
public class ClassesFacadeREST extends AbstractFacade<Classes> {
    @PersistenceContext(unitName = "MyFlashCardWSPU")
    private EntityManager em;

    public ClassesFacadeREST() {
        super(Classes.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Classes entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Classes entity) {
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
    public Classes find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    
    @GET
    @Path("allClassesOrderByClassnum")
    @Produces({"application/xml", "application/json"})
    public List<Classes> findAllOrderByClassnum() {
        Query q = em.createQuery("SELECT c FROM Classes c ORDER BY c.classnumber");
        return q.getResultList();
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Classes> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Classes> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
