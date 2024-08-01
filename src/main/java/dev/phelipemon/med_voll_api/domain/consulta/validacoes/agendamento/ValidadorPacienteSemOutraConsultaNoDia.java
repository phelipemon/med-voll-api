package dev.phelipemon.med_voll_api.domain.consulta.validacoes.agendamento;

import dev.phelipemon.med_voll_api.domain.ValidacaoException;
import dev.phelipemon.med_voll_api.domain.consulta.ConsultaRepository;
import dev.phelipemon.med_voll_api.domain.consulta.DadosAgendamentoConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private ConsultaRepository repository;
    public void validar(DadosAgendamentoConsultaDTO dados) {

        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByIdPaciente_IdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui uma consulta agendada nesse dia");
        }


    }


}
