package com.fincatto.nfe.classes.nota;

import org.simpleframework.xml.Element;

import com.fincatto.nfe.classes.NFBase;
import com.fincatto.nfe.classes.NFUnidadeFederativa;
import com.fincatto.nfe.validadores.StringValidador;

public class NFNotaInfoLocal extends NFBase {
    @Element(name = "CNPJ", required = false)
    private String cnpj;

    @Element(name = "CPF", required = false)
    private String cpf;

    @Element(name = "xLgr", required = true)
    private String logradouro;

    @Element(name = "nro", required = true)
    private String numero;

    @Element(name = "xCpl", required = false)
    private String complemento;

    @Element(name = "xBairro", required = true)
    private String bairro;

    @Element(name = "cMun", required = true)
    private String codigoMunicipio;

    @Element(name = "xMun", required = true)
    private String nomeMunicipio;

    @Element(name = "UF", required = true)
    private String uf;

    public void setCnpj(final String cnpj) {
        if (this.cpf != null) {
            throw new IllegalStateException("Nao pode setar CNPJ por que o CPF foi setado");
        }
        StringValidador.cnpj(cnpj);
        this.cnpj = cnpj;
    }

    public void setCpf(final String cpf) {
        if (this.cnpj != null) {
            throw new IllegalStateException("Nao pode setar CPF por que o CNPJ foi setado");
        }
        StringValidador.cpf(cpf);
        this.cpf = cpf;
    }

    public void setLogradouro(final String logradouro) {
        StringValidador.tamanho60(logradouro);
        this.logradouro = logradouro;
    }

    public void setNumero(final String numero) {
        StringValidador.tamanho60(numero);
        this.numero = numero;
    }

    public void setComplemento(final String complemento) {
        StringValidador.tamanho60(complemento);
        this.complemento = complemento;
    }

    public void setBairro(final String bairro) {
        StringValidador.tamanho2ate60(bairro);
        this.bairro = bairro;
    }

    public void setCodigoMunicipio(final String codigoMunicipio) {
        StringValidador.exatamente7(codigoMunicipio);
        this.codigoMunicipio = codigoMunicipio;
    }

    public void setNomeMunicipio(final String nomeMunicipio) {
        StringValidador.tamanho60(nomeMunicipio);
        this.nomeMunicipio = nomeMunicipio;
    }

    public void setUf(final NFUnidadeFederativa uf) {
        this.uf = uf.getCodigo();
    }
}