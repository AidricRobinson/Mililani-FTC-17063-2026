package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.PIDController;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

public class EncoderTurningCommand {
    MecanumDriveSubsystem mecanumDriveSubsystem;
    PIDController m_PIDController;
    LinearOpMode m_linearOpMode;

    public EncoderTurningCommand(MecanumDriveSubsystem mecanumDriveSubsystem, LinearOpMode linearOpMode){
        this.mecanumDriveSubsystem = mecanumDriveSubsystem;
        m_PIDController = new PIDController(0.006/*idk yet*/, 0, 0, 0.05);
        m_linearOpMode = linearOpMode;



    }
    public void EncoderTurningOperate(double degrees, String direction){
        int motorTarget = (int)(degrees);
        m_PIDController.createSetPoint(motorTarget + (mecanumDriveSubsystem.getYaw()));

        while(m_linearOpMode.opModeIsActive()){
            m_PIDController.setProcessVariable(mecanumDriveSubsystem.getYaw());

            if (Math.abs(m_PIDController.getError()) < 10) {
                break;
            }
            double powerOutput = m_PIDController.getOutput();
            mecanumDriveSubsystem.setLeftFrontPower(powerOutput);
            mecanumDriveSubsystem.setLeftBackPower(powerOutput);
            mecanumDriveSubsystem.setRightFrontPower(-powerOutput);
            mecanumDriveSubsystem.setRightBackPower(-powerOutput);
        }
        mecanumDriveSubsystem.shutdown();
    }
    public void shutdown(){
        mecanumDriveSubsystem.shutdown();
    }
}
