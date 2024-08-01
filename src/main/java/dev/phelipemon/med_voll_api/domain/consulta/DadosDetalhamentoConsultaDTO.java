package dev.phelipemon.med_voll_api.domain.consulta;

import dev.phelipemon.med_voll_api.domain.medico.Medico;
import dev.phelipemon.med_voll_api.domain.paciente.Paciente;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsultaDTO(
        Long id,
        Long idMedico,
        Long idPaciente,
        LocalDateTime data) {

    public DadosDetalhamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getIdMedico().getId(), consulta.getIdPaciente().getId(), consulta.getData());
    }
}
