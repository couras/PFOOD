package br.com.pfood.converter;


import br.com.pfood.bo.CidadeBO;
import br.com.pfood.bo.GrupoProdutoBO;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Cliente;
import br.com.pfood.model.GrupoProduto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "grupoProdutoConverter")
public class GrupoProdutoConverter implements Converter {

    @Inject
    private GrupoProdutoBO bo;

    public GrupoProdutoBO getBo() {
        return bo;
    }

    public void setBo(GrupoProdutoBO bo) {
        this.bo = bo;
    }

    

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String codString) {
        try {
            int code = Integer.parseInt(codString);
            return (GrupoProduto) bo.getById(GrupoProduto.class, code);
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
                GrupoProduto gp = (GrupoProduto) obj;
                return String.valueOf(gp.getIdGrupoProduto());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
