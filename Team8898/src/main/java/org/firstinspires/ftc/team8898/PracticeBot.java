package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class PracticeBot {
    private Servo arm1;
    private Servo arm2;
    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private HardwareMap hwMap;
    private LinearOpMode opMode;
    double ticksPerInch = 1120 / Math.PI / 4;
    double inchesPerDegrees = 28.8 * Math.PI /360;
    public PracticeBot (LinearOpMode opMode) {this.opMode = opMode;}
    public void init(HardwareMap awhmap){

        hwMap = awhmap;
        frontLeftMotor = hwMap.get(DcMotor.class, "frontleft");
        frontRightMotor =hwMap.get(DcMotor.class, "frontright");
        backLeftMotor = hwMap.get(DcMotor.class, "backleft");
        backRightMotor = hwMap.get(DcMotor.class, "backright");
        frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        arm1 = hwMap.get(Servo.class, "servo3");
        arm2 = hwMap.get(Servo.class, "servo4");

    }

    public void setArmPosition1(double position){

        arm1.setPosition(position);


    }
    public void setArm2Position(double position) {

        arm2.setPosition(position);

    }

    public double getArmOnePosition(){

        return arm1.getPosition();


    }

    public double getArmTwoPosition(){

        return arm2.getPosition();

    }

 public void setPower(double leftPower, double rightPower) {

        frontLeftMotor.setPower(leftPower);
        frontRightMotor.setPower(rightPower);
        backLeftMotor.setPower(leftPower);
        backRightMotor.setPower(rightPower);


 }
 public void setDistance(double inches){
        int initalPosition = frontLeftMotor.getCurrentPosition();
     if(inches < 0){

         while (frontLeftMotor.getCurrentPosition() > initalPosition + inches * ticksPerInch){

             frontLeftMotor.setPower(-0.5);
             frontRightMotor.setPower(-0.5);
             backLeftMotor.setPower(-0.5);
             backRightMotor.setPower(-0.5);

         }

     }
     else{

         while (frontLeftMotor.getCurrentPosition() < initalPosition + inches * ticksPerInch){

             frontLeftMotor.setPower(0.5);
             frontRightMotor.setPower(0.5);
             backLeftMotor.setPower(0.5);
             backRightMotor.setPower(0.5);

         }

     }

 }

 public void turnDegrees(double degrees){

     int initalPosition = frontLeftMotor.getCurrentPosition();
     if(degrees < 0){

         while (frontLeftMotor.getCurrentPosition() > initalPosition + degrees * ticksPerInch * inchesPerDegrees){

             frontLeftMotor.setPower(-0.5);
             frontRightMotor.setPower(0.5);
             backLeftMotor.setPower(-0.5);
             backRightMotor.setPower(0.5);

         }

     }
     else{

         while (frontLeftMotor.getCurrentPosition() < initalPosition + degrees * ticksPerInch * inchesPerDegrees){

             frontLeftMotor.setPower(0.5);
             frontRightMotor.setPower(-0.5);
             backLeftMotor.setPower(0.5);
             backRightMotor.setPower(-0.5);

         }

     }

    }




}

