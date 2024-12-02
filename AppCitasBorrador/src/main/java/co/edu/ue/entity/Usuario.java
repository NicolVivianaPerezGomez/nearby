package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usu_id")
	private String usuId;

	@Column(name="usu_contraseña")
	private String usuContraseña;

	@Column(name="usu_edad")
	private String usuEdad;

	@Column(name="usu_email")
	private String usuEmail;

	@Column(name="usu_genero")
	private String usuGenero;

	@Column(name="usu_nombre")
	private String usuNombre;

	//bi-directional many-to-one association to Perfile
	@ManyToOne
	@JoinColumn(name="perfiles_per_id")
	private Perfiles perfile;

	//bi-directional many-to-many association to Match
	@ManyToMany
	@JoinTable(
		name="usuarios_has_matches"
		, joinColumns={
			@JoinColumn(name="usuarios_usu_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="matches_mat_id")
			}
		)
	private List<Match> matches;

	public Usuario() {
	}

	public String getUsuId() {
		return this.usuId;
	}

	public void setUsuId(String usuId) {
		this.usuId = usuId;
	}

	public String getUsuContraseña() {
		return this.usuContraseña;
	}

	public void setUsuContraseña(String usuContraseña) {
		this.usuContraseña = usuContraseña;
	}

	public String getUsuEdad() {
		return this.usuEdad;
	}

	public void setUsuEdad(String usuEdad) {
		this.usuEdad = usuEdad;
	}

	public String getUsuEmail() {
		return this.usuEmail;
	}

	public void setUsuEmail(String usuEmail) {
		this.usuEmail = usuEmail;
	}

	public String getUsuGenero() {
		return this.usuGenero;
	}

	public void setUsuGenero(String usuGenero) {
		this.usuGenero = usuGenero;
	}

	public String getUsuNombre() {
		return this.usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public Perfiles getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfiles perfile) {
		this.perfile = perfile;
	}

	public List<Match> getMatches() {
		return this.matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

}