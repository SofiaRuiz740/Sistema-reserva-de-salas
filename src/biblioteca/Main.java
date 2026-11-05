package biblioteca;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE CONSTRUCCIÓN ===");
        Reserva reserva = new ReservaBuilder()
            .estudiante(new Estudiante("E001", "Laura"))
            .fecha(java.time.LocalDate.now().plusDays(7))
            .horaInicio(java.time.LocalTime.of(14, 0))
            .duracionHoras(2)
            .cantidadPersonas(4)
            .sala(new Sala("B", "Sala B", 4))
            .build();

        System.out.println(reserva);

        System.out.println("\n=== PRUEBA NEGATIVA 1: sin estudiante ===");
        try {
            new ReservaBuilder()
                .fecha(java.time.LocalDate.now().plusDays(7))
                .horaInicio(java.time.LocalTime.of(14, 0))
                .duracionHoras(2)
                .cantidadPersonas(4)
                .sala(new Sala("B", "Sala B", 4))
                .build();
        } catch (IllegalStateException ex) {
            System.out.println("Construcción rechazada: " + ex.getMessage());
        }

        System.out.println("\n=== PRUEBA NEGATIVA 2: sala con capacidad menor ===");
        try {
            new ReservaBuilder()
                .estudiante(new Estudiante("E001", "Laura"))
                .fecha(java.time.LocalDate.now().plusDays(7))
                .horaInicio(java.time.LocalTime.of(14, 0))
                .duracionHoras(2)
                .cantidadPersonas(6)
                .sala(new Sala("B", "Sala B", 4))
                .build();
        } catch (IllegalStateException ex) {
            System.out.println("Construcción rechazada: " + ex.getMessage());
        }
    }
}