/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.SoftwarePR.AgendaDeVeiculos.Principal;

import br.com.SoftwarePR.AgendaDeVeiculos.Banco.ConexaoCRUD;
import br.com.SoftwarePR.AgendaDeVeiculos.Telas.TelaMenu;

/**
 *
 * @author Paulo Ricardo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TelaMenu menu = new TelaMenu();
       menu.setVisible(true);
    }
    
}
