/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.controller;

import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.pjp.insjps.controller.util.JsfUtil;
import com.pjp.insjps.entity.Estudiantes;
import com.pjp.insjps.entity.Iglesias;
import com.pjp.insjps.entity.Inscripciones;
import com.pjp.insjps.entity.Niveles;
import com.pjp.insjps.entity.Paralelos;
import com.pjp.insjps.entity.Periodos;
import com.pjp.insjps.facade.EstudiantesFacade;
import com.pjp.insjps.facade.IglesiasFacade;
import com.pjp.insjps.facade.InscripcionesFacade;
import com.pjp.insjps.facade.ParalelosFacade;
import com.pjp.insjps.facade.PeriodosFacade;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
import java.io.Serializable;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
/*     */ import javax.annotation.PostConstruct;
/*     */ import javax.ejb.EJB;
import javax.ejb.EJBException;
/*     */ import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
/*     */ import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
/*     */ import javax.faces.event.ActionEvent;
/*     */ import javax.faces.event.ComponentSystemEvent;
/*     */ import javax.faces.view.ViewScoped;
/*     */ import javax.inject.Inject;
import javax.inject.Named;
import javax.lang.model.element.Element;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/*     */ import org.primefaces.model.DefaultStreamedContent;
/*     */ import org.primefaces.model.StreamedContent;
import org.w3c.dom.Document;

/*     */
 /*     */ @Named("inscripcionesListController")
