package Gestor.empresarial.contrato;

public final class contrato {
    private int id;
    private int noContrato;
    private int annio;
    private String horario;
    private Cargos tipoCargo;


    public contrato(int id) {

    }

    public void setNoContrato(int noContrato) {
        this.noContrato = noContrato;
    }

    public int getNoContrato() {
        return this.noContrato;
    }

    public void setAnnio(int annio) {
        this.annio = annio;
    }
    public int getAnnio(){
        return this.annio;
    }
}

