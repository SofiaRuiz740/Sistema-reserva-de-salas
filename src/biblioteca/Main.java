package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioSalas salas = new RepositorioSalasMemoria();
        RepositorioReservasMemoria reservas = new RepositorioReservasMemoria();
        ReservaFacade fachada = new ReservaFacade(salas, reservas,
            List.of(new NotificadorEstudiante()));

        // Reserva armada a mano para ver el estado inicial (Pendiente)
        Reserva reserva = new ReservaBuilder()
            .estudiante(new Estudiante("E001", "Laura"))
            .fecha(LocalDate.now().plusDays(7))
            .horaInicio(LocalTime.of(14, 0))
            .duracionHoras(2)
            .cantidadPersonas(4)
            .sala(new Sala("B", "Sala B", 4))
            .build();
        reserva.agregarObservador(new NotificadorEstudiante());

        System.out.println("Estado inicial: " + reserva.getNombreEstado());

        System.out.println("\n1) Confirmar una reserva pendiente");
        reserva.confirmar();
        System.out.println("Estado: " + reserva.getNombreEstado());

        System.out.println("\n2) Cancelar una reserva confirmada");
        reserva.cancelar();
        System.out.println("Estado: " + reserva.getNombreEstado());

        System.out.println("\n3) Intentar confirmar una reserva cancelada");
        try {
            reserva.confirmar();
        } catch (IllegalStateException ex) {
            System.out.println("Rechazado: " + ex.getMessage());
        }
        System.out.println("Estado: " + reserva.getNombreEstado());

        // Otra reserva (por la fachada, queda confirmada)
        Reserva otra = fachada.realizarReserva(
            new Estudiante("E002", "Andrés"),
            LocalDate.now().plusDays(8),
            LocalTime.of(10, 0), 2, 4, new SeleccionPorCapacidad()
        ).orElseThrow();

        System.out.println("\n4) Finalizar otra reserva confirmada");
        otra.finalizar();
        System.out.println("Estado: " + otra.getNombreEstado());

        System.out.println("\n5) Intentar cancelar una reserva finalizada");
        try {
            otra.cancelar();
        } catch (IllegalStateException ex) {
            System.out.println("Rechazado: " + ex.getMessage());
        }
        System.out.println("Estado: " + otra.getNombreEstado());
    }
}