package com.victor.sistema;
import static com.victor.sistema.Conexion.contrasenha;
import static com.victor.sistema.Conexion.url;
import static com.victor.sistema.Conexion.driver;
import static com.victor.sistema.Conexion.usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author victo
 */
public class Borrar extends javax.swing.JInternalFrame {

        Connection conexion = null;
        PreparedStatement ps;
        ResultSet rs;
        
    public Borrar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        bBorrar = new javax.swing.JButton();
        lNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();
        bBuscar = new javax.swing.JButton();
        lDNI = new javax.swing.JTextField();

        jLabel3.setText("Nombre");

        bBorrar.setText("BORRAR");
        bBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBorrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellidos");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "DNI", "Sexo", "Fecha", "Gmail"
            }
        ));
        jScrollPane2.setViewportView(tabla);

        jLabel2.setText("DNI");

        Actualizar.setText("ACTUALIZAR");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        bBuscar.setText("BUSCAR");
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 415, Short.MAX_VALUE)
                        .addComponent(bBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lDNI, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addComponent(lNombre)
                                .addComponent(lApellidos))
                            .addComponent(bBorrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bBuscar)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBorrarActionPerformed
       

        try {
            conexion=getConnection( );
            ps= conexion.prepareStatement("delete from clientes where Dni ='"+lDNI.getText()+"'");

            int resultado= ps.executeUpdate();

            if(resultado>0){
                JOptionPane.showMessageDialog(null,"Borrado correctamente");
               
            }else{
                JOptionPane.showMessageDialog(null,"Error al Actualizar");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_bBorrarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        DefaultTableModel modelotabla = new DefaultTableModel();
        tabla.setModel(modelotabla);

        try {
            conexion=getConnection( );

            ps= conexion.prepareStatement("select * from clientes");

            rs= ps.executeQuery();

            modelotabla.addColumn("Dni");
            modelotabla.addColumn("Nombre");
            modelotabla.addColumn("Apellidos");
            modelotabla.addColumn("Fecha");
            modelotabla.addColumn("Sexo");
            modelotabla.addColumn("Gmail");

            while(rs.next()) {
                Object fila[] =new Object[6];
                for( int i=0; i<6; i++){
                    fila[i]= rs.getObject(i+1);
                }
                modelotabla.addRow(fila);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_ActualizarActionPerformed

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed

        try {
            conexion=getConnection();
            ps=conexion.prepareStatement("select * from clientes where Dni='"+lDNI.getText()+"'");

            rs=ps.executeQuery();
            lDNI.setText("");
            lNombre.setText("");
            lApellidos.setText("");
            

            if(rs.next()){
                lDNI.setText(rs.getString("Dni"));
                lNombre.setText(rs.getString("Nombre"));
                lApellidos.setText(rs.getString("Apellidos"));
                
                String a=rs.getString("Sexo");


            }else{
                JOptionPane.showMessageDialog(null,"Persona no encontrada");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }

    }//GEN-LAST:event_bBuscarActionPerformed

    public Connection getConnection(   ){
     
       url = url;
       usuario = usuario ;    
       contrasenha = contrasenha ;
       
        try{
        Class.forName(driver);
     conexion=(Connection) DriverManager.getConnection(url,usuario,contrasenha);
           
                   
    }catch(Exception ex){
        System.err.println("Error, "+ex);
             
    }
        
    return conexion;
}
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton bBorrar;
    private javax.swing.JButton bBuscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lApellidos;
    private javax.swing.JTextField lDNI;
    private javax.swing.JTextField lNombre;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}