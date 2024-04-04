package Gestor.empresarial.empresa;
import Gestor.empresarial.empleados.Empleados;

public final class Empresa {
    private String nombreEmpresa;
    private String representanteLegal;
    private String telefono;
    private String rfc;
    public Empleados datosRH;
    public Error GestionErrores;



    public Empresa(String nombreEmpresa,String representanteLegal){

    }
    public void setRepresentanteLegal(String representanteLegal){
        this.representanteLegal=representanteLegal;
    }
    public String getRepresentanteLegal(){
        return this.representanteLegal;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public String getInfo(){
        return this.getInfo();
    }

}
