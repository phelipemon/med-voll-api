package dev.phelipemon.med_voll_api.domain.consulta.validacoes.cancelamento;

import dev.phelipemon.med_voll_api.domain.ValidacaoException;
import dev.phelipemon.med_voll_api.domain.consulta.ConsultaRepository;
import dev.phelipemon.med_voll_api.domain.consulta.DadosCancelamentoConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioDeCancelamento implements ValidadorCancelamentoDeConsulta {

    @Autowired
    private ConsultaRepository repository;
    @Override
    public void validar(DadosCancelamentoConsultaDTO dados){

        var consulta = repository.getReferenceById(dados.idConsulta());
        var agora = LocalDateTime.now();
        var diferencaEmHoras = Duration.between(agora, consulta.getData()).toHours();

        if (diferencaEmHoras < 24){
            throw new ValidacaoException("Consulta só pode ser cancelada com antecedência mínima de 24 horas.");
        }


    }
}
