package cg.transformacoes;

import cg.panels.PlanoCartesiano;
import cg.retas.Ponto;
import cg.retas.Rasterizacao;
import java.awt.Color;
import java.awt.Graphics2D;
import static java.lang.Thread.sleep;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Classe da animação do batimento cardíaco.
 *
 * @author Matheus Clemente
 */
public class BeatingHeart {
    
    public static Thread threadAnimation;
    
    private final PlanoCartesiano planoCartesiano;
    private final Graphics2D g;
    private final Rasterizacao rast;
    
    private final List<Ponto> pontosLine;
    private final Ponto ini;
    private final Ponto fim;
    
    /**
     * Construtor, inicializa variáveis.
     */
    public BeatingHeart(){
        planoCartesiano = PlanoCartesiano.getInstance();
        g = (Graphics2D) planoCartesiano.getGraphics();
        rast = Rasterizacao.getInstance();
        
        pontosLine = new LinkedList<>();
        ini = new Ponto((-1)*(planoCartesiano.getLargura()/2),0);
        fim = new Ponto((planoCartesiano.getLargura()/2), 0);
    }
    
    /**
     * Método que gera os pontos de uma linha iniciando pInicial.
     * @param pInicial 
     */
    private void geraPontosLinha(Ponto pInicial) {
        Ponto aux = new Ponto(pInicial.getX()+100, 0);
        rast.metodoPontoMedio(pInicial, aux, Color.red, null);
        pontosLine.addAll(rast.getPontos());
        removePontos();
    }
    
    /**
     * Método que gera os pontos do batimento cardíaco iniciando do pInicial.
     * @param pInicial 
     */
    private void geraPontosBatimento(Ponto pInicial){
        int incX = 15;
        int incY = 2;
        Ponto aux = new Ponto(pInicial.getX()+incX, 70);
        
        rast.metodoPontoMedio(pInicial, aux, Color.red, null);
        pontosLine.addAll(rast.getPontos());
        
        rast.metodoPontoMedio(aux, new Ponto(aux.getX()+incX,-aux.getY()), Color.red, null);
        pontosLine.addAll(rast.getPontos());
        
        rast.metodoPontoMedio(new Ponto(aux.getX()+incX,-aux.getY()), new Ponto(aux.getX()+(incX*2), aux.getY()*incY), Color.red, null);
        pontosLine.addAll(rast.getPontos());
        
        rast.metodoPontoMedio(new Ponto(aux.getX()+(incX*2), aux.getY()*incY), new Ponto(aux.getX()+(incX*3), -aux.getY()*incY), Color.red, null);
        pontosLine.addAll(rast.getPontos());
        
        rast.metodoPontoMedio(new Ponto(aux.getX()+(incX*3), -aux.getY()*incY), new Ponto(aux.getX()+(incX*4), aux.getY()), Color.red, null);
        pontosLine.addAll(rast.getPontos());
        
        rast.metodoPontoMedio(new Ponto(aux.getX()+(incX*4), aux.getY()), new Ponto(aux.getX()+(incX*5), 0), Color.red, null);
        pontosLine.addAll(rast.getPontos());
        
        removePontos();
    }
    
    /**
     * Método que remove os pontos que ultrapassaram o tamanho do plano.
     */
    private void removePontos() {
        int t = pontosLine.size() - 1;
        boolean c = true;
        while(c){
            if(pontosLine.get(t).getX() > fim.getX()){
                pontosLine.remove(t);
                t--;
            }else{
                c = false;
            }
        }
    }
            
    /**
     * Método que inicia a animação
     */
    public void startAnimation(){
        int x = (int) ini.getX();
        int y = (int) ini.getY();
        while(x < fim.getX()){
            geraPontosLinha(new Ponto(x, y));
            x += 100;
            geraPontosBatimento(new Ponto(x, y));
            x += 90;
        }
        for(int i=0; i<2; i++){
            planoCartesiano.redesenha();
            pontosLine.forEach(p -> {
                rast.metodoPontoMedio(p, p, Color.red, null);

                try {
                    sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(BeatingHeart.class.getName()).log(Level.SEVERE, null, ex);
                } 
            });
        }
        
    }
}
