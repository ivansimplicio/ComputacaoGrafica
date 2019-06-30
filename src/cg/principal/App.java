package cg.principal;

import cg.dialog.DialogSobre;
import cg.enums.EnumRasterizacao;
import cg.panels.FrameHeartBeating;
import cg.panels.PanelMenu2D;
import cg.panels.PanelMenu3D;
import cg.panels.PanelMenuCircunferencia;
import cg.panels.PanelMenuImagem;
import cg.panels.PanelMenuRasterizacao;
import cg.panels.PanelMenuRecorteReta;
import cg.panels.PlanoCartesiano;
import cg.retas.Circunferencia;
import cg.retas.Ponto;
import cg.retas.Rasterizacao;
import cg.sistemaDeCoordenadas.FuncoesDeNormalizacao;
import cg.transformacoes.BeatingHeart;
import cg.transformacoes.Imagem;
import cg.transformacoes.Transformacoes2D;
import cg.transformacoes.Transformacoes3D;
import cg.transformacoes.TransformacoesImagem;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.List;
import javax.swing.JPanel;

/**
 * JFrame principal da aplicação.
 *
 * @author Ivanildo Simplício
 */
public class App extends javax.swing.JFrame {

    private final PanelMenuRasterizacao panelMenuRasterizacao;
    private final PanelMenuCircunferencia panelMenuCircunferencia;
    private final PanelMenu2D panelMenu2D;
    private final PanelMenu3D panelMenu3D;
    private final PanelMenuRecorteReta panelMenuRecorteReta;
    private final PanelMenuImagem panelMenuImagem;

