/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gm.sga.cliente;

import com.gm.sga.domain.Usuario;
import com.gm.sga.servicio.UsuarioServiceRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author harold
 */
public class ClienteUsuarioService {
        
    private static final String JNDI_REMOTE = "java:global/sga-jee-jpa/UsuarioServiceImpl!com.gm.sga.servicio.UsuarioServiceRemote";
    //private static final String JNDI_LOCAL = "java:global/sga-jee-jpa/UsuarioServiceImpl!com.gm.sga.servicio.UsuarioService";
    
    public static void main(String[] args) throws NamingException {
  
        

        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        
        //UsuarioServiceRemote usuarioService = (UsuarioServiceRemote) InitialContext.lookup(JNDI_REMOTE);
        
        
        Context jndi = new InitialContext();
        UsuarioServiceRemote usuarioService = (UsuarioServiceRemote) jndi.lookup(JNDI_REMOTE);
        
        
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
        System.out.println("\nFin llamada al EJB desde el cliente");

    }

}
