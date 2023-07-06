package com.example.juegos.naipes;

public enum ValorNaipe {
    COMODIN(0), AS(1), DOS(2), TRES(3), CUATRO(4), CINCO(5), SEIS(6),
    SIETE(7), OCHO(8), NUEVE(9), DIEZ(10), JOTA(11), REINA(12), REY(13);

    public final int valorNumerico;

    ValorNaipe(int valorAsociado) {
        valorNumerico = valorAsociado;
    }

    public static ValorNaipe toEnum(int valor) {
        return switch (valor) {
            case 0 -> COMODIN;
            case 1 -> AS;
            case 2 -> DOS;
            case 3 -> TRES;
            case 4 -> CUATRO;
            case 5 -> CINCO;
            case 6 -> SEIS;
            case 7 -> SIETE;
            case 8 -> OCHO;
            case 9 -> NUEVE;
            case 10 -> DIEZ;
            case 11 -> JOTA;
            case 12 -> REINA;
            case 13 -> REY;
            default -> throw new IllegalArgumentException("No es un valor de la enumeración.");
        };
    }
}
