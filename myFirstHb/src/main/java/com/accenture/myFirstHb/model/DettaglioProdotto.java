package com.accenture.myFirstHb.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity 
@Table(name = "dettaglioProdotto")
public class DettaglioProdotto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "dettaglio_seq")
	
	@SequenceGenerator(name = "dettaglio_seq",allocationSize = 1 , sequenceName = "DETTAGLIO_SEQ")
	@Column(name="id_dett")
	private int id_dett;
	
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "qta")
	private Double quantita;
	
	@Column(name = "fornitore")
	private String Fornitore;
	
	@OneToOne 
	@JoinColumn(name="prodotto",unique = true)
	private Prodotto prodotto;
	
	
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public DettaglioProdotto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId_dett() {
		return id_dett;
	}
	public void setId_dett(int id_dett) {
		this.id_dett = id_dett;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Double getQuantita() {
		return quantita;
	}
	public void setQuantita(Double quantita) {
		this.quantita = quantita;
	}
	public String getFornitore() {
		return Fornitore;
	}
	public void setFornitore(String fornitore) {
		Fornitore = fornitore;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fornitore == null) ? 0 : Fornitore.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + id_dett;
		result = prime * result + ((quantita == null) ? 0 : quantita.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DettaglioProdotto other = (DettaglioProdotto) obj;
		if (Fornitore == null) {
			if (other.Fornitore != null)
				return false;
		} else if (!Fornitore.equals(other.Fornitore))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (id_dett != other.id_dett)
			return false;
		if (quantita == null) {
			if (other.quantita != null)
				return false;
		} else if (!quantita.equals(other.quantita))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DettaglioProdotto [id_dett=" + id_dett + ", descrizione=" + descrizione
				+ ", quantita=" + quantita + ", Fornitore=" + Fornitore + "]";
	}
	
	
	


}
