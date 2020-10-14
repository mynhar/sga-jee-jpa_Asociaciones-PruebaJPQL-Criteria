/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gm.sga.cliente.cascada;

import com.gm.sga.domain.Persona;
import com.gm.sga.domain.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author harold
 */
public class PersistenciaCascadaJPA {
    
        static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args){
    
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ConsolaJpqlPU");
        EntityManager em =emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        // Paso1. Crear nuevo objeto
        // Objeto en estado transitivo
        Persona persona = new Persona("Harold","Millas","Nauticas","hmbonilla@gmail.com","123456789");
        
        // Creamos el objeto usuario. tiene dependencia a un objeto persona.
        Usuario usuario = new Usuario("hmn","123",persona);
        
        //Paso 2. Inicia Transaccion
        tx.begin();
        
        //Paso 3. Ejecuta SQL.
        // Solo persistimos el objeto usuarii
        // No hay becesidad de persistir el objeto persona, lo hara por cascada
        em.persist(usuario);
        
        //Paso 4. Commit/rollback
        tx.commit();
        
        // objetos en estado detached
        log.debug("Objeto persistido usuario: "+ usuario);
        log.debug("Objeto persistido persona: "+ persona);
        
        // Cerramos el Entity Manager
        em.close();
    
    }
}
