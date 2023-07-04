package com.example.juegos.numero;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import com.example.juegos.Juego;
import com.example.juegos.JuegoException;

/**
 * Juego de adivinar numeros
 *
 * @author Javier
 * @version 1.0
 */
public class JuegoDelNumero implements Juego<String> {

    public static class NotificaEventArgs {

        private String msg;
        private boolean cancel = false;

        public NotificaEventArgs(String msg) {
            super();
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public boolean isCancel() {
            return cancel;
        }

        public void setCancel(boolean cancel) {
            this.cancel = cancel;
        }

    }
    private int numeroBuscado;
    private int intentos;
    private boolean encontrado;
    private String resultado;

    private List<BiConsumer<Object, NotificaEventArgs>> notifica = new ArrayList<>();

    public JuegoDelNumero() {
        inicializar();
    }

    public void addNotificaListener(BiConsumer<Object, NotificaEventArgs> notifica) {
        this.notifica.add(notifica);
    }

    public void removeNotificaListener(BiConsumer<Object, NotificaEventArgs> notifica) {
    	if(!this.notifica.contains(notifica)) return;
        this.notifica.remove(notifica);
    }

    protected void onNotifica(NotificaEventArgs arg) {
    	if(notifica.size() == 0) return;
    	notifica.forEach(event -> event.accept(this, arg));
    }

    /**
     * Inicializa el juego
     */
    @Override
    public void inicializar() {
//     numeroBuscado = (new Random()).nextInt(100) + 1;
        numeroBuscado = (int) (Math.random() * 100 + 1);
        System.out.println("Objetivo: " + numeroBuscado);
        intentos = 0;
        encontrado = false;
        resultado = "Pendiente de empezar";
        onNotifica(new NotificaEventArgs("Inicializado"));
    }

    @Override
    public void jugada(String movimiento) throws JuegoException {
        try {
            jugada(Integer.parseInt(movimiento));
        } catch (NumberFormatException e) {
            throw new JuegoException("No es un número.", e);
        }
    }

    public void jugada(int numeroIntroducido) throws JuegoException {
        if (getFinalizado()) {
            throw new JuegoException("El juego a finalizado");
        }
        intentos += 1;
        if (numeroBuscado == numeroIntroducido) {
            encontrado = true;
            resultado = "Bieeen!!! Acertaste.";
        } else if (intentos >= 10) {
            resultado = "Upsss! Se acabaron los intentos, el número era el " + numeroBuscado;
        } else if (numeroBuscado > numeroIntroducido) {
            resultado = "Mi número es mayor.";
        } else {
            resultado = "Mi número es menor.";
        }
        var arg = new NotificaEventArgs(resultado);
        onNotifica(arg);
        if (arg.isCancel()) {
            encontrado = true;
            resultado = "CANCELADO: " + arg.getMsg();
        }
    }

    /**
     * Cadena con el mensaje de la ultima jugada
     */
    @Override
    public String getResultado() {
        return resultado;
    }

    @Override
    public boolean getFinalizado() {
        return intentos >= 10 || encontrado;
    }

    @Override
    public int getJugadas() {
        return intentos;
    }

}