package dev.phelipemon.med_voll_api.domain.consulta.validacoes.agendamento;

import dev.phelipemon.med_voll_api.domain.ValidacaoException;
import dev.phelipemon.med_voll_api.domain.consulta.ConsultaRepository;
import dev.phelipemon.med_voll_api.domain.consulta.DadosAgendamentoConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsulta implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsultaDTO dados){

        var medicoPossuiOutraConsultaNoHorario = repository.existsByIdMedico_IdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoHorario){
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }

    }


}