    /**
     * Construtor padrão.
     */
    public App() {
        panelMenuRasterizacao = PanelMenuRasterizacao.getInstance();
        panelMenuCircunferencia = PanelMenuCircunferencia.getInstance();
        panelMenu2D = PanelMenu2D.getInstance();
        panelMenu3D = PanelMenu3D.getInstance();
        panelMenuRecorteReta = PanelMenuRecorteReta.getInstance();
        panelMenuImagem = PanelMenuImagem.getInstance();
        
        initComponents();
        sistemaCoordenadas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelMenuLeft = new javax.swing.JPanel();
        panelBox = new javax.swing.JPanel();
        panelPlanoCartesiano = cg.panels.PlanoCartesiano.getInstance();
        labelResTela = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        labelX = new javax.swing.JLabel();
        labelNDCY = new javax.swing.JLabel();
        labelNDCX = new javax.swing.JLabel();
        labelDCY = new javax.swing.JLabel();
        labelDCX = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuQ1 = new javax.swing.JMenu();
        menuItemReta = new javax.swing.JMenuItem();
        menuItemCircuferencia = new javax.swing.JMenuItem();
        menuQ2 = new javax.swing.JMenu();
        itemPrintLine = new javax.swing.JMenuItem();
        itemPulse = new javax.swing.JMenuItem();
        itemBeatingHeart = new javax.swing.JMenuItem();
        menuQ3 = new javax.swing.JMenu();
        menuRecorte = new javax.swing.JMenuItem();
        menuItem2D = new javax.swing.JMenuItem();
        menuItem3D = new javax.swing.JMenuItem();
        menuQ4 = new javax.swing.JMenu();
        menuSobre = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Computação Gráfica - 2019.1");
        setExtendedState(6);
        setMinimumSize(new java.awt.Dimension(1080, 720));
        setName("framePrincipal"); // NOI18N
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                actionResized(evt);
            }
        });

        panelMenuLeft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelMenuLeft.setMinimumSize(new java.awt.Dimension(240, 0));
        panelMenuLeft.setPreferredSize(new java.awt.Dimension(240, 2));

        javax.swing.GroupLayout panelMenuLeftLayout = new javax.swing.GroupLayout(panelMenuLeft);
        panelMenuLeft.setLayout(panelMenuLeftLayout);
        panelMenuLeftLayout.setHorizontalGroup(
            panelMenuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        panelMenuLeftLayout.setVerticalGroup(
            panelMenuLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 671, Short.MAX_VALUE)
        );

        panelPlanoCartesiano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        panelPlanoCartesiano.setPreferredSize(new java.awt.Dimension(550, 550));

        labelResTela.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelResTela.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelResTela.setText("Tela:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel10.setText("C. Entrada:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("C. Normalização:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("C. Saída:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("DCX:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("NDCX:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("X:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("DCY:");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("NDCY:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel18.setText("Y:");

        labelY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelY.setText("0");

        labelX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelX.setText("0");

        labelNDCY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelNDCY.setText("0");

        labelNDCX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelNDCX.setText("0");

        labelDCY.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelDCY.setText("0");

        labelDCX.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelDCX.setText("0");

        javax.swing.GroupLayout panelPlanoCartesianoLayout = new javax.swing.GroupLayout(panelPlanoCartesiano);
        panelPlanoCartesiano.setLayout(panelPlanoCartesianoLayout);
        panelPlanoCartesianoLayout.setHorizontalGroup(
            panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlanoCartesianoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPlanoCartesianoLayout.createSequentialGroup()
                        .addComponent(labelResTela, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addGap(484, 484, 484))
                    .addGroup(panelPlanoCartesianoLayout.createSequentialGroup()
                        .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelX)
                            .addComponent(labelDCX)
                            .addComponent(labelNDCX, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPlanoCartesianoLayout.createSequentialGroup()
                                .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelY)
                                    .addComponent(labelDCY)))
                            .addGroup(panelPlanoCartesianoLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNDCY, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelPlanoCartesianoLayout.setVerticalGroup(
            panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlanoCartesianoLayout.createSequentialGroup()
                .addContainerGap(590, Short.MAX_VALUE)
                .addComponent(labelResTela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(labelDCY)
                    .addComponent(labelDCX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel17)
                    .addComponent(labelNDCY)
                    .addComponent(labelNDCX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPlanoCartesianoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jLabel18)
                    .addComponent(labelY)
                    .addComponent(labelX))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
        panelBox.setLayout(panelBoxLayout);
        panelBoxLayout.setHorizontalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPlanoCartesiano, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
        );
        panelBoxLayout.setVerticalGroup(
            panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPlanoCartesiano, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );

        menuBar.setPreferredSize(new java.awt.Dimension(104, 25));

        menuQ1.setText("Q1. Desenhar");

        menuItemReta.setText("Reta");
        menuItemReta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuReta(evt);
            }
        });
        menuQ1.add(menuItemReta);

        menuItemCircuferencia.setText("Circunferência e Elipse");
        menuItemCircuferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuCircunferencia(evt);
            }
        });
        menuQ1.add(menuItemCircuferencia);

        menuBar.add(menuQ1);

        menuQ2.setText("Q2. Heart Beating");

        itemPrintLine.setText("Print Line");
        itemPrintLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPrintLineActionPerformed(evt);
            }
        });
        menuQ2.add(itemPrintLine);

        itemPulse.setText("Pulse");
        itemPulse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemPulseActionPerformed(evt);
            }
        });
        menuQ2.add(itemPulse);

        itemBeatingHeart.setText("No Plano Cartesiano");
        itemBeatingHeart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBeatingHeartActionPerformed(evt);
            }
        });
        menuQ2.add(itemBeatingHeart);

        menuBar.add(menuQ2);

        menuQ3.setText("Q3. Transformações");

        menuRecorte.setText("Recorte de Reta");
        menuRecorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRecorteReta(evt);
            }
        });
        menuQ3.add(menuRecorte);

        menuItem2D.setText("2D");
        menuItem2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTrans2D(evt);
            }
        });
        menuQ3.add(menuItem2D);

        menuItem3D.setText("3D");
        menuItem3D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openTrans3D(evt);
            }
        });
        menuQ3.add(menuItem3D);

        menuBar.add(menuQ3);

        menuQ4.setText("Q4. Operações em Imagem");
        menuQ4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuQ4MouseClicked(evt);
            }
        });
        menuBar.add(menuQ4);

        menuSobre.setText("Sobre");
        menuSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSobreMouseClicked(evt);
            }
        });
        menuBar.add(menuSobre);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMenuLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMenuLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1096, 759));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre menu para desenhar reta.
     */
    private void openMenuReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuReta
        panelMenuLeft.setVisible(true);
        PlanoCartesiano.getInstance().redesenha();
        changeMenuLeft(panelMenuRasterizacao);
    }//GEN-LAST:event_openMenuReta

     /**
     * Abre menu para desenhar circunferência e elipse.
     */
    private void openMenuCircunferencia(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuCircunferencia
        panelMenuLeft.setVisible(true);
        PlanoCartesiano.getInstance().redesenha();
        changeMenuLeft(panelMenuCircunferencia);
    }//GEN-LAST:event_openMenuCircunferencia

     /**
     * Abre menu para utilizar as transformações 2D.
     */
    private void openTrans2D(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTrans2D
        panelMenuLeft.setVisible(true);
        PlanoCartesiano.getInstance().redesenha();
        changeMenuLeft(panelMenu2D);
    }//GEN-LAST:event_openTrans2D

     /**
     * Abre menu para utilizar as transformações 3D.
     */
    private void openTrans3D(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openTrans3D
        panelMenuLeft.setVisible(true);
        PlanoCartesiano.getInstance().redesenha3D();
        changeMenuLeft(panelMenu3D);
    }//GEN-LAST:event_openTrans3D

    /**
     * Evento disparado toda vez que a tela é redimensinada. Seta a resolução da tela atual.
     */
    private void actionResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_actionResized
        PlanoCartesiano p = PlanoCartesiano.getInstance();
        labelResTela.setText("Tela: " + p.getLargura() + "x" + p.getAltura());
    }//GEN-LAST:event_actionResized

     /**
     * Abre menu para utilizar o algoritmo de recorte de linha.
     */
    private void menuRecorteReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRecorteReta
        panelMenuLeft.setVisible(true);
        PlanoCartesiano.getInstance().redesenha();
        changeMenuLeft(panelMenuRecorteReta);
    }//GEN-LAST:event_menuRecorteReta

    /**
     * Abre painel que exibe informações do projeto.
     */
    private void menuSobreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSobreMouseClicked
         new DialogSobre(this, true).setVisible(true);
    }//GEN-LAST:event_menuSobreMouseClicked

    /**
     * documentar quando implementar...
     */
    private void menuQ4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuQ4MouseClicked
        panelMenuLeft.setVisible(true);
        PlanoCartesiano.getInstance().redesenha();
        changeMenuLeft(panelMenuImagem);
    }//GEN-LAST:event_menuQ4MouseClicked

    /**
     * Não exibe a linha do deslocamento e exibe o objeto "pulsando".
     */
    private void itemPulseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPulseActionPerformed
        boolean printLine = false;
        executaAnimacao(printLine);
    }//GEN-LAST:event_itemPulseActionPerformed

    /**
     * Exibe a linha do deslocamento do objeto.
     */
    private void itemPrintLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemPrintLineActionPerformed
        boolean printLine = true;
        executaAnimacao(printLine);
    }//GEN-LAST:event_itemPrintLineActionPerformed
    
    /**
     * Inicia a execução do Heart Beating no plano cartesiano.
     * @param evt 
     */
    private void itemBeatingHeartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemBeatingHeartActionPerformed
        openBeatingHeart();
    }//GEN-LAST:event_itemBeatingHeartActionPerformed

    /**
     * Executa o beating heart.
     */
    private void openBeatingHeart(){      
       BeatingHeart heart = new BeatingHeart();
       heart.startAnimation();
    }
    
    /**
     * Executa o JFrame que possui a animação.
     */
    private void executaAnimacao(boolean printLine){
        int width = 550;
        int height = 300;
        FrameHeartBeating f = new FrameHeartBeating(width, height, printLine);

        f.setTitle("Heart Beating (Exercício 2.5)");
        f.setSize(width, height);
        f.setType(Type.POPUP);
        f.setVisible(true);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }
    
    /**
     * Altera o jPanel do menu esquerdo de acordo com o jPanel passado como parâmetro.
     */
    private void changeMenuLeft(JPanel panel) {
        panelMenuLeft.removeAll();
        panelMenuLeft.repaint();

        panelMenuLeft.setLayout(new GridLayout());
        panelMenuLeft.add(panel);

        panelMenuLeft.validate();
    }

    /**
     * Altera o jPanel do central adicionando o novo componente passado como parâmetro.
     */
    private void changePanelCentral(Component component) {
        javax.swing.GroupLayout panelBoxLayout = new javax.swing.GroupLayout(panelBox);
        panelBox.setLayout(panelBoxLayout);
        panelBoxLayout.setHorizontalGroup(
                panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelBoxLayout.createSequentialGroup()
                                .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
        );
        panelBoxLayout.setVerticalGroup(
                panelBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(component, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(App.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new App().setVisible(true);
            }
        });
    }

    /**
     * Executa o algoritmo selecionado.
     * @param instance Instância de algum painel de opções.
     */
    public static void runResult(Object instance) {
        if (instance instanceof PanelMenuRasterizacao) {
            processaRasterizacaoReta(PanelMenuRasterizacao.getInstance());
        } else if (instance instanceof PanelMenuCircunferencia) {
            processaRasterizacaoCircunferencia(PanelMenuCircunferencia.getInstance());
        } else if (instance instanceof PanelMenu2D) {
            processaTransformacoes2D(PanelMenu2D.getInstance());
        } else if (instance instanceof PanelMenu3D) {
            processaTransformacoes3D(PanelMenu3D.getInstance());
        } else if (instance instanceof PanelMenuImagem) {
            processaTransformacoesImagem(PanelMenuImagem.getInstance());
        }
    }

    /**
     * Processa o pedido vindo do Painel de rasterização de reta.
     */
    private static void processaRasterizacaoReta(PanelMenuRasterizacao menu) {
        Rasterizacao rast = Rasterizacao.getInstance();
        PlanoCartesiano.getInstance().redesenha();

        if (menu.getTipoAlgoritimo().equals(EnumRasterizacao.DDA)) {
            rast.metodoDDA(menu.getPontoInicial(), menu.getPontoFinal(), menu.getColor(), menu.getTextAreaResult());
        } else if (menu.getTipoAlgoritimo().equals(EnumRasterizacao.PONTO_MEDIO)) {
            rast.metodoPontoMedio(menu.getPontoInicial(), menu.getPontoFinal(), menu.getColor(), menu.getTextAreaResult());
        }
    }

    /**
     * Processa o pedido vindo do Painel de rasterização de circunferência.
     */
    private static void processaRasterizacaoCircunferencia(PanelMenuCircunferencia menu) {
        Circunferencia circ = Circunferencia.getInstance();

        switch (menu.getTipoAlgoritimo()) {
            case PONTO_MEDIO:
                circ.funcaoPontoMedio((int) menu.getRaioX(), menu.getColor());
                break;
            case EQUACAO_EXPLICITA:
                circ.funcaoExplicita((int) menu.getRaioX(), menu.getColor());
                break;
            case TRIGONOMETRICO:
                circ.funcaoTrigonometrica((int) menu.getRaioX(), menu.getColor());
                break;
            case ELIPSE:
                List<Ponto> lista = circ.funcaoElipse((int) menu.getRaioX(), (int) menu.getRaioY(), menu.getColor());
            default:
                break;
        }
    }

    /**
     * Processa o pedido vindo da tela de transformações 2D.
     */
    private static void processaTransformacoes2D(PanelMenu2D menu) {
        if (PanelMenu2D.matrizObjeto != null) {
            Transformacoes2D trans2D = Transformacoes2D.getInstance();

            //matriz objeto original. Atualizada a cada transformação
            double[][] matrizObjeto = PanelMenu2D.matrizObjeto;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLACAO:
                    // Aplica translação
                    matrizObjeto = trans2D.translacao(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case ESCALA:
                    // Aplica escala de acordo com Sx e Sy
                    matrizObjeto = trans2D.escala(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case ROTACAO:
                    // Aplica rotação de acordo com o ângulo
                    matrizObjeto = trans2D.rotacao(matrizObjeto, menu.getAngulo());
                    break;
                case REFLEXAO:
                    // Aplica reflexão de acordo com o eixo selecionado
                    matrizObjeto = trans2D.reflexao(matrizObjeto, menu.getEixo());
                    break;
                case CISALHAMENTO:
                    // Aplica cisalhamento de acordo com o valor de a e b
                    matrizObjeto = trans2D.cisalhamento(matrizObjeto, menu.getValorX(), menu.getValorY());
                    break;
                case TRANSFORMACAO_COMPOSTA:
                    matrizObjeto = trans2D.composta(menu.listaDeTransformacoes, matrizObjeto);
                    break;
                default:
                    break;
            }
            // Desenha o objeto no plano.
            PlanoCartesiano.getInstance().drawObjeto2D(matrizObjeto, menu.getColor());
        }
    }

    /**
     * Processa o pedido vindo da tela de transformações 3D.
     */
    private static void processaTransformacoes3D(PanelMenu3D menu) {
        if (PanelMenu3D.matrizObjeto3D != null) {
            Transformacoes3D trans3D = Transformacoes3D.getInstance();

            //matriz objeto original. Atualizada a cada transformação
            double[][] matrizObjeto3D = PanelMenu3D.matrizObjeto3D;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLACAO:
                    // Aplica translação
                    matrizObjeto3D = trans3D.translacao(matrizObjeto3D, menu.getValorX(), menu.getValorY(), menu.getValorZ());
                    break;
                case ESCALA:
                    // Aplica escala de acordo com Sx e Sy
                    matrizObjeto3D = trans3D.escala(matrizObjeto3D, menu.getValorX(), menu.getValorY(), menu.getValorZ());
                    break;
                case ROTACAO:
                    // Aplica rotação de acordo com o ângulo
                    matrizObjeto3D = trans3D.rotacao(matrizObjeto3D, menu.getAngulo(), menu.getEixo());
                    break;
                case REFLEXAO:
                    // Aplica reflexão de acordo com o eixo selecionado
                    matrizObjeto3D = trans3D.reflexao(matrizObjeto3D, menu.getEixo());
                    break;
                case CISALHAMENTO:
                    // Aplica cisalhamento de acordo com o valor de a e b
                    matrizObjeto3D = trans3D.cisalhamento(matrizObjeto3D, menu.getValorX(), menu.getAlignmentY(), menu.getEixo());
                    break;
                case TRANSFORMACAO_COMPOSTA:
                    matrizObjeto3D = trans3D.composta(menu.listaDeTransformacoes, matrizObjeto3D);
                    break;
                default:
                    break;
            }

            // Desenha o objeto no espaço.
            PlanoCartesiano.getInstance().drawObjeto3D(matrizObjeto3D, menu.getColor());
        }
    }
    
    /**
     * Calcula e exibe o sistema de coordenadas de acordo com os pontos no plano cartesiano.
     * O Evento mouseMoved é utilizado para pegar as coordenadas no plano cartesiano.
     */
    private void sistemaCoordenadas() {
        panelPlanoCartesiano.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                // Pega a instancia do Plano Cartesiano
                PlanoCartesiano planoCartesiano = PlanoCartesiano.getInstance();

                // Calcula o dc - Entrada de dispositivo | Será o mesmo que a saída
                int dcx = e.getX() - planoCartesiano.getValorCentroX();
                int dcy = (e.getY() - planoCartesiano.getValorCentroY()) * -1;

                // Calcula o ndc - Normalização do dispositivo
                double ndcx = FuncoesDeNormalizacao.calcularNDCX(planoCartesiano.getLargura(), dcx);
                double ndcy = FuncoesDeNormalizacao.calcularNDCX(planoCartesiano.getAltura(), dcy);

                labelNDCX.setText(String.format("%.6f", ndcx));
                labelNDCY.setText(String.format("%.6f", ndcy));

                labelDCX.setText(String.valueOf(FuncoesDeNormalizacao.calcularDCX(planoCartesiano.getLargura(), (float) ndcx)));
                labelDCY.setText(String.valueOf(FuncoesDeNormalizacao.calcularDCY(planoCartesiano.getAltura(), (float) ndcy)));

                labelX.setText(String.valueOf(Math.round(dcx)));
                labelY.setText(String.valueOf(Math.round(dcy)));
            }
        });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Processa o pedido vindo da tela de transformações na Imagem.
     */
    private static void processaTransformacoesImagem(PanelMenuImagem menu) {
        if (PanelMenuImagem.imagem != null) {
            TransformacoesImagem transImg = TransformacoesImagem.getInstance();
            Imagem imagem = PanelMenuImagem.imagem;

            switch (menu.getTipoAlgoritimo()) {
                case TRANSLACAO:
                    transImg.translacao(imagem, menu.getValorX(), menu.getValorY());
                    break;
                case ESCALA:
                    transImg.escala(imagem, menu.getValorX(), menu.getValorY());
                    break;
                case ROTACAO:
                    transImg.rotacao(imagem, menu.getAngulo());
                    break;
                case REFLEXAO:
                    transImg.reflexao(imagem, menu.getEixo());
                    break;
                case CISALHAMENTO:
                    transImg.cisalhamento(imagem, menu.getValorX(), menu.getValorY());
                    break;
                default:
                    break;
            }
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenuItem itemBeatingHeart;
    private javax.swing.JMenuItem itemPrintLine;
    private javax.swing.JMenuItem itemPulse;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel labelDCX;
    private javax.swing.JLabel labelDCY;
    private javax.swing.JLabel labelNDCX;
    private javax.swing.JLabel labelNDCY;
    private javax.swing.JLabel labelResTela;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItem2D;
    private javax.swing.JMenuItem menuItem3D;
    private javax.swing.JMenuItem menuItemCircuferencia;
    private javax.swing.JMenuItem menuItemReta;
    private javax.swing.JMenu menuQ1;
    private javax.swing.JMenu menuQ2;
    private javax.swing.JMenu menuQ3;
    private javax.swing.JMenu menuQ4;
    private javax.swing.JMenuItem menuRecorte;
    private javax.swing.JMenu menuSobre;
    private javax.swing.JPanel panelBox;
    private javax.swing.JPanel panelMenuLeft;
    private static javax.swing.JPanel panelPlanoCartesiano;
    // End of variables declaration//GEN-END:variables
}