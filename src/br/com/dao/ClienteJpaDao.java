package br.com.dao;

import br.com.model.Cliente;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
public class ClienteJpaDao extends GenericaDAO {
    
    public ClienteJpaDao(){
        super();
    }
    
     public List<Cliente> listarTodos() {
        return listar(Cliente.class);
    }
     
      public List<Cliente> procuraPessoa(String nome){
        return  procuraPorNome(Cliente.class,"nome", nome);
    }
    
    public List<Cliente> procuraCPF(String nome){
        return  procuraPorNome(Cliente.class,"cpf", nome);
    }
    
}