/*     */ @ViewScoped
/*     */ public class InscripcionesListController implements Serializable {

    @EJB
    private com.pjp.insjps.facade.InscripcionesFacade ejbFacade;
    private List<Inscripciones> items = null;
    private Inscripciones selected;

    @Inject
    private ParalelosController paralelosController;
    @Inject
    private EstudiantesController estudiantesController;
    @Inject
    InscripcionPreview inscripcionPreview;
    @EJB
    private EstudiantesFacade estudiantesFacade;
    private Estudiantes estudiante = new Estudiantes();

    @EJB
    private ParalelosFacade paralelosFacade;
    @Inject
    private PeriodosFacade periodosFacade;
    @EJB
    private IglesiasFacade iglesiasFacade;
    private List<Inscripciones> inscripcionesToList = new ArrayList<>();
    private List<Paralelos> paralelosToList = new ArrayList<>();
    private List<Periodos> periodosToList = new ArrayList<>();

    private Niveles nivel;

    private Periodos periodo;
    private Paralelos paralelo;
    private Iglesias iglesia;
    private Long numIns = Long.valueOf(0);

    private boolean boolPdf = true;

    private boolean boolPanel = true;

    private StreamedContent content;

    public InscripcionesListController() {
    }

    public Inscripciones getSelected() {
        return selected;
    }

    public void setSelected(Inscripciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private InscripcionesFacade getFacade() {
        return ejbFacade;
    }

    public Inscripciones prepareCreate() {
        selected = new Inscripciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(JsfUtil.PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("InscripcionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(JsfUtil.PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("InscripcionesUpdated"));
    }

    public void destroy() {
        persist(JsfUtil.PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("InscripcionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Inscripciones> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(JsfUtil.PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != JsfUtil.PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Inscripciones getInscripciones(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Inscripciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Inscripciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Inscripciones.class)
    public static class InscripcionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            InscripcionesController controller = (InscripcionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "inscripcionesController");
            return controller.getInscripciones(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Inscripciones) {
                Inscripciones o = (Inscripciones) object;
                return getStringKey(o.getInsCodigo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Inscripciones.class.getName()});
                return null;
            }
        }

    }

    public void execute() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Executed", "Using RemoteCommand."));
    }

    @PostConstruct
    public void init() {
        if (this.periodo == null) {
            setPeriodosToList(this.periodosFacade.obtPeriodos());
            this.periodo = getPeriodosToList().get(0);
        }

        if (this.iglesia == null) {
            this.iglesia = this.iglesiasFacade.findAll().get(0);
        }
    }

    public void resetParents() {
        this.paralelosController.setSelected(null);
        this.estudiantesController.setSelected(null);
    }

    public void prepareParalelos(ActionEvent event) {
        if (getSelected() != null && this.paralelosController.getSelected() == null) {
            this.paralelosController.setSelected(((Inscripciones) getSelected()).getParalelos());
        }
    }

    public void prepareEstudiantes(ActionEvent event) {
        if (getSelected() != null && this.estudiantesController.getSelected() == null) {
            this.estudiantesController.setSelected(((Inscripciones) getSelected()).getEstudiantes());
        }
    }

    public void prepararEstudiantes() {
        prepareEstudiantes(null);
    }

    public void actualizarParalelos() {
        this.numIns = Long.valueOf(0);
        this.paralelosToList = this.paralelosFacade.obtParalelos(this.iglesia, this.nivel, this.periodo);
    }

    public void actualizarNumIns() {
        this.numIns = this.ejbFacade.obtNumIns(this.paralelo);
    }

    public void buscarEstudiante() {
        if (!this.estudiante.getEstCedula().isEmpty()) {

            this.estudiante = this.estudiantesFacade.obtEstudiante(this.estudiante.getEstCedula());
            this.inscripcionesToList = this.ejbFacade.obtInscripciones(this.estudiante);
            if (this.estudiante.getIglesias() != null) {
                this.iglesia = this.estudiante.getIglesias();
            }
            prepareCreate();
            ((Inscripciones) getSelected()).setEstudiantes(this.estudiante);
            ((Inscripciones) getSelected()).setInsFecha(new Date());
            ((Inscripciones) getSelected()).setInsValor(new Double(15.0D));
            this.numIns = Long.valueOf(0);
            if (this.paralelo != null) {
                this.numIns = this.ejbFacade.obtNumIns(this.paralelo);
            }
        }
    }

    public void guardar() {
        ((Inscripciones) getSelected()).setParalelos(this.paralelo);
        this.estudiante.setIglesias(this.iglesia);
        this.ejbFacade.guardar(this.estudiante, (Inscripciones) getSelected());
        imprimir(((Inscripciones) getSelected()).getInsCodigo());
        encerarVariables();
    }

    public void encerarVariables() {
        this.estudiante = new Estudiantes();
        this.inscripcionesToList = new ArrayList<>();
        ((Inscripciones) getSelected()).setInsObservaciones(null);
        this.numIns = Long.valueOf(0);
    }

    public void imprimir(Integer insCodigo) {
        try {
            byte[] archivo = this.ejbFacade.bytesPdf(insCodigo);
            inscripcionPreview.setPdf(new DefaultStreamedContent(new ByteArrayInputStream(archivo), "application/pdf", "ins.pdf"));

        } catch (Exception e) {
            System.out.println("Durante generacion de reporte..." + e.getMessage());
        }
    }

  


    /*
  public void onPrerender(ComponentSystemEvent event) {
    try {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
     Document document = new Document();
     PdfWriter.getInstance(document, out);
    document.open();
     for (int i = 0; i < 50; i++) {
       document.add((Element)new Paragraph("All work and no play makes Jack a dull boy"));
      }
      document.close();
     this.content = (StreamedContent)new DefaultStreamedContent(new ByteArrayInputStream(out.toByteArray()), "application/pdf");
    } catch (Exception e) {
    e.printStackTrace();
    } 
  }

     */
    public Estudiantes getEstudiante() {
        return this.estudiante;
    }

    public void setEstudiante(Estudiantes estudiante) {
        this.estudiante = estudiante;
    }

    public List<Inscripciones> getInscripcionesToList() {
        return this.inscripcionesToList;
    }

    public void setInscripcionesToList(List<Inscripciones> inscripcionesToList) {
        this.inscripcionesToList = inscripcionesToList;
    }

    public Niveles getNivel() {
        return this.nivel;
    }

    public void setNivel(Niveles nivel) {
        this.nivel = nivel;
    }

    public Periodos getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(Periodos periodo) {
        this.periodo = periodo;
    }

    public Paralelos getParalelo() {
        return this.paralelo;
    }

    public void setParalelo(Paralelos paralelo) {
        this.paralelo = paralelo;
    }

    public List<Paralelos> getParalelosToList() {
        return this.paralelosToList;
    }

    public void setParalelosToList(List<Paralelos> paralelosToList) {
        this.paralelosToList = paralelosToList;
    }

    public List<Periodos> getPeriodosToList() {
        return this.periodosToList;
    }

    public void setPeriodosToList(List<Periodos> periodosToList) {
        this.periodosToList = periodosToList;
    }

    public Iglesias getIglesia() {
        return this.iglesia;
    }

    public void setIglesia(Iglesias iglesia) {
        this.iglesia = iglesia;
    }

    public StreamedContent getContent() {
        return this.content;
    }

    public void setContent(StreamedContent content) {
        this.content = content;
    }

    public boolean isBoolPdf() {
        return this.boolPdf;
    }

    public void setBoolPdf(boolean boolPdf) {
        this.boolPdf = boolPdf;
    }

    public boolean isBoolPanel() {
        return this.boolPanel;
    }

    public void setBoolPanel(boolean boolPanel) {
        this.boolPanel = boolPanel;
    }

    public Long getNumIns() {
        return numIns;
    }

    public void setNumIns(Long numIns) {
        this.numIns = numIns;
    }



}
