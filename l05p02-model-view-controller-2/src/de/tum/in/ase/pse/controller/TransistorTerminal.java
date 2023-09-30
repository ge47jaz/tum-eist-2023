package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.GateType;
import de.tum.in.ase.pse.model.TransistorMachine;
import de.tum.in.ase.pse.model.TransistorType;
import de.tum.in.ase.pse.utils.FactoryException;

/**
 * The controller class for the model TransistorMachine
 * This class and the corresponding buttons form the controller part of the
 * system.
 * Actually this only delegates the calls. It was however implemented to mock a
 * dedicated controller.
 */
public class TransistorTerminal {

	private final TransistorMachine machine;

	public TransistorTerminal(TransistorMachine transistorMachine) {
		this.machine = transistorMachine;
	}

	/**
	 * This method updates the target temperature of the machine (by using machine's
	 * setter).
	 * It checks if the input value is between the min. and the max. temperature of
	 * the machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetTemperature(int targetTemperature) {
		if (targetTemperature >= machine.getMinTemperature() && targetTemperature <= machine.getMaxTemperature()) {
			machine.setTargetTemperature(targetTemperature);
			return;
		}
		throw new FactoryException("Temperature out of range");
	}

	/**
	 * This method updates the target voltage of the machine (by using machine's
	 * setter).
	 * It checks if the input value is between the min. and the max. voltage of the
	 * machine,
	 * and throws a FactoryException otherwise.
	 */
	public void setTargetVoltage(int targetVoltage) {
		if (targetVoltage >= machine.getMinVoltage() && targetVoltage <= machine.getMaxVoltage()) {
			machine.setTargetVoltage(targetVoltage);
			return;
		}
		throw new FactoryException("Voltage out of range");
	}

	/**
	 * This method sets the transistor size of the transistor machine (by using
	 * machine's setter).
	 * It checks if the input value is reasonable (between 7nm and 22nm),
	 * and throws a FactoryException otherwise.
	 */
	public void setTransistorSize(int transistorSize) {
		int min = 7;
		int max = 22;
		if (transistorSize >= min && transistorSize <= max) {
			machine.setTransistorSize(transistorSize);
			return;
		}
		throw new FactoryException("Transistor size out of range");
	}

	/**
	 * This method sets the transistor type of the transistor machine (by using
	 * machine's setter).
	 */
	public void setTransistorType(TransistorType transistorType) {
		machine.setTransistorType(transistorType);
	}

	/**
	 * This method sets the gate type of the transistor machine (by using machine's
	 * setter).
	 */
	public void setGateType(GateType gateType) {
		machine.setGateType(gateType);
	}
}
