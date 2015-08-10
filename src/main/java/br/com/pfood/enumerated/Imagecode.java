/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pfood.enumerated;

/**
 *
 * @author palazzio
 */
public enum Imagecode {
    IMG_PRODUTO(1),
    IMG_USER_PERFIL(2);
    
    private int imgCode;

    public int getImgCode() {
        return imgCode;
    }

    public void setImgCode(int imgCode) {
        this.imgCode = imgCode;
    }

    private Imagecode(int imgCode) {
        this.imgCode = imgCode;
    }
    
}
