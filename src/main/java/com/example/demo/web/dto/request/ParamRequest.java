package com.example.demo.web.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@GroupSequenceProvider(value = RequestGroupSequenceProvider.class)
public class ParamRequest {

    @NotEmpty
    private String nome;
    @NotNull
    private LocalDate dataNastimento;
    private List<String> usuarios;
    @NotEmpty
    @CPF(groups = CpfGroup.class)
    @CNPJ(groups = CnpjGroup.class)
    private String cpfCnpj;
}
