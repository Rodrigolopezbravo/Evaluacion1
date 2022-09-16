package evaluacion1.DTO;

import java.util.Date;

public class ClubesDeportivos {

    private String Codigo;
    private String NombreClub;
    private String NombreFundador;
    private Date AnoFundacion;
    private String PaisOrigen;
    private String Lema;
    private int ValorSuscripcion;
    private String[] Colores;

    public ClubesDeportivos() {
        this.Codigo = "";
        this.NombreClub = "";
        this.NombreFundador = "";
        this.AnoFundacion = new Date();
        this.PaisOrigen = "";
        this.Lema = "";
        this.ValorSuscripcion = 0;
        this.Colores = new String[]{""};
    }

    public ClubesDeportivos(String Codigo, String nombreClub, String NombreFundador, Date AnoFundacion, String paisOrigen, String Lema, int ValorSuscripcion, String[] Colores) {
        this.Codigo = Codigo;
        this.NombreClub = nombreClub;
        this.NombreFundador = NombreFundador;
        this.AnoFundacion = AnoFundacion;
        this.PaisOrigen = paisOrigen;
        this.Lema = Lema;
        this.ValorSuscripcion = ValorSuscripcion;
        this.Colores = Colores;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        String parte1 = Codigo.substring(0, 2);
        if (parte1.length() == 2) {
            String parte2 = Codigo.substring(2, 3);
            if (parte2.toUpperCase().equals("H")) {
                int parte3 = Integer.parseInt(Codigo.substring(3, Codigo.length()));
                if (parte3 >= 10) {
                    this.Codigo = Codigo;
                    System.out.println(this.Codigo);
                } else {
                    System.out.println("Valor del correlativo debe ser mayor o igual a 10");
                }
            } else {
                System.out.println("Valor distinto a H");
            }

        }

    }

    public String getNombreClub() {
        return NombreClub;
    }

    public void setNombreClub(String NombreClub) {
        this.NombreClub = NombreClub;
    }

    public String getNombreFundador() {
        return NombreFundador;
    }

    public void setNombreFundador(String NombreFundador) {
        this.NombreFundador = NombreFundador;
    }

    public Date getAnoFundacion() {
        return AnoFundacion;
    }

    public void setAnoFundacion(Date AnooFundacion) {
        this.AnoFundacion = AnooFundacion;
    }

    public String getPaisOrigen() {
        return PaisOrigen;
    }

    public void setPaisOrigen(String PaisOrigen) {
        this.PaisOrigen = PaisOrigen;
    }

    public String getLema() {
        return Lema;
    }

    public void setLema(String Lema) {
        this.Lema = Lema;
    }

    public int getValorSuscripcion() {
        return ValorSuscripcion;
    }

    public void setValorSuscripcion(int ValorSuscripcion) {
        if (ValorSuscripcion > 0) {
            this.ValorSuscripcion = ValorSuscripcion;
        }
    }

    public String[] getColores() {
        return Colores;
    }

    public void setColores(String[] Colores) {
        this.Colores = Colores;
    }

    @Override
    public String toString() {
        return this.Codigo + " $" + this.ValorSuscripcion;
    }

    public void concatColor() {
        String color = "";

        for (int i = 0; i < this.getColores().length; i++) {

            color = color + this.getColores()[i];
            if (i < this.getColores().length -1) {
                color += ", ";
            }

        }

        System.out.println(color);
    }
        public String cambiarClub(String pNombreClub, String pCodigo) {
        if (this.NombreClub != pNombreClub) {
            this.setNombreClub(pNombreClub);
            this.setCodigo(pCodigo);
            return "Nombre club cambiado: " + this.getNombreClub()+ this.getCodigo();
        } else {
            return "Datos erroneos";
        }
    }
}
