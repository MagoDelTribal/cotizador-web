package mx.edu.utez.cotizador.controller.dto;

import jakarta.validation.constraints.*;

public class RequestHospedajeDTO {

    @NotBlank
    private String nombreHuesped;

    @NotBlank
    @Pattern(regexp = "^(INDIVIDUAL|DOBLE|SUITE)$")
    private String tipoHabitacion;

    @NotNull
    @Positive
    @Max(30)
    private Integer numeroNoches;

    @NotNull
    @Positive
    private Integer numeroHuespedes;

    @NotBlank
    @Pattern(regexp = "^(BAJA|REGULAR|ALTA)$")
    private String temporada;

    @NotNull
    private Boolean incluyeDesayuno;

    @NotNull
    private Boolean incluyeEstacionamiento;

    public String getNombreHuesped() { return nombreHuesped; }
    public void setNombreHuesped(String nombreHuesped) { this.nombreHuesped = nombreHuesped; }

    public String getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(String tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }

    public Integer getNumeroNoches() { return numeroNoches; }
    public void setNumeroNoches(Integer numeroNoches) { this.numeroNoches = numeroNoches; }

    public Integer getNumeroHuespedes() { return numeroHuespedes; }
    // CORRECCIÓN AQUÍ: asignamos a numeroHuespedes
    public void setNumeroHuespedes(Integer numeroHuespedes) { this.numeroHuespedes = numeroHuespedes; }

    public String getTemporada() { return temporada; }
    public void setTemporada(String temporada) { this.temporada = temporada; }

    public Boolean getIncluyeDesayuno() { return incluyeDesayuno; }
    public void setIncluyeDesayuno(Boolean incluyeDesayuno) { this.incluyeDesayuno = incluyeDesayuno; }

    public Boolean getIncluyeEstacionamiento() { return incluyeEstacionamiento; }
    public void setIncluyeEstacionamiento(Boolean incluyeEstacionamiento) { this.incluyeEstacionamiento = incluyeEstacionamiento; }
}