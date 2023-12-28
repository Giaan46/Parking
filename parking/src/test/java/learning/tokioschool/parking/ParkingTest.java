package learning.tokioschool.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ParkingTest {

    private Parking parking;
    private Coche coche1;
    private Coche coche2;
    private Coche coche3;

    @Before
    public void setUp() {
        // Creo instancias de coches
        coche1 = new Coche("Marca1", "Modelo1", LocalDateTime.now(), LocalDateTime.now().plusHours(1));
        coche2 = new Coche("Marca2", "Modelo2", LocalDateTime.now(), LocalDateTime.now().plusHours(2));
        coche3 = new Coche("Marca3", "Modelo3", LocalDateTime.now(), null);

        //  instancia de parking
        parking = new Parking();

        // coches al parking
        parking.putCoche("ABC123", coche1);
        parking.putCoche("DEF456", coche2);
        parking.putCoche("GHI789", coche3);
    }

    @Test
    public void testExisteCoche() {
        Assert.assertTrue(parking.existeCoche("ABC123"));
        Assert.assertFalse(parking.existeCoche("XYZ987"));
    }

    @Test
    public void testGetCoche() {
        Coche coche = parking.getCoche("ABC123");
        Assert.assertEquals(coche1, coche);
    }

    @Test
    public void testImprimirCochesSistema() {
        // No se pueden realizar pruebas directas de salida por consola con JUnit
        // Se puede comprobar si la llamada al método no lanza excepciones
        parking.imprimirCochesSistema();
    }

    @Test
    public void testImprimirCochesParking() {
        //En este caso es igual que el anterir, se llama al metodo para verificar que no lance excepciones
        parking.imprimirCochesParking();
    }

    @Test
    public void testCantidadAPagar() {
        // Calcular la cantidad a pagar por el coche1
        float cantidadAPagar = coche1.cantidadAPagar();
        Assert.assertEquals(9.0f, cantidadAPagar, 0.0f);
    }

    @Test
    public void testSetHoraSalida() {
        LocalDateTime nuevaHoraSalida = LocalDateTime.now().plusHours(3);
        coche1.setHoraSalida(nuevaHoraSalida);
        Assert.assertEquals(nuevaHoraSalida, coche1.getHoraSalida());
    }
}