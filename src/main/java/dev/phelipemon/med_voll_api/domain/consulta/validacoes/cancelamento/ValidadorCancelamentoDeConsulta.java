package dev.phelipemon.med_voll_api.domain.consulta.validacoes.cancelamento;

import dev.phelipemon.med_voll_api.domain.consulta.DadosCancelamentoConsultaDTO;

public interface ValidadorCancelamentoDeConsulta {
    void validar(DadosCancelamentoConsultaDTO dados);

}
