package net.guides.springboot2.springboot2jpacrudexample.util;

public class Util {

    public static String removeMascaraCPF(String cpf){
        String cpfSemMascara = cpf.replace(".", "");
        cpfSemMascara = cpfSemMascara.replace("-", "");
        return cpfSemMascara;
    }
}
