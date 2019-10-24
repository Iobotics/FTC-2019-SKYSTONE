package org.firstinspires.ftc.team8898;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import java.security.PublicKey;

public class Bot {
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private HardwareMap hwMap = null;
    private DcMotor Latch = null;
    private DcMotor Lift = null;
    private TouchSensor limitSwitch = null;
    /*private DcMotor rightFlyWheel = null;
    private DcMotor leftFlyWheel = null;
    private DcMotor screwMotor = null;*/
    private Servo clasp = null;
    private BNO055IMU imu = null;
    private Orientation angles = null;
    private Acceleration gravity = null;
    private double p_Coeff = 0.001;
    private double f_Coeff = 0.09;


    double inchesPerDegrees = 13.8 * Math.PI / 360;





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
        Latch = hwMap.get(DcMotor.class, "latch2");
        Lift = hwMap.get(DcMotor.class, "lift");
        limitSwitch = hwMap.get(TouchSensor.class, "limitSwitch");
        /*rightFlyWheel = hwMap.get(DcMotor.class, "rightflywheel" );
        leftFlyWheel = hwMap.get(DcMotor.class, "leftflywheel");
        screwMotor = hwMap.get(DcMotor.class,"screwmotor");*/
        clasp = hwMap.get(Servo.class, "Clasp");
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);
        Latch.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Latch.setDirection(DcMotor.Direction.REVERSE);
        /*rightFlyWheel.setDirection(DcMotor.Direction.REVERSE);
        leftFlyWheel.setDirection(DcMotor.Direction.FORWARD);
        screwMotor.setDirection(DcMotor.Direction.FORWARD);*/
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = false;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hwMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }


    public void setPower(double leftPower, double rightPower) {
        frontLeftDrive.setPower(leftPower);
        frontRightDrive.setPower(rightPower);
        backLeftDrive.setPower(leftPower);
        backRightDrive.setPower(rightPower);

    }
    public void setLiftPower(double liftPower){
        Lift.setPower(liftPower);
    }
    public void setClasp(double position){
        clasp.setPosition(position);

    }
    /*public void setFlyPower(double flyPower){
        rightFlyWheel.setPower(flyPower);
        leftFlyWheel.setPower(flyPower);
    }
    public void setScrewPower(double screwPower){
        screwMotor.setPower(screwPower);
    }*/
    public double getFrontLeftPower(){
        return frontLeftDrive.getPower();
    }

    public void setLatchPower(double latchPower) {
        if (limitSwitch.isPressed()){
            setLatchPower(0);
        }
        else  Latch.setPower(latchPower);
    }
    public double getLatchPosition(){
        return Latch.getCurrentPosition();
    }
    public void setLatchPosition(int offset){
        Latch.setTargetPosition( offset + (int)getLatchPosition());
        Latch.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        Latch.setPower(.25);
    }


    private ElapsedTime runtime = new ElapsedTime();

    public double getRunTime() {
        return runtime.seconds();
    }


    static final double COUNTS_PER_MOTOR_REV = 1680;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;

    public void encoderDrive(double speed, double leftInches, double rightInches, double timeoutS) {
        int newfrontLeftTarget;
        int newfrontRightTarget;
        int newbackLeftTarget;
        int newbackRightTarget;


        // Ensure that the opmode is still active
        if (opMode.opModeIsActive()) {
            // Determine new target position, and pass to motor controller
            newfrontLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newfrontRightTarget = frontRightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            newbackLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newbackRightTarget = frontRightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            frontLeftDrive.setTargetPosition(newfrontLeftTarget);
            frontRightDrive.setTargetPosition(newfrontRightTarget);
            backLeftDrive.setTargetPosition(newbackLeftTarget);
            backRightDrive.setTargetPosition(newbackRightTarget);
            /*
            rightFlyWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftFlyWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            screwMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/
            // Turn On RUN_TO_POSITION
            frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            // reset the timeout time and start motion.
            runtime.reset();
            frontLeftDrive.setPower(Math.abs(speed));
            frontRightDrive.setPower(Math.abs(speed));
            backLeftDrive.setPower(Math.abs(speed));
            backRightDrive.setPower(Math.abs(speed));
            /*rightFlyWheel.setPower(Math.abs(speed));
            leftFlyWheel.setPower(Math.abs(speed));
            screwMotor.setPower(Math.abs(speed));*/
        }
        while (opMode.opModeIsActive() &&
                (runtime.seconds() < timeoutS) &&
                (frontLeftDrive.isBusy() && frontRightDrive.isBusy() && backLeftDrive.isBusy() && backRightDrive.isBusy())) {
            opMode.telemetry.addData("frontLeftEncoder", frontLeftDrive.getCurrentPosition());
            opMode.telemetry.addData("frontRightEncoder", frontRightDrive.getCurrentPosition());
            opMode.telemetry.addData("backLeftEncoder", backLeftDrive.getCurrentPosition());
            opMode.telemetry.addData("backRightEncoder", backRightDrive.getCurrentPosition());
            opMode.telemetry.update();
        }
        // Stop all motion;
        frontLeftDrive.setPower(0);
        frontRightDrive.setPower(0);
        backLeftDrive.setPower(0);
        backRightDrive.setPower(0);
        //this is new
        /*leftFlyWheel.setPower(0);
        rightFlyWheel.setPower(0);
        screwMotor.setPower(0);*/

        // Turn off RUN_TO_POSITION
        frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        /*rightFlyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftFlyWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        screwMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
    }

    public void resetEncoder() {
        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        /*rightFlyWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFlyWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        screwMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);*/

    }

    public double getFrontLeft() {
        return frontLeftDrive.getCurrentPosition();
    }

    public double getFrontRight() {
        return frontRightDrive.getCurrentPosition();
    }

    public double getBackLeft() {
        return backLeftDrive.getCurrentPosition();
    }

    public double getBackRight() {
        return backRightDrive.getCurrentPosition();
    }

    /*
    public double getRightFly(){
        return rightFlyWheel.getCurrentPosition();
    }
    public double getLeftFly() {
        return leftFlyWheel.getCurrentPosition();
    }
    public double getScrewMotor() {
        return screwMotor.getCurrentPosition();
    }*/


    public void autoDriveStraightB(double distance) {
        double ticks = COUNTS_PER_INCH * distance;
        ticks += frontLeftDrive.getCurrentPosition();
        while (frontLeftDrive.getCurrentPosition() < ticks) {
            setPower(1, 1);
        }
        setPower(0, 0);
    }
    public double getGyroHeading() {
        // Update gyro
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        gravity = imu.getGravity();

        double heading = AngleUnit.DEGREES.normalize(AngleUnit.DEGREES.fromUnit(angles.angleUnit, angles.firstAngle));
        return heading;
    }
    public void gyroTurn(double target, double speed){
        double error;
        double power;
        while((!(getGyroHeading() < target + 1 && getGyroHeading() > target -1))&& opMode.opModeIsActive()) {
            error = target - getGyroHeading();
            power = absRange((p_Coeff * error) + f_Coeff * ((Math.abs(error))/ error), speed);
            setPower(power, -power);
            opMode.telemetry.addData("Gyro", getGyroHeading());
            opMode.telemetry.update();
        }
        setPower(0,0);
    }

    public double absRange(double input, double range){
        if (input <= range || input >= -range){
            return input;
        }
        else return 1 * ((Math.abs(input))/ input);
    }
    public void rotate(double power, double degrees, double timeout) {

        encoderDrive(power,degrees * inchesPerDegrees, degrees * -inchesPerDegrees, timeout);
    }
    /*public void setArmPosition1(double position){

        Arm1.setPosition(position);


    }
    public void setArm2Position(double position) {

        Arm2.setPosition(position);

    }

    public double getArmOnePosition(){

        return Arm1.getPosition();


    }

    public double getArmTwoPosition(){

        return Arm2.getPosition();
    }
    public void setArmPosition(double armPosition){
        Arm1.setPosition(armPosition);
        Arm2.setPosition(armPosition);
    }*/

}
