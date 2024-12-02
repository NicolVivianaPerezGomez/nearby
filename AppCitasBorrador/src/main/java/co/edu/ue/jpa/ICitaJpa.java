package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Cita;

public interface ICitaJpa extends JpaRepository<Cita, Integer> {

}
