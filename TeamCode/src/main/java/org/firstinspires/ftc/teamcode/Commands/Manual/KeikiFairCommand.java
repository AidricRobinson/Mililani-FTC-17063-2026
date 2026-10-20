package org.firstinspires.ftc.teamcode.Commands.Manual;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.sun.tools.javac.comp.Flow;

import org.firstinspires.ftc.teamcode.PIDController;
import org.firstinspires.ftc.teamcode.Subsystems.FeederSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;

public class KeikiFairCommand {
    FlowerSubsystem flowerSubsystem;
    FeederSubsystem feederSubsystem;
    FlywheelSubsystem flywheelSubsystem;
    IntakeSubsystem intakeSubsystem;
    Gamepad gamepad;
    PIDController pidController;

    public KeikiFairCommand(FlywheelSubsystem flywheelSubsystem, IntakeSubsystem intakeSubsystem,
                            FeederSubsystem feederSubsystem, Gamepad gamepad){
        this.flywheelSubsystem = flywheelSubsystem;
        this.intakeSubsystem = intakeSubsystem;
        this.feederSubsystem = feederSubsystem;
        this.gamepad = gamepad;
        this.pidController = new PIDController(0.005, 0, 0, .10);
    }
    public void Operate(Gamepad gamepad){
        if (gamepad.a){
            flywheelSubsystem.setFlywheelPower(.5);
        }
//        if (gamepad.right_bumper){
//            feederSubsystem.setPower(1);
//        }
//        else if (gamepad.right_trigger > 0.2 && !gamepad.right_bumper){
//            feederSubsystem.setPower(-1);//reverse
//        }
        if (gamepad.x){
            intakeSubsystem.setPower(1);
        }
        if (!gamepad.a) {
            flywheelSubsystem.setFlywheelPower(0);
        }
//        if (!gamepad.right_bumper){
//            feederSubsystem.setPower(0);
//        }
        if (!gamepad.x){
            intakeSubsystem.setPower(0);
        }
//        if (gamepad.right_trigger >=0.2){
//            feederSubsystem.setPower(0);
//        }

    }
    public void Shutdown(){
        flywheelSubsystem.shutdown();
        feederSubsystem.shutdown();
        intakeSubsystem.shutdown();
    }

}
