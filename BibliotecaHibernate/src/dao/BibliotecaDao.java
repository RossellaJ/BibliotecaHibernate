package dao;

import hibernateUtil.HibernateUtil;

import java.util.List;

import model.Biblioteca;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BibliotecaDao {

	

		// 1- Create

		public boolean creaBiblioteca(Biblioteca b) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.persist(b);

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
		
		public Biblioteca leggiBibliotecaConId(long idBiblioteca) {

			Biblioteca b = null;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				b = session.get(Biblioteca.class, idBiblioteca);

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return b;

		}

		// 2- Read ( con nome )

		public Biblioteca leggiBibliotecaConNome(String nome) {

			Biblioteca b = null;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();
				

				Query query = session.createQuery("from Utente where nome=:nomeInserito ");

				query.setString("nomeInserito", nome);
				

				b = (Biblioteca) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return b;

		}

		// read Tutte le biblioteche
		
		@SuppressWarnings("unchecked")
		public List<Biblioteca> getTuttegliBiblioteca(){
			
			List<Biblioteca> lista=null;
			
			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();
				

				Query query = session.createQuery("from Biblioteca");

				

				lista = (List<Biblioteca>) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}
			
			return lista;
			
			
		}
		
		
		
		
		
		
		// 4- Update

		public boolean aggiornaBiblioteca(Biblioteca b) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.update(b);

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
		public boolean eliminaBiblioteca(Biblioteca b) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.delete(b);

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

