package Gestor.empresarial.empresa;
import Gestor.empresarial.empleados.Empleados;
import Gestor.empresarial.contrato.Cargos;

public final class Empresa {
    private Cargos cargoEmpleado;
    private String nombreEmpresa;
    private String representanteLegal;
    private String telefono;

    public Empresa(String nombreEmpresa, String representanteLegal, String telefono) {
        this.nombreEmpresa = nombreEmpresa;
        this.representanteLegal = representanteLegal;
        this.telefono = telefono;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getRepresentanteLegal() {
        return this.representanteLegal;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getInfo() {
        return "Nombre de la empresa: " + nombreEmpresa + "\nRepresentante legal: " + representanteLegal
                + "\nTeléfono: " + telefono;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
}
