package org.firstinspires.ftc.teamcode.Commands.Manual;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.PIDController;
import org.firstinspires.ftc.teamcode.PIDControllerShooter;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;

public class FlywheelCommand {
    FlywheelSubsystem flywheelSubsystem;
    LimeLightCommand limeLightCommand;
    PIDControllerShooter pidControllerShooter;
    Telemetry telemetry;
    Gamepad gamepad;

//    private final double kP;
//    private final double kFF;
    private final double setPoint;

    public FlywheelCommand(FlywheelSubsystem flywheelSubsystem, Gamepad gamepad,/*, Limelight limelight*/ Telemetry telemetry){
        this.flywheelSubsystem = flywheelSubsystem;
        this.gamepad = gamepad;
        this.telemetry = telemetry;
//        this.limeLightCommand = limeLightCommand;
        this.pidControllerShooter = new PIDControllerShooter(0.0025, 0.00019, .002);
//        kP = .0000125;
//        kFF = 1/5000.0;
        setPoint = 2600;//2650 maybe 2600 is 2350
    }
    public void operate(){
        pidControllerShooter.createSetPoint(setPoint);
        pidControllerShooter.setProcessVariable(flywheelSubsystem.getRPM());

//        double targetRpm = 0;
//        if (gamepad.x){
//            targetRpm = 1700;//idk
//        }
//        else if (gamepad.y){
//            targetRpm = 1500;//change values later
//        }
        telemetry.addData("RPM: ", flywheelSubsystem.getRPM());
        telemetry.addData("Output: ", pidControllerShooter.getOutput());
        telemetry.update();

        if (gamepad.right_trigger > 0.2){
//            limeLightCommand.operate();

//            pidController.createSetPoint(targetRpm);
//            pidController.setProcessVariable(flywheelSubsystem.getFlywhe  elVelocity());
//            flywheelSubsystem.setFlywheelPower(pidController.getOutput());
//            if (pidController.getError() <= 0) {
//                flywheelSubsystem.setFlywheelPower(0);
//            }
//
//            else {
            //double output = kP * (setPoint - flywheelSubsystem.getRPM()) + kFF*setPoint;
            //output = Math.min(output, 1);
            //flywheelSubsystem.setFlywheelPower(output);

            flywheelSubsystem.setFlywheelPower(pidControllerShooter.getOutput());
//            flywheelSubsystem.setFlywheelPower(1);
//            }

//            telemetry.addData("Output", pidController.getOutput())

//
//

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
