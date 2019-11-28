/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import DAOs.JogadorDAO;
import Users.Jogador;
import javax.swing.JOptionPane;

/**
 *
 * @author sarah
 */
public class TelaCadastroJogador extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroJogador
     */
    public TelaCadastroJogador() {
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

        textoNome = new javax.swing.JTextField();
        textoEmail = new javax.swing.JTextField();
        textoSenha = new javax.swing.JTextField();
        botaoInserir = new javax.swing.JButton();
        rotuloNome = new javax.swing.JLabel();
        rotuloEmail = new javax.swing.JLabel();
        rotuloSenha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNomeActionPerformed(evt);
            }
        });

        botaoInserir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        botaoInserir.setText("Inserir");
        botaoInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botaoInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoInserirActionPerformed(evt);
            }
        });

        rotuloNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rotuloNome.setText("Nome");

        rotuloEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rotuloEmail.setText("Email");

        rotuloSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rotuloSenha.setText("Senha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotuloSenha)
                    .addComponent(rotuloEmail)
                    .addComponent(rotuloNome))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botaoInserir)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoEmail)
                    .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloNome)
                    .addComponent(textoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloEmail))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rotuloSenha))
                .addGap(18, 18, 18)
                .addComponent(botaoInserir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoInserirActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente cadastrar esse jogador?", "Cadastrar jogador", JOptionPane.YES_NO_CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                Jogador j = new Jogador();
                // Adocao a = new Adocao();
                //a.setCpf_pessoa(textoCpf.getText());
                j.setNome_usuario(textoNome.getText());
                j.setEmail(textoEmail.getText());
                j.setSenha(textoSenha.getText());
                JogadorDAO dao = new JogadorDAO();
                dao.inserir(j);
                //adao.inserir(a);
                textoNome.setText("");
                textoEmail.setText("");
                textoSenha.setText("");
                JOptionPane.showMessageDialog(this, "Jogador cadastrado com sucesso", "Cadastrar jogador", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Cadastrar jogador", JOptionPane.ERROR_MESSAGE);
            }
        }
        botaoInserir.transferFocus();
    }//GEN-LAST:event_botaoInserirActionPerformed

    private void textoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNomeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroJogador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoInserir;
    private javax.swing.JLabel rotuloEmail;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JLabel rotuloSenha;
    private javax.swing.JTextField textoEmail;
    private javax.swing.JTextField textoNome;
    private javax.swing.JTextField textoSenha;
    // End of variables declaration//GEN-END:variables
}
