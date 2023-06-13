package com.rafa.bancovetor;

import com.rafa.bancovetor.models.Banco;

import javax.swing.*;

public class BancoVetor {

    public static void main(String[] args) {
        
        Banco b = new Banco();
        boolean parar = false;
        b.AutoCadastro();

        while (!parar) {
            int escolha = Integer.parseInt(JOptionPane.showInputDialog(null, "Selecione uma ação:\n" +
                    "1- Cadastrar conta\n" +
                    "2- Ordenar contas por número\n" +
                    "3- Ordenar contas por saldo\n" +
                    "4- Depositar\n" +
                    "5- Sacar\n" +
                    "6- Saldo total do banco\n" +
                    "7- Verificar saldo negativo\n" +
                    "8- Parar programa"));


            switch (escolha) {
                case 1 -> b.CadastrarConta();
                case 2 -> b.OrdenarContasPorNum();
                case 3 -> b.OrdenarContasPorSaldo();
                case 4 -> b.Depositar();
                case 5 -> b.Sacar();
                case 6 -> b.CalcularSaldoTotalBanco();
                case 7 -> b.VerificarSaldoNegativo();
                case 8 -> parar = true;
            }
        }
    }
}
