package de.tum.in.ase.eist;

public class CelsiusThermo implements ThermoInterface {

	private ThermoAdapter thermoAdapter = new ThermoAdapter();

	public double getTempC() {
		return thermoAdapter.getTempC();
	}
}
