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
//        this.limeLightCommand = limeLightCommand;
        this.pidController = new PIDController(0.005, 0, 0, .10);
    }
    public void operate(){
        double targetRpm = 0;
        if (gamepad.x){
            targetRpm = 1700;//idk
        }
        else if (gamepad.y){
            targetRpm = 1500;//change values later
        }
        if (gamepad.right_trigger > 0.2){
//            limeLightCommand.operate();

            pidController.createSetPoint(targetRpm);
            pidController.setProcessVariable(flywheelSubsystem.getFlywheelVelocity());
            flywheelSubsystem.setFlywheelPower(pidController.getOutput());
            telemetry.addData("Output", pidController.getOutput());
            telemetry.update();
        }
        else {
            flywheelSubsystem.setFlywheelPower(0);
        }
    }
    public void Shutdown(){
        flywheelSubsystem.shutdown();
    }
}
