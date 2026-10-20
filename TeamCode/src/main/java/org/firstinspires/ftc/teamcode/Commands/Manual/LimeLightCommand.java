package org.firstinspires.ftc.teamcode.Commands.Manual;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.PIDController;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

//not sure if we need these 2 imports below (keep in mind)
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;

public class LimeLightCommand {
    public MecanumDriveSubsystem mecanumDriveSubsystem;
    public Limelight3A limelight3A;
    public Gamepad gamepad;
    public Telemetry telemetry;
    public LLResult result;
    public PIDController pidController;

    public LimeLightCommand(MecanumDriveSubsystem mecanumDriveSubsystem, Limelight3A limelight3A, Gamepad gamepad, Telemetry telemetry) {
        this.mecanumDriveSubsystem = mecanumDriveSubsystem;
        this.limelight3A = limelight3A;
        this.gamepad = gamepad;
        this.telemetry = telemetry;
        pidController = new PIDController(0.05, 0, 0, 20); //change later when test type

    }

    public void operate(){
        result = limelight3A.getLatestResult();
        double tx = 0;
        if (result.isValid()){
            tx = result.getTx();
            telemetry.addData("Tx", tx);
        }
        else{
            tx = 0;
        }
        while (Math.abs(tx) > 0.5)
        {
            result = limelight3A.getLatestResult();
            tx = 0;
            if (result.isValid())
            {
                tx = result.getTx();
            }
            else
            {
                tx = 0;
            }

            pidController.createSetPoint(0);
            pidController.setProcessVariable(tx);

            double powerOutput = pidController.getOutput();
            mecanumDriveSubsystem.setLeftBackPower(powerOutput);
            mecanumDriveSubsystem.setLeftFrontPower(powerOutput);
            mecanumDriveSubsystem.setRightBackPower(-powerOutput);
            mecanumDriveSubsystem.setRightFrontPower(-powerOutput);
            telemetry.addData("Output", powerOutput);
            telemetry.addData("Current Tx", tx);
            telemetry.update();

        }
        mecanumDriveSubsystem.shutdown();
    }

    public double getDistance(){

        result = limelight3A.getLatestResult();
        double ty = 0;


        if(result.isValid())
        {
            ty = result.getTy();
        }
        else
        {
            ty = 0;
        }

        final double kh2 = 53.5;
        double kh1 = 10; //change later based off of limelight height

        double ka1 = 67; // change later based off of height
        double ka2 = ty;

        return (kh1 - kh2) / Math.tan((ka1 - ka2));

        
    }

    public void shutdown(){
        mecanumDriveSubsystem.shutdown();
    }
}