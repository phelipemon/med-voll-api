package dev.phelipemon.med_voll_api.repository;

import dev.phelipemon.med_voll_api.domain.paciente.Paciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            SELECT p.ativo FROM Paciente p
            WHERE p.id = :id
            """)
    boolean findAtivoById(Long id);
}
