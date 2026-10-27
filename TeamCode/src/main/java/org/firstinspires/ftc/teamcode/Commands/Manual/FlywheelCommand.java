package org.firstinspires.ftc.teamcode.Commands.Manual;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.PIDController;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;

public class FlywheelCommand {
    FlywheelSubsystem flywheelSubsystem;
    LimeLightCommand limeLightCommand;
    PIDController pidController;
    Telemetry telemetry;
    Gamepad gamepad;

    public FlywheelCommand(FlywheelSubsystem flywheelSubsystem, Gamepad gamepad,/*, Limelight limelight*/ Telemetry telemetry){
        this.flywheelSubsystem = flywheelSubsystem;
        this.gamepad = gamepad;
        this.telemetry = telemetry;
//        this.limeLightCommand = limeLightCommand;
        this.pidController = new PIDController(0.0025, 0, 0, 0.125);
    }
    public void operate(){
        pidController.createSetPoint(2650);
        pidController.setProcessVariable(flywheelSubsystem.getRPM());

//        double targetRpm = 0;
//        if (gamepad.x){
//            targetRpm = 1700;//idk
//        }
//        else if (gamepad.y){
//            targetRpm = 1500;//change values later
//        }
        telemetry.addData("RPM? ", flywheelSubsystem.getRPM());
        telemetry.update();
        if (gamepad.right_trigger > 0.2){
//            limeLightCommand.operate();

//            pidController.createSetPoint(targetRpm);
//            pidController.setProcessVariable(flywheelSubsystem.getFlywhe  elVelocity());
//            flywheelSubsystem.setFlywheelPower(pidController.getOutput());
            if (pidController.getError() <= 0) {
                flywheelSubsystem.setFlywheelPower(0);
            }

            else {
                flywheelSubsystem.setFlywheelPower(pidController.getOutput());
            }

//            telemetry.addData("Output", pidController.getOutput());

        }
        else if (gamepad.dpad_down){
            flywheelSubsystem.setFlywheelPower(-1);
        }
        else {
            flywheelSubsystem.setFlywheelPower(0);
        }
    }
    public void Shutdown(){
        flywheelSubsystem.shutdown();
    }
}
