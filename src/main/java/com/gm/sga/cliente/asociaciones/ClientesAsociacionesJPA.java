/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gm.sga.cliente.asociaciones;

import com.gm.sga.domain.Persona;
import com.gm.sga.domain.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author harold
 */
public class ClientesAsociacionesJPA {
    
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em =emf.createEntityManager();
        
        List<Persona> personas = em.createNamedQuery("Persona.findAll").getResultList();
        
        // Cerramos la conexion
        em.close();
                
        imprimirPersonas(personas);
    
    }

    /**
     * 
     * @param personas 
     */
    private static void imprimirPersonas(List<Persona> personas) {
        // objetos en estado detached o desconectados
        for(Persona persona: personas){
            log.debug("Persona: "+persona);
            //Recuperamos los usuarios de cada persona
            for(Usuario usuario: persona.getUsuarioList()){
                log.debug("Usuario: "+usuario);
            }
        }
    }
    
}
