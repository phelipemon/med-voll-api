package dev.phelipemon.med_voll_api.domain.paciente;

import dev.phelipemon.med_voll_api.domain.endereco.Endereco;

public record DadosDetalhamentoPacienteDTO(Long id, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
