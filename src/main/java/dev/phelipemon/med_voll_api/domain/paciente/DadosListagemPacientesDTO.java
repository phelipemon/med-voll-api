package dev.phelipemon.med_voll_api.domain.paciente;

public record DadosListagemPacientesDTO(
        Long id,
        String nome,
        String email,
        String cpf) {

    public DadosListagemPacientesDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
}
