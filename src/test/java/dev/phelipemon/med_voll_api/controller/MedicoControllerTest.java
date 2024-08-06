package dev.phelipemon.med_voll_api.controller;

import dev.phelipemon.med_voll_api.domain.endereco.DadosEnderecoDTO;
import dev.phelipemon.med_voll_api.domain.endereco.Endereco;
import dev.phelipemon.med_voll_api.domain.medico.DadosCadastroMedicoDTO;
import dev.phelipemon.med_voll_api.domain.medico.DadosDetalhamentoMedicoDTO;
import dev.phelipemon.med_voll_api.domain.medico.Especialidade;
import dev.phelipemon.med_voll_api.domain.medico.Medico;
import dev.phelipemon.med_voll_api.repository.MedicoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class MedicoControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private JacksonTester<DadosCadastroMedicoDTO> dadosCadastroMedicoDTOJson;
    @Autowired
    private JacksonTester<DadosDetalhamentoMedicoDTO> dadosDetalhamentoMedicoDTOJson;
    @MockBean
    private MedicoRepository medicoRepository;


    @Test
    @DisplayName("Deveria devolver código http 400 quando informacoes estao invalidas")
    @WithMockUser
    void cadastrar_cenario1() throws Exception {

        var response = mvc.perform(post("/medicos"))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }


    @Test
    @DisplayName("Deveria devolver código http 201 quando informacoes estao validas")
    @WithMockUser
    void cadastrar_cenario2() throws Exception {

        var especialidade = Especialidade.ORTOPEDIA;
        var endereco = new DadosEnderecoDTO("Rua", "Nova", "71888889", "Fortal", "CE", "1", "Casa");
        var dadosCadastro = new DadosCadastroMedicoDTO("Doc", "doc.medico@med.voll", "98887788776", "233455", especialidade, endereco);
        var dadosMedico = new Medico(dadosCadastro);

        when(medicoRepository.save(any())).thenReturn(dadosMedico);


        var response = mvc
                .perform(
                        post("/medicos")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(dadosCadastroMedicoDTOJson.write(
                                        dadosCadastro
                                ).getJson())
                )
                .andReturn()
                .getResponse();

        var dadosDetalhamento = new DadosDetalhamentoMedicoDTO(
                null,
                dadosCadastro.nome(),
                dadosCadastro.email(),
                dadosCadastro.telefone(),
                dadosCadastro.crm(),
                dadosCadastro.especialidade(),
                new Endereco(dadosCadastro.endereco()));



        var jsonEsperado = dadosDetalhamentoMedicoDTOJson.write(
                dadosDetalhamento
        ).getJson();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.getContentAsString()).isEqualTo(jsonEsperado);

    }
}