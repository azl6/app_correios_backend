package com.alex.projeto_correios.domain.enums;

import java.io.Serializable;

public enum Status implements Serializable {

    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    PENDENTE_DE_ENVIO("Pendente de envio");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
