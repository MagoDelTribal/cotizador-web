package mx.edu.utez.cotizador.controller.dto;

import jakarta.validation.constraints.*;

public class RequestRentaDTO {

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombreCliente;

    @NotNull(message = "La edad del conductor es obligatoria")
    @Min(value = 18, message = "No se aceptan rentas a menores de 18 años")
    private Integer edadConductor;

    @NotBlank(message = "El tipo de vehículo es obligatorio")
    @Pattern(regexp = "^(COMPACTO|SEDAN|SUV|CAMIONETA)$", message = "Los tipos permitidos son: COMPACTO, SEDAN, SUV, CAMIONETA")
    private String tipoVehiculo;

    @NotNull(message = "El número de días de renta es obligatorio")
    @Positive(message = "Los días de renta deben ser mayores a 0")
    @Max(value = 30, message = "La renta no puede superar los 30 días")
    private Integer diasRenta;

    @NotNull(message = "Los kilómetros estimados son obligatorios")
    @PositiveOrZero(message = "Los kilómetros estimados no pueden ser negativos")
    @Max(value = 5000, message = "Los kilómetros estimados no pueden superar los 5,000 km")
    private Integer kilometrosEstimados;

    @NotNull(message = "Debe indicar si contrata seguro completo")
    private Boolean seguroCompleto;

    // Getters y Setters
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public Integer getEdadConductor() { return edadConductor; }
    public void setEdadConductor(Integer edadConductor) { this.edadConductor = edadConductor; }

    public String getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(String tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }

    public Integer getDiasRenta() { return diasRenta; }
    public void setDiasRenta(Integer diasRenta) { this.diasRenta = diasRenta; }

    public Integer getKilometrosEstimados() { return kilometrosEstimados; }
    public void setKilometrosEstimados(Integer kilometrosEstimados) { this.kilometrosEstimados = kilometrosEstimados; }

    public Boolean getSeguroCompleto() { return seguroCompleto; }
    public void setSeguroCompleto(Boolean seguroCompleto) { this.seguroCompleto = seguroCompleto; }
}