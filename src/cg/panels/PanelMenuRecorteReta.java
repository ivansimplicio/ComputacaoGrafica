package cg.panels;

import cg.enums.EnumRasterizacao;
import cg.exceptions.RecorteException;
import cg.retas.Ponto;
import cg.retas.Rasterizacao;
import cg.retas.RecorteLinha;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Painel com as configurações necessárias para executar o recorte de linha usando o algoritmo de cohen-sutherland.
 *
 * @author Ivanildo Simplício
 */
public class PanelMenuRecorteReta extends javax.swing.JPanel {

    private static PanelMenuRecorteReta instance;

    private Ponto pontoInicial, pontoFinal;
    private Color color;
    private EnumRasterizacao tipoAlgoritimo;
    private List<Ponto> listaPontos;

    /**
     * Construtor padrão.
     */
    private PanelMenuRecorteReta() {
        initComponents();
    }

    public static synchronized PanelMenuRecorteReta getInstance() {
        if (instance == null) {
            instance = new PanelMenuRecorteReta();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlgoritmos = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        xMin = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        yMin = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        xMax = new javax.swing.JSpinner();
        yMax = new javax.swing.JSpinner();
        btJanela = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pontoInicialX = new javax.swing.JSpinner();
        pontoInicialY = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pontoFinalX = new javax.swing.JSpinner();
        pontoFinalY = new javax.swing.JSpinner();
        btDesenhaLinha1 = new javax.swing.JButton();
        btDesenhaLinha = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setMaximumSize(new java.awt.Dimension(220, 32767));
        jPanel4.setMinimumSize(new java.awt.Dimension(220, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(220, 106));

        xMin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xMin.setModel(new javax.swing.SpinnerNumberModel(60.0d, null, null, 1.0d));
        xMin.setToolTipText("Largura do objeto...");
        xMin.setMaximumSize(new java.awt.Dimension(30, 25));
        xMin.setMinimumSize(new java.awt.Dimension(30, 25));
        xMin.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel1.setText("Xmin:");

        jLabel6.setText("Ymin:");

        yMin.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yMin.setModel(new javax.swing.SpinnerNumberModel(60.0d, null, null, 1.0d));
        yMin.setToolTipText("Coordenada de X...");
        yMin.setMaximumSize(new java.awt.Dimension(30, 25));
        yMin.setMinimumSize(new java.awt.Dimension(30, 25));
        yMin.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel7.setText("Ymax:");

        jLabel8.setText("Xmax:");

        xMax.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        xMax.setModel(new javax.swing.SpinnerNumberModel(200.0d, null, null, 1.0d));
        xMax.setToolTipText("Altura do objeto...");
        xMax.setMaximumSize(new java.awt.Dimension(63, 25));
        xMax.setMinimumSize(new java.awt.Dimension(63, 25));
        xMax.setPreferredSize(new java.awt.Dimension(63, 25));

        yMax.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        yMax.setModel(new javax.swing.SpinnerNumberModel(150.0d, null, null, 1.0d));
        yMax.setToolTipText("Coordenada de Y...");
        yMax.setMaximumSize(new java.awt.Dimension(30, 25));
        yMax.setMinimumSize(new java.awt.Dimension(30, 25));
        yMax.setPreferredSize(new java.awt.Dimension(30, 25));

        btJanela.setText("Desenhar Viewport");
        btJanela.setPreferredSize(new java.awt.Dimension(61, 30));
        btJanela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCriarJanela(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yMin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xMin, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yMax, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xMax, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btJanela, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(yMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btJanela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Inicial:");

        jLabel3.setText("Final:");

        pontoInicialX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoInicialX.setModel(new javax.swing.SpinnerNumberModel(15.0d, null, null, 1.0d));
        pontoInicialX.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoInicialX.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoInicialX.setPreferredSize(new java.awt.Dimension(30, 25));

        pontoInicialY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoInicialY.setModel(new javax.swing.SpinnerNumberModel(65.0d, null, null, 1.0d));
        pontoInicialY.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoInicialY.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoInicialY.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel4.setText("X");

        jLabel5.setText("Y");

        pontoFinalX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoFinalX.setModel(new javax.swing.SpinnerNumberModel(250.0d, null, null, 1.0d));
        pontoFinalX.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoFinalX.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoFinalX.setPreferredSize(new java.awt.Dimension(30, 25));

        pontoFinalY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pontoFinalY.setModel(new javax.swing.SpinnerNumberModel(190.0d, null, null, 1.0d));
        pontoFinalY.setMaximumSize(new java.awt.Dimension(30, 25));
        pontoFinalY.setMinimumSize(new java.awt.Dimension(30, 25));
        pontoFinalY.setPreferredSize(new java.awt.Dimension(30, 25));

        btDesenhaLinha1.setText("Desenhar Reta");
        btDesenhaLinha1.setMaximumSize(new java.awt.Dimension(90, 23));
        btDesenhaLinha1.setMinimumSize(new java.awt.Dimension(90, 23));
        btDesenhaLinha1.setPreferredSize(new java.awt.Dimension(90, 30));
        btDesenhaLinha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desenhaReta(evt);
            }
        });

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
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDesenhaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btDesenhaLinha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btDesenhaLinha.setText("Aplicar Recorte");
        btDesenhaLinha.setPreferredSize(new java.awt.Dimension(61, 30));
        btDesenhaLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recorteReta(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btDesenhaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btDesenhaLinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(442, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Utiliza o algoritmo de recorte para recortar a reta de acordo com a viewport.
     */
    private void recorteReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recorteReta
        PlanoCartesiano.getInstance().redesenha();
        listaPontos = new ArrayList<>();
        List<Ponto> listaPontoReta;

        listaPontos.add(new Ponto((double) pontoInicialX.getValue(), (double) pontoInicialY.getValue()));
        listaPontos.add(new Ponto((double) pontoFinalX.getValue(), (double) pontoFinalY.getValue()));

        try {
            if (RecorteLinha.getInstance().isRetaInJanela((double) xMin.getValue(), (double) xMax.getValue(), (double) yMin.getValue(), (double) yMax.getValue(), listaPontos.get(0), listaPontos.get(1))) {
                listaPontoReta = RecorteLinha.getInstance().aplicaRecorte((double) xMin.getValue(), (double) xMax.getValue(), (double) yMin.getValue(), (double) yMax.getValue(), listaPontos);
                btCriarJanela(evt);
                Rasterizacao.getInstance().metodoPontoMedio(listaPontoReta.get(0), listaPontoReta.get(1), this.getColor(), null);
            }
        } catch (RecorteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Cohen-Sutherland", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_recorteReta

    /**
     * Desenha a ViewPort.
     */
    private void btCriarJanela(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCriarJanela
        listaPontos = new ArrayList<>();

        listaPontos.add(new Ponto((double) xMin.getValue(), (double) yMin.getValue()));
        listaPontos.add(new Ponto((double) xMax.getValue(), (double) yMin.getValue()));
        listaPontos.add(new Ponto((double) xMax.getValue(), (double) yMax.getValue()));
        listaPontos.add(new Ponto((double) xMin.getValue(), (double) yMax.getValue()));

        PlanoCartesiano.getInstance().desenhaViewPort(listaPontos);
    }//GEN-LAST:event_btCriarJanela

    /**
     * Desenha a reta.
     */
    private void desenhaReta(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desenhaReta
        setColor(Color.RED);
        PlanoCartesiano.getInstance().desenhaViewPort(listaPontos);
        // Seta as coordenadas dos pontos e seta no obejto Ponto
        setPontoInicial(new Ponto((double) pontoInicialX.getValue(), (double) pontoInicialY.getValue()));
        setPontoFinal(new Ponto((double) pontoFinalX.getValue(), (double) pontoFinalY.getValue()));

        Rasterizacao.getInstance().metodoPontoMedio(this.getPontoInicial(), this.getPontoFinal(), this.getColor(), null);
    }//GEN-LAST:event_desenhaReta


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDesenhaLinha;
    private javax.swing.JButton btDesenhaLinha1;
    private javax.swing.JButton btJanela;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSpinner pontoFinalX;
    private javax.swing.JSpinner pontoFinalY;
    private javax.swing.JSpinner pontoInicialX;
    private javax.swing.JSpinner pontoInicialY;
    private javax.swing.JSpinner xMax;
    private javax.swing.JSpinner xMin;
    private javax.swing.JSpinner yMax;
    private javax.swing.JSpinner yMin;
    // End of variables declaration//GEN-END:variables
}