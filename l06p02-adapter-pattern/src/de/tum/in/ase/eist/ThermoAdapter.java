package de.tum.in.ase.eist;

public class ThermoAdapter implements ThermoInterface {

    private FahrenheitThermo thermo = new FahrenheitThermo();

    @Override
    public double getTempC() {
        return (thermo.getFahrenheitTemperature() - 32.0) * 5.0 / 9.0;
    }

}
