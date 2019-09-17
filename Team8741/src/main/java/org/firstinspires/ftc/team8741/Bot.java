package org.firstinspires.ftc.team8741;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Bot {
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private HardwareMap hwMap = null;
    private Servo closer1 = null;
    private Servo closer2 = null;
    private Servo spinner = null;
    private DcMotor lifter1 = null;
    private DcMotor lifter2 = null;

    private LinearOpMode opMode = null;
    public Bot(LinearOpMode opMode) {
        this.opMode = opMode;
    }


    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        frontLeftDrive = hwMap.get(DcMotor.class, "frontLeft"); //front left motor
        frontRightDrive = hwMap.get(DcMotor.class, "frontRight"); //front right motor
        backLeftDrive = hwMap.get(DcMotor.class, "backLeft"); //back left motor
        backRightDrive = hwMap.get(DcMotor.class, "backRight"); //back right motor
        closer1 = hwMap.get(Servo.class, "closerRight"); //right closer
        closer2 = hwMap.get(Servo.class, "closerLeft"); //left closer
        spinner = hwMap.get(Servo.class, "spinner"); //the spinner
        lifter1 = hwMap.get(DcMotor.class, "lifterRight"); //right lifter
        lifter2 = hwMap.get(DcMotor.class, "lifterLeft"); //left lifter
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);

        lifter1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lifter2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
}

    public void setPower(double leftPower, double rightPower) {
        frontLeftDrive.setPower(leftPower);
        frontRightDrive.setPower(rightPower);
        backLeftDrive.setPower(leftPower);
        backRightDrive.setPower(rightPower);
    }

    public void setLifter(boolean lifterPower, boolean lifterPower2){

        if (lifterPower2 == true) {
            lifter1.setPower(-0.5);
            lifter2.setPower(0.5);
        }

        else if (lifterPower == true) {
            lifter1.setPower(0.5);
            lifter2.setPower(-0.5);
        }

        else if (lifterPower == false && lifterPower2 == false){
            lifter1.setPower(0);
            lifter2.setPower(0);
        }
    }

    /*public void setLifter(boolean lifterPower){
        if (lifterPower == false) {
            lifter1.setPosition(1);
            lifter2.setPosition(1);
        }

        else if (lifterPower == true) {
            lifter1.setPosition(0);
            lifter2.setPosition(0);
        }

    }*/



    private double servoPos = 0;

    /*public void setLifter(boolean lifterPower, boolean lifterPower2){

        if (lifterPower2 == true) {
            lifter1.setPosition(0);
            lifter2.setPosition(1);

        }

        else if (lifterPower == true) {
            lifter1.setPosition(1);
            lifter2.setPosition(0);

        }

        lifter1.setPosition(.5);
        lifter2.setPosition(.5);

    }

    public double getLifter1Servo(){
        return lifter1.getPosition();
    }

    public double getLifter2Servo(){
        return lifter2.getPosition();
    }

     */
    public void setSpinner(boolean spinnerPower, boolean spinnerPower2) {

        if (spinnerPower2 == true) {
            servoPos += 0.01;
        }

        if (spinnerPower == true) {
            servoPos -= 0.01;
        }

        spinner.setPosition(servoPos);
    }

    public void setCloser(boolean closerPower, boolean closerPower2){

        if (closerPower2 == true){
            servoPos += 0.01;
        }

        if (closerPower == true){
            servoPos -= 0.01;
        }

        closer1.setPosition(servoPos);
        closer2.setPosition(1 - servoPos);
    }


}


