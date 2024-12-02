package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Match;

public interface IMatchJpa extends JpaRepository<Match, Integer> {

}
