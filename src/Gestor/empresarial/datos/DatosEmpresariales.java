package Gestor.empresarial.datos;

public class DatosEmpresariales {
    private String adscripcion;
    private String telefonoExterior;
    private String puesto;
    private int id2;

    public DatosEmpresariales(int id2, String adscripcion, String telefonoExterior, String puesto) {
        this.id2 = id2;
        this.adscripcion = adscripcion;
        this.telefonoExterior = telefonoExterior;
        this.puesto = puesto;
    }

    // Métodos para acceder y modificar los campos privados
    public void setAdscripcion(String adscripcion) {
        this.adscripcion = adscripcion;
    }

    public String getAdscripcion() {
        return adscripcion;
    }

    public void setTelefonoExterior(String telefonoExterior) {
        this.telefonoExterior = telefonoExterior;
    }

    public String getTelefonoExterior() {
        return telefonoExterior;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public int getId2() {
        return id2;
    }
}
