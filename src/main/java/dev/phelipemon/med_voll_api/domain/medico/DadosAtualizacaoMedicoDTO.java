package dev.phelipemon.med_voll_api.domain.medico;

import dev.phelipemon.med_voll_api.domain.endereco.DadosEnderecoDTO;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedicoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco) {
}
