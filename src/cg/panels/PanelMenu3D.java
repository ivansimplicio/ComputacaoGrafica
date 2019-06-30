package cg.panels;

import cg.principal.App;
import cg.enums.EnumTransformacoes;
import cg.retas.Ponto;
import cg.transformacoes.Transformacoes3D;
import java.awt.Color;
import java.util.Stack;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 * Painel com as configurações necessárias para manipulação de um objeto 3D.
 *
 * @author Ivanildo Simplício
 */
public final class PanelMenu3D extends javax.swing.JPanel {

    private static PanelMenu3D instance;
    public static double[][] matrizObjeto3D;
    public Stack<double[][]> listaDeTransformacoes;
    private EnumTransformacoes tipoAlgoritimo;
    private final DefaultListModel<String> modelListTransformacoes;

    private double valorX, valorY, valorZ; //usando na translacao, escala, cisalhamento
    private Ponto ponto;
    private double angulo; //usado na  rotacao
    private String eixo; //usado na reflexao

    private Color color;

    public static synchronized PanelMenu3D getInstance() {
        if (instance == null) {
            instance = new PanelMenu3D();
        }
        return instance;
    }

    /**
     * Construtor padrão.
     */
    private PanelMenu3D() {
        modelListTransformacoes = new DefaultListModel();
        listaDeTransformacoes = new Stack<>();

        initComponents();

        this.setColor(Color.BLUE);
        panelDados2.setVisible(false);
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

    public double getValorZ() {
        return valorZ;
    }

    public void setValorZ(double valorZ) {
        this.valorZ = valorZ;
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
        panelObjeto = new javax.swing.JPanel();
        spinnerX = new javax.swing.JSpinner();
        spinnerY = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        spinnerZ = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        btResolve1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        rbTranslacao = new javax.swing.JRadioButton();
        rbRotacao = new javax.swing.JRadioButton();
        rbEscala = new javax.swing.JRadioButton();
        rbReflexao = new javax.swing.JRadioButton();
        rbCisalhamento = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        panelDados1 = new javax.swing.JPanel();
        valorDado1 = new javax.swing.JSpinner();
        lbDado1 = new javax.swing.JLabel();
        lbDado2 = new javax.swing.JLabel();
        valorDado2 = new javax.swing.JSpinner();
        valorDado3 = new javax.swing.JSpinner();
        lbDado3 = new javax.swing.JLabel();
        panelDados2 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        btResolve = new javax.swing.JButton();
        brAddLista = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTransformacoes = new javax.swing.JList<>();
        btResolveCompostas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(240, 779));
        setMinimumSize(new java.awt.Dimension(240, 779));
        setPreferredSize(new java.awt.Dimension(240, 779));

        panelObjeto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelObjeto.setMaximumSize(new java.awt.Dimension(220, 106));
        panelObjeto.setMinimumSize(new java.awt.Dimension(220, 106));
        panelObjeto.setPreferredSize(new java.awt.Dimension(220, 106));

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
        spinnerY.setPreferredSize(new java.awt.Dimension(63, 25));

        jLabel1.setText("W");

        jLabel2.setText("H");

        spinnerZ.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        spinnerZ.setModel(new javax.swing.SpinnerNumberModel(75.0d, null, null, 1.0d));
        spinnerZ.setToolTipText("Profundidade do objeto...");
        spinnerZ.setMaximumSize(new java.awt.Dimension(63, 25));
        spinnerZ.setMinimumSize(new java.awt.Dimension(63, 25));
        spinnerZ.setPreferredSize(new java.awt.Dimension(63, 25));

        jLabel5.setText("L");

        btResolve1.setText("Criar Objeto 3D");
        btResolve1.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResolve1aplicarObjeto(evt);
            }
        });

        javax.swing.GroupLayout panelObjetoLayout = new javax.swing.GroupLayout(panelObjeto);
        panelObjeto.setLayout(panelObjetoLayout);
        panelObjetoLayout.setHorizontalGroup(
            panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObjetoLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinnerZ, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelObjetoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btResolve1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        panelObjetoLayout.setVerticalGroup(
            panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObjetoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(panelObjetoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(btResolve1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupAlgoritmos.add(rbTranslacao);
        rbTranslacao.setSelected(true);
        rbTranslacao.setText("Translação");
        rbTranslacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbTranslacaoselectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbRotacao);
        rbRotacao.setText("Rotação");
        rbRotacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRotacaoselectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbEscala);
        rbEscala.setText("Escala");
        rbEscala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEscalaselectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbReflexao);
        rbReflexao.setText("Reflexão");
        rbReflexao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbReflexaoselectedTransformacao(evt);
            }
        });

        buttonGroupAlgoritmos.add(rbCisalhamento);
        rbCisalhamento.setText("Cisalhamento");
        rbCisalhamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCisalhamentoselectedTransformacao(evt);
            }
        });

        jLabel3.setText("Selecione a transformação:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbRotacao)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbTranslacao)
                            .addComponent(rbEscala))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbCisalhamento)
                            .addComponent(rbReflexao)))
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTranslacao)
                    .addComponent(rbReflexao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbCisalhamento)
                    .addComponent(rbEscala, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbRotacao)
                .addGap(31, 31, 31))
        );

        panelDados1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelDados1.setMaximumSize(new java.awt.Dimension(220, 80));
        panelDados1.setMinimumSize(new java.awt.Dimension(220, 80));
        panelDados1.setPreferredSize(new java.awt.Dimension(220, 80));

        valorDado1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorDado1.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        valorDado1.setMaximumSize(new java.awt.Dimension(30, 25));
        valorDado1.setMinimumSize(new java.awt.Dimension(30, 25));
        valorDado1.setPreferredSize(new java.awt.Dimension(30, 25));

        lbDado1.setText("X");

        lbDado2.setText("Y");

        valorDado2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorDado2.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        valorDado2.setMaximumSize(new java.awt.Dimension(30, 25));
        valorDado2.setMinimumSize(new java.awt.Dimension(30, 25));
        valorDado2.setPreferredSize(new java.awt.Dimension(30, 25));

        valorDado3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        valorDado3.setModel(new javax.swing.SpinnerNumberModel(0.0d, null, null, 1.0d));
        valorDado3.setMaximumSize(new java.awt.Dimension(30, 25));
        valorDado3.setMinimumSize(new java.awt.Dimension(30, 25));
        valorDado3.setPreferredSize(new java.awt.Dimension(30, 25));

        lbDado3.setText("Z");

        javax.swing.GroupLayout panelDados1Layout = new javax.swing.GroupLayout(panelDados1);
        panelDados1.setLayout(panelDados1Layout);
        panelDados1Layout.setHorizontalGroup(
            panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDados1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDado1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorDado1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDado2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorDado2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDado3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valorDado3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        panelDados1Layout.setVerticalGroup(
            panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDados1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDado1)
                    .addComponent(valorDado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorDado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDado2)
                    .addComponent(lbDado3)
                    .addComponent(valorDado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelDados2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroupReflexao.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("XY");

        buttonGroupReflexao.add(jRadioButton2);
        jRadioButton2.setText("YZ");

        buttonGroupReflexao.add(jRadioButton3);
        jRadioButton3.setText("XZ");

        javax.swing.GroupLayout panelDados2Layout = new javax.swing.GroupLayout(panelDados2);
        panelDados2.setLayout(panelDados2Layout);
        panelDados2Layout.setHorizontalGroup(
            panelDados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addGap(46, 46, 46)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButton3)
                .addContainerGap())
        );
        panelDados2Layout.setVerticalGroup(
            panelDados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDados2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDados2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btResolve.setText("Aplicar");
        btResolve.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResolveaplicaTransformacao(evt);
            }
        });

        brAddLista.setText("Add à Lista");
        brAddLista.setToolTipText("Adicione as transformações na ordem que desejar. Depois clique em: Aplicar Transformações Compostas...");
        brAddLista.setMaximumSize(new java.awt.Dimension(151, 23));
        brAddLista.setMinimumSize(new java.awt.Dimension(151, 23));
        brAddLista.setPreferredSize(new java.awt.Dimension(61, 30));
        brAddLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brAddListaaddListaTransformacoes(evt);
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
                listTransformacoesremoveTransformacao(evt);
            }
        });
        jScrollPane1.setViewportView(listTransformacoes);

        btResolveCompostas.setText("Aplicar T.C.");
        btResolveCompostas.setMaximumSize(new java.awt.Dimension(151, 23));
        btResolveCompostas.setMinimumSize(new java.awt.Dimension(151, 23));
        btResolveCompostas.setPreferredSize(new java.awt.Dimension(61, 30));
        btResolveCompostas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResolveCompostasaplicaTransCompostas(evt);
            }
        });

        jButton1.setText("Limpar");
        jButton1.setPreferredSize(new java.awt.Dimension(61, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Informe os dados:");

        jLabel6.setText("Lista de Transformações:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelObjeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator2)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelDados1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(panelDados2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(brAddLista, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btResolveCompostas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDados1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDados2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btResolve, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brAddLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btResolveCompostas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Faz a chamada do método que desenha um objeto 3D no espaço.
     */
    private void btResolve1aplicarObjeto(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResolve1aplicarObjeto
        desenharObjeto();
    }//GEN-LAST:event_btResolve1aplicarObjeto

    /**
     * Configura painel caso seja escolhida a transformação: translação.
     */
    private void rbTranslacaoselectedTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbTranslacaoselectedTransformacao
        panelDados1.setVisible(true);
        panelDados2.setVisible(false);

        valorDado1.setValue(0D);
        valorDado2.setValue(0D);
        valorDado3.setValue(0D);

        if (rbRotacao.isSelected()) {
            lbDado1.setText("Ângulo");
            lbDado2.setVisible(false);
            valorDado2.setVisible(false);
        } else if (rbReflexao.isSelected()) {
            panelDados1.setVisible(false);
            panelDados2.setVisible(true);
        } else {
            lbDado1.setText("X");
            lbDado2.setText("Y");
            lbDado3.setText("Z");
            lbDado2.setVisible(true);
            lbDado3.setVisible(true);
            valorDado2.setVisible(true);
            valorDado3.setVisible(true);
        }
    }//GEN-LAST:event_rbTranslacaoselectedTransformacao

    /**
     * Configura painel caso seja escolhida a transformação: rotação.
     */
    private void rbRotacaoselectedTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRotacaoselectedTransformacao
        panelDados1.setVisible(true);
        panelDados2.setVisible(true);

        valorDado1.setValue(0D);
        valorDado2.setValue(0D);
        valorDado3.setValue(0D);

        if (rbRotacao.isSelected()) {
            lbDado1.setText("Ângulo");
            lbDado2.setVisible(false);
            lbDado3.setVisible(false);
            valorDado2.setVisible(false);
            valorDado3.setVisible(false);

            jRadioButton1.setText("X");
            jRadioButton2.setText("Y");
            jRadioButton3.setText("Z");
        } else if (rbReflexao.isSelected()) {
            panelDados1.setVisible(false);
            panelDados2.setVisible(true);
        } else {
            lbDado1.setText("X");
            lbDado2.setVisible(true);
            lbDado3.setVisible(true);
            valorDado2.setVisible(true);
            valorDado3.setVisible(true);
        }
    }//GEN-LAST:event_rbRotacaoselectedTransformacao

    /**
     * Configura painel caso seja escolhida a transformação: escala.
     */
    private void rbEscalaselectedTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEscalaselectedTransformacao
        panelDados1.setVisible(true);
        panelDados2.setVisible(false);

        valorDado1.setValue(1D);
        valorDado2.setValue(1D);
        valorDado3.setValue(1D);

        if (rbRotacao.isSelected()) {
            lbDado1.setText("Ângulo");
            lbDado2.setVisible(false);
            valorDado2.setVisible(false);
        } else if (rbReflexao.isSelected()) {
            panelDados1.setVisible(false);
            panelDados2.setVisible(true);
        } else {
            lbDado1.setText("X");
            lbDado2.setText("Y");
            lbDado3.setText("Z");
            lbDado2.setVisible(true);
            lbDado3.setVisible(true);
            valorDado2.setVisible(true);
            valorDado3.setVisible(true);
        }
    }//GEN-LAST:event_rbEscalaselectedTransformacao

    /**
     * Configura painel caso seja escolhida a transformação: reflexão.
     */
    private void rbReflexaoselectedTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbReflexaoselectedTransformacao
        panelDados1.setVisible(true);
        panelDados2.setVisible(false);

        valorDado1.setValue(0D);
        valorDado2.setValue(0D);
        valorDado3.setValue(0D);

        if (rbRotacao.isSelected()) {
            lbDado1.setText("Ângulo");
            lbDado2.setVisible(false);
            valorDado2.setVisible(false);
        } else if (rbReflexao.isSelected()) {
            panelDados1.setVisible(false);
            panelDados2.setVisible(true);

            jRadioButton1.setText("XY");
            jRadioButton2.setText("YZ");
            jRadioButton3.setText("XZ");
        } else {
            lbDado1.setText("X");
            lbDado2.setVisible(true);
            lbDado3.setVisible(true);
            valorDado2.setVisible(true);
            valorDado3.setVisible(true);
        }
    }//GEN-LAST:event_rbReflexaoselectedTransformacao

    /**
     * Configura painel caso seja escolhida a transformação: Cisalhamento.
     */
    private void rbCisalhamentoselectedTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCisalhamentoselectedTransformacao
        panelDados1.setVisible(true);
        panelDados2.setVisible(true);

        valorDado1.setValue(0D);
        valorDado2.setValue(0D);
        valorDado3.setValue(0D);

        if (rbRotacao.isSelected()) {
            lbDado1.setText("Ângulo");
            lbDado2.setVisible(false);
            valorDado2.setVisible(false);
        } else if (rbReflexao.isSelected()) {
            panelDados1.setVisible(false);
            panelDados2.setVisible(true);
        } else {
            lbDado1.setText("a");
            lbDado2.setText("b");
            lbDado2.setVisible(true);
            valorDado2.setVisible(true);
            lbDado3.setVisible(false);
            valorDado3.setVisible(false);

            jRadioButton1.setText("X");
            jRadioButton2.setText("Y");
            jRadioButton3.setText("Z");
        }
    }//GEN-LAST:event_rbCisalhamentoselectedTransformacao

    /**
     * Aplica a transformação escolhida no objeto 3D.
     */
    private void btResolveaplicaTransformacao(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResolveaplicaTransformacao
        setColor(Color.BLUE);

        //Seta o tipo de algoritmo selecionado e seus parametros necessários
        if (rbTranslacao.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.TRANSLACAO);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
            setValorZ((double) valorDado3.getValue());
        } else if (rbEscala.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.ESCALA);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
            setValorZ((double) valorDado3.getValue());
        } else if (rbRotacao.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.ROTACAO);
            setAngulo((double) valorDado1.getValue());
            if (jRadioButton1.isSelected()) {
                setEixo("x");
            } else if (jRadioButton2.isSelected()) {
                setEixo("y");
            } else if (jRadioButton3.isSelected()) {
                setEixo("z");
            }
        } else if (rbReflexao.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.REFLEXAO);
            if (jRadioButton1.isSelected()) {
                setEixo("xy");
            } else if (jRadioButton2.isSelected()) {
                setEixo("yz");
            } else if (jRadioButton3.isSelected()) {
                setEixo("xz");
            }
        } else if (rbCisalhamento.isSelected()) {
            setTipoAlgoritimo(EnumTransformacoes.CISALHAMENTO);
            setValorX((double) valorDado1.getValue());
            setValorY((double) valorDado2.getValue());
            setValorZ((double) valorDado3.getValue());
        }
        if (matrizObjeto3D == null) {
            JOptionPane.showMessageDialog(null, "Não existe um objeto desenhado!\nPor favor, desenhe o objeto primeiro...", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        } else {
            App.runResult(this); //Tela principal processa os dados enviados desse painel.
        }
    }//GEN-LAST:event_btResolveaplicaTransformacao

    /**
     * Adiciona uma transformação a lista de transformação composta.
     */
    private void brAddListaaddListaTransformacoes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brAddListaaddListaTransformacoes
        Transformacoes3D trans3D = Transformacoes3D.getInstance();
        
        //adiciona a lista o tipo de algoritmo selecionado e seus parametros necessários
        if (rbTranslacao.isSelected()) {
            modelListTransformacoes.addElement("- Translação: Tx=" + valorDado1.getValue() + ", Ty=" + valorDado2.getValue() + ", Tz=" + valorDado3.getValue());
            listaDeTransformacoes.push(trans3D.geraMatrizTranslacao((double) valorDado1.getValue(), (double) valorDado2.getValue(), (double) valorDado3.getValue()));
        } else if (rbEscala.isSelected()) {
            modelListTransformacoes.addElement("- Escala: Sx=" + valorDado1.getValue() + ", Sy=" + valorDado2.getValue() + ", Sz=" + valorDado3.getValue());
            listaDeTransformacoes.push(trans3D.geraMatrizEscala((double) valorDado1.getValue(), (double) valorDado2.getValue(), (double) valorDado3.getValue()));
        } else if (rbRotacao.isSelected()) {
            if (jRadioButton1.isSelected()) {
                modelListTransformacoes.addElement("- Rotação em X, Θ=" + valorDado1.getValue());
                listaDeTransformacoes.push(trans3D.geraMatrizRotacao((double) valorDado1.getValue(), "x"));
            } else if (jRadioButton2.isSelected()) {
                modelListTransformacoes.addElement("- Rotação em Y, Θ=" + valorDado1.getValue());
                listaDeTransformacoes.push(trans3D.geraMatrizRotacao((double) valorDado1.getValue(), "y"));
            } else if (jRadioButton3.isSelected()) {
                modelListTransformacoes.addElement("- Rotação em Z, Θ=" + valorDado1.getValue());
                listaDeTransformacoes.push(trans3D.geraMatrizRotacao((double) valorDado1.getValue(), "z"));
            }
        } else if (rbReflexao.isSelected()) {
            if (jRadioButton1.isSelected()) {
                modelListTransformacoes.addElement("- Reflexão em XY");
                listaDeTransformacoes.push(trans3D.geraMatrizReflexao("xy"));
            } else if (jRadioButton2.isSelected()) {
                modelListTransformacoes.addElement("- Reflexão em YZ");
                listaDeTransformacoes.push(trans3D.geraMatrizReflexao("yz"));
            } else if (jRadioButton3.isSelected()) {
                modelListTransformacoes.addElement("- Reflexão em XZ");
                listaDeTransformacoes.push(trans3D.geraMatrizReflexao("xz"));
            }
        } else if (rbCisalhamento.isSelected()) {
            modelListTransformacoes.addElement("- Cisalhamento: Cx=" + valorDado1.getValue() + ", Cy=" + valorDado2.getValue() + ", Cz=" + valorDado3.getValue());
            listaDeTransformacoes.push(trans3D.geraMatrizCisalhamento((double) valorDado1.getValue(), (double) valorDado2.getValue(), ""));
        }
    }//GEN-LAST:event_brAddListaaddListaTransformacoes

    /**
     * Remove uma transformação da lista de transformações.
     */
    private void listTransformacoesremoveTransformacao(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTransformacoesremoveTransformacao
        if (evt.getClickCount() == 2) {
            int indexItem = listTransformacoes.getSelectedIndex();
            modelListTransformacoes.remove(indexItem);
            listaDeTransformacoes.remove(indexItem);
        }
    }//GEN-LAST:event_listTransformacoesremoveTransformacao

    /**
     * Aplica uma transformação composta em um objeto 3D.
     */
    private void btResolveCompostasaplicaTransCompostas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResolveCompostasaplicaTransCompostas
        if (matrizObjeto3D == null) {
            JOptionPane.showMessageDialog(null, "Não existe um objeto desenhado!\nPor favor, desenhe o objeto primeiro...", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        } else {
            if (!listaDeTransformacoes.isEmpty()) {
                setTipoAlgoritimo(EnumTransformacoes.TRANSFORMACAO_COMPOSTA);
                App.runResult(this); //Tela principal processa os dados enviados desse painel.
            } else {
                JOptionPane.showMessageDialog(null, "Você não adicionou nenhum tipo de transformação na lista.\nPor favor, adicione e tente novamente...", "ALERTA!", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btResolveCompostasaplicaTransCompostas
    /**
     * Limpa a lista de transformação composta. 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listaDeTransformacoes.clear();
        modelListTransformacoes.clear();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Desenha um objeto 3D no espaço.
     */
    private void desenharObjeto() {
        double width = (double) spinnerX.getValue();
        double height = (double) spinnerY.getValue();
        double depth = (double) spinnerZ.getValue();

        if (width > 0 && height > 0) {

            matrizObjeto3D = new double[4][8];

            // PONTO A
            matrizObjeto3D[0][0] = 0;
            matrizObjeto3D[1][0] = 0;
            matrizObjeto3D[2][0] = 0;
            matrizObjeto3D[3][0] = 1;

            // PONTO B
            matrizObjeto3D[0][1] = width;
            matrizObjeto3D[1][1] = 0;
            matrizObjeto3D[2][1] = 0;
            matrizObjeto3D[3][1] = 1;

            // PONTO C
            matrizObjeto3D[0][2] = width;
            matrizObjeto3D[1][2] = height;
            matrizObjeto3D[2][2] = 0;
            matrizObjeto3D[3][2] = 1;

            // PONTO D
            matrizObjeto3D[0][3] = 0;
            matrizObjeto3D[1][3] = height;
            matrizObjeto3D[2][3] = 0;
            matrizObjeto3D[3][3] = 1;

            // PONTO E
            matrizObjeto3D[0][4] = (depth / 2);
            matrizObjeto3D[1][4] = (depth / 2);
            matrizObjeto3D[2][4] = 0;
            matrizObjeto3D[3][4] = 1;

            // PONTO F
            matrizObjeto3D[0][5] = (width + depth / 2);
            matrizObjeto3D[1][5] = (depth / 2);
            matrizObjeto3D[2][5] = 0;
            matrizObjeto3D[3][5] = 1;

            // PONTO G
            matrizObjeto3D[0][6] = (width + depth / 2);
            matrizObjeto3D[1][6] = (height + depth / 2);
            matrizObjeto3D[2][6] = 0;
            matrizObjeto3D[3][6] = 1;

            // PONTO H
            matrizObjeto3D[0][7] = (depth / 2);
            matrizObjeto3D[1][7] = (height + depth / 2);
            matrizObjeto3D[2][7] = 0;
            matrizObjeto3D[3][7] = 1;

            PlanoCartesiano.getInstance().drawObjeto3D(matrizObjeto3D, getColor());
        } else {
            JOptionPane.showMessageDialog(null, "Defina a largura (W), altura (H) e profundidade (L) do objeto!", "ALERTA!", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brAddLista;
    private javax.swing.JButton btResolve;
    private javax.swing.JButton btResolve1;
    private javax.swing.JButton btResolveCompostas;
    private javax.swing.ButtonGroup buttonGroupAlgoritmos;
    private javax.swing.ButtonGroup buttonGroupReflexao;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbDado1;
    private javax.swing.JLabel lbDado2;
    private javax.swing.JLabel lbDado3;
    private javax.swing.JList<String> listTransformacoes;
    private javax.swing.JPanel panelDados1;
    private javax.swing.JPanel panelDados2;
    private javax.swing.JPanel panelObjeto;
    private javax.swing.JRadioButton rbCisalhamento;
    private javax.swing.JRadioButton rbEscala;
    private javax.swing.JRadioButton rbReflexao;
    private javax.swing.JRadioButton rbRotacao;
    private javax.swing.JRadioButton rbTranslacao;
    private javax.swing.JSpinner spinnerX;
    private javax.swing.JSpinner spinnerY;
    private javax.swing.JSpinner spinnerZ;
    private javax.swing.JSpinner valorDado1;
    private javax.swing.JSpinner valorDado2;
    private javax.swing.JSpinner valorDado3;
    // End of variables declaration//GEN-END:variables
}