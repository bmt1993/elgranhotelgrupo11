/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Entidades.habitacion;
import Entidades.huesped;
import accesoadatos.habitaciondata;
import accesoadatos.huespeddata;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bmt
 */
public class habitacionesdisp extends javax.swing.JInternalFrame {

    /**
     * Creates new form habitacionesdisp
     */
   
    
    
    private DefaultTableModel modelotabla = new DefaultTableModel();
    
        public boolean iseditable(int f,int c){
        return false;
    }
    
    
    public habitacionesdisp() {
        initComponents();
        armarcabecera();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jLabel1.setText("Capacidad (personas):");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un valor", "2", "3", "4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha checkin:");

        jDateChooser1.setMinSelectableDate(fechaminima());
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });

        jDateChooser2.setMinSelectableDate(fechaminima());
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Fecha checkout");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar campos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Reservar habitación seleccionada");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, 140, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        // TODO add your handling code here:
        borrarcampostabla();
        
        if(jDateChooser1.getDate()!=null){
            jDateChooser2.setMinSelectableDate(jDateChooser1.getDate());
            if(jDateChooser2.getDate()!=null){
                if(jDateChooser1.getDate().compareTo(jDateChooser2.getDate())==1){
                    jDateChooser2.setDate(null);
                }
            }
        }
