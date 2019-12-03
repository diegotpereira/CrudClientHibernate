/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Diego
 */
public class HibernateUtil {

    private static SessionFactory fabricaDeSessoes = criarFabricaDeSessoes();
    

    
    private static SessionFactory criarFabricaDeSessoes(){
    		try {
    			Configuration configuracao = new Configuration().configure();
    			
    			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
    			
    			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
    			
    			return fabrica;
    		} catch (Exception ex) {
    			System.err.println("A fábrica de sessões não pode ser criada." + ex);
    			throw new ExceptionInInitializerError(ex);
    		}
    	}

    public static SessionFactory getSessionFactory() {
       return fabricaDeSessoes;
    }
}
