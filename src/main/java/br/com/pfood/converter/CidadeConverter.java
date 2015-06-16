package br.com.pfood.converter;


import br.com.pfood.bo.CidadeBO;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Cliente;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "cidadeConverter")
public class CidadeConverter implements Converter {

    @Inject
    private CidadeBO bo;

    public CidadeBO getBo() {
        return bo;
    }

    public void setBo(CidadeBO bo) {
        this.bo = bo;
    }


    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String codString) {
        try {
            int code = Integer.parseInt(codString);
            return (Cidade) bo.getById(Cidade.class, code);
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
                Cidade ci = (Cidade) obj;
                return String.valueOf(ci.getIdCidade());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
