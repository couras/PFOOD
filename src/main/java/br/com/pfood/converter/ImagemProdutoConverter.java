package br.com.pfood.converter;

import br.com.pfood.bo.ImagemBO;
import br.com.pfood.model.Cidade;
import br.com.pfood.model.Cliente;
import br.com.pfood.model.ImagemProduto;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "imagemProdutoConverter")
public class ImagemProdutoConverter implements Converter {

    @Inject
    private ImagemBO bo;

    public ImagemBO getBo() {
        return bo;
    }

    public void setBo(ImagemBO bo) {
        this.bo = bo;
    }

    

    @Override
    public Object getAsObject(FacesContext arg0, UIComponent arg1, String codString) {
        try {
            int code = Integer.parseInt(codString);
            return (ImagemProduto) bo.getById(ImagemProduto.class, code);
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
                ImagemProduto gp = (ImagemProduto) obj;
                return String.valueOf(gp.getIdImagemProduto());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
