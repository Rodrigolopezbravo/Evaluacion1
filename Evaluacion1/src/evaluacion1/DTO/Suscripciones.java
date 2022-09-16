package evaluacion1.DTO;

import java.util.Date;

public class Suscripciones {

    private int Numero;
    private Usuario Usuario;
    private Date FechaInicio;
    private int AbonoTotal;
    private String Equipos;

    public Suscripciones() {
        this.Numero = 0;
        this.Usuario = new Usuario();
        this.FechaInicio = new Date();
        this.AbonoTotal = 0;
        this.Equipos = "";
    }

    public Suscripciones(int Numero, Usuario Usuario, Date FechaInicio, int AbonoTotal, String Equipos) {
        this.Numero = Numero;
        this.Usuario = Usuario;
        this.FechaInicio = FechaInicio;
        this.AbonoTotal = AbonoTotal;
        this.Equipos = Equipos;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        if (Numero > 0) {
            this.Numero = Numero;
        }
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public int getAbonoTotal() {
        return AbonoTotal;
    }

    public void setAbonoTotal(int AbonoTotal) {
        if (AbonoTotal > 0) {
            this.AbonoTotal = AbonoTotal;
        }
    }

    public String getEquipos() {
        return Equipos;
    }

    public void setEquipos(String Equipos) {
        this.Equipos = Equipos;
    }

    public void AgregarClubes(ClubesDeportivos p) {

        if (!this.Equipos.equals("")) {
            this.Equipos += "; ";
        }

        this.Equipos += p.toString();
        this.AbonoTotal += p.getValorSuscripcion();
    }

    @Override
    public String toString() {
        // Un método que permite ver el detalle del pedido del cliente
        StringBuilder sb = new StringBuilder();
        sb.append("============\n");
        sb.append("Suscripcion Numero: ");
        sb.append(this.Numero);
        sb.append("\n============\n");
        sb.append("Cliente: ");
        sb.append(this.Usuario.getNombreCompleto());
        sb.append("\n============");
        sb.append("\nTotal: $");
        sb.append(this.AbonoTotal);
        sb.append("\n============\n");
        sb.append(this.Equipos);
        sb.append("\n");
        return sb.toString();
    }
}
