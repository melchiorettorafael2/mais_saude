/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Color;
import static java.lang.Thread.sleep;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.util.List;
/**
 *
 * @author rafa
 */
public class Splash extends javax.swing.JFrame {

    /**
     * Creates new form Splash
     */
    public Splash() {
       
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

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        loadingnumber = new javax.swing.JLabel();
        loadingbar = new javax.swing.JProgressBar();
        jLabelTextoInfromativo = new javax.swing.JLabel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelPlanoFundo = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Sistema_Mais_Saude/icone3.png"));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(null);

        loadingnumber.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        loadingnumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loadingnumber.setText("99");
        jPanel1.add(loadingnumber);
        loadingnumber.setBounds(290, 270, 50, 30);
        jPanel1.add(loadingbar);
        loadingbar.setBounds(110, 270, 410, 30);

        jLabelTextoInfromativo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelTextoInfromativo.setFont(new java.awt.Font("Vani", 1, 17)); // NOI18N
        jLabelTextoInfromativo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTextoInfromativo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabelTextoInfromativo);
        jLabelTextoInfromativo.setBounds(110, 240, 410, 20);

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/RM_logo.png"))); // NOI18N
        jPanel1.add(jLabelLogo);
        jLabelLogo.setBounds(110, 70, 430, 160);

        jLabelPlanoFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/splash.jpg"))); // NOI18N
        jPanel1.add(jLabelPlanoFundo);
        jLabelPlanoFundo.setBounds(0, -10, 630, 380);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 630, 360);

        setSize(new java.awt.Dimension(630, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
        new Thread(){
            int i =0;
            
            public void run(){
                while(i<100){
                    i++;
                    loadingnumber.setText(Integer.toString(i) + "%");
                    loadingbar.setValue(i);
                    UIManager.put("ProgressBar.foreground", Color.RED);
                   
                       
                    if(i<=20){
                jLabelTextoInfromativo.setText("Resolvendo Cache");
                    
                
                }
                
                else if(i<=40){
                
                jLabelTextoInfromativo.setText("Estabelecendo Conex??o com o Banco de Dados");
                
                }
                
                else if (i<=60){
                
                   jLabelTextoInfromativo.setText("Carregando Formul??rios");
                }
                
                else if (i<=80){
                
                    jLabelTextoInfromativo.setText("Importando Relat??rios");
                }
                
                else if (i>80){
                
                     jLabelTextoInfromativo.setText("Iniciando o Sistema");
                }
                
                    
                    
                    try{
                        sleep(90);
                        
                        
                    }catch(Exception e){
                        
                        
                    }
                }//fecha o while
                
             
                
                Splash.this.dispose();//Fecha o Formul??rio Splash
                new telaLogin().setVisible(true); //Chama o pr??ximo form.
            }//fecha m??todo run.
        }.start();
        
        
        
    }//GEN-LAST:event_formWindowOpened

    
        
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
              try {
    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
        
}
        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelPlanoFundo;
    private javax.swing.JLabel jLabelTextoInfromativo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JProgressBar loadingbar;
    private javax.swing.JLabel loadingnumber;
    // End of variables declaration//GEN-END:variables
}
