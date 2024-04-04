package Gestor.empresarial.datos;

public abstract class DatosEmpresariales {
    private String adscripcion;
    private String telefonoExterior;
    private String puesto;

    DatosPersonales id1 = new DatosPersonales();
    int id2 = id1.getId();

    public  DatosEmpresariales(int id2,String adscripcion,String telefonoExterior,String puesto){
    }

    void setAdscripcion(String adscripcion){
        this.adscripcion=adscripcion;
    }
    String getAdscripcion(){
        return this.adscripcion;
    }
    void setTelefonoExterior(String telefonoExterior){
        this.telefonoExterior=telefonoExterior;
    }
    String getTelefonoExterior(){
        return this.telefonoExterior;
    }
    void setPuesto(String puesto){
        this.puesto=puesto;
    }
    String getPuesto(){
        return this.puesto;
    }


}
