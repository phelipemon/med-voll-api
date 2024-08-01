package dev.phelipemon.med_voll_api.domain.consulta.validacoes.agendamento;

import dev.phelipemon.med_voll_api.domain.consulta.DadosAgendamentoConsultaDTO;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsultaDTO dados);
}
