/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author aitor
 */
public class SelectCollectionException extends Exception{
    
    private static final long SerialVersionUID = 1L;
    public SelectCollectionException(String mensaje){
        super(mensaje);
    }
    
}
