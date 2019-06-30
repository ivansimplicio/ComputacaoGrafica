package cg.transformacoes;

import cg.retas.Ponto;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Representa uma imagem do tipo .PGM
 *
 */
public class Imagem {

    private int[][] matrizPixel;
    private BufferedImage bufferedImage;
    private int width;
    private int height;
    private Ponto ponto;

    /**
     * Construtor default.
     */
    public Imagem() {

    }

    /**
     * Construtor parametrizado.
     */
    public Imagem(int[][] matrizPixel, BufferedImage bufferedImage, int width, int height) {
        this.matrizPixel = matrizPixel;
        this.bufferedImage = bufferedImage;
        this.width = width;
        this.height = height;
        this.ponto = new Ponto(0, 0);
    }

    /**
     * Seta o valor do pixel numa posição especificada na imagem.
     */
    public boolean setPixel(int lin, int col, int valor) throws ArrayIndexOutOfBoundsException {
        if (this.width <= 0 || this.height <= 0) {
            return false;
        }

        if (this.matrizPixel == null) {
            this.matrizPixel = new int[this.width][this.height];
        }

        try {
            this.matrizPixel[lin][col] = valor;
        } catch (Exception e) {
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }

        return true;
    }

    /**
     * Carrega a imagem de um arquivo .PGM
     */
    public static Imagem carregaImagem(File caminho) {
        Imagem img = new Imagem();
        BufferedImage bufferedImg;

        try {
            FileInputStream fileInput = new FileInputStream(caminho);
            Scanner scan = new Scanner(fileInput);

            // Descarta a primeira linha
            scan.nextLine();

            img.setWidth(scan.nextInt()); // Largura da imagem
            img.setHeight(scan.nextInt()); // Altura da imagem
            scan.nextInt(); // valor maximo. Infor desconsiderada
            bufferedImg = new BufferedImage(img.getWidth(), img.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int row = 0; row < img.getWidth(); row++) {
                for (int col = 0; col < img.getHeight(); col++) {
                    // Popula a matriz com os pixels da imagem
                    int valuePixel = scan.nextInt();
                    img.setPixel(col, row, valuePixel);
                    bufferedImg.setRGB(row, col, new Color(valuePixel, valuePixel, valuePixel).getRGB());
                }
            }
            img.setBufferedImage(bufferedImg);

            fileInput.close();
            scan.close();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Caminho especificado não encontrado.", "Falha!", JOptionPane.WARNING_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao abrir a imagem.", "Falha!", JOptionPane.WARNING_MESSAGE);
        }
        return img;
    }

    public int[][] getMatrizPixel() {
        return matrizPixel;
    }

    public void setMatrizPixel(int[][] matrizPixel) {
        this.matrizPixel = matrizPixel;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public void setBufferedImage(BufferedImage bufferedImage) {
        this.bufferedImage = bufferedImage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    public void setPonto2D(double x, double y) {
        this.ponto = new Ponto(x, y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Arrays.deepHashCode(this.matrizPixel);
        hash = 59 * hash + this.width;
        hash = 59 * hash + this.height;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Imagem)) {
            return false;
        }

        final Imagem other = (Imagem) obj;

        if (this.width != other.width || this.height != other.height) {
            return false;
        }

        return Arrays.deepEquals(this.matrizPixel, other.matrizPixel);
    }

    @Override
    public String toString() {
        return "Imagem{" + "matrizPixel=" + Arrays.toString(matrizPixel) + ", width=" + width + ", height=" + height + '}';
    }
}