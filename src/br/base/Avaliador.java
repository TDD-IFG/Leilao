package br.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tatuapu
 */
public class Avaliador {
    private double maiorLance = 0.0;
    private List<Lance> maiores;
    
    public void avalia(Leilao l){
        List<Lance> lances = l.getLances();        
        
        for(Lance lance: lances){
        	if(lance.getValor() > this.maiorLance)
        		this.maiorLance = lance.getValor();
        }
    }
    
    public double getMaior(){
        return maiorLance;
    }
    
}
