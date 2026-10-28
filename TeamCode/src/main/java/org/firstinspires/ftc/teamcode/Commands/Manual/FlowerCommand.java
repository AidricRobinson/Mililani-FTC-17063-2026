package org.firstinspires.ftc.teamcode.Commands.Manual;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Subsystems.FlowerSubsystem;

public class FlowerCommand {
    FlowerSubsystem flowerSubsystem;
    boolean toggle = true;
    boolean toggley = true;

    Gamepad gamepad;
    public FlowerCommand(FlowerSubsystem flowerSubsystem, Gamepad gamepad){
        this.flowerSubsystem = flowerSubsystem;
        this.gamepad = gamepad;
    }
    public void operate(){
        if(gamepad.right_bumper && toggle && toggley)
        {
            flowerSubsystem.setFlowerServoPosition(0);
            toggle = false;
            toggley = false;
        }
        else if(gamepad.right_bumper && !toggle && toggley)
        {
            flowerSubsystem.setFlowerServoPosition(1);
            toggle = true;
            toggley = false;

        }
        else if (!gamepad.right_bumper && !toggley) {
            toggley = true;
        }

    }
    public void shutdown(){
        flowerSubsystem.shutdown();
    }
}
