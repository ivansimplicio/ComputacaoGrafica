package cg.panels;

import cg.principal.App;
import cg.enums.EnumTransformacoes;
import cg.retas.Ponto;
import cg.transformacoes.Transformacoes2D;
import java.awt.Color;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Painel com as configurações necessárias para manipulação de um objeto 2D.
 *
 * @author Ivanildo Simplício
 */
public final class PanelMenu2D extends javax.swing.JPanel {

    private static PanelMenu2D instance;
    public static double[][] matrizObjeto;
    public Stack<double[][]> listaDeTransformacoes;
    private EnumTransformacoes tipoAlgoritimo;
    private final DefaultListModel<String> modelListTransformacoes;

    private double valorX, valorY; //usando na translacao, escala, cisalhamento
    private Ponto ponto;
    private double angulo; //usado na  rotacao
    private String eixo; //usado na reflexao

    private Color color;

    public static synchronized PanelMenu2D getInstance() {
        if (instance == null) {
            instance = new PanelMenu2D();
        }
        return instance;
    }

    /**
     * Construtor padrão.
     */
    private PanelMenu2D() {
        modelListTransformacoes = new DefaultListModel();
        listaDeTransformacoes = new Stack<>();

        initComponents();

        this.setColor(Color.BLUE);
        panelEixo.setVisible(false);
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public double getValorX() {
        return valorX;
    }

    public void setValorX(double valorX) {
        this.valorX = valorX;
    }

    public double getValorY() {
        return valorY;
    }

    public void setValorY(double valorY) {
        this.valorY = valorY;
    }

    public double getAngulo() {
        return angulo;
    }

    public void setAngulo(double raio) {
        this.angulo = raio;
    }

    public String getEixo() {
        return eixo;
    }

    public void setEixo(String eixo) {
        this.eixo = eixo;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public EnumTransformacoes getTipoAlgoritimo() {
        return tipoAlgoritimo;
    }

    public void setTipoAlgoritimo(EnumTransformacoes tipoAlgoritimo) {
        this.tipoAlgoritimo = tipoAlgoritimo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupAlgoritmos = new javax.swing.ButtonGroup();
        buttonGroupReflexao = new javax.swing.ButtonGroup();
        buttonGroupObjetos = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rbTranslacao = new javax.swing.JRadioButton();
        rbRotacao = new javax.swing.JRadioButton();
        rbEscala = new javax.swing.JRadioButton();
        rbReflexao = new javax.swing.JRadioButton();
        rbCisalhamento = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        btResolve = new javax.swing.JButton();
        panelDados1 = new javax.swing.JPanel();
        valorDado1 = new javax.swing.JSpinner();
        lbDado1 = new javax.swing.JLabel();
        lbDado2 = new javax.swing.JLabel();
        valorDado2 = new javax.swing.JSpinner();
        panelEixo = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        panelObjeto = new javax.swing.JPanel();
        spinnerX = new javax.swing.JSpinner();
        spinnerY = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spinnerPY = new javax.swing.JSpinner();
        spinnerPX = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btResolve1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        brAddLista = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTransformacoes = new javax.swing.JList<>();
        btResolveCompostas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setMaximumSize(new java.awt.Dimension(240, 779));
        setMinimumSize(new java.awt.Dimension(240, 779));
        setPreferredSize(new java.awt.Dimension(240, 779));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setMaximumSize(new java.awt.Dimension(220, 106));

        buttonGroupAlgoritmos.add(rbTranslacao);
        rbTranslacao.setSelected(true);
        rbTranslacao.setText("Translação");
        rbTranslacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbRotacao);
        rbRotacao.setText("Rotação");
        rbRotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbEscala);
        rbEscala.setText("Escala");
        rbEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbReflexao);
        rbReflexao.setText("Reflexão");
        rbReflexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbCisalhamento);
        rbCisalhamento.setText("Cisalhamento");
        rbCisalhamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectedTransformacao(evt);
            }
        });

        jLabel6.setText("Selecione a transformação:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rbTranslacao)
                        .addGap(18, 18, 18)
                        .addComponent(rbReflexao))
                    .addComponent(rbRotacao)
                    .addComponent(jLabel6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(rbEscala)
                        .addGap(40, 40, 40)
                        .addComponent(rbCisalhamento)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTranslacao)
                    .addComponent(rbReflexao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCisalhamento)
                    .addComponent(rbEscala))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbRotacao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btResolve.setText("Aplicar");
        btResolve.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicaTransformacao(evt);
            }
        });

        panelDados1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDados1.setMaximumSize(new java.awt.Dimension(220, 80));
        panelDados1.setMinimumSize(new java.awt.Dimension(220, 80));
        panelDados1.setPreferredSize(new java.awt.Dimension(220, 80));

        valorDado1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorDado1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        valorDado1.setMaximumSize(new java.awt.Dimension(30, 25));
        valorDado1.setMinimumSize(new java.awt.Dimension(30, 25));
        valorDado1.setPreferredSize(new java.awt.Dimension(30, 25));

        lbDado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDado1.setText("X");

        lbDado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDado2.setText("Y");

        valorDado2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorDado2.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        valorDado2.setMaximumSize(new java.awt.Dimension(30, 25));
        valorDado2.setMinimumSize(new java.awt.Dimension(30, 25));
        valorDado2.setPreferredSize(new java.awt.Dimension(30, 25));

        javax.swing.GroupLayout panelDados1Layout = new javax.swing.GroupLayout(panelDados1);
        panelDados1.setLayout(panelDados1Layout);
        panelDados1Layout.setHorizontalGroup(
            panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelDados1Layout.setVerticalGroup(
            panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDado1)
                    .addComponent(valorDado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDado2)
                    .addComponent(valorDado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelEixo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupReflexao.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("X");

        buttonGroupReflexao.add(jRadioButton2);
        jRadioButton2.setText("Y");

        buttonGroupReflexao.add(jRadioButton3);
        jRadioButton3.setText("X e Y");

        javax.swing.GroupLayout panelEixoLayout = new javax.swing.GroupLayout(panelEixo);
        panelEixo.setLayout(panelEixoLayout);
        panelEixoLayout.setHorizontalGroup(
            panelEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEixoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(35, 35, 35))
        );
        panelEixoLayout.setVerticalGroup(
            panelEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEixoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelEixoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton3)))
        );

        panelObjeto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelObjeto.setMaximumSize(new java.awt.Dimension(220, 106));

        spinnerX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinnerX.setModel(new javax.swing.SpinnerNumberModel(75.0d, null, null, 1.0d));
        spinnerX.setToolTipText("Largura do objeto...");
        spinnerX.setMaximumSize(new java.awt.Dimension(30, 25));
        spinnerX.setMinimumSize(new java.awt.Dimension(30, 25));
        spinnerX.setPreferredSize(new java.awt.Dimension(30, 25));

        spinnerY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinnerY.setModel(new javax.swing.SpinnerNumberModel(75.0d, null, null, 1.0d));
        spinnerY.setToolTipText("Altura do objeto...");
        spinnerY.setMaximumSize(new java.awt.Dimension(63, 25));
        spinnerY.setMinimumSize(new java.awt.Dimension(63, 25));
        spinnerY.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel1.setText("Largura:");

        jLabel2.setText("Altura:");

        spinnerPY.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinnerPY.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        spinnerPY.setToolTipText("Coordenada de Y...");
        spinnerPY.setMaximumSize(new java.awt.Dimension(30, 25));
        spinnerPY.setMinimumSize(new java.awt.Dimension(30, 25));
        spinnerPY.setPreferredSize(new java.awt.Dimension(30, 25));

        spinnerPX.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinnerPX.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        spinnerPX.setToolTipText("Coordenada de X...");
        spinnerPX.setMaximumSize(new java.awt.Dimension(30, 25));
        spinnerPX.setMinimumSize(new java.awt.Dimension(30, 25));
        spinnerPX.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel3.setText("X:");

        jLabel4.setText("Y:");

        btResolve1.setText("Criar Objeto 2D");
        btResolve1.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarObjeto(evt);
            }
        });

        javax.swing.GroupLayout panelObjetoLayout = new javax.swing.GroupLayout(panelObjeto);
        panelObjeto.setLayout(panelObjetoLayout);
        panelObjetoLayout.setHorizontalGroup(
            panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelObjetoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btResolve1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(panelObjetoLayout.createSequentialGroup()
                            .addComponent(spinnerPX, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spinnerPY, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelObjetoLayout.createSequentialGroup()
                            .addComponent(spinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        panelObjetoLayout.setVerticalGroup(
            panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(spinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerPX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerPY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btResolve1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        brAddLista.setText("Add à Lista");
        brAddLista.setToolTipText("Adicione as transformações na ordem que desejar. Depois clique em: Aplicar Transformações Compostas...");
        brAddLista.setMaximumSize(new java.awt.Dimension(151, 23));
        brAddLista.setMinimumSize(new java.awt.Dimension(151, 23));
        brAddLista.setPreferredSize(new java.awt.Dimension(61, 30));
        brAddLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addListaTransformacoes(evt);
            }
        });

        listTransformacoes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listTransformacoes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        listTransformacoes.setForeground(new java.awt.Color(102, 102, 102));
        listTransformacoes.setModel(modelListTransformacoes);
        listTransformacoes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listTransformacoes.setToolTipText("Duplo clique para remover da lista...");
        listTransformacoes.setDropMode(javax.swing.DropMode.ON_OR_INSERT);
        listTransformacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removeTransformacao(evt);
            }
        });
        jScrollPane1.setViewportView(listTransformacoes);

        btResolveCompostas.setText("Aplicar T.C.");
        btResolveCompostas.setMaximumSize(new java.awt.Dimension(151, 23));
        btResolveCompostas.setMinimumSize(new java.awt.Dimension(151, 23));
        btResolveCompostas.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolveCompostas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicaTransCompostas(evt);
            }
        });

        jButton1.setText("Limpar");
        jButton1.setPreferredSize(new java.awt.Dimension(89, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Informe os dados:");

        jLabel8.setText("Lista de Transformações:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btResolveCompostas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelObjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(panelDados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelEixo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(brAddLista, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDados1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelEixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(brAddLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btResolveCompostas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Aplica a transformação selecionada.
     */
    private void aplicaTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicaTransformacao
        setColor(Color.BLUE);

        //Seta o tipo de algoritmo selecionado e seus parametros necessários
        if (rbTranslacao.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.TRANSLACAO);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
        } else if (rbEscala.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.ESCALA);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
        } else if (rbRotacao.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.ROTACAO);
            setAngulo((double) valorDado1.getValue());
        } else if (rbReflexao.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.REFLEXAO);
            if (jRadioButton1.isSelected()) {
                setEixo("x");
            } else if (jRadioButton2.isSelected()) {
                setEixo("y");
            } else if (jRadioButton3.isSelected()) {
                setEixo("xy");
            }
        } else if (rbCisalhamento.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.CISALHAMENTO);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
        }

        if (matrizObjeto == null) {
            JOptionPane.showMessageDialog(null, "Não existe objeto no plano cartesiano!\nPor favor, desenhe o objeto primeiro...", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        } else {
            App.runResult(this); //Tela principal processa os dados enviados desse painel.
        }
    }//GEN-LAST:event_aplicaTransformacao

    /**
     * Prepara o menu de acordo com o tipo de transformação selecionada.
     */
    private void selectedTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectedTransformacao
        panelDados1.setVisible(true);
        panelEixo.setVisible(false);

        valorDado1.setValue(0D);
        valorDado2.setValue(0D);

        if (rbRotacao.isSelected()) {
            lbDado1.setText("Ângulo");
            lbDado2.setVisible(false);
            valorDado2.setVisible(false);
        } else if (rbReflexao.isSelected()) {
            panelDados1.setVisible(false);
            panelEixo.setVisible(true);
        } else {
            lbDado1.setText("X");
            lbDado2.setVisible(true);
            valorDado2.setVisible(true);
        }
    }//GEN-LAST:event_selectedTransformacao

    /**
     * Adiciona a transformação requerida pelo usuário a lista de transformações.
     */
    private void addListaTransformacoes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addListaTransformacoes
        Transformacoes2D trans2D = Transformacoes2D.getInstance();
        
        //Adiciona na lista o tipo de algoritmo selecionado e seus parametros necessários.
        if (rbTranslacao.isSelected()) {
            modelListTransformacoes.addElement("- Translação: Tx=" + valorDado1.getValue() + ", Ty=" + valorDado2.getValue());
            listaDeTransformacoes.push(trans2D.geraMatrizTranslacao((double) valorDado1.getValue(), (double) valorDado2.getValue()));
        } else if (rbEscala.isSelected()) {
            modelListTransformacoes.addElement("- Escala: Sx=" + valorDado1.getValue() + ", Sy=" + valorDado2.getValue());
            listaDeTransformacoes.push(trans2D.geraMatrizEscala((double) valorDado1.getValue(), (double) valorDado2.getValue()));
        } else if (rbRotacao.isSelected()) {
            modelListTransformacoes.addElement("- Rotação: Θ=" + valorDado1.getValue());
            listaDeTransformacoes.push(trans2D.geraMatrizRotacao((double) valorDado1.getValue()));
        } else if (rbReflexao.isSelected()) {
            if (jRadioButton1.isSelected()) {
                modelListTransformacoes.addElement("- Reflexão em X");
                listaDeTransformacoes.push(trans2D.geraMatrizReflexao("x"));
            } else if (jRadioButton2.isSelected()) {
                modelListTransformacoes.addElement("- Reflexão em Y");
                listaDeTransformacoes.push(trans2D.geraMatrizReflexao("y"));
            } else if (jRadioButton3.isSelected()) {
                modelListTransformacoes.addElement("- Reflexão em XY");
                listaDeTransformacoes.push(trans2D.geraMatrizReflexao("xy"));
            }
        } else if (rbCisalhamento.isSelected()) {
            modelListTransformacoes.addElement("- Cisalhamento: Cx=" + valorDado1.getValue() + ", Cy=" + valorDado2.getValue());
            listaDeTransformacoes.push(trans2D.geraMatrizCisalhamento((double) valorDado1.getValue(), (double) valorDado2.getValue()));
        }
    }//GEN-LAST:event_addListaTransformacoes

    /**
     * Remove uma transformação da lista de transformações.
     */
    private void removeTransformacao(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeTransformacao
        if (evt.getClickCount() == 2) {
            int indexItem = listTransformacoes.getSelectedIndex();
            modelListTransformacoes.remove(indexItem);
            listaDeTransformacoes.remove(indexItem);
        }
    }//GEN-LAST:event_removeTransformacao

    /**
     * Aplica uma transformação composta no objeto.
     */
    private void aplicaTransCompostas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicaTransCompostas
        if (matrizObjeto == null) {
            JOptionPane.showMessageDialog(null, "Não existe objeto no plano cartesiano!\nPor favor, desenhe o objeto primeiro...", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }else{
            if (!listaDeTransformacoes.isEmpty()) {
                setTipoAlgoritimo(EnumTransformacoes.TRANSFORMACAO_COMPOSTA);
                App.runResult(this); //Tela principal processa os dados enviados desse painel.
            } else {
                JOptionPane.showMessageDialog(null, "Você não adicionou nenhuma transformação na lista.\nPor favor, adicione e tente novamente...", "ALERTA!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_aplicaTransCompostas

    /**
     * Limpa a lista de transformação composta. 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listaDeTransformacoes.clear();
        modelListTransformacoes.clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Evento que chama o método que desenha o objeto 2D.
     */
    private void aplicarObjeto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarObjeto
        desenharObjeto();
    }//GEN-LAST:event_aplicarObjeto

    /**
     * Desenha um objeto 2D no plano cartesiano.
     */
    private void desenharObjeto() {

        double width = (double) spinnerX.getValue();
        double height = (double) spinnerY.getValue();

        //pegando as coordenadas iniciais do objeto
        double px = (double) spinnerPX.getValue();
        double py = (double) spinnerPY.getValue();

        if (width > 0 && height > 0) {

            matrizObjeto = new double[3][4];

            // PONTO A
            matrizObjeto[0][0] = px;
            matrizObjeto[1][0] = py;
            matrizObjeto[2][0] = 1;

            // PONTO B
            matrizObjeto[0][1] = width + px;
            matrizObjeto[1][1] = 0 + py;
            matrizObjeto[2][1] = 1;

            // PONTO C
            matrizObjeto[0][2] = width + px;
            matrizObjeto[1][2] = height + py;
            matrizObjeto[2][2] = 1;

            // PONTO D
            matrizObjeto[0][3] = 0 + px;
            matrizObjeto[1][3] = height + py;
            matrizObjeto[2][3] = 1;

            PlanoCartesiano.getInstance().drawObjeto2D(matrizObjeto, getColor());
        } else {
            JOptionPane.showMessageDialog(null, "Defina a largura (W) e altura (H) do objeto!", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brAddLista;
    private javax.swing.JButton btResolve;
    private javax.swing.JButton btResolve1;
    private javax.swing.JButton btResolveCompostas;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.ButtonGroup buttonGroupObjetos;
    private javax.swing.ButtonGroup buttonGroupReflexao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDado1;
    private javax.swing.JLabel lbDado2;
    private javax.swing.JList<String> listTransformacoes;
    private javax.swing.JPanel panelDados1;
    private javax.swing.JPanel panelEixo;
    private javax.swing.JPanel panelObjeto;
    private javax.swing.JRadioButton rbCisalhamento;
    private javax.swing.JRadioButton rbEscala;
    private javax.swing.JRadioButton rbReflexao;
    private javax.swing.JRadioButton rbRotacao;
    private javax.swing.JRadioButton rbTranslacao;
    private javax.swing.JSpinner spinnerPX;
    private javax.swing.JSpinner spinnerPY;
    private javax.swing.JSpinner spinnerX;
    private javax.swing.JSpinner spinnerY;
    private javax.swing.JSpinner valorDado1;
    private javax.swing.JSpinner valorDado2;
    // End of variables declaration//GEN-END:variables
}