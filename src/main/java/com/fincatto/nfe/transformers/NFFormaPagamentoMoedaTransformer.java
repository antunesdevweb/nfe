package com.fincatto.nfe.transformers;

import org.simpleframework.xml.transform.Transform;

import com.fincatto.nfe.classes.nota.NFFormaPagamentoMoeda;

public class NFFormaPagamentoMoedaTransformer implements Transform<NFFormaPagamentoMoeda> {

    @Override
    public NFFormaPagamentoMoeda read(final String codigo) throws Exception {
        return NFFormaPagamentoMoeda.valueOfCodigo(codigo);
    }

    @Override
    public String write(final NFFormaPagamentoMoeda pagamentoMoeda) throws Exception {
        return pagamentoMoeda.getCodigo();
    }
}