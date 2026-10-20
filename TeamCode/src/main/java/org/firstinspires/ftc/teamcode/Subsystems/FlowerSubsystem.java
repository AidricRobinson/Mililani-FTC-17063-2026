
package org.firstinspires.ftc.teamcode.Subsystems;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
public class FlowerSubsystem {
    //false comment used to check if the github is linked :D
    Servo flower;

    public FlowerSubsystem(OpMode opMode){
        flower = opMode.hardwareMap.get(Servo.class,"FlowerServo");

    }
    public void setFlowerServoPosition(double pos){
        flower.setPosition(pos);
    }

    public double getPosition()
    {
        return flower.getPosition();
    }
    public void shutdown(){
        flower.setPosition(0);
    }
}
