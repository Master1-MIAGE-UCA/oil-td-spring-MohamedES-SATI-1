package fr.unica.miage.essati.dice.repository;

import fr.unica.miage.essati.dice.entity.DiceRollLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiceRollLogRepository extends JpaRepository<DiceRollLog, Long> {
}