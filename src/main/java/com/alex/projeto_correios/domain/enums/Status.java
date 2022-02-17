package com.alex.projeto_correios.domain.enums;

public enum Status {

    ENVIADO("Enviado"),
    ENTREGUE("Entregue"),
    PENDENTE_DE_ENVIO("Pendente de envio");

    private String status;

    Status(String status) {
        this.status = status;
    }
}
