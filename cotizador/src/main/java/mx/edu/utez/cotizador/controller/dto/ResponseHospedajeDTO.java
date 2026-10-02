package mx.edu.utez.cotizador.controller.dto;

public class ResponseHospedajeDTO {

    private String nombreHuesped;
    private String tipoHabitacion;
    private Integer numeroNoches;
    private Integer numeroHuespedes;
    private String temporada;
    private Double costoNoche;
    private Double costoHospedajeBase;
    private Double ajusteTemporada;
    private Double descuentoLargaEstancia;
    private Double costoDesayuno;
    private Double costoEstacionamiento;
    private Double subtotal;
    private Double impuesto;
    private Double total;

    public String getNombreHuesped() { return nombreHuesped; }
    public void setNombreHuesped(String nombreHuesped) { this.nombreHuesped = nombreHuesped; }

    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }

    public Integer getNumeroNoches() { return numeroNoches; }
    public void setNumeroNoches(Integer numeroNoches) { this.numeroNoches = numeroNoches; }

    public Integer getNumeroHuespedes() { return numeroHuespedes; }
    public void setNumeroHuespedes(Integer numeroHuespedes) { this.numeroHuespedes = numeroHuespedes; }

    public String getTemporada() { return temporada; }
    public void setTemporada(String temporada) { this.temporada = temporada; }

    public Double getCostoNoche() { return costoNoche; }
    public void setCostoNoche(Double costoNoche) { this.costoNoche = costoNoche; }

    public Double getCostoHospedajeBase() { return costoHospedajeBase; }
    public void setCostoHospedajeBase(Double costoHospedajeBase) { this.costoHospedajeBase = costoHospedajeBase; }

    public Double getAjusteTemporada() { return ajusteTemporada; }
    public void setAjusteTemporada(Double ajusteTemporada) { this.ajusteTemporada = ajusteTemporada; }

    public Double getDescuentoLargaEstancia() { return descuentoLargaEstancia; }
    public void setDescuentoLargaEstancia(Double descuentoLargaEstancia) { this.descuentoLargaEstancia = descuentoLargaEstancia; }

    public Double getCostoDesayuno() { return costoDesayuno; }
    public void setCostoDesayuno(Double costoDesayuno) { this.costoDesayuno = costoDesayuno; }

    public Double getCostoEstacionamiento() { return costoEstacionamiento; }
    public void setCostoEstacionamiento(Double costoEstacionamiento) { this.costoEstacionamiento = costoEstacionamiento; }

    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Double getImpuesto() { return impuesto; }
    public void setImpuesto(Double impuesto) { this.impuesto = impuesto; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
}