package mx.edu.utez.cotizador.controller.dto;

public class ResponseCotizadorDTO {

    private String codigoPostal;
    private Double pesoKg;
    private Double volumenCm3;
    private String tipoEnvio;
    private Double costoBase;
    private Double costoPeso;
    private Double recargoVolumen;
    private Double recargoTipoEnvio;
    private Double seguro;
    private Double costoTotal;

    // Getters y Setters
    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }

    public Double getVolumenCm3() { return volumenCm3; }
    public void setVolumenCm3(Double volumenCm3) { this.volumenCm3 = volumenCm3; }

    public String getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(String tipoEnvio) { this.tipoEnvio = tipoEnvio; }

    public Double getCostoBase() { return costoBase; }
    public void setCostoBase(Double costoBase) { this.costoBase = costoBase; }

    public Double getCostoPeso() { return costoPeso; }
    public void setCostoPeso(Double costoPeso) { this.costoPeso = costoPeso; }

    public Double getRecargoVolumen() { return recargoVolumen; }
    public void setRecargoVolumen(Double recargoVolumen) { this.recargoVolumen = recargoVolumen; }

    public Double getRecargoTipoEnvio() { return recargoTipoEnvio; }
    public void setRecargoTipoEnvio(Double recargoTipoEnvio) { this.recargoTipoEnvio = recargoTipoEnvio; }

    public Double getSeguro() { return seguro; }
    public void setSeguro(Double seguro) { this.seguro = seguro; }

    public Double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(Double costoTotal) { this.costoTotal = costoTotal; }
}