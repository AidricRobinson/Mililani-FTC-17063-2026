package org.firstinspires.ftc.teamcode.Commands.Manual;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class IntakeCommand {
    IntakeSubsystem intakeSubsystem;
    Gamepad gamepad;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, Gamepad gamepad)
    {
        this.intakeSubsystem = intakeSubsystem;
        this.gamepad = gamepad;

    }

    public void operate()
    {
        if(gamepad.right_trigger > 0.2)
        {
            intakeSubsystem.setPower(1);
        }
        else if (gamepad.left_trigger > 0.2){
            intakeSubsystem.setPower(-1);
        }
        else
        {
            intakeSubsystem.setPower(0);
        }
    }
}
