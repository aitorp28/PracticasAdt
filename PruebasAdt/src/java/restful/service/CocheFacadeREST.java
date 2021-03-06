/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful.service;

import entities.Coche;
import exception.SelectCollectionException;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aitor
 */
@Stateless
@Path("entities.coche")
public class CocheFacadeREST extends AbstractFacade<Coche> {

        private static final Logger LOGGER = Logger.getLogger("package.class");
    @PersistenceContext(unitName = "PruebasAdtPU")
    private EntityManager em;

    public CocheFacadeREST() {
        super(Coche.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, })
    public void create(Coche entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, })
    public void edit(@PathParam("id") Integer id, Coche entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, })
    public Coche find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("marca/{marca}")
    @Produces({MediaType.APPLICATION_XML, })
    public List<Coche> listCarByMarca(@PathParam("marca") String marca) throws SelectCollectionException {
        List<Coche> coches = null;
        try{
           coches =  em.createNamedQuery("listCarByMarca")
               .setParameter("marca", marca)
               .getResultList(); 
        }catch(Exception e){
           LOGGER.info("la marca no esta bien" + e);
           throw new SelectCollectionException(e.getMessage());
        }
       
           return coches;    
    }
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, })
    public List<Coche> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, })
    public List<Coche> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
