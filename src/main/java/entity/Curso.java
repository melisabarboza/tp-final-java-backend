package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer idCurso;

	@Column(name = "nombre_curso")
	String nombreCurso;

	@Column(name = "descripcion_curso")
	String descripciónCurso;

	@Column(name = "modalidad_curso")
	String modalidadCurso;

	@Column(name = "costo_curso")
	Integer costoCurso;

	@Column(name = "horas_curso")
	Integer horasCurso;

	@Column(name = "categoria_curso")
	String categoríaCurso;

	@Column(name = "numero_participantes")
	Integer númeroParticipantes;

	@Column(name = "numero_cupos_becas")
	Integer númeroCuposConBeca;

	public Curso(String nombre, String descripcion, String modalidad, Integer costoCurso2, Integer horas,
			String categoria, Integer numeroParticipantes, Integer cuposConBecas) {
		// TODO Auto-generated constructor stub
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public String getDescripciónCurso() {
		return descripciónCurso;
	}

	public void setDescripciónCurso(String descripciónCurso) {
		this.descripciónCurso = descripciónCurso;
	}

	public String getModalidadCurso() {
		return modalidadCurso;
	}

	public void setModalidadCurso(String modalidadCurso) {
		this.modalidadCurso = modalidadCurso;
	}

	public Integer getCostoCurso() {
		return costoCurso;
	}

	public void setCostoCurso(Integer costoCurso) {
		this.costoCurso = costoCurso;
	}

	public Integer getHorasCurso() {
		return horasCurso;
	}

	public void setHorasCurso(Integer horasCurso) {
		this.horasCurso = horasCurso;
	}

	public String getCategoríaCurso() {
		return categoríaCurso;
	}

	public void setCategoríaCurso(String categoríaCurso) {
		this.categoríaCurso = categoríaCurso;
	}

	public Integer getNúmeroParticipantes() {
		return númeroParticipantes;
	}

	public void setNúmeroParticipantes(Integer númeroParticipantes) {
		this.númeroParticipantes = númeroParticipantes;
	}

	public Integer getNúmeroCuposConBeca() {
		return númeroCuposConBeca;
	}

	public void setNúmeroCuposConBeca(Integer númeroCuposConBeca) {
		this.númeroCuposConBeca = númeroCuposConBeca;
	}

}
