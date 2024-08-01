package dev.phelipemon.med_voll_api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByIdMedico_IdAndData(Long medicoId, LocalDateTime data);

    boolean existsByIdPaciente_IdAndDataBetween(Long pacienteId, LocalDateTime primeiraHora, LocalDateTime ultimaHora);

}
