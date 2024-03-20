package org.iesvdm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class AlturaAlumnoTest {

    @Test
    void verdadero() {
        assertTrue(1==1);
    }

    @Test
    void aniadeNombreTest1() {

        final String[] array = new String[10];

        String nombre = "Maria";
        String[] arrayActual = AlturaAlumno.aniadeNombre(array, nombre);

        assertTrue(arrayActual[arrayActual.length-1]
                .equals(nombre));
    }

    @Test
    void aniadeNombreTest2() {

        final String[] array = new String[10];

        int longInicial = array.length;

        String nombre = "Maria";
        String[] arrayActual = AlturaAlumno
                .aniadeNombre(array, nombre);

        assertEquals(longInicial+1, arrayActual.length);
        assertEquals(nombre, arrayActual[arrayActual.length-1]);
    }

    @Test
    void modificaAlturaPosicionEnElArray() {

        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);

        int posicion = 1;
        double altura = 1.9;

        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);

        //Then (Entonces)

        //altura esta en la posicion
        assertTrue(altura == array[posicion]);

        //todos los demas elementos del array no cambian
        for (int i = 0; i < array.length; i++) {
            if (i != posicion) {
                assertEquals(array[i], array2[i]);
            }
        }
    }

    @Test
    void modificaAlturaPosicionFueraDeRangoArray() {
        //When (Cuando)
        double[] array = {1.6, 1.8, 1.7};
        double[] array2 = Arrays.copyOf(array,array.length);

        int posicion = array.length+2;
        double altura = 1.9;

        //Do (Hacer)
        AlturaAlumno.modificaAltura(array, posicion, altura);

        //Then (Entonces)

        //altura esta en la posicion
        //assertTrue(altura == array[posicion]);

        //todos los demas elementos del array no cambian
        //for (int i = 0; i < array.length; i++) {
        //        assertEquals(array[i], array2[i]);
        //}
        assertArrayEquals(array2, array);
    }

    @Test
    public void buscaNombreTestEncontrado() {

        String[] array = {"Juan", "Ana", "Luis"};
        String nombre= "Ana";

        assertEquals(1,AlturaAlumno.buscaNombre(array,nombre));

    }

    @Test
    public void buscaNombreTestNoEncontrado() {

        String[] array = {"Juan", "Ana", "Luis"};
        String nombre= "Saul";

        assertEquals(-1,AlturaAlumno.buscaNombre(array,nombre));

    }

    @Test
    public void buscaNombreTestArrayVacio() {

        String[] array = {"Juan", "Ana", "Luis"};
        String nombre= "";

        assertEquals(-1,AlturaAlumno.buscaNombre(array,nombre));
        assertEquals(-11,AlturaAlumno.buscaNombre(array,nombre));

    }

    @Test
    public void motrarCorrecto(){

        String[] array= {"Ana", "Juan", "Saul"};
        double[] altura={1.9,1.5,1.3};

        assertDoesNotThrow(() ->{
            AlturaAlumno.mostrar(array,altura);
        });
    }

    @Test
    public void motrarFallo(){

        // WHEN
        String[] array = {"Juan", "Ana", "Luis"};
        double[] alturas1 = {1.9, 1.78};
        double[] alturas2 = {1.9, 1.78, 1.8};

        // DO THEN
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            AlturaAlumno.mostrar(array, alturas1);
        });
        assertDoesNotThrow(() -> {
            AlturaAlumno.mostrar(array, alturas2);
        });

    }

    @Test
    public void calculaMAX(){

        double[] array = {19.5,18.5,20.5};
        double  ResultadoMax = 20.5;

        double[] resultado=AlturaAlumno.calculaMaximo(array);

        assertEquals(2,resultado[0]);
        assertEquals(20.5,resultado[1]);
    }

    @Test
    public void calcularMAXVacio(){
        double[] array = {0.0, -1, -5};
        double resultadoMax=0;

        double[] resultado=AlturaAlumno.calculaMaximo(array);

        assertEquals(0.0, resultado[0]);
        assertEquals(0.0, resultado[1]);

    }

    @Test
    public void calculaMedia(){
        double[] array= {1,2,3};
        double mediat=2;

        double mediaactual= AlturaAlumno.calculaMedia(array);

        assertEquals(2,mediaactual);
    }
}
