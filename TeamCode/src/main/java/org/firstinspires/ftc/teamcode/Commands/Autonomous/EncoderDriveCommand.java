package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;
import org.firstinspires.ftc.teamcode.PIDController;

public class EncoderDriveCommand {
    MecanumDriveSubsystem mecanumDriveSubsystem;
    PIDController  m_PIDController;
    Telemetry telemetry;
    LinearOpMode m_LinearOpMode;
    public EncoderDriveCommand(MecanumDriveSubsystem mecanumDriveSubsystem, LinearOpMode linearOpMode, Telemetry telemetry){
        this.mecanumDriveSubsystem = mecanumDriveSubsystem;
        m_PIDController = new PIDController(0.0009/*kP tbd*/, 0 ,0 , 0.07) ;
        m_LinearOpMode = linearOpMode;
        this.telemetry = telemetry;

    }

    public void EncoderDriveOperate(double distance, String direction){
        int motorTarget = (int)(distance * Constants.EncoderConstants.kCOUNTS_PER_INCH);
            m_PIDController.createSetPoint(motorTarget + mecanumDriveSubsystem.encoderReading()[0]);

            while (m_LinearOpMode.opModeIsActive()){
                m_PIDController.setProcessVariable(mecanumDriveSubsystem.encoderReading()[0]);
                telemetry.addData("error:", m_PIDController.getError());
                telemetry.update();
//
                if(Math.abs(m_PIDController.getError()) < 10){
                    break;
                }

               double powerOutput = m_PIDController.getOutput();

                mecanumDriveSubsystem.setLeftBackPower(powerOutput);
                mecanumDriveSubsystem.setLeftFrontPower(powerOutput);
                mecanumDriveSubsystem.setRightBackPower(powerOutput);
                mecanumDriveSubsystem.setRightFrontPower(powerOutput);
            }
            mecanumDriveSubsystem.shutdown();
    }

    public void EncoderDriveOperatePower(double distance, double power, String direction){
        int motorTarget = (int)(distance * Constants.EncoderConstants.kCOUNTS_PER_INCH);
        m_PIDController.createSetPoint(motorTarget + mecanumDriveSubsystem.encoderReading()[0]);

        while (m_LinearOpMode.opModeIsActive()){
            m_PIDController.setProcessVariable(mecanumDriveSubsystem.encoderReading()[0]);

            if(Math.abs(m_PIDController.getError()) < 10){
                break;
            }

            double powerOutput = power;
            mecanumDriveSubsystem.setLeftBackPower(powerOutput);
            mecanumDriveSubsystem.setLeftFrontPower(powerOutput);
            mecanumDriveSubsystem.setRightBackPower(powerOutput);
            mecanumDriveSubsystem.setRightFrontPower(powerOutput);
        }
        mecanumDriveSubsystem.shutdown();
    }
    public void shutdown(){
        mecanumDriveSubsystem.shutdown();
    }
}