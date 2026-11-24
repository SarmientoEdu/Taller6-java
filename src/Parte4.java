import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

/**
 * Taller 6 - Parte 4: Colecciones ArrayList y LinkedList
 * Integrante A: Pitti Jorge
 * Integrante B: Diaz Angel
 * Fecha: 23/11/2026
 *
 * INSTRUCCIONES:
 * Copia aquí el código completo de la Parte 4 que aparece en el documento.
 * Se mostrarán 3 ventanas de JOptionPane en secuencia.
 * Toma captura de cada una:
 *   imagenes/p4a_ciudades.png
 *   imagenes/p4b_numeros.png
 *   imagenes/p4c_cola.png
 */
public class Parte4 {
    public static void main(String[] args) {

        // ════════════════════════════════
        // SECCIÓN A: ArrayList de Strings
        // ════════════════════════════════

        // 1. CREACIÓN — sin tamaño fijo
        ArrayList<String> ciudades = new ArrayList<>();

        // 2. ADD — agregar elementos
        ciudades.add("Panamá");
        ciudades.add("Colón");
        ciudades.add("David");
        ciudades.add("Santiago");
        ciudades.add("Chitré");

        // 3. SIZE — tamaño actual
        StringBuilder sb = new StringBuilder();
        sb.append("=== ArrayList de ciudades ===\n");
        sb.append("Tamaño: ").append(ciudades.size()).append("\n");

        // 4. GET — acceso por índice
        sb.append("Primera ciudad: ").append(ciudades.get(0)).append("\n");
        sb.append("Última ciudad : ").append(ciudades.get(ciudades.size() - 1)).append("\n");

        // 5. CONTAINS — verificar existencia
        sb.append("¿Contiene 'David'? ").append(ciudades.contains("David")).append("\n");
        sb.append("¿Contiene 'Bocas'? ").append(ciudades.contains("Bocas")).append("\n");

        // 6. RECORRER con for-each
        sb.append("\nLista completa:\n");
        for (String ciudad : ciudades) {
            sb.append("  - ").append(ciudad).append("\n");
        }

        // 7. REMOVE — eliminar por valor
        ciudades.remove("Colón");
        sb.append("\nDespués de eliminar 'Colón': ").append(ciudades).append("\n");

        // 8. ADD en posición específica
        ciudades.add(1, "Bocas del Toro");  // inserta en índice 1
        sb.append("Después de insertar en pos 1: ").append(ciudades).append("\n");

        // 9. SORT — ordenar
        Collections.sort(ciudades);
        sb.append("Ordenadas alfabéticamente: ").append(ciudades).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0); // limpiar el StringBuilder

        // ════════════════════════════════
        // SECCIÓN B: ArrayList de enteros con operaciones
        // ════════════════════════════════

        ArrayList<Integer> numeros = new ArrayList<>();
        int[] datos = {34, 12, 78, 56, 23, 89, 45, 67};
        for (int d : datos) {
            numeros.add(d);
        }

        int suma = 0;
        int mayor = numeros.get(0);
        for (int n : numeros) {
            suma += n;
            if (n > mayor) mayor = n;
        }

        sb.append("=== ArrayList de números ===\n");
        sb.append("Lista: ").append(numeros).append("\n");
        sb.append("Suma  : ").append(suma).append("\n");
        sb.append(String.format("Prom  : %.2f\n", (double) suma / numeros.size()));
        sb.append("Mayor : ").append(mayor).append("\n");

        // Modificación: filtrar los mayores o iguales a 40 y sumar los filtrados
        ArrayList<Integer> mayoresDe40 = new ArrayList<>();
        int sumaFiltrados = 0;
        for (int n : numeros) {
            if (n >= 40) {
                mayoresDe40.add(n);
                sumaFiltrados += n;
            }
        }
        sb.append("Mayores o iguales a 40: ").append(mayoresDe40).append("\n");
        sb.append("Suma de filtrados      : ").append(sumaFiltrados).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
        sb.setLength(0);

        // ════════════════════════════════
        // SECCIÓN C: LinkedList como cola (FIFO)
        // ════════════════════════════════

        LinkedList<String> cola = new LinkedList<>();

        // addLast = agregar al final (enqueue)
        cola.addLast("Cliente 1");
        cola.addLast("Cliente 2");
        cola.addLast("Cliente 3");
        cola.addLast("Cliente 4");

        sb.append("=== LinkedList como Cola (turno bancario) ===\n");
        sb.append("Cola inicial: ").append(cola).append("\n\n");

        // removeFirst = atender al primero (dequeue)
        sb.append("Atendiendo clientes:\n");
        for (int i = 0; i < 2; i++) {
            String cliente = cola.removeFirst();
            sb.append("  Atendido: ").append(cliente);
            sb.append(" | Restantes en cola: ").append(cola.size()).append("\n");
        }

        // Modificación: mientras hay clientes en cola llegan otros 2
        cola.addLast("Cliente 5");
        cola.addLast("Cliente 6");
        sb.append("\nLlegan 2 clientes nuevos mientras hay gente en cola.\n");
        sb.append("Cola completa antes de seguir atendiendo: ").append(cola).append("\n\n");

        while (!cola.isEmpty()) {
            String cliente = cola.removeFirst();
            sb.append("  Atendido: ").append(cliente);
            sb.append(" | Restantes en cola: ").append(cola.size()).append("\n");
        }
        sb.append("\nCola vacía. Fin de atención.\n");

        // addFirst = urgencia (enqueue al frente)
        cola.addLast("Cliente A");
        cola.addLast("Cliente B");
        cola.addFirst("URGENTE");  // salta al frente
        sb.append("\nNueva cola con urgencia: ").append(cola).append("\n");

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
