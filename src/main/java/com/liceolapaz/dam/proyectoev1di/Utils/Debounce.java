package com.liceolapaz.dam.proyectoev1di.Utils;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class Debounce
{
    private Timeline timeline;
    private final int DEBOUNCE_MILLIS = 800;
    private String newValue = "";

    public Debounce()
    {
        timeline = new Timeline(new KeyFrame(Duration.millis(DEBOUNCE_MILLIS), e->{}));
        timeline.setCycleCount(1);
    }

    public void debounce(String newValue)
    {
        this.newValue = newValue;
        timeline.stop();
        timeline.playFromStart();
    }

    public String getNewValue()
    {
        return newValue;
    }

    public void newKeyframe(EventHandler<ActionEvent> evento)
    {
        timeline.getKeyFrames().set(0, new KeyFrame(Duration.millis(DEBOUNCE_MILLIS),evento));
    }
}
