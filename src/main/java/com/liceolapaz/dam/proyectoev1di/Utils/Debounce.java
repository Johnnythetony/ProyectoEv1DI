package com.liceolapaz.dam.proyectoev1di.Utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Debounce
{
    private Timeline timeline;
    private final int DEBOUNCE_MILLIS = 400;

    public Debounce(EventHandler<ActionEvent> evento)
    {
        timeline = new Timeline(new KeyFrame(Duration.millis(DEBOUNCE_MILLIS), evento));
        timeline.setCycleCount(1);
    }

    public void debounce()
    {
        timeline.stop();
        timeline.playFromStart();
    }
}
