package evaluacion1.DTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Usuario {

    private int ID;
    private String NombreCompleto;
    private int Run;
    private String DV;
    private Date FechaNacimiento;
    private String Telefono;
    private String Email;
    private String NombreUsuario;
    private String Contraseña;

    public Usuario() {
        this.ID = 0;
        this.NombreCompleto = "";
        this.Run = 0;
        this.DV = "";
        this.FechaNacimiento = new Date();
        this.Telefono = "";
        this.Email = "";
        this.NombreUsuario = "";
        this.Contraseña = "";
    }

    public Usuario(int ID, String NombreCompleto, int Run, String DV, Date FechaNacimiento, String Telefono, String Email, String NombreUsuario, String Contraseña) {
        this.ID = ID;
        this.NombreCompleto = NombreCompleto;
        this.Run = Run;
        this.DV = DV;
        this.FechaNacimiento = FechaNacimiento;
        this.Telefono = Telefono;
        this.Email = Email;
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        if (ID > 0) {
            this.ID = ID;
        }
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public int getRun() {
        return Run;
    }

    public void setRun(int Run, char DV) {
        if (this.validarRut(Run, DV)) {
            this.Run = Run;
            this.DV = DV + "";
        }
        if (Run > 0) {
        }

    }

    public String getDV() {
        return DV;
    }

    public void setDV(String DV) {
        this.DV = DV;
    }

    public Date getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(Date FechaNacimiento) {
        long dif = new Date().getTime() - FechaNacimiento.getTime();
        TimeUnit tiempo = TimeUnit.DAYS;
        long dias = tiempo.convert(dif, TimeUnit.MILLISECONDS);
        System.out.println(dias / 365);
        if ((dias / 365) >= 18) {
            System.out.println("Es mayor de edad");
            String patron = "yyyy/MM/dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patron);
            String date = simpleDateFormat.format(FechaNacimiento);
            System.out.println(date);

            this.FechaNacimiento = FechaNacimiento;
        } else {
            System.out.println("No es mayor de edad");
        }

    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        if (Telefono.length() >= 8) {
            if (Telefono.substring(0, 2).equals("56")) {
                this.Telefono = Telefono;
            } else {
                System.out.println("No empieza con 56");
            }
        }
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        if (Email.contains("@")) {
            if (Email.contains(".com") || Email.contains(".cl")) {
                this.Email = Email;
            }
        }
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        if (NombreUsuario.length() >= 4) {
            this.NombreUsuario = NombreUsuario;
        }
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        if (Contraseña.length() >= 6) {
            boolean validarMayuscula = false;
            boolean validarNumero = false;
            for (int i = 0; i < Contraseña.length(); i++) {
                char letra = Contraseña.charAt(i);
                if (Character.isUpperCase(letra)) {
                    validarMayuscula = true;
                }
                if (Character.isDigit(letra)) {
                    validarNumero = true;
                }
            }
            if (validarMayuscula && validarNumero) {
                this.Contraseña = Contraseña;
            } else {
                System.out.println("No se cumplen los requisitos");
            }

        }
    }

    public boolean validarRut(int rut, char dv) {
        boolean validacion = false;
        try {
            int m = 0, s = 1;
            for (; rut != 0; rut /= 10) {
                s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }

        } catch (java.lang.NumberFormatException e) {
        } catch (Exception e) {
        }
        return validacion;
    }

    public String validarUsuario(String pUsuario, String pContraseña) {
        if (this.NombreUsuario == pUsuario && this.Contraseña == pContraseña) {
            return "Usuario Valido";
        } else {
            return "Usuario y/o Contraseña incorrectos";
        }
    }

    public String resetContraseña(String pUsuario) {
        if (this.NombreUsuario == pUsuario) {
            this.setContraseña("Default1");
            return "Contraseña restablecida a: " + this.getContraseña();
        } else {
            return "Datos erroneos" + pUsuario;
        }
    }

}
