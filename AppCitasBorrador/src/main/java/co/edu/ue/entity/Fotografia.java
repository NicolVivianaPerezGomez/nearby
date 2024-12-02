package co.edu.ue.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the fotografias database table.
 * 
 */
@Entity
@Table(name="fotografias")
@NamedQuery(name="Fotografia.findAll", query="SELECT f FROM Fotografia f")
public class Fotografia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fot_id")
	private int fotId;

	@Temporal(TemporalType.DATE)
	@Column(name="fot_fechasubida")
	private Date fotFechasubida;

	//bi-directional many-to-one association to Perfile
	@ManyToOne
	@JoinColumn(name="perfiles_per_id")
	private Perfiles perfile;

	public Fotografia() {
	}

	public int getFotId() {
		return this.fotId;
	}

	public void setFotId(int fotId) {
		this.fotId = fotId;
	}

	public Date getFotFechasubida() {
		return this.fotFechasubida;
	}

	public void setFotFechasubida(Date fotFechasubida) {
		this.fotFechasubida = fotFechasubida;
	}

	public Perfiles getPerfile() {
		return this.perfile;
	}

	public void setPerfile(Perfiles perfile) {
		this.perfile = perfile;
	}

}