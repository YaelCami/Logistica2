package co.edu.uniquindio.poo.logistica2.controller;

import co.edu.uniquindio.poo.logistica2.App;

public class PrimaryController {
    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void irACotizar(){
        app.openCotizarTarifa();
    }

    public void irAlRastreo(){
        app.openRastrearPedido();
    }


}
