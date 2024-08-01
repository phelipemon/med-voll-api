package dev.phelipemon.med_voll_api.domain.consulta.validacoes.agendamento;

import dev.phelipemon.med_voll_api.domain.ValidacaoException;
import dev.phelipemon.med_voll_api.domain.consulta.DadosAgendamentoConsultaDTO;
import dev.phelipemon.med_voll_api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsultaDTO dados){

        //escolha do médico é opcional
        if (dados.idMedico() == null){
            return;
        }

        var medicoestaAtivo = repository.findByAtivoById(dados.idMedico());
        if (!medicoestaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com um médico inativo!");
        }
    }
}
