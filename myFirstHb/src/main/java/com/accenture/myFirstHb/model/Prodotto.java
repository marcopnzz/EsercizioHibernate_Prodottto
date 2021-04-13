package com.accenture.myFirstHb.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="prodotto")
public class Prodotto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "prodotto_sq")
	
	@SequenceGenerator(name = "prodotto_sq",allocationSize = 1 , sequenceName = "PRODOTTO_SEQ")
	@Column(name="id")
	private int id;
	
	@Column(name = "nome_prodotto")
	private String nome;
	@Column(name = "categoria")
	private String categoria;
	@Column(name = "prezzo")
	private double prezzo;
	
	@OneToOne(mappedBy="prodotto")
	private DettaglioProdotto dettaglioProd;

	public Prodotto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public DettaglioProdotto getDettaglioProd() {
		return dettaglioProd;
	}

	public void setDettaglioProd(DettaglioProdotto dettaglioProd) {
		this.dettaglioProd = dettaglioProd;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((dettaglioProd == null) ? 0 : dettaglioProd.hashCode());
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prezzo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Prodotto other = (Prodotto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (dettaglioProd == null) {
			if (other.dettaglioProd != null)
				return false;
		} else if (!dettaglioProd.equals(other.dettaglioProd))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(prezzo) != Double.doubleToLongBits(other.prezzo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Prodotto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", prezzo=" + prezzo
				+ ", dettaglioProd=" + dettaglioProd + "]";
	}
	
	
}
