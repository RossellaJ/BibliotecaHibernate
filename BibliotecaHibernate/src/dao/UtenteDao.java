package dao;

import hibernateUtil.HibernateUtil;

import java.util.List;

import model.Utente;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UtenteDao {
	

		// 1- Create

		public boolean creaUtente(Utente u) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.persist(u);

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
		
		public Utente leggiUtenteConId(long idUtente) {

			Utente u = null;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				u = session.get(Utente.class, idUtente);

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return u;

		}

		// 2- Read ( con nome e cognome )

		public Utente leggiUtenteConNome(String nome, String cognome) {

			Utente u = null;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();
				

				Query query = session.createQuery("from Utente where nome=:nomeInserito and cognome=:cognomeInserito ");

				query.setString("nomeInserito", nome);
				query.setString("cognomeInserito", cognome);

				u = (Utente) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}

			return u;

		}

		// read Tutte gli utenti
		
		@SuppressWarnings("unchecked")
		public List<Utente> getTuttegliUtenti(long idBiblioteca){
			
			List<Utente> lista=null;
			
			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();
				

				Query query = session.createQuery("from Voce where idBiblioteca=:idInserito ");

				query.setLong("idInserito", idBiblioteca);

				lista = (List<Utente>) query.uniqueResult();

				tx.commit();

			} catch (Exception ex) {

				tx.rollback();

			} finally {

				session.close();

			}
			
			return lista;
			
			
		}
		
		
		
		
		
		
		// 4- Update

		public boolean aggiornaUtente(Utente v) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.update(v);

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
		public boolean eliminaUtente(Utente u) {

			boolean res = false;

			Session session = HibernateUtil.openSession();

			Transaction tx = null;

			try {

				tx = session.getTransaction();

				tx.begin();

				session.delete(u);

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
