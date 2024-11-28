/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseminimaxjogodavelha;

import java.util.ArrayList;

/**
 *
 * @author MarcoAntônio
 */
public class Minimax {
    private int alfa = Integer.MIN_VALUE;
    private int beta = Integer.MAX_VALUE;

    public Tabuleiro minimaxDecision(Tabuleiro tabuleiro) {
        int melhor = MaxValue(tabuleiro);
        ArrayList<Tabuleiro> filhos = tabuleiro.getTodosFilhos();
        for (Tabuleiro filho : filhos) {
            filho.mostra();
            System.out.println("");
            if (filho.getValor() == melhor) {
                return filho;
            }
        }
        return null;
    }

    private int MinValue(Tabuleiro tabuleiro) {
        if (tabuleiro.isTerminal()) {
            tabuleiro.setValor(tabuleiro.getResultado());
            return tabuleiro.getValor();
        } else {
            tabuleiro.setValor(Integer.MAX_VALUE);
            tabuleiro.setJogador(Jogador.Min);
            ArrayList<Tabuleiro> filhos = tabuleiro.getFilhos(tabuleiro);
            for (Tabuleiro filho : filhos) {
                int minValue = Math.min(tabuleiro.getValor(), MaxValue(filho));
                //Corte alfa beta
                if (minValue < alfa) {
                    tabuleiro.setValor(minValue);
                    return tabuleiro.getValor();
                }
                tabuleiro.setValor(minValue);
            }
            if (tabuleiro.getValor() < beta) {
                beta = tabuleiro.getValor();
            }
            return tabuleiro.getValor();
        }
    }

    private int MaxValue(Tabuleiro tabuleiro) {
        if (tabuleiro.isTerminal()) {
            tabuleiro.setValor(tabuleiro.getResultado());
            return tabuleiro.getValor();
        } else {
            tabuleiro.setValor(Integer.MIN_VALUE);
            tabuleiro.setJogador(Jogador.Max);
            ArrayList<Tabuleiro> filhos = tabuleiro.getFilhos(tabuleiro);
            for (Tabuleiro filho : filhos) {
                int maxValue = Math.max(tabuleiro.getValor(), MinValue(filho));
                //Corte alfa beta
                if (maxValue > beta) {
                    tabuleiro.setValor(maxValue);
                    return tabuleiro.getValor(); 
                }
                tabuleiro.setValor(maxValue);
            }
            if (tabuleiro.getValor() > alfa) {
                alfa = tabuleiro.getValor();
            }
            return tabuleiro.getValor();
        }
    }
}
