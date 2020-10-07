/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.reportes;


/*     */ 

import com.pjp.insjps.controller.InscripcionPreview;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.util.HashMap;
/*     */ import javax.faces.context.FacesContext;
/*     */ import javax.inject.Inject;
/*     */ import javax.servlet.ServletException;
/*     */ import javax.servlet.http.HttpServlet;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/*     */ import org.primefaces.model.DefaultStreamedContent;
/*     */ import org.primefaces.model.StreamedContent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Reporte
/*     */   extends HttpServlet
/*     */ {
/*     */   @Inject
/*     */   InscripcionPreview inscripcionPreview;
/*     */   
/*     */   protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  41 */     HttpSession session = request.getSession(false);
/*  42 */     if (session == null) {
/*     */       return;
/*     */     }
/*     */     
/*     */     try {
/*  47 */       Object obj = request.getSession().getAttribute("pn_ins_codigo");
/*  48 */       if (obj != null) {
/*  49 */         Integer cllcCdg = (Integer)obj;
/*     */ 
/*     */ 
/*     */         
/*     */         try {
/*  54 */           byte[] datos = bytesPdf(cllcCdg);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  62 */           this.inscripcionPreview.setPdf((StreamedContent)new DefaultStreamedContent(new ByteArrayInputStream(datos)));
/*     */         
/*     */         }
/*  65 */         catch (Exception e) {
/*  66 */           System.out.println("Error Abriendo el archivo para usuario_" + cllcCdg + " error_" + e.getLocalizedMessage());
/*     */         } 
/*     */       } 
/*  69 */     } catch (Exception excep) {
/*  70 */       System.out.println("Generacion Reporte..." + excep.getLocalizedMessage());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  78 */     processRequest(request, response);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*  84 */     processRequest(request, response);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] bytesPdf(Integer cllcCdg) {
/*  92 */     Connection conn = null;
/*     */     try {
/*  94 */       HashMap<Object, Object> param = new HashMap<>();
/*     */       
/*  96 */       param.put("pn_ins_codigo", cllcCdg);
/*  97 */       String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/reportes");
/*  98 */       param.put("pv_rut_img", ruta + File.separator);
/*     */ 
/*     */       
/* 101 */       String rutaReporte = "";
/* 102 */       JasperPrint print = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 110 */       conn = DriverManager.getConnection("jdbc:mysql://localhost/bdcate", "root", "");
/*     */       
/* 112 */       rutaReporte = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/WEB-INF/reportes");
/* 113 */       File is = new File(rutaReporte + File.separator + "repIns.jrxml");
/* 114 */       System.out.println("rutaReporte: " + rutaReporte);
/*     */ 
/*     */       
/* 117 */       JasperDesign masterDesign = JRXmlLoader.load(is);
/* 118 */       JasperReport masterReport = JasperCompileManager.compileReport(masterDesign);
/* 119 */      // print = JasperFillManager.fillReport(masterReport, param, conn);
/*     */       
/* 121 */       byte[] pdf = JasperExportManager.exportReportToPdf(print);
/*     */       
/* 123 */       return pdf;
/*     */     }
/* 125 */     catch (Throwable tr) {
/* 126 */       tr.printStackTrace();
/*     */     } finally {
/*     */       try {
/* 129 */         conn.close();
/* 130 */       } catch (Exception excep) {}
/*     */     } 
/*     */     
/* 133 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Santiago\Desktop\santiago castro - copia\SanPablo.war!\WEB-INF\classes\reportes\Reporte.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */