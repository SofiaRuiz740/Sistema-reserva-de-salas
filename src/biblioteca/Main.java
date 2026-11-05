package biblioteca;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioSalas salas = new RepositorioSalasMemoria();
        RepositorioReservasMemoria reservas = new RepositorioReservasMemoria();
        List<ObservadorReserva> observadores = List.of(
            new NotificadorEstudiante(),
            new RegistroEventos()
        );
        ReservaFacade fachada = new ReservaFacade(salas, reservas, observadores);

        Reserva reserva = fachada.realizarReserva(
            new Estudiante("E001", "Laura"),
            LocalDate.now().plusDays(7),
            LocalTime.of(14, 0), 2, 4, new SeleccionPorCapacidad()
        ).orElseThrow();
        System.out.println(reserva);

        // Todavía no existen las clases State (Estación 7): se simula un cambio
        // de estado con un estado de prueba para ver que los observadores reaccionan.
        System.out.println("\nSimulando un cambio de estado:");
        reserva.cambiarEstado(new EstadoReserva() {
            public String nombre() { return "Confirmada"; }
            public void confirmar(Reserva r) { }
            public void cancelar(Reserva r) { }
            public void finalizar(Reserva r) { }
        });
    }
}