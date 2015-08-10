/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.mb.imp;

import br.com.pfood.bo.ProdutoBO;
import br.com.pfood.enumerated.Imagecode;
import br.com.pfood.model.Imagem;
import br.com.pfood.model.ImagemProduto;
import br.com.pfood.model.Produto;
import br.com.pfood.model.Usuario;
import br.com.pfood.qualifier.Bundle;
import br.com.pfood.util.AppUtil;
import br.com.pfood.util.ImagemUtil;
import br.com.pfood.util.ObjectUtil;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Event;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.criterion.Order;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author r.palazzio
 */
@Named(value = "produtoMB")
@ViewScoped
public class ProdutoMB extends GenericMBImp<Produto> {

    @Inject
    ProdutoBO produtoBO;
    @Inject
    UsuarioLogadoMB usuarioLogado;
    @Inject
    Event<Produto> evtPtoduto;
    @Inject @Bundle(tipo = "urlServico") 
    transient ResourceBundle bundleServico;
    
    private Usuario user = null;
    private List<ImagemProduto> listaImagensProduto = new ArrayList<ImagemProduto>();

    public ResourceBundle getBundleServico() {
        return bundleServico;
    }

    public void setBundleServico(ResourceBundle bundleServico) {
        this.bundleServico = bundleServico;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public ProdutoBO getProdutoBO() {
        return produtoBO;
    }

    public void setProdutoBO(ProdutoBO produtoBO) {
        this.produtoBO = produtoBO;
    }

    public UsuarioLogadoMB getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(UsuarioLogadoMB usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public List<ImagemProduto> getListaImagensProduto() {
        return listaImagensProduto;
    }

    public void setListaImagensProduto(List<ImagemProduto> listaImagensProduto) {
        this.listaImagensProduto = listaImagensProduto;
    }

    @PostConstruct
    public void init() {
        super.init(produtoBO);
        user = new Usuario();
        super.getAll();
        super.novoAoGravar = false;

    }

    @Override
    public void save() {
        obj.setVendedor(usuarioLogado.getUsuario().getVendedor());
        super.save();
        evtPtoduto.fire(obj);

    }

    public void setProduto(Produto p) {
        super.obj = p;
        evtPtoduto.fire(obj);

        //carrega imagens
        ImagemProduto imgProd = ObjectUtil.preparaObjetoParaBusca(new ImagemProduto());
        imgProd.setProduto(obj);
        listaImagensProduto = produtoBO.getPorAtributosIguais(imgProd, Order.asc("sequencia"));
    }

    public void handleFileUpload(FileUploadEvent event) throws IOException {
        if (listaImagensProduto.size() <= 5) {
            String dir = AppUtil.getDirFilesVendor() + usuarioLogado.getUsuario().getVendedor().getIdVendedor() + "/";
            String fileName = event.getFile().getFileName();

            InputStream is = event.getFile().getInputstream();
            String extencao = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
            extencao = extencao.replace("jpeg", "jpg");
            if (!extencao.equalsIgnoreCase("jpg")) {
                messageUtil.addMenssageWarn("Imagens devem ser do tipo JPG");
                return;
            }
            fileName = DigestUtils.md5Hex(fileName) + "." + extencao;
            
            try {
                FileOutputStream out = new FileOutputStream(dir + "or/" + fileName);
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = is.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                out.close();
                out = null;
            } catch (Exception ex) {
                Logger.getLogger(ProdutoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            is.close();
            is = null;
            BufferedImage imagem = ImageIO.read(ImageIO.createImageInputStream(new File(dir + "or/" + fileName)));

            if (imagem.getWidth() >= 128 || imagem.getHeight() >= 128) {
                ImagemUtil.redimenImagem(dir + "sm/" + fileName, dir + "or/" + fileName, 128, 128, extencao);
            } else {
                ImagemUtil.redimenImagem(dir + "sm/" + fileName, dir + "or/" + fileName, imagem.getWidth(null), imagem.getHeight(null), extencao);
            }


            if (imagem.getWidth() >= 640 || imagem.getHeight() >= 640) {
                ImagemUtil.redimenImagem(dir + "md/" + fileName, dir + "or/" + fileName, 640, 640, extencao);
            } else {
                ImagemUtil.redimenImagem(dir + "md/" + fileName, dir + "or/" + fileName, imagem.getWidth(null), imagem.getHeight(null), extencao);
            }

            Imagem i = new Imagem();
            i.setCodigo(Imagecode.IMG_PRODUTO.getImgCode());
            i.setDescricao(event.getFile().getFileName());
            i.setHash(DigestUtils.md5Hex(event.getFile().getFileName()));
            i.setNomeArquivo(fileName);
            try {
                produtoBO.save(i);
                ImagemProduto imgProd = new ImagemProduto();
                imgProd.setProduto(obj);
                imgProd.setImagem(i);
                imgProd.setSequencia(listaImagensProduto.size() + 1);
                produtoBO.save(imgProd);
                listaImagensProduto.add(imgProd);
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(ProdutoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            messageUtil.addMenssageWarn("Maximo de 6 imagens por produto");
        }

    }
    
    public void gravarOrdenacao(){
        int i = 0;
        for(ImagemProduto imgP : listaImagensProduto){
            i++ ;        
            imgP.setSequencia(i);
            try {
                produtoBO.save(imgP);
            } catch (Exception ex) {
                ex.printStackTrace();
                Logger.getLogger(ProdutoMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void removeImagem(ActionEvent evt){
        try {
            ImagemProduto imp = produtoBO.getById(ImagemProduto.class, Integer.valueOf( FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("imgProd")));
            listaImagensProduto.remove(imp);
            produtoBO.remove(imp);
            gravarOrdenacao();
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(ProdutoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getUrlImage(ImagemProduto img){
        return bundleServico.getString("pfoodServiceImage") + "?inf=" + usuarioLogado.getUsuario().getVendedor().getIdVendedor() +"-sm-"+ img.getImagem().getNomeArquivo();
    }
}
