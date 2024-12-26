import com.google.gson.annotations.SerializedName;

public class Conversion {

    @SerializedName("moneda_base")
    private String monedaBase;

    @SerializedName("moneda_objetivo")
    private String monedaObjetivo;

    @SerializedName("cantidad_base")
    private double cantidadBase;

    @SerializedName("tasa_conversion")
    private double tasaConversion;

    @SerializedName("cantidad_convertida")
    private double cantidadConvertida;

    public Conversion(String monedaBase, String monedaObjetivo, double cantidadBase, double tasaConversion, double cantidadConvertida) {
        this.monedaBase = monedaBase;
        this.monedaObjetivo = monedaObjetivo;
        this.cantidadBase = cantidadBase;
        this.tasaConversion = tasaConversion;
        this.cantidadConvertida = cantidadConvertida;
    }

    // Getters y setters (si los necesitas)
    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void setMonedaObjetivo(String monedaObjetivo) {
        this.monedaObjetivo = monedaObjetivo;
    }

    public double getCantidadBase() {
        return cantidadBase;
    }

    public void setCantidadBase(double cantidadBase) {
        this.cantidadBase = cantidadBase;
    }

    public double getTasaConversion() {
        return tasaConversion;
    }

    public void setTasaConversion(double tasaConversion) {
        this.tasaConversion = tasaConversion;
    }

    public double getCantidadConvertida() {
        return cantidadConvertida;
    }

    public void setCantidadConvertida(double cantidadConvertida) {
        this.cantidadConvertida = cantidadConvertida;
    }
 }

