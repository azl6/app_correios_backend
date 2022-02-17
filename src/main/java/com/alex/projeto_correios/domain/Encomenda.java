package com.alex.projeto_correios.domain;

import com.alex.projeto_correios.domain.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Encomenda implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @ManyToOne
        @JoinColumn(name = "endereco_id")
        private Endereco enderecoDeEntrega;
        private Date dataDeEnvio;
        private Date previsaoDeEntrega;
        private String codigo;
        private Status status = Status.PENDENTE_DE_ENVIO;

        public Encomenda(Integer id, Endereco enderecoDeEntrega, Date dataDeEnvio, Date previsaoDeEntrega, String codigo, Status status) {
                this.id = id;
                this.enderecoDeEntrega = enderecoDeEntrega;
                this.dataDeEnvio = dataDeEnvio;
                this.previsaoDeEntrega = previsaoDeEntrega;
                this.codigo = codigo;
                this.status = status;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Encomenda encomenda = (Encomenda) o;
                return id.equals(encomenda.id);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id);
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Endereco getEnderecoDeEntrega() {
                return enderecoDeEntrega;
        }

        public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
                this.enderecoDeEntrega = enderecoDeEntrega;
        }

        public Date getDataDeEnvio() {
                return dataDeEnvio;
        }

        public void setDataDeEnvio(Date dataDeEnvio) {
                this.dataDeEnvio = dataDeEnvio;
        }

        public Date getPrevisaoDeEntrega() {
                return previsaoDeEntrega;
        }

        public void setPrevisaoDeEntrega(Date previsaoDeEntrega) {
                this.previsaoDeEntrega = previsaoDeEntrega;
        }

        public String getCodigo() {
                return codigo;
        }

        public void setCodigo(String codigo) {
                this.codigo = codigo;
        }

        public Status getStatus() {
                return status;
        }

        public void setStatus(Status status) {
                this.status = status;
        }
}
