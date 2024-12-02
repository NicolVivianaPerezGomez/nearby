package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the citas database table.
 * 
 */
@Entity
@Table(name="citas")
@NamedQuery(name="Cita.findAll", query="SELECT c FROM Cita c")
public class Cita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cit_id")
	private int citId;

	@Column(name="cit_estado")
	private String citEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="cit_fecha")
	private Date citFecha;

	@Column(name="cit_hora")
	private String citHora;

	@Column(name="cit_ubicación")
	private String citUbicación;

	//bi-directional many-to-one association to Match
	@ManyToOne
	@JoinColumn(name="matches_mat_id")
	private Match match;

	public Cita() {
	}

	public int getCitId() {
		return this.citId;
	}

	public void setCitId(int citId) {
		this.citId = citId;
	}

	public String getCitEstado() {
		return this.citEstado;
	}

	public void setCitEstado(String citEstado) {
		this.citEstado = citEstado;
	}

	public Date getCitFecha() {
		return this.citFecha;
	}

	public void setCitFecha(Date citFecha) {
		this.citFecha = citFecha;
	}

	public String getCitHora() {
		return this.citHora;
	}

	public void setCitHora(String citHora) {
		this.citHora = citHora;
	}

	public String getCitUbicación() {
		return this.citUbicación;
	}

	public void setCitUbicación(String citUbicación) {
		this.citUbicación = citUbicación;
	}

	public Match getMatch() {
		return this.match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

}