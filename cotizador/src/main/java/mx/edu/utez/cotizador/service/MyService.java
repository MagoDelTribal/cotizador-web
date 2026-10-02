package mx.edu.utez.cotizador.service;

import mx.edu.utez.cotizador.controller.dto.*;
import mx.edu.utez.cotizador.exception.customExceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public ResponseCotizadorDTO cotizarEnvio(RequestCotizadorDTO payload) {
        double volumen = payload.getLargoCm() * payload.getAnchoCm() * payload.getAltoCm();

        if (volumen > 1_000_000) {
            throw new BadRequestException("El volumen del paquete (" + volumen + " cm³) excede el límite permitido.");
        }

        double costoBase = 80.0;
        double acumulado = costoBase;

        double costoPeso = payload.getPesoKg() * 12.0;
        acumulado += costoPeso;

        double recargoVolumen = 0.0;
        if (volumen > 50_000) {
            recargoVolumen = 100.0;
            acumulado += recargoVolumen;
        }

        double recargoTipoEnvio = 0.0;
        String tipo = payload.getTipoEnvio().toUpperCase();

        if (tipo.equals("EXPRESS")) {
            recargoTipoEnvio = acumulado * 0.40;
            acumulado += recargoTipoEnvio;
        } else if (tipo.equals("MISMO_DIA")) {
            recargoTipoEnvio = acumulado * 0.70;
            acumulado += recargoTipoEnvio;
        }

        double seguro = 0.0;
        if (payload.getValorDeclarado() > 10_000) {
            seguro = payload.getValorDeclarado() * 0.02;
            acumulado += seguro;
        }

        ResponseCotizadorDTO response = new ResponseCotizadorDTO();
        response.setCodigoPostal(payload.getCodigoPostal());
        response.setPesoKg(payload.getPesoKg());
        response.setVolumenCm3(volumen);
        response.setTipoEnvio(tipo);
        response.setCostoBase(costoBase);
        response.setCostoPeso(costoPeso);
        response.setRecargoVolumen(recargoVolumen);
        response.setRecargoTipoEnvio(recargoTipoEnvio);
        response.setSeguro(seguro);
        response.setCostoTotal(Math.round(acumulado * 100.0) / 100.0);

        return response;
    }

    public ResponseRentaDTO cotizarRenta(RequestRentaDTO payload) {
        String tipoVehiculo = payload.getTipoVehiculo().toUpperCase();

        if (tipoVehiculo.equals("CAMIONETA") && payload.getEdadConductor() < 25) {
            throw new BadRequestException("No se permite la renta de CAMIONETA a menores de 25 años.");
        }

        double costoDiario = switch (tipoVehiculo) {
            case "COMPACTO" -> 550.0;
            case "SEDAN" -> 700.0;
            case "SUV" -> 950.0;
            case "CAMIONETA" -> 1200.0;
            default -> throw new BadRequestException("Tipo de vehículo no válido");
        };

        double costoRentaBase = costoDiario * payload.getDiasRenta();

        double descuentoRenta = 0.0;
        if (payload.getDiasRenta() >= 7) {
            descuentoRenta = costoRentaBase * 0.10;
        }

        double costoRentaConDescuento = costoRentaBase - descuentoRenta;

        int kilometrosIncluidos = payload.getDiasRenta() * 100;
        int kilometrosAdicionales = Math.max(0, payload.getKilometrosEstimados() - kilometrosIncluidos);
        double costoKmAdicionales = kilometrosAdicionales * 4.0;

        double cargoPorEdad = 0.0;
        if (payload.getEdadConductor() >= 18 && payload.getEdadConductor() <= 24) {
            cargoPorEdad = (costoRentaBase + costoKmAdicionales) * 0.15;
        }

        double costoSeguro = 0.0;
        if (Boolean.TRUE.equals(payload.getSeguroCompleto())) {
            costoSeguro = payload.getDiasRenta() * 180.0;
        }

        double costoTotal = costoRentaConDescuento + costoKmAdicionales + cargoPorEdad + costoSeguro;

        ResponseRentaDTO response = new ResponseRentaDTO();
        response.setNombreCliente(payload.getNombreCliente());
        response.setTipoVehiculo(tipoVehiculo);
        response.setDiasRenta(payload.getDiasRenta());
        response.setKilometrosEstimados(payload.getKilometrosEstimados());
        response.setKilometrosIncluidos(kilometrosIncluidos);
        response.setKilometrosAdicionales(kilometrosAdicionales);
        response.setCostoDiario(costoDiario);
        response.setCostoRentaBase(costoRentaBase);
        response.setDescuentoRenta(descuentoRenta);
        response.setCostoKilometrosAdicionales(costoKmAdicionales);
        response.setCargoPorEdad(cargoPorEdad);
        response.setCostoSeguro(costoSeguro);
        response.setCostoTotal(Math.round(costoTotal * 100.0) / 100.0);

        return response;
    }

    public ResponseHospedajeDTO cotizarHospedaje(RequestHospedajeDTO payload) {
        String hab = payload.getTipoHabitacion().toUpperCase();
        int personas = payload.getNumeroHuespedes();

        if (hab.equals("INDIVIDUAL") && personas > 1) {
            throw new BadRequestException("Habitación INDIVIDUAL permite máximo 1 persona.");
        }
        if (hab.equals("DOBLE") && personas > 2) {
            throw new BadRequestException("Habitación DOBLE permite máximo 2 personas.");
        }
        if (hab.equals("SUITE") && personas > 4) {
            throw new BadRequestException("Habitación SUITE permite máximo 4 personas.");
        }

        double costoNoche = switch (hab) {
            case "INDIVIDUAL" -> 700.0;
            case "DOBLE" -> 1100.0;
            case "SUITE" -> 1800.0;
            default -> throw new BadRequestException("Tipo de habitación no válido.");
        };

        double costoHospedajeBase = costoNoche * payload.getNumeroNoches();

        double ajusteTemporada = 0.0;
        String temporada = payload.getTemporada().toUpperCase();
        if (temporada.equals("BAJA")) {
            ajusteTemporada = -(costoHospedajeBase * 0.10);
        } else if (temporada.equals("ALTA")) {
            ajusteTemporada = costoHospedajeBase * 0.25;
        }

        double costoHospedajeConTemporada = costoHospedajeBase + ajusteTemporada;

        double descuentoLargaEstancia = 0.0;
        if (payload.getNumeroNoches() >= 7) {
            descuentoLargaEstancia = costoHospedajeBase * 0.08;
        }

        double costoDesayuno = 0.0;
        if (Boolean.TRUE.equals(payload.getIncluyeDesayuno())) {
            costoDesayuno = personas * payload.getNumeroNoches() * 150.0;
        }

        double costoEstacionamiento = 0.0;
        if (Boolean.TRUE.equals(payload.getIncluyeEstacionamiento())) {
            costoEstacionamiento = payload.getNumeroNoches() * 100.0;
        }

        double subtotal = (costoHospedajeConTemporada - descuentoLargaEstancia) + costoDesayuno + costoEstacionamiento;
        double impuesto = subtotal * 0.04;
        double total = subtotal + impuesto;

        ResponseHospedajeDTO response = new ResponseHospedajeDTO();
        response.setNombreHuesped(payload.getNombreHuesped());
        response.setTipoHabitacion(hab);
        response.setNumeroNoches(payload.getNumeroNoches());
        response.setNumeroHuespedes(personas);
        response.setTemporada(temporada);
        response.setCostoNoche(costoNoche);
        response.setCostoHospedajeBase(costoHospedajeBase);
        response.setAjusteTemporada(ajusteTemporada);
        response.setDescuentoLargaEstancia(descuentoLargaEstancia);
        response.setCostoDesayuno(costoDesayuno);
        response.setCostoEstacionamiento(costoEstacionamiento);
        response.setSubtotal(Math.round(subtotal * 100.0) / 100.0);
        response.setImpuesto(Math.round(impuesto * 100.0) / 100.0);
        response.setTotal(Math.round(total * 100.0) / 100.0);

        return response;
    }
}