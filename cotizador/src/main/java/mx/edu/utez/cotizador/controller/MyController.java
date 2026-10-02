package mx.edu.utez.cotizador.controller;

import jakarta.validation.Valid;
import mx.edu.utez.cotizador.controller.dto.*;
import mx.edu.utez.cotizador.service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/cotizador")
public class MyController {

    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @PostMapping("/envio")
    public ResponseEntity<ResponseCotizadorDTO> cotizarEnvio(@RequestBody @Valid RequestCotizadorDTO payload) {
        return ResponseEntity.status(HttpStatus.OK).body(service.cotizarEnvio(payload));
    }

    @PostMapping("/renta")
    public ResponseEntity<ResponseRentaDTO> cotizarRenta(@RequestBody @Valid RequestRentaDTO payload) {
        return ResponseEntity.status(HttpStatus.OK).body(service.cotizarRenta(payload));
    }

    @PostMapping("/hospedaje")
    public ResponseEntity<ResponseHospedajeDTO> cotizarHospedaje(@RequestBody @Valid RequestHospedajeDTO payload) {
        return ResponseEntity.status(HttpStatus.OK).body(service.cotizarHospedaje(payload));
    }
}