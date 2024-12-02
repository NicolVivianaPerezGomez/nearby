package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the matches database table.
 * 
 */
@Entity
@Table(name="matches")
@NamedQuery(name="Match.findAll", query="SELECT m FROM Match m")
public class Match implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="mat_id")
	private int matId;

	@Column(name="mat_estado")
	private String matEstado;

	@Column(name="mat_usu1")
	private String matUsu1;

	@Column(name="mat_usu2")
	private String matUsu2;

	//bi-directional many-to-one association to Cita
	@OneToMany(mappedBy="match")
	private List<Cita> citas;

	//bi-directional many-to-one association to CategoriasMatch
	@ManyToOne
	@JoinColumn(name="categorias_matches_cat_mat_id")
	private CategoriasMatch categoriasMatch;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="matches")
	private List<Usuario> usuarios;

	public Match() {
	}

	public int getMatId() {
		return this.matId;
	}

	public void setMatId(int matId) {
		this.matId = matId;
	}

	public String getMatEstado() {
		return this.matEstado;
	}

	public void setMatEstado(String matEstado) {
		this.matEstado = matEstado;
	}

	public String getMatUsu1() {
		return this.matUsu1;
	}

	public void setMatUsu1(String matUsu1) {
		this.matUsu1 = matUsu1;
	}

	public String getMatUsu2() {
		return this.matUsu2;
	}

	public void setMatUsu2(String matUsu2) {
		this.matUsu2 = matUsu2;
	}

	public List<Cita> getCitas() {
		return this.citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public Cita addCita(Cita cita) {
		getCitas().add(cita);
		cita.setMatch(this);

		return cita;
	}

	public Cita removeCita(Cita cita) {
		getCitas().remove(cita);
		cita.setMatch(null);

		return cita;
	}

	public CategoriasMatch getCategoriasMatch() {
		return this.categoriasMatch;
	}

	public void setCategoriasMatch(CategoriasMatch categoriasMatch) {
		this.categoriasMatch = categoriasMatch;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}