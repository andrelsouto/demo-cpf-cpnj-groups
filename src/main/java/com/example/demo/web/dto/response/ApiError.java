package com.example.demo.web.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ApiError {

    private LocalDateTime dataHora;
    private String mensagem;
    private List<ObjetoErro> erros;

}
