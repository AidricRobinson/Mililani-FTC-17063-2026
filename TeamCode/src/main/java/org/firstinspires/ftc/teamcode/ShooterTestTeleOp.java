package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.Manual.FlywheelCommand;
import org.firstinspires.ftc.teamcode.Commands.Manual.LimeLightCommand;
import org.firstinspires.ftc.teamcode.Subsystems.FlywheelSubsystem;


@TeleOp(name="ShooterTestTeleOp")
public class ShooterTestTeleOp extends OpMode{

    FlywheelSubsystem flywheelSubsystem;
    PIDController pidController;
    boolean toggle1 = true;
    boolean toggle2 = true;// eletric boogaloo

    boolean toggle3 = true; //step
    public static double kp = 0.00325;
    public static double kff = 0.2;
    public double[] stepSizes= {.1, .01, .001, .0001, .00001};
    public int stepIndex = 0;


        @Override
        public void init() {
            flywheelSubsystem = new FlywheelSubsystem(this);


        }
        @Override
        public void loop() {
            pidController = new PIDController(kp, 0,0,kff);
            pidController.createSetPoint(2650);
            pidController.setProcessVariable(flywheelSubsystem.getRPM());





            telemetry.addData("RPM: ", flywheelSubsystem.getRPM());
            telemetry.addData("kP:", kp);
            telemetry.addData("kff: ", kff);
            telemetry.addData("Step Size: ", stepSizes[stepIndex]);
            telemetry.addData("Output", pidController.getOutput());
            telemetry.update();




            if (gamepad1.right_trigger > 0.2){

                flywheelSubsystem.setFlywheelPower(pidController.getOutput());

            }
            else if (gamepad1.dpad_down){
                flywheelSubsystem.setFlywheelPower(-1);
            }
            else {
                flywheelSubsystem.setFlywheelPower(0);
            }


            if(gamepad1.a && toggle1){
                kp += stepSizes[stepIndex];
                toggle1 = false;
            }
            else if(gamepad1.b && toggle1){
                kp -= stepSizes[stepIndex];
                toggle1 = false;
            } else if (!gamepad1.a && !gamepad1.b && !toggle1) {
                toggle1 = true;
            }

            if(gamepad1.x && toggle2){
                kff += stepSizes[stepIndex];
                toggle2 = false;
            }
            else if(gamepad1.y && toggle2){
                kff -= stepSizes[stepIndex];
                toggle2 = false;
            } else if (!gamepad1.x && !gamepad1.y && !toggle2) {
                toggle2 = true;
            }

            //stepIndex
            if(gamepad1.right_bumper && toggle3)
            {
                stepIndex = (stepIndex + 1) % stepSizes.length;
                toggle3 = false;
            }
            else if(!gamepad1.right_bumper && !toggle3)
            {
                toggle3 = true;
            }




        }
        public void stop(){
            flywheelSubsystem.shutdown();
        }
    }


