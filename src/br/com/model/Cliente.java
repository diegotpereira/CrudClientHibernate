/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.io.Serializable;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 *
 * @author Diego
 */

  

  
@Entity
@Table (name = "cliente")
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 8633415090390966715L;
  
         @Id
         @Column(name="Id")
         @GeneratedValue(strategy=GenerationType.AUTO)
         private int idcliente;
         
         @Column(name="nome")
         private String nome;
         
         @Column(name="ddd")
         private String ddd;
         
         @Column(name="telefone")
         private String telefone;
         
         @Column(name="email")
         private String email;
         
         @Column(name="cpf")
         private String cpf;
         
         @Column(name="rg")
         private String rg;
         
         @Column(name="Dtnascimento")
         private Date Dtnascimento;

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDtnascimento() {
        return Dtnascimento;
    }

    public void setDtnascimento(Date Dtnascimento) {
        this.Dtnascimento = Dtnascimento;
    }
    
     public Object[] toArray() {
        //return new Object[] {cod, nome, cpf, rg, telefone01, telefone02, observacoes, endereco, conta};   
        return new Object[] {this, nome, ddd, telefone, email, cpf, rg, Dtnascimento};
    }
    
    

   
    
}

    



