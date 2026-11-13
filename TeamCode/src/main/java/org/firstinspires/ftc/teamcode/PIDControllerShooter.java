package org.firstinspires.ftc.teamcode;

public class PIDControllerShooter {
    private double kP;
    private double setPoint; // target variable
    private double error;
    private double processVariable; // current position
    private double kFF;
    private double output; // power to the robot


    private double kV;
    private double kS;
    private double prevError = 0;
    //private double prevPos = 0;
    public PIDControllerShooter(double kP, double kV, double kS) {
        this.kP = kP;

        this.kV = kV;
        this.kS = kS;

    }
    public void createSetPoint(double setPoint){
        this.setPoint = setPoint;
    }
    public void setProcessVariable(double processVariable){

        this.processVariable = processVariable;
    }
    public double getError(){
        prevError = error;
        error = setPoint - processVariable;
        return error;
    }
    public double getOutput(){
        error = getError();
        kFF = kV * setPoint + kS;
        output = kP * error + kFF;
        return output;
    }
}

