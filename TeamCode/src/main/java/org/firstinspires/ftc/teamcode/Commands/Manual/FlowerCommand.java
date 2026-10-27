package org.firstinspires.ftc.teamcode.Commands.Manual;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;

public class FlowerCommand {
    FlowerSubsystem flowerSubsystem;
    boolean toggle = true;

    Gamepad gamepad;
    public FlowerCommand(FlowerSubsystem flowerSubsystem, Gamepad gamepad){
        this.flowerSubsystem = flowerSubsystem;
        this.gamepad = gamepad;
    }
    public void operate(){
        if(gamepad.right_bumper && toggle)
        {
            flowerSubsystem.setFlowerServoPosition(1);//tbd
            toggle = false;

        }
        else if(!gamepad.right_bumper)
        {
            toggle = true;
        }

        if( gamepad.left_trigger >= 0.2)
        {
            flowerSubsystem.setFlowerServoPosition(0);
        }

    }
    public void shutdown(){
        flowerSubsystem.shutdown();
    }
}
