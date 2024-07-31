package dev.phelipemon.med_voll_api.domain.paciente;

import dev.phelipemon.med_voll_api.domain.endereco.DadosEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPacienteDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco) {

}
