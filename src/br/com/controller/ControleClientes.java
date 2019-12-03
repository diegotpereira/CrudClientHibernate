/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.ClienteJpaDao;
import br.com.model.Cliente;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Diego
 */
public class ControleClientes {
    
    ClienteJpaDao clientejpadao;
    
    public ControleClientes(){
        
        clientejpadao = new ClienteJpaDao();
    
    }
    
     public List<Cliente> listarPessoas(int tipo, String pesq) throws SQLException {
        List<Cliente> lista = null;
        switch (tipo) {
            case 0:
                lista = clientejpadao.listarTodos();
                break;
            case 1:
                lista = clientejpadao.procuraPessoa("%"+pesq+"%");
                break;
            case 2:
                lista = clientejpadao.procuraCPF(pesq);
                break;
        }

        return lista;
    }
    
    
}
