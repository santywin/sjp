/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.controller;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.StreamedContent;

@Named("inscripcionPreview")
@SessionScoped
public class InscripcionPreview
        implements Serializable {

    private StreamedContent pdf;

    public StreamedContent getPdf() {
        return this.pdf;
    }

    public void setPdf(StreamedContent pdf) {
        this.pdf = pdf;
    }
}
