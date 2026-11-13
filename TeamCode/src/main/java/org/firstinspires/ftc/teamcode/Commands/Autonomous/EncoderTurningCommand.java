package org.firstinspires.ftc.teamcode.Commands.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.PIDController;
import org.firstinspires.ftc.teamcode.Subsystems.MecanumDriveSubsystem;

public class EncoderTurningCommand {
    MecanumDriveSubsystem mecanumDriveSubsystem;
    PIDController m_PIDController;
    LinearOpMode m_linearOpMode;

    Telemetry telemetry;

    public EncoderTurningCommand(MecanumDriveSubsystem mecanumDriveSubsystem, LinearOpMode linearOpMode, Telemetry telemetry){
        this.mecanumDriveSubsystem = mecanumDriveSubsystem;
        m_PIDController = new PIDController(0.01, 0, 0, 0.15);
        m_linearOpMode = linearOpMode;
        this.telemetry = telemetry;



    }
    public void EncoderTurningOperate(double degrees, String direction){
        int motorTarget = (int)(degrees);
        double setPoint = motorTarget + (mecanumDriveSubsystem.getYaw());
        m_PIDController.createSetPoint(setPoint);

        while(m_linearOpMode.opModeIsActive()) {
            m_PIDController.setProcessVariable(mecanumDriveSubsystem.getYaw());

            if (Math.abs(m_PIDController.getError()) < 1) {
                break;
            }
            telemetry.addData("Error:", m_PIDController.getError());
            telemetry.addData("Process variable: ", mecanumDriveSubsystem.getYaw());
            telemetry.addData("Setpoint: ", setPoint);
            telemetry.update();
            double powerOutput = m_PIDController.getOutput();
            mecanumDriveSubsystem.setLeftFrontPower(-powerOutput);
            mecanumDriveSubsystem.setLeftBackPower(-powerOutput);
            mecanumDriveSubsystem.setRightFrontPower(powerOutput);
            mecanumDriveSubsystem.setRightBackPower(powerOutput);
        }
        mecanumDriveSubsystem.shutdown();
    }
    public void shutdown(){
        mecanumDriveSubsystem.shutdown();
    }
}