//        
//        if(jDateChooser1.getDate()!=null){
//
//        String personas =jComboBox1.getSelectedItem().toString();
//        
//        JOptionPane.showMessageDialog(null,personas);
//        
//        }
//      
        
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        jComboBox1.setSelectedIndex(0);
        
        jDateChooser1.setDate(null);
        
        jDateChooser2.setDate(null);
        
        borrarcampostabla();
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        boolean datos;
        
        if(jComboBox1.getSelectedItem()=="Seleccione un valor" || jDateChooser1.getDate()==null || jDateChooser2.getDate()==null){
            JOptionPane.showMessageDialog(null,"Falta seleccionar algún dato");
        }else{
        
        
        borrarcampostabla();
        
        habitaciondata nuevashab=new habitaciondata();
        
        ArrayList<Integer> hab1=new ArrayList();
        
        int personas =Integer.parseInt(jComboBox1.getSelectedItem().toString());
        
        hab1= nuevashab.vecthabitacionesid(personas);
        
        ArrayList<ArrayList<Integer>> hab2=new ArrayList();
        
        ArrayList<ArrayList<Integer>> hab3=new ArrayList();
        
        hab2=nuevashab.matrizfcheckin2(hab1);
        
        hab3=nuevashab.matrizfcheckout2(hab1);
        
        ArrayList<habitacion> hab4=new ArrayList();
        
        LocalDate f1 = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        LocalDate f2 = jDateChooser2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        
        hab4= nuevashab.habitacionesdisponiblesparareservar(f1,f2, hab1, hab2, hab3, personas);
        
        
        boolean[] hab5 = new boolean[14];
        
        hab5=nuevashab.tiposdisponibles(hab4);
        int falsos=0;
        
        for(int k=0;k<=13;k++){
            if(hab5[k]==false){
                falsos++;
            }
        }
        
        if(falsos==14){
            JOptionPane.showMessageDialog(null,"No existen habitaciones con capacidad para "+personas+" para las fechas indicadas.");
        }
        
        
        
        llenarcampos(hab5);
        
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        
        
        if(jTable1.getSelectedRow()!=-1){
                
                
                
        habitaciondata nuevashab =new habitaciondata();
        
        huespeddata hues = new huespeddata();
        
        ArrayList<Integer> hab1=new ArrayList();
        
        int personas =Integer.parseInt(jComboBox1.getSelectedItem().toString());
        
        hab1= nuevashab.vecthabitacionesid(personas);
        
        ArrayList<ArrayList<Integer>> hab2=new ArrayList();
        
        ArrayList<ArrayList<Integer>> hab3=new ArrayList();
        
        hab2=nuevashab.matrizfcheckin2(hab1);
        
        hab3=nuevashab.matrizfcheckout2(hab1);
        
        ArrayList<habitacion> hab4=new ArrayList();
        
        LocalDate f1 = jDateChooser1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        LocalDate f2 = jDateChooser2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        
        hab4= nuevashab.habitacionesdisponiblesparareservar(f1,f2, hab1, hab2, hab3, personas);
        
        boolean exception;
        
        String dni;
        
        dni=JOptionPane.showInputDialog("Ingresar el DNI del cliente");
            do{
                if(dni!=null){
                exception=false;
                try{
                    String tipoareservar=jTable1.getValueAt(jTable1.getSelectedRow(),4).toString();
                    JDesktopPane desktopPane = getDesktopPane();
                    int p=0;
                    do{
                        p++;
                    }while(hab4.get(p).getTipohabitacion().getTipo()!=Integer.parseInt(tipoareservar));
                    habitacion habitacionareservar=hab4.get(p);
                    boolean existencia = hues.comprobarexistencia(Integer.parseInt(dni));
                    formnuevocliente nuevoCliente = new formnuevocliente(Integer.parseInt(dni),f1,f2,habitacionareservar,existencia,this);
                    if(existencia==true){
                        JOptionPane.showMessageDialog(null,"El DNI ingresado ya existe en la base de datos. A continuación, podrá cotejar si los datos del cliente se encuentran actualizados.");
                        nuevoCliente.textoboton(existencia);
                        desktopPane.add(nuevoCliente);
                        nuevoCliente.setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(null,"El DNI ingresado no existe en la base de datos. En el siguiente formulario podrá crearlo agregando todos sus datos.");
                        nuevoCliente.textoboton(existencia);
                        desktopPane.add(nuevoCliente);
                        nuevoCliente.setVisible(true);
                    }
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Debe ingresar un número");
                    exception=true;
                    dni=JOptionPane.showInputDialog("Ingresar el DNI del cliente");
                }
                }else{
                    exception=false;
                }
            }while(exception==true);
            
        }else{
            JOptionPane.showMessageDialog(null,"Debe seleccionar una fila de la columna");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        borrarcampostabla();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        // TODO add your handling code here:
        borrarcampostabla();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables



    private void armarcabecera(){
        modelotabla.addColumn("Categoría");
        modelotabla.addColumn("Camas simples");
        modelotabla.addColumn("Camas dobles");
        modelotabla.addColumn("Precio por noche");
        modelotabla.addColumn("Tipo");
        jTable1.setModel(modelotabla);
    }
    
    
    
    private void borrarcampostabla(){
        
//        int r=modelotabla.getRowCount();
//        for(int i=0;i<=r-1;i++){
//            modelotabla.removeRow(1);
//        }
        
        
        while(modelotabla.getRowCount()>0){
            modelotabla.removeRow(0);
        }
        
    }
    
    
    private Date fechaminima(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date fechaManana = calendar.getTime();
        return fechaManana;
    }

    
    
    
    private void llenarcampos(boolean[] tiposdisp){
        String[] vector=new String[5];
        for(int i=0;i<=13;i++){
            if(tiposdisp[i]==true){
                switch (i+1) {
                        case 1:
                            vector[0]="Comfort";
                            vector[1]="2";
                            vector[2]="-";
                            vector[3]="$";
                            vector[4]="1";
                            break;
                        case 2:
                            vector[0]="Comfort";
                            vector[1]="-";
                            vector[2]="1";
                            vector[3]="$";
                            vector[4]="2";
                            break;    
                        case 3:
                            vector[0]="Privilege";
                            vector[1]="2";
                            vector[2]="-";
                            vector[3]="$";
                            vector[4]="3";
                            break;    
                        case 4:
                            vector[0]="Privilege";
                            vector[1]="-";
                            vector[2]="1";
                            vector[3]="$";
                            vector[4]="4";
                            break;    
                        case 5:
                            vector[0]="Luxury";
                            vector[1]="2";
                            vector[2]="-";
                            vector[3]="$";
                            vector[4]="5";
                            break;    
                        case 6:
                            vector[0]="Luxury";
                            vector[1]="-";
                            vector[2]="1";
                            vector[3]="$";
                            vector[4]="6";
                            break;
                        case 7:
                            vector[0]="Privilege";
                            vector[1]="3";
                            vector[2]="-";
                            vector[3]="$";
                            vector[4]="7";
                            break;
                        case 8:
                            vector[0]="Privilege";
                            vector[1]="1";
                            vector[2]="1";
                            vector[3]="$";
                            vector[4]="8";
                            break;    
                        case 9:
                            vector[0]="Luxury";
                            vector[1]="3";
                            vector[2]="-";
                            vector[3]="$";
                            vector[4]="9";
                            break;    
                        case 10:
                            vector[0]="Luxury";
                            vector[1]="1";
                            vector[2]="1";
                            vector[3]="$";
                            vector[4]="10";
                            break;    
                        case 11:
                            vector[0]="Privilege";
                            vector[1]="4";
                            vector[2]="-";
                            vector[3]="$";
                            vector[4]="11";
                            break;    
                        case 12:
                            vector[0]="Privilege";
                            vector[1]="2";
                            vector[2]="1";
                            vector[3]="$";
                            vector[4]="12";
                            break;
                        case 13:
                            vector[0]="Luxury";
                            vector[1]="4";
                            vector[2]="-";
                            vector[3]="$";
                            vector[4]="13";
                            break;
                        default:
                            vector[0]="Luxury";
                            vector[1]="2";
                            vector[2]="1";
                            vector[3]="$";
                            vector[4]="14";
                            break;
                }   
            
                modelotabla.addRow(vector);
            }
            
        }
        
    }




}
