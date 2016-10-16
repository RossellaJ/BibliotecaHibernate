package dao;

import hibernateUtil.HibernateUtil;

import java.util.List;

import model.Libro;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LibroDao {
		

			// 1- Create

			public boolean creaLibro(Libro l) {

				boolean res = false;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					session.persist(l);

					tx.commit();

					res = true;

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return res;

			}
			
			//2)Leggi 
			
			public Libro leggiLibroConId(long idLibro) {

				Libro l = null;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					l = session.get(Libro.class, idLibro);

					tx.commit();

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return l;

			}

			// 2- Read ( con nome )

			public Libro leggiLibroConTitoloautoreSerialNum(String titolo,String autore, String serialNum) {

				Libro l = null;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();
					

					Query query = session.createQuery("from Utente where titolo=:titoloInserito and autore=:autoreInserito and serialNum=:serialNumInserito ");

					query.setString("titoloInserito", titolo);
					query.setString("autoreInserito", autore);
					query.setString("serialNumInserito", serialNum);
					
					l = (Libro) query.uniqueResult();

					tx.commit();

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return l;

			}

			// read Tutte le biblioteche
			
			@SuppressWarnings("unchecked")
			public List<Libro> getTutteiLibri(long idBiblioteca){
				
				List<Libro> lista=null;
				
				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();
					

					Query query = session.createQuery("from Libro where idBiblioteca=:idInserito ");

					query.setLong("idInserito", idBiblioteca);

					lista = (List<Libro>) query.uniqueResult();

					tx.commit();

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}
				
				return lista;
				
				
			}
			
			
			
			
			
			
			// 4- Update

			public boolean aggiornaBiblioteca(Libro l) {

				boolean res = false;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					session.update(l);

					tx.commit();

					res = true;

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return res;

			}
		//Delete
			public boolean eliminaBiblioteca(Libro l) {

				boolean res = false;

				Session session = HibernateUtil.openSession();

				Transaction tx = null;

				try {

					tx = session.getTransaction();

					tx.begin();

					session.delete(l);

					tx.commit();

					res = true;

				} catch (Exception ex) {

					tx.rollback();

				} finally {

					session.close();

				}

				return res;

			}


	}




