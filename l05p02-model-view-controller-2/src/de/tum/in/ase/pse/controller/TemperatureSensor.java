package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.Machine;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 * The (sensor) controller class, miming a temperature sensor
 * This class forms an alternative controller type for the system.
 * Actually this only updates the machine's temperature, by simulating sensor
 * inputs.
 */
public class TemperatureSensor {

	/**
	 * 1.1 TODO: Add a "machine" attribute for a machine the sensor should control
	 * AND update the constructor accordingly
	 */
	private Machine machine;

	private static final int MULTIPLIER = 3;
	private static int timestamp = 0;

	public TemperatureSensor(Machine machine) {

		// for simulating regular sensor input/update
		Timeline beat = new Timeline(
				new KeyFrame(Duration.ZERO, event -> sendValue()),
				new KeyFrame(Duration.seconds(1), event -> {
				}));
		beat.setAutoReverse(true);
		beat.setCycleCount(Animation.INDEFINITE);
		beat.play();
		this.machine = machine;
	}

	/**
	 * This method updates the current temperature of the machine (by using
	 * machine's setter).
	 * It simulates the new value by generating fluctuations around the target
	 * temperature.
	 * It uses the timestamp to create alternating values.
	 */
	protected void sendValue() {
		timestamp++;

		int targetTemperature = machine.getTargetTemperature();
		int value = (int) Math.max(Math.sin(timestamp) * MULTIPLIER + targetTemperature, 0);
		machine.setCurrentTemperature(value);
	}
}
