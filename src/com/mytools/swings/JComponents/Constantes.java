
package com.mytools.swings.JComponents;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.net.MalformedURLException;
import java.net.URL;

public interface Constantes {
    public enum PosicionCentral {
        ARRIBA, CENTRO, DERECHA, IZQUIERDA, ABAJO, IZQUIERDA_ABAJO, IZQUIERDA_ARRIBA, DERECHA_ABAJO, DERECHA_ARRIBA
    }

    public enum TipoFondo {
        RADIAL, LINEAL, SOLID
    }

    public enum NumeroColores {
        NUMERO_COLOR_1, NUMERO_COLOR_2, NUMERO_COLOR_3, NUMERO_COLOR_4
    }
    
    public static boolean isValidURL(String urlString) {
        try {
            // Intenta crear una instancia de URL con la cadena proporcionada
            new URL(urlString);
            return true;  // Si no hay excepción, la URL es válida
        } catch (MalformedURLException e) {
            return false; // Si se captura una excepción, la URL no es válida
        }
    }
}
