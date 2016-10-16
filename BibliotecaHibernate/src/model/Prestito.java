package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Prestito {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPrestito;
	
	@ManyToOne
	private Libro libro;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private Biblioteca b;
	
	private Date dataPrestito;
	private Date dataRestituzione;
	
	
	
	
	
	public Prestito() {//giusto?
		
	}



	
	public Prestito(long idPrestito, Libro libro, Utente utente, Biblioteca b,
			Date dataPrestito, Date dataRestituzione) {
		super();
		this.idPrestito = idPrestito;
		this.libro = libro;
		this.utente = utente;
		this.b = b;
		this.dataPrestito = dataPrestito;
		this.dataRestituzione = dataRestituzione;
	}




	public long getIdPrestito() {
		return idPrestito;
	}
	public void setIdPrestito(long idPrestito) {
		this.idPrestito = idPrestito;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public Date getDataPrestito() {
		return dataPrestito;
	}
	public void setDataPrestito(Date dataPrestito) {
		this.dataPrestito = dataPrestito;
	}
	public Date getDataRestituzione() {
		return dataRestituzione;
	}
	public void setDataRestituzione(Date dataRestituzione) {
		this.dataRestituzione = dataRestituzione;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
