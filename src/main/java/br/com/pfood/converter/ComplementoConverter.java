package br.com.pfood.converter;


import br.com.pfood.bo.CidadeBO;
import br.com.pfood.bo.ComplementoBO;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Cliente;
import br.com.pfood.model.Complemento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "complementoConverter")
public class ComplementoConverter implements Converter {

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
            int code = Integer.parseInt(codString);
            return (Complemento) bo.getById(Complemento.class, code);
        } catch (Exception e) {
            System.out.println("ERRO DE CONVERSÃO DO FILTRO" + e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
        try {
            if (obj != null) {
                Complemento gp = (Complemento) obj;
                return String.valueOf(gp.getIdComplemento());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
