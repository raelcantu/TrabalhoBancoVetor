package com.rafa.bancovetor.models;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Banco {

    Vector<ContaBancaria> listaContas = new Vector<>();
    double total = 0;
    ContaBancaria contaEncontrada = null;

    public void CadastrarConta() {
        boolean continuar = false;
        String numConta = "";

        while (continuar == false) {
            numConta = JOptionPane.showInputDialog("Número da conta:");

            int encontrado = 0;

            for(ContaBancaria c : listaContas){
                if(numConta.equals(c.getNumConta())){
                    JOptionPane.showMessageDialog(null, "Ja existe uma conta com esse número, escolha outro");
                    encontrado = 1;
                }
            }
            if(encontrado == 0){
                continuar = true;
            }
        }
        String primeiroNome = JOptionPane.showInputDialog("Primeiro nome do titular:");
        String sobrenome = JOptionPane.showInputDialog("Sobrenome do titular:");
        long saldo = Long.parseLong(JOptionPane.showInputDialog("Saldo:"));

        listaContas.add(new ContaBancaria(numConta, primeiroNome, sobrenome, saldo));
    }

    public void AutoCadastro() {
        listaContas.add(new ContaBancaria("13", "Rafael", "Cantu", 350));
        listaContas.add(new ContaBancaria("25", "Heloisa", "Rosseto", 1250));
        listaContas.add(new ContaBancaria("1", "Joao", "Signor de Andrade", 3000));
        listaContas.add(new ContaBancaria("4", "Nicolau", "Kekeyl", 1983));
        listaContas.add(new ContaBancaria("32", "Joana", "Maria", 934));
    }

    public void ListarContas() {
        for (ContaBancaria listaConta : listaContas) {
            System.out.println(listaConta);
        }
    }

    public void Sacar() {
        //Eu tentei por tudo implementar a pesquisa binária aqui mas não consegui então vou usar o mesmo do deposito
        ListarContas();
        String buscaNumero = JOptionPane.showInputDialog(null, "Qual o número da conta?");
        for (ContaBancaria c : listaContas) {
            if (buscaNumero.equals(c.getNumConta())) {
                contaEncontrada = c;
            }
        }
        JOptionPane.showMessageDialog(null, "Conta encotrada: " + contaEncontrada);

        long deposito = Long.parseLong(JOptionPane.showInputDialog(null, "Quanto deseja sacar?"));

        long novoSacado = contaEncontrada.getDepositado() + deposito;
        contaEncontrada.setSacado(novoSacado);

        JOptionPane.showMessageDialog(null, "Sacado da conta: " + novoSacado + "R$");

    }

    public void Depositar() {


        String nomeNumero = JOptionPane.showInputDialog(null, "Deseja buscar uma conta por nome ou número?\n" +
                "1-Nome\n" +
                "2-Número");

        if(nomeNumero.equals("1")){

            ListarContas();
            String buscaNome = JOptionPane.showInputDialog(null, "Qual o nome do titular da conta?");
            for (ContaBancaria c : listaContas){
                if(buscaNome.equalsIgnoreCase(c.getPrimeiroNome())){
                    contaEncontrada = c;
                }
            }

            JOptionPane.showMessageDialog(null, "Conta encotrada: " + contaEncontrada);

            long deposito = Long.parseLong(JOptionPane.showInputDialog(null, "Quanto deseja depositar?"));

            long novoDepositado = contaEncontrada.getDepositado()+ deposito;
            contaEncontrada.setDepositado(novoDepositado);

            JOptionPane.showMessageDialog(null, "Depósito na conta: " + novoDepositado + "R$");

        } else {

            ListarContas();
            String buscaNumero = JOptionPane.showInputDialog(null, "Qual o número da conta?");
            for (ContaBancaria c : listaContas){
                if(buscaNumero.equals(c.getNumConta())){
                    contaEncontrada = c;
                }
            }

            JOptionPane.showMessageDialog(null, "Conta encotrada: " + contaEncontrada);

            long deposito = Long.parseLong(JOptionPane.showInputDialog(null, "Quanto deseja depositar?"));

            long novoDepositado = contaEncontrada.getDepositado() + deposito;
            contaEncontrada.setDepositado(novoDepositado);

            JOptionPane.showMessageDialog(null, "Depositado na conta: " + novoDepositado + "R$");

        }

    }

    public void OrdenarContasPorNum() {

        Vector<ContaBancaria> vetorAux;
        vetorAux = listaContas;

        int j;

        ContaBancaria chave;

        for (int i = 1;i< listaContas.size();i++){
            chave = listaContas.get(i);

            for(j = i-1; (j>=0 && (Integer.parseInt(listaContas.get(j).getNumConta())> Integer.parseInt(chave.getNumConta())));j--){

                vetorAux.set(j+1, listaContas.get(j));

            }

            vetorAux.set(j+1, chave);


        }

        System.out.println("\n\nCONTAS ORDENADAS POR NÚMERO\n" +
                "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n\n");
        for(int i = 0; i < vetorAux.size(); i++){
            System.out.println("\n==============" +
                    "\nNúmero da Conta = " + vetorAux.get(i).getNumConta()
                    + "\nTitular = " + vetorAux.get(i).getPrimeiroNome() +
                    " " + vetorAux.get(i).getSobrenome() +
                    "\nSaldo = " + vetorAux.get(i).getSaldo() + "R$" +
                    "\nDepositado = " + vetorAux.get(i).getDepositado() +
                    "\nSacado = " + vetorAux.get(i).getSacado() +
                    "\n==============");
        }

        JOptionPane.showMessageDialog(null, "Contas ordenadas! Cheque o console.");

    }

    public void OrdenarContasPorSaldo() {

        Vector<ContaBancaria> vetorAux;
        vetorAux = listaContas;

        int j;

        ContaBancaria chave;

        for (int i = 1;i< listaContas.size();i++){
            chave = listaContas.get(i);

            for(j = i-1; (j>=0 && (Long.valueOf(listaContas.get(j).getSaldo())> Long.valueOf(chave.getSaldo())));j--){

                vetorAux.set(j+1, listaContas.get(j));

            }

            vetorAux.set(j+1, chave);


        }

        System.out.println("\n\nCONTAS ORDENADAS POR SALDO\n" +
                "vvvvvvvvvvvvvvvvvvvvvvvvvvvvvv\n\n");
        for(int i = 0; i < vetorAux.size(); i++){
            System.out.println("\n==============" +
                    "\nNúmero da Conta = " + vetorAux.get(i).getNumConta() + "\nTitular = " + vetorAux.get(i).getPrimeiroNome() +
                    " " + vetorAux.get(i).getSobrenome() +
                    "\nSaldo = " + vetorAux.get(i).getSaldo() + "R$" +
                    "\nDepositado = " + vetorAux.get(i).getDepositado() +
                    "\nSacado = " + vetorAux.get(i).getSacado() +
                    "\n==============");
        }

        JOptionPane.showMessageDialog(null, "Contas ordenadas! Cheque o console.");

    }

    public void CalcularSaldoTotalBanco() {
        for (ContaBancaria conta : listaContas) {
            total += conta.getSaldo() + conta.getDepositado() - conta.getSacado();
        }

        JOptionPane.showMessageDialog(null, "Saldo total no banco: " + total + "R$");
        total = 0;
    }

    public void VerificarSaldoNegativo() {
        long saldoTotal = 0;
        long saqueTotal = 0;
        long depositoTotal = 0;
        Vector<ContaBancaria> contasNegativas = new Vector();


        for(ContaBancaria c : listaContas){
            saldoTotal += c.getSaldo();
            saqueTotal += c.getSacado();
            depositoTotal += c.getDepositado();

            if(saqueTotal>(saldoTotal + depositoTotal)){
                contasNegativas.add(c);
            }
            saldoTotal = 0;
            saqueTotal = 0;
            depositoTotal = 0;
        }

        for(ContaBancaria c : contasNegativas){
            JOptionPane.showMessageDialog(null, "Contas impressas no console. (Caso haja contas com saldo negativo)");
            System.out.println("\nConta com saldo negativo: " + c.toString() + "\n");
        }

    }

}
