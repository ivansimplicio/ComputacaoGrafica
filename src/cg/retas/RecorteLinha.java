package cg.retas;

import cg.exceptions.RecorteException;
import cg.panels.PlanoCartesiano;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa o algoritmo de recorte de linha: Cohen-Suterland.
 * 
 * @author Ivanildo Simplício
 */
public class RecorteLinha {

    static RecorteLinha instance;
    private final PlanoCartesiano planoCartesiano;
    private List<Ponto> listaPontos;

    /**
     * Construtor padrão.
     */
    private RecorteLinha() {
        listaPontos = new ArrayList<>();
        planoCartesiano = PlanoCartesiano.getInstance();
    }

    public static synchronized RecorteLinha getInstance() {
        if (instance == null) {
            instance = new RecorteLinha();
        }
        return instance;
    }

    /**
     * Função sinal.
     */
    public static String funcaoSig(double a, double b) {
        if ((a - b) > 0) {
            return "1";
        }
        return "0";
    }

    /**
     * Cria um código 4-bit para representar cada região.
     */
    public String criarBit(double Xmin, double Xmax, double Ymin, double Ymax, Ponto ponto) {
        String bit1, bit2, bit3, bit4;

        bit1 = funcaoSig((int) ponto.getY(), Ymax); //sig(y-ymax)
        bit2 = funcaoSig(Ymin, (int) ponto.getY()); //sig(ymin - y)
        bit3 = funcaoSig((int) ponto.getX(), Xmax); //sig(x-xmax)
        bit4 = funcaoSig(Xmin, (int) ponto.getX()); //sig(xmin-x)

        return bit1 + bit2 + bit3 + bit4;
    }

    /**
     * Aplica a lógica do operador AND em duas cadeias de bits.
     */
    public String operacaoLogicaAND(String codigo1, String codigo2) {
        String codigoFinal = "";
        int bitFinal;

        //faz operacao AND bit/bit (codigo1 AND codigo2)        
        for (int bit = 0; bit < codigo1.length(); bit++) {
            bitFinal = Integer.parseInt(String.valueOf(codigo1.charAt(bit))) & Integer.parseInt(String.valueOf(codigo2.charAt(bit)));
            codigoFinal += bitFinal;
        }
        return codigoFinal;
    }

    /**
     * Verifica se a reta esta dentro ou fora da janela.
     */
    public boolean isRetaInJanela(double Xmin, double Xmax, double Ymin, double Ymax, Ponto pontoInicial, Ponto pontoFinal) throws RecorteException {
        String codigo1, codigo2, resultado;
        codigo1 = criarBit(Xmin, Xmax, Ymin, Ymax, pontoInicial);
        codigo2 = criarBit(Xmin, Xmax, Ymin, Ymax, pontoFinal);
        if ("0000".equals(codigo1) && "0000".equals(codigo2)) {
            throw new RecorteException("CASO TRIVIAL\nA reta está dentro da janela!");
        } else {
            resultado = operacaoLogicaAND(codigo1, codigo2);
            if (!"0000".equals(resultado)) {
                throw new RecorteException("REJEITA\nA reta está fora da janela!");
            }
        }
        return true;
    }

    /**
     *  Aplica o algoritmo de recorte no primeiro ponto.
     */
    public Ponto aplicaRecortePonto1(String codigo, double Xmin, double Xmax, double Ymin, double Ymax, Ponto pontoInicial, Ponto pontoFinal) {
        int posicao = 0;

        //equacao m = y2-y1/x2-x1
        double m = (pontoFinal.getY() - pontoInicial.getY()) / (pontoFinal.getX() - pontoInicial.getX());

        posicao = codigo.indexOf("1");
        //aplicar o recorte de acordo a posicao do bit 1 
        switch (posicao) {
            case 0:
                double xNovo1 = pontoInicial.getX() + (Ymax - pontoInicial.getY()) / m;
                pontoInicial.setX(xNovo1);
                pontoInicial.setY(Ymax);
                break;
            case 1:
                double xNovo2 = pontoInicial.getX() + (Ymin - pontoInicial.getY()) / m;
                pontoInicial.setX(xNovo2);
                pontoInicial.setY(Ymin);
                break;
            case 2:
                double yNovo1 = pontoInicial.getY() + m * (Xmax - pontoInicial.getX());
                pontoInicial.setX(Xmax);
                pontoInicial.setY(yNovo1);
                break;

            case 3:
                double yNovo2 = pontoInicial.getY() + m * (Xmin - pontoInicial.getX());
                pontoInicial.setX(Xmin);
                pontoInicial.setY(yNovo2);
                break;
        }
        return pontoInicial;
    }

