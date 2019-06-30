package cg.panels;

import cg.principal.App;
import cg.enums.EnumCircunferencia;
import java.awt.Color;

/**
 * Painel com as configurações necessárias para desenhar uma circunferência.
 *
 * @author Ivanildo Simplício
 */
public class PanelMenuCircunferencia extends javax.swing.JPanel {

    private static PanelMenuCircunferencia instance;

    private float raioX;
    private float raioY;
    private Color color;
    private EnumCircunferencia tipoAlgoritimo;

    /**
     * Construtor padrão.
     */
    private PanelMenuCircunferencia() {
        initComponents();
        valorRaioY.setVisible(false);
        label_b.setVisible(false);
        label_a.setText("Raio: ");
    }
    
    public static synchronized PanelMenuCircunferencia getInstance() {
        if (instance == null) {
            instance = new PanelMenuCircunferencia();
        }
        return instance;
    }

    public float getRaioX() {
        return raioX;
    }

    public void setRaioX(float raioX) {
        this.raioX = raioX;
    }

    public float getRaioY() {
        return raioY;
    }

    public void setRaioY(float raioY) {
        this.raioY = raioY;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public EnumCircunferencia getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(EnumCircunferencia tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlgoritmos = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        rbPontoMedio = new javax.swing.JRadioButton();
        rbTrigonometrica = new javax.swing.JRadioButton();
        rbEquacaoExplicita = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        label_a = new javax.swing.JLabel();
        valorRaioX = new javax.swing.JSpinner();
        valorRaioY = new javax.swing.JSpinner();
        label_b = new javax.swing.JLabel();
        btResolve = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rbElipse = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(240, 32767));
        setMinimumSize(new java.awt.Dimension(240, 0));
        setPreferredSize(new java.awt.Dimension(240, 779));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupAlgoritmos.add(rbPontoMedio);
        rbPontoMedio.setSelected(true);
        rbPontoMedio.setText("Ponto Médio");
        rbPontoMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbTrigonometrica);
        rbTrigonometrica.setText("Trigonométrico");
        rbTrigonometrica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbEquacaoExplicita);
        rbEquacaoExplicita.setText("Equação Explícita");
        rbEquacaoExplicita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbTrigonometrica)
                    .addComponent(rbPontoMedio)
                    .addComponent(rbEquacaoExplicita))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbPontoMedio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbEquacaoExplicita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbTrigonometrica)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label_a.setText("a:");

        valorRaioX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorRaioX.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        valorRaioX.setMaximumSize(new java.awt.Dimension(30, 25));
        valorRaioX.setMinimumSize(new java.awt.Dimension(30, 25));
        valorRaioX.setPreferredSize(new java.awt.Dimension(30, 25));

        valorRaioY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorRaioY.setModel(new javax.swing.SpinnerNumberModel(0.0f, null, null, 0.1f));
        valorRaioY.setMaximumSize(new java.awt.Dimension(30, 25));
        valorRaioY.setMinimumSize(new java.awt.Dimension(30, 25));
        valorRaioY.setPreferredSize(new java.awt.Dimension(30, 25));

        label_b.setText("b:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(label_a)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorRaioX, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_b)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorRaioY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorRaioX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_a)
                    .addComponent(valorRaioY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_b))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btResolve.setText("Desenhar Circunferência");
        btResolve.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desenhaCirc(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupAlgoritmos.add(rbElipse);
        rbElipse.setText("Elipse por varredura (Ponto Médio)");
        rbElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecetedAlgoritmo(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rbElipse)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbElipse)
                .addContainerGap())
        );

        jLabel1.setText("Selecione o algoritmo (Circunferência):");

        jLabel2.setText("Selecione o algoritmo (Elipse):");

        jLabel3.setText("Informe os dados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(450, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Desenha a circuferência utilizando o algoritmo selecionado.
     */
    private void desenhaCirc(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desenhaCirc
        setColor(Color.RED);

        // Seta o raio
        setRaioX((float) valorRaioX.getValue());

        // Seta o tipo de algoritmo selecionado
        if (rbPontoMedio.isSelected()) {
            setTipoAlgoritimo(EnumCircunferencia.PONTO_MEDIO);
        } else if (rbEquacaoExplicita.isSelected()) {
            setTipoAlgoritimo(EnumCircunferencia.EQUACAO_EXPLICITA);
        } else if (rbTrigonometrica.isSelected()) {
            setTipoAlgoritimo(EnumCircunferencia.TRIGONOMETRICO);
        } else if (rbElipse.isSelected()) {
            setRaioY((float) valorRaioY.getValue());
            setTipoAlgoritimo(EnumCircunferencia.ELIPSE);
        }
        App.runResult(this); //Tela principal processa os dados enviados desse painel.
    }//GEN-LAST:event_desenhaCirc

    /**
     * Habilita/desabilita componentes de acordo como algoritmo selecionado.
     */
    private void selecetedAlgoritmo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecetedAlgoritmo
        if (rbTrigonometrica.isSelected() || rbEquacaoExplicita.isSelected() || rbPontoMedio.isSelected()) {
            valorRaioY.setVisible(false);
            label_b.setVisible(false);
            label_a.setText("Raio:");
            btResolve.setText("Desenhar Circunferência");
        } else {
            valorRaioY.setVisible(true);
            label_b.setVisible(true);
            label_a.setText("a:");
            btResolve.setText("Desenhar Elipse");
        }
    }//GEN-LAST:event_selecetedAlgoritmo


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btResolve;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel label_a;
    private javax.swing.JLabel label_b;
    private javax.swing.JRadioButton rbElipse;
    private javax.swing.JRadioButton rbEquacaoExplicita;
    private javax.swing.JRadioButton rbPontoMedio;
    private javax.swing.JRadioButton rbTrigonometrica;
    private javax.swing.JSpinner valorRaioX;
    private javax.swing.JSpinner valorRaioY;
    // End of variables declaration//GEN-END:variables
}