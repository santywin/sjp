/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.insjps.facade;

import com.pjp.insjps.controller.util.JsfUtil;
import com.pjp.insjps.entity.Estudiantes;
import com.pjp.insjps.entity.Inscripciones;
import com.pjp.insjps.entity.Paralelos;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.omnifaces.util.Faces;

/**
 *
 * @author Santiago
 */
@Stateless
public class InscripcionesFacade extends AbstractFacade<Inscripciones> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @EJB
    /*     */ private EstudiantesFacade estudiantesFacade;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InscripcionesFacade() {
        super(Inscripciones.class);
    }

    /*     */ public void guardar(Estudiantes estudiante, Inscripciones inscripcion) {
        /*  51 */ if (estudiante.getEstCodigo() != null) {
            /*  52 */ this.estudiantesFacade.edit(estudiante);
            /*     */        } else {
            /*     */
 /*  55 */ this.estudiantesFacade.create(estudiante);
            /*     */        }
        /*     */
 /*     */
 /*  59 */ create(inscripcion);
        /*     */
 /*  61 */ if (!JsfUtil.isValidationFailed()) {
            /*  62 */ JsfUtil.addSuccessMessage("Inscripcion Guardada");
            /*     */        }
        /*     */
 /*  65 */ System.out.println("parece q inscribio");
        /*     */    }

    /*     */
 /*     */
    public List<Inscripciones> obtInscripciones(Estudiantes estudiante) {
        /*  82 */ TypedQuery typedQuery = this.em.createQuery("SELECT i FROM Inscripciones i WHERE i.estudiantes = :estudiante", Inscripciones.class).setParameter("estudiante", estudiante);
        /*     */
 /*     */ try {
            /*  85 */ return typedQuery.getResultList();
            /*     */
 /*     */        } /*  88 */ catch (Exception e) {
            /*  89 */ return new ArrayList<>();
            /*     */        }
        /*     */    }

    /*     */ public List<Inscripciones> getInscripciones(Paralelos paralelo) {
        /*  94 */ TypedQuery<Inscripciones> query = this.em.createQuery("SELECT ins FROM Inscripciones ins WHERE ins.paralelos = ?1", Inscripciones.class);
        /*     */
 /*     */
 /*  97 */ query.setParameter(1, paralelo);
        /*     */
 /*  99 */ List<Inscripciones> result = query.getResultList();
        /* 100 */ return result;
        /*     */    }

    public byte[] bytesPdf(Integer insCodigo) {
        Session hibernateSession = em.unwrap(Session.class);

        return hibernateSession.doReturningWork((Connection connection) -> {
            try {

                URL url;
                url = Faces.getResource("/WEB-INF/reportes/repIns.jasper");
                File f = new File(url.toURI());
                //  Connection conn = null;

                byte[] pdf = certificadopdf(f, insCodigo, connection);

                return pdf;
            } catch (Throwable tr) {
                tr.printStackTrace();
            } finally {
                try {
                    // conn.close();
                } catch (Exception excep) {
                }
            }

            return null;
        });

    }

    public byte[] certificadopdf(File file, Integer codigo, Connection connection) throws JRException, IOException, URISyntaxException {

        URL url;
        url = Faces.getResource("/WEB-INF/reportes/");
        File f = new File(url.toURI());

        final String pathLogo = f.getPath();
        System.out.println(" path ** " + pathLogo);
        byte[] bytes = null;
        InputStream inputStream = new FileInputStream(file);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("pn_ins_codigo", codigo);
        parametros.put("pv_rut_img", pathLogo + File.separator);
        bytes = JasperRunManager.runReportToPdf(inputStream, parametros, connection);
        return bytes;
    }

    /*     */ public Long obtNumIns(Paralelos paralelo) {
        /* 105 */ TypedQuery typedQuery = this.em.createQuery("SELECT COUNT(i) FROM Inscripciones i WHERE i.paralelos = :paralelo", Long.class).setParameter("paralelo", paralelo);
        /*     */ try {
            /* 107 */ return ((Long) typedQuery.getSingleResult());
            /* 108 */        } catch (Exception e) {
            /* 109 */ return 0L;
            /*     */        }
        /*     */    }

}