    /**
     * Aplica o algoritmo de recorte no segundo ponto.
     */
    public Ponto aplicaRecortePonto2(String codigo, double xMin, double xMax, double yMin, double yMax, Ponto pontoInicial, Ponto pontoFinal) {
        int posicao = 0;

        //equacao m = y2-y1/x2-x1
        double m = (pontoFinal.getY() - pontoInicial.getY()) / (pontoFinal.getX() - pontoInicial.getX());

        //procure a posicao 1 no codigo
        posicao = codigo.indexOf("1");

        //aplicar o recorte de acordo a posicao do bit 1 
        switch (posicao) {
            case 0:
                double xNovo1 = pontoInicial.getX() + (yMax - pontoInicial.getY()) / m;
                pontoFinal.setX(xNovo1);
                pontoFinal.setY(yMax);
                break;
            case 1:
                double xNovo2 = pontoInicial.getX() + (yMin - pontoInicial.getY()) / m;
                pontoFinal.setX(xNovo2);
                pontoFinal.setY(yMin);
                break;
            case 2:
                double yNovo1 = pontoInicial.getY() + m * (xMax - pontoInicial.getX());
                pontoFinal.setX(xMax);
                pontoFinal.setY(yNovo1);
                break;

            case 3:
                double yNovo2 = pontoInicial.getY() + m * (xMin - pontoInicial.getX());
                pontoFinal.setX(xMin);
                pontoFinal.setY(yNovo2);
                break;
        }
        return pontoFinal;
    }

    /**
     * Médoto coordenador do algoritmo de recorte.
     */
    public List<Ponto> aplicaRecorte(double xMin, double xMax, double yMin, double yMax, List<Ponto> listaPontosOriginal) {
        List<Ponto> novaListaPontos = new ArrayList<>();
        String codigo1, codigo2;

        Ponto pontoA;
        Ponto pontoB;

        codigo1 = criarBit(xMin, xMax, yMin, yMax, listaPontosOriginal.get(0));
        codigo2 = criarBit(xMin, xMax, yMin, yMax, listaPontosOriginal.get(1));

        while (!codigo1.equals("0000") || !codigo2.equals("0000")) {
            if (!codigo1.equals("0000") && codigo2.equals("0000")) {
                pontoA = aplicaRecortePonto1(codigo1, xMin, xMax, yMin, yMax, listaPontosOriginal.get(0), listaPontosOriginal.get(1));

                codigo1 = criarBit(xMin, xMax, yMin, yMax, pontoA);
                codigo2 = criarBit(xMin, xMax, yMin, yMax, listaPontosOriginal.get(1));
                novaListaPontos.add(pontoA);
                novaListaPontos.add(listaPontosOriginal.get(1));
            } else if (codigo1.equals("0000") && !codigo2.equals("0000")) {
                pontoB = aplicaRecortePonto2(codigo2, xMin, xMax, yMin, yMax, listaPontosOriginal.get(0), listaPontosOriginal.get(1));
                
                codigo2 = criarBit(xMin, xMax, yMin, yMax, pontoB);
                novaListaPontos.add(listaPontosOriginal.get(0));
                novaListaPontos.add(pontoB);
            } else {
                pontoA = aplicaRecortePonto1(codigo1, xMin, xMax, yMin, yMax, listaPontosOriginal.get(0), listaPontosOriginal.get(1));
                pontoB = aplicaRecortePonto2(codigo2, xMin, xMax, yMin, yMax, listaPontosOriginal.get(0), listaPontosOriginal.get(1));
                
                codigo1 = criarBit(xMin, xMax, yMin, yMax, pontoA);
                codigo2 = criarBit(xMin, xMax, yMin, yMax, pontoB);
                novaListaPontos.add(pontoA);
                novaListaPontos.add(pontoB);
            }
        }
        return novaListaPontos;
    }
}