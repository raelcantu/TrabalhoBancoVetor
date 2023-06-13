
package com.rafa.bancovetor.models;


public class ContaBancaria {
    
    private String numConta;
    private String sobrenome;
    private String primeiroNome;
    private long saldo;
    private long depositado = 0;
    private long sacado = 0;

    public ContaBancaria() {
    }

    public ContaBancaria(String numConta, String primeiroNome, String sobrenome, long saldo) {
        this.numConta = numConta;
        this.sobrenome = sobrenome;
        this.primeiroNome = primeiroNome;
        this.saldo = saldo;
    }

    public long getDepositado() {
        return depositado;
    }

    public void setDepositado(long depositado) {
        this.depositado = depositado;
    }

    public long getSacado() {
        return sacado;
    }

    public void setSacado(long sacado) {
        this.sacado = sacado;
    }
    
    

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\n==============" +
                "\nNúmero da Conta = " + numConta +
                "\nTitular = " + primeiroNome +
                " " + sobrenome +
                "\nSaldo = " + saldo + "R$" +
                "\nDepositado = " + depositado + "R$" +
                "\nSacado = " + sacado + "R$" +
                "\n==============";
    }
}
