package de.dfki.reeti.builders;

/**
 * Created by alvaro on 3/7/17.
 */
public class DummyHandler extends RettiBuilderHandler {
    DummyHandler(){

    }
    @Override
    protected void write() {
        System.out.println("Do nothing");
    }
}
