package Gestor.errores;

import java.util.Map;
public final class GestionErrores {
    private final Map<Integer, String> error; private boolean existeError; private int noError; private String descripcionTecnica;
    public GestionErrores() { this.error = null; this.existeError = false; this.noError = 0; this.descripcionTecnica = null;
    }
    public void cargarErrores() {
    }
    public void setNoError(int noError, String descripcion) { this.noError = noError; this.descripcionTecnica = descripcion;
    }
    public String getError() { if (existeError) {
        return "Error " + noError + ": " + descripcionTecnica;
    } return null; }
    public String getErrorTecnico() { return descripcionTecnica;
    }
    public boolean existeError() { return existeError;
    }
}

