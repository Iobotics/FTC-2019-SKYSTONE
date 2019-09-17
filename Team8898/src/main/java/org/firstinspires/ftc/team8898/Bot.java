package org.firstinspires.ftc.team8898;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Bot {
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private HardwareMap hwMap = null;
    private Servo servo = null;
    private Servo second = null;

    private LinearOpMode opMode = null;
    public Bot(LinearOpMode opMode) {
        this.opMode = opMode;
    }


    public void init(HardwareMap ahwMap) {


        hwMap = ahwMap;

        frontLeftDrive = hwMap.get(DcMotor.class, "frontleft");
        frontRightDrive = hwMap.get(DcMotor.class, "frontright");
        backLeftDrive = hwMap.get(DcMotor.class, "backleft");
        backRightDrive = hwMap.get(DcMotor.class, "backright");
        servo = hwMap.get (Servo.class, "servo");
        second = hwMap.get (Servo.class, "second");
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);

}

    public void setPower(double leftPower, double rightPower) {
        frontLeftDrive.setPower(leftPower);
        frontRightDrive.setPower(rightPower);
        backLeftDrive.setPower(leftPower);
        backRightDrive.setPower(rightPower);
    }
    private ElapsedTime runtime = new ElapsedTime();
    public double getRunTime (){
        return runtime.seconds();
    }
    public void setServo1 (double position){ servo.setPosition(position);
    }
    public void setServo2 (double position){second.setPosition(position);
    }
    public double getServo () {
        return servo.getPosition();
    }
}
