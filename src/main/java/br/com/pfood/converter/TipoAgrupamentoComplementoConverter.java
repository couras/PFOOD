package br.com.pfood.converter;


import br.com.pfood.bo.CidadeBO;
import br.com.pfood.bo.ComplementoBO;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Cliente;
import br.com.pfood.model.Complemento;
import br.com.pfood.model.TipoAgrupamentoComplemento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "tipoAgrupamentoComplementoConverter")
public class TipoAgrupamentoComplementoConverter implements Converter {

    @Inject
    private ComplementoBO bo;

    public ComplementoBO getBo() {
        return bo;
    }

    public void setBo(ComplementoBO bo) {
        this.bo = bo;
    }

    

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String codString) {
        try {
           if(codString!=null && !codString.equals("")){
            int code = Integer.parseInt(codString);
            return (TipoAgrupamentoComplemento) bo.getById(TipoAgrupamentoComplemento.class, code);
           }
        
        } catch (Exception e) {
            System.out.println("ERRO DE CONVERSÃO DO FILTRO" + e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
        try {
            if (obj != null && !obj.equals("")) {
                TipoAgrupamentoComplemento gp = (TipoAgrupamentoComplemento) obj;
                return String.valueOf(gp.getIdTipoAgrupamentoComplemento());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
