package com.example.demo.web.dto.request;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RequestGroupSequenceProvider implements DefaultGroupSequenceProvider<ParamRequest> {

    private static final String cpfPattern = "\\d{11}";

    @Override
    public List<Class<?>> getValidationGroups(ParamRequest paramRequest) {

        List<Class<?>> groups = new ArrayList<>();

        groups.add(ParamRequest.class);

        if(Objects.nonNull(paramRequest)
                && Objects.nonNull(paramRequest.getCpfCnpj())
                && paramRequest.getCpfCnpj().matches(cpfPattern)) {

            groups.add(CpfGroup.class);
        } else {

            groups.add(CnpjGroup.class);
        }

        return groups;
    }
}
