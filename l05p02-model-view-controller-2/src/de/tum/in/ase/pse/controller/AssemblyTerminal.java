package de.tum.in.ase.pse.controller;

import de.tum.in.ase.pse.model.AssemblyMachine;
import de.tum.in.ase.pse.model.ChipType;
import de.tum.in.ase.pse.utils.FactoryException;

/**
 * The controller class for the model AssemblyMachine
 * This class and the corresponding buttons form the controller part of the
 * system.
 * Actually this only delegates the calls. It was however implemented to mock a
 * dedicated controller.
 */
public class AssemblyTerminal {

	private final AssemblyMachine machine;

	public AssemblyTerminal(AssemblyMachine assemblyMachine) {
		this.machine = assemblyMachine;
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
	 * This method sets the space between transistors ("fin pitch") of the assembly
	 * machine (by using machine's setter).
	 * It checks if the input value is reasonable (between 27nm and 60nm),
	 * and throws a FactoryException otherwise.
	 */
	public void setSpaceBetweenTrans(int space) {
		int min = 27;
		int max = 60;
		if (space >= min && space <= max) {
			machine.setSpaceBetweenTrans(space);
			return;
		}
		throw new FactoryException("Space out of range");
	}

	/**
	 * This method sets the chip type of the assembly machine (by using machine's
	 * setter).
	 */
	public void setChipType(ChipType chipType) {
		machine.setChipType(chipType);
	}
}
