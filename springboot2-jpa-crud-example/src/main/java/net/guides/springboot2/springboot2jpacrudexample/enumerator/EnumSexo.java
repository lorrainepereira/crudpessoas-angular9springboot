package net.guides.springboot2.springboot2jpacrudexample.enumerator;


public enum EnumSexo{
    F("F","Feminino"),
    M("M","Masculino");

    private String sigla;
    private String descricao;

    EnumSexo(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EnumSexo getPorSigla(String sigla){
        for (EnumSexo enumSexo: EnumSexo.values()) {
            if(enumSexo.getSigla().equalsIgnoreCase(sigla))
                return enumSexo;
        }
        return null;
    }
}
