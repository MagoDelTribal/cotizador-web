package mx.edu.utez.cotizador.controller.dto;

public class ResponseRentaDTO {

    private String nombreCliente;
    private String tipoVehiculo;
    private Integer diasRenta;
    private Integer kilometrosEstimados;
    private Integer kilometrosIncluidos;
    private Integer kilometrosAdicionales;
    private Double costoDiario;
    private Double costoRentaBase;
    private Double descuentoRenta;
    private Double costoKilometrosAdicionales;
    private Double cargoPorEdad;
    private Double costoSeguro;
    private Double costoTotal;

    // Getters y Setters
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public Integer getDiasRenta() { return diasRenta; }
    public void setDiasRenta(Integer diasRenta) { this.diasRenta = diasRenta; }

    public Integer getKilometrosEstimados() { return kilometrosEstimados; }
    public void setKilometrosEstimados(Integer kilometrosEstimados) { this.kilometrosEstimados = kilometrosEstimados; }

    public Integer getKilometrosIncluidos() { return kilometrosIncluidos; }
    public void setKilometrosIncluidos(Integer kilometrosIncluidos) { this.kilometrosIncluidos = kilometrosIncluidos; }

    public Integer getKilometrosAdicionales() { return kilometrosAdicionales; }
    public void setKilometrosAdicionales(Integer kilometrosAdicionales) { this.kilometrosAdicionales = kilometrosAdicionales; }

    public Double getCostoDiario() { return costoDiario; }
    public void setCostoDiario(Double costoDiario) { this.costoDiario = costoDiario; }

    public Double getCostoRentaBase() { return costoRentaBase; }
    public void setCostoRentaBase(Double costoRentaBase) { this.costoRentaBase = costoRentaBase; }

    public Double getDescuentoRenta() { return descuentoRenta; }
    public void setDescuentoRenta(Double descuentoRenta) { this.descuentoRenta = descuentoRenta; }

    public Double getCostoKilometrosAdicionales() { return costoKilometrosAdicionales; }
    public void setCostoKilometrosAdicionales(Double costoKilometrosAdicionales) { this.costoKilometrosAdicionales = costoKilometrosAdicionales; }

    public Double getCargoPorEdad() { return cargoPorEdad; }
    public void setCargoPorEdad(Double cargoPorEdad) { this.cargoPorEdad = cargoPorEdad; }

    public Double getCostoSeguro() { return costoSeguro; }
    public void setCostoSeguro(Double costoSeguro) { this.costoSeguro = costoSeguro; }

    public Double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }
}