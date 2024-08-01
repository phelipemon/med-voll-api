package dev.phelipemon.med_voll_api.domain.consulta;

import jakarta.validation.constraints.NotNull;
public record DadosCancelamentoConsultaDTO(
        @NotNull
        Long idConsulta,

        @NotNull
        MotivoCancelamento motivo) {
    public DadosCancelamentoConsultaDTO(Consulta consulta) {
        this(consulta.getId(), consulta.getMotivoCancelamento());
    }
}