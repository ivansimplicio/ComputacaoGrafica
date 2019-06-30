package cg.panels;

import cg.principal.App;
import cg.enums.EnumRasterizacao;
import cg.retas.Ponto;
import java.awt.Color;
import javax.swing.JTextArea;

/**
 * Painel com as configurações necessárias para plotar uma reta.
 *
 * @author Ivanildo Simplício
 */
public class PanelMenuRasterizacao extends javax.swing.JPanel {

    private static PanelMenuRasterizacao instance;

    private Ponto pontoInicial;
    private Ponto pontoFinal;
    private Color color;
    private EnumRasterizacao tipoAlgoritimo;

    /**
     * Construtor padrão.
     */
    private PanelMenuRasterizacao() {
        initComponents();
        textAreaResult.setEditable(false);
    }
    
    public static synchronized PanelMenuRasterizacao getInstance() {
        if (instance == null) {
            instance = new PanelMenuRasterizacao();
        }
        return instance;
    }

    public Ponto getPontoInicial() {
        return pontoInicial;
    }

    public void setPontoInicial(Ponto pontoInicial) {
        this.pontoInicial = pontoInicial;
    }

    public Ponto getPontoFinal() {
        return pontoFinal;
    }

    public void setPontoFinal(Ponto pontoFinal) {
        this.pontoFinal = pontoFinal;
    }

    public EnumRasterizacao getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(EnumRasterizacao tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public JTextArea getTextAreaResult() {
        return textAreaResult;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlgoritmos = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rbDDA = new javax.swing.JRadioButton();
        rbPontoMedio = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pontoInicialX = new javax.swing.JSpinner();
        pontoInicialY = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pontoFinalX = new javax.swing.JSpinner();
        pontoFinalY = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaResult = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btResolve = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("jLabel1");

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupAlgoritmos.add(rbDDA);
        rbDDA.setSelected(true);
        rbDDA.setText("DDA (Digital Differential Analyser)");

        buttonGroupAlgoritmos.add(rbPontoMedio);
        rbPontoMedio.setText("Bresenham (Ponto Médio)");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbPontoMedio)
                    .addComponent(rbDDA))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbDDA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(rbPontoMedio)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Inicial:");

        jLabel3.setText("Final:");

        pontoInicialX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoInicialX.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        pontoInicialX.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoInicialX.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoInicialX.setPreferredSize(new java.awt.Dimension(30, 25));

        pontoInicialY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoInicialY.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        pontoInicialY.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoInicialY.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoInicialY.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel4.setText("X");

        jLabel5.setText("Y");

        pontoFinalX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoFinalX.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        pontoFinalX.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoFinalX.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoFinalX.setPreferredSize(new java.awt.Dimension(30, 25));

        pontoFinalY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoFinalY.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        pontoFinalY.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoFinalY.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoFinalY.setPreferredSize(new java.awt.Dimension(30, 25));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(51, 51, 51))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pontoInicialX, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(pontoFinalX, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pontoInicialY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pontoFinalY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pontoInicialX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pontoInicialY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pontoFinalX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(pontoFinalY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder("Iterações"));

        textAreaResult.setColumns(20);
        textAreaResult.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        textAreaResult.setRows(5);
        textAreaResult.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jScrollPane1.setViewportView(textAreaResult);

        jLabel6.setText("Defina os pontos:");

        jLabel7.setText("Selecione o algoritmo de rasterização:");

        btResolve.setText("Desenhar Reta");
        btResolve.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desenharReta(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Desenha a reta utilizando o algoritmo selecionado.
     */
    private void desenharReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desenharReta
        textAreaResult.setText(""); //Limpa o textArea de result
        setColor(Color.RED);

        //Seta as coordenadas dos pontos e seta no obejto Ponto
        setPontoInicial(new Ponto((double) pontoInicialX.getValue(), (double) pontoInicialY.getValue()));
        setPontoFinal(new Ponto((double) pontoFinalX.getValue(), (double) pontoFinalY.getValue()));

        //Seta o tipo de algoritmo selecionado
        if (rbDDA.isSelected()) {
            setTipoAlgoritimo(EnumRasterizacao.DDA);
        } else if (rbPontoMedio.isSelected()) {
            setTipoAlgoritimo(EnumRasterizacao.PONTO_MEDIO);
        }
        App.runResult(this); //Tela principal processa os dados enviados desse painel.
    }//GEN-LAST:event_desenharReta


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btResolve;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner pontoFinalX;
    private javax.swing.JSpinner pontoFinalY;
    private javax.swing.JSpinner pontoInicialX;
    private javax.swing.JSpinner pontoInicialY;
    private javax.swing.JRadioButton rbDDA;
    private javax.swing.JRadioButton rbPontoMedio;
    private javax.swing.JTextArea textAreaResult;
    // End of variables declaration//GEN-END:variables
}