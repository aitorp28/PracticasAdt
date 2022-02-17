/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restful;

import entities.CocheAccidente;
import entities.CocheAccidenteId;
import exceptions.SelectCollectionException;
import java.util.List;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author aitor
 */
@Stateless
@Path("entities.cocheaccidente")
public class CocheAccidenteFacadeREST extends AbstractFacade<CocheAccidente> {

    @PersistenceContext(unitName = "PruebaExamenPU")
    private EntityManager em;

    private CocheAccidenteId getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;cocheId=cocheIdValue;accidenteId=accidenteIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entities.CocheAccidenteId key = new entities.CocheAccidenteId();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> cocheId = map.get("cocheId");
        if (cocheId != null && !cocheId.isEmpty()) {
            key.setCocheId(new java.lang.Integer(cocheId.get(0)));
        }
        java.util.List<String> accidenteId = map.get("accidenteId");
        if (accidenteId != null && !accidenteId.isEmpty()) {
            key.setAccidenteId(new java.lang.Integer(accidenteId.get(0)));
        }
        return key;
    }

    public CocheAccidenteFacadeREST() {
        super(CocheAccidente.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(CocheAccidente entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, CocheAccidente entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entities.CocheAccidenteId key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public CocheAccidente find(@PathParam("id") PathSegment id) {
        entities.CocheAccidenteId key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CocheAccidente> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<CocheAccidente> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }
    
     @GET
   @Path("numero/{numero}")
    @Produces({MediaType.APPLICATION_XML})
    public List<CocheAccidente> findCocheByAccidente(@PathParam("numero") Integer numero) throws SelectCollectionException {
        List<CocheAccidente> resultado=null;
        try{
            resultado = em.createNamedQuery("findCocheByAccidente")
                    .setParameter("numero", numero)
                    .getResultList();
        }catch(Exception e){
            throw new SelectCollectionException(e.getMessage());
            
        }
        return resultado;
    }

    
     @GET
   @Path("numero1/{numero1}")
    @Produces({MediaType.APPLICATION_XML})
    public List<CocheAccidente> finddeUnCocheQueAccidentes(@PathParam("numero1") Integer numero1) throws SelectCollectionException {
        List<CocheAccidente> resultado=null;
        try{
            resultado = em.createNamedQuery("finddeUnCocheQueAccidentes")
                    .setParameter("numero1", numero1)
                    .getResultList();
        }catch(Exception e){
            throw new SelectCollectionException(e.getMessage());
            
        }
        return resultado;
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
