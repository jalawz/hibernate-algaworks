package com.algaworks.veiculos.dominio;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tab_veiculo")
public class Veiculo {

	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	private Long codigo;

	@Column(length = 60, nullable = false)
	private String fabricante;

	@Column(length = 60, nullable = false)
	private String modelo;

	@Column(name = "ano_fabricacao", nullable = false)
	private Integer anoFabricacao;

	@Column(name = "ano_modelo", nullable = false)
	private Integer anoModelo;

	@Column(precision = 10, scale = 2, nullable = true)
	private BigDecimal valor;

	@Column(name = "tipo_combustivel", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoCombustivel tipoCombustivel;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	@Transient
	private String descricao;

	@Lob
	private String especificacoes;

	@Lob
	private byte[] foto;

	@ManyToOne
	@JoinColumn(name = "cod_proprietario")
	private Proprietario proprietario;
	
	@ManyToMany
	@JoinTable(name = "veiculo_acessorios",
		joinColumns = @JoinColumn(name = "cod_veiculo"),
		inverseJoinColumns = @JoinColumn(name = "cod_acessorio"))
	private Set<Acessorio> acessorios = new HashSet<>();

	public Veiculo() {
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDescricao() {
		return this.getFabricante() + " " + this.getModelo() + " " + this.getAnoFabricacao() + "/" + this.getAnoModelo()
				+ " por apenas " + this.getValor();
	}

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Set<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(Set<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Veiculo other = (Veiculo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
