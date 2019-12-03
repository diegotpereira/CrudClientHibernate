/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Diego
 */
public class GenericaDAO {
    
     public Session retornaSessao() {
        Session sess = null;
        try {
            sess = HibernateUtil.getSessionFactory().getCurrentSession();
        } catch (org.hibernate.HibernateException he) {
            sess = HibernateUtil.getSessionFactory().openSession();
        }
        return sess;
    }
    
    public List listar(Class classe) {

        List lista = null;
        Session sessao = null;
        try {
            //sessao = HibernateUtil.getSessionFactory().openSession();
            sessao = retornaSessao();
            sessao.beginTransaction();

            Criteria cons = sessao.createCriteria(classe);
            lista = cons.list();

            sessao.getTransaction().commit();

        } catch (HibernateException e) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            lista = null;
            throw new HibernateException(e);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
            return lista;
        }
    }
    public List procuraPorNome(Class classe, String nomeColuna, String nomePesquisa) {

        List lista = null;
        Session sessao = null;
        try {
            //sessao = HibernateUtil.getSessionFactory().openSession();
            sessao = retornaSessao();
            sessao.beginTransaction();

            Criteria criteria = sessao.createCriteria(classe)
                    .add(Restrictions.like(nomeColuna, nomePesquisa));
            lista = criteria.list();

            sessao.getTransaction().commit();

        } catch (HibernateException e) {
            if (sessao != null) {
                sessao.getTransaction().rollback();
            }
            lista = null;
            throw new HibernateException(e);
        } finally {
            if (sessao != null) {
                sessao.close();
            }
            return lista;
        }
    }
    
}
