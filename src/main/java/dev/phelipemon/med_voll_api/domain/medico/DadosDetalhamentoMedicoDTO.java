package dev.phelipemon.med_voll_api.domain.medico;

import dev.phelipemon.med_voll_api.domain.endereco.Endereco;

public record DadosDetalhamentoMedicoDTO(Long id, String nome, String email, String telefone, String  crm, Especialidade especialidade, Endereco endereco) {

    public DadosDetalhamentoMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }

}
