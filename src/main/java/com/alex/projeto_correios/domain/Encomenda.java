package com.alex.projeto_correios.domain;

import com.alex.projeto_correios.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Encomenda implements Serializable {

        @Id
        @GenericGenerator(name = "encomenda_id", strategy = "com.alex.projeto_correios.utils.EncomendaIdGenerator")
        @GeneratedValue(generator = "encomenda_id")
        private String codigo;

        @ManyToOne
        @JoinColumn(name = "endereco_id")
        private Endereco enderecoDeEntrega;

        private Date dataDeEnvio;
        private Date previsaoDeEntrega;

        private Status status = Status.PENDENTE_DE_ENVIO;
        
        @ManyToOne
        @JoinColumn(name = "cliente_id")
        private Cliente cliente;

        public Encomenda(String codigo, Endereco enderecoDeEntrega, Date dataDeEnvio, Date previsaoDeEntrega, Status status) {
                this.codigo = codigo;
                this.enderecoDeEntrega = enderecoDeEntrega;
                this.dataDeEnvio = dataDeEnvio;
                this.previsaoDeEntrega = previsaoDeEntrega;
                this.status = status;
        }

        public Encomenda(){}

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Encomenda encomenda = (Encomenda) o;
                return codigo.equals(encomenda.codigo);
        }

        @Override
        public int hashCode() {
                return Objects.hash(codigo);
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

        public Cliente getCliente() {
                return cliente;
        }

        public void setCliente(Cliente cliente) {
                this.cliente = cliente;
        }
}
