package org.firstinspires.ftc.teamcode.Commands.Manual;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class IntakeCommand {
    IntakeSubsystem intakeSubsystem;
    Gamepad gamepad1;
    Gamepad gamepad2;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, Gamepad gamepad1, Gamepad gamepad2)
    {
        this.intakeSubsystem = intakeSubsystem;
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;

    }

    public void operate()
    {
        if(gamepad1.right_trigger > 0.2 || gamepad2.left_trigger > 0.2)
        {
            intakeSubsystem.setPower(1);
        }
        else if (gamepad1.left_trigger > 0.2 || gamepad2.left_bumper){
            intakeSubsystem.setPower(-1);
        }
        else
        {
            intakeSubsystem.setPower(0);
        }
    }
}
