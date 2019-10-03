package org.firstinspires.ftc.team8741;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

import static java.lang.Thread.sleep;

public class Bot {


    final static int ENCODER_TICKS_PER_REV = 1120;
    final static int WHEEL_DIAMETER = 4; //Inches

    static final double COUNTS_PER_MOTOR_REV = 1440;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    private ElapsedTime runtime = new ElapsedTime();

    static final double DRIVE_SPEED = 0.6;
    static final double TURN_SPEED = 0.5;


    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;
    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private HardwareMap hwMap = null;
    private Servo closer1 = null;
    private Servo closer2 = null;
    private Servo spinner = null;
    private DcMotor latcher = null;
    private DcMotor lifter1 = null;
    private DcMotor lifter2 = null;

    private BNO055IMU imu = null;
    private Orientation angles = null;
    private Acceleration gravity = null;
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
        //closer1 = hwMap.get(Servo.class, "closerRight"); //right closer
        //closer2 = hwMap.get(Servo.class, "closerLeft"); //left closer
        //spinner = hwMap.get(Servo.class, "spinner"); //the spinner
        latcher = hwMap.get(DcMotor.class, "latcher"); //the latcher
        //lifter1 = hwMap.get(DcMotor.class, "lifter"); //right lifter
        //lifter2 = hwMap.get(DcMotor.class, "lifterLeft"); //left lifter
        frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
        backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
        backRightDrive.setDirection(DcMotor.Direction.REVERSE);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = false;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        imu = hwMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        //lifter1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //lifter2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        latcher.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    public void setPower(double leftPower, double rightPower) {
        frontLeftDrive.setPower(leftPower);
        frontRightDrive.setPower(rightPower);
        backLeftDrive.setPower(leftPower);
        backRightDrive.setPower(rightPower);
    }

    private double servoPos = 0;

    public void slowMode(boolean setPower, boolean setPower2){

        if(setPower2 == true){
            setPower(0.25, 0.25);
        }

        else if (setPower == true){
            setPower(0.5, 0.5);
        }

    }

    public void setLatcher(boolean latcherPower, boolean latcherPower2) {
        if (latcherPower2 == true) {
            latcher.setPower(-0.5);
        }

        else if (latcherPower == true) {
            latcher.setPower(0.5);
        }

        else if (latcherPower == false && latcherPower2 == false){
            latcher.setPower(0);
        }
    }

    /*public void setLifter(boolean lifterPower, boolean lifterPower2){

        if (lifterPower2 == true) {
            lifter1.setPower(-0.5);
            //lifter2.setPower(0.5);
        }

        else if (lifterPower == true) {
            lifter1.setPower(0.5);
            //lifter2.setPower(-0.5);
        }

        else if (lifterPower == false && lifterPower2 == false){
            lifter1.setPower(0);
            //lifter2.setPower(0);
        }
    }

     */

    public double getGyroHeading() {
        // Update gyro
        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        gravity = imu.getGravity();

        double heading = AngleUnit.DEGREES.normalize(AngleUnit.DEGREES.fromUnit(angles.angleUnit, angles.firstAngle));
        return heading;
    }
    public void gyroTurn(double target, double speed){
        int multiplier = 1;
        while((target > 178 && getGyroHeading() < target - 1) || ((target <= 178 && target >= -178 && !(getGyroHeading() < target + 1 && getGyroHeading() > target -1))) || (target < -178 && getGyroHeading() < target +1)) {

            if (isTurnCCW(getGyroHeading() + 180, target + 180)) {
                multiplier = 1;
            } else {
                multiplier = -1;
            }
            setPower(-speed * multiplier, speed * multiplier);
        }
    }

    boolean isTurnCCW(double hdg, double newHdg) { // should a new heading turn left ie. CCW?
        double diff = newHdg - hdg;        // CCW = counter-clockwise ie. left
        return diff > 0 ? diff > 180 : diff >= -180;
    }
    public void stop() {
        frontLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }


    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) throws InterruptedException {
        int newFrontLeftTarget;
        int newFrontRightTarget;
        int newBackLeftTarget;
        int newBackRightTarget;

        // Ensure that the opmode is still active
        if (opMode.opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newFrontLeftTarget = frontLeftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newFrontRightTarget = frontRightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            newBackLeftTarget = backLeftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newBackRightTarget = backRightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            frontLeftDrive.setTargetPosition(newFrontLeftTarget);
            frontRightDrive.setTargetPosition(newFrontRightTarget);
            backLeftDrive.setTargetPosition(newBackLeftTarget);
            backRightDrive.setTargetPosition(newBackRightTarget);


            // Turn On RUN_TO_POSITION
            frontRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            frontLeftDrive.setPower(Math.abs(speed));
            frontRightDrive.setPower(Math.abs(speed));
            backLeftDrive.setPower(Math.abs(speed));
            backRightDrive.setPower(Math.abs(speed));

            // keep looping while we are still active, and there is time left, and both motors are running.
            // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
            // its target position, the motion will stop.  This is "safer" in the event that the robot will
            // always end the motion as soon as possible.
            // However, if you require that BOTH motors have finished their moves before the robot continues
            // onto the next step, use (isBusy() || isBusy()) in the loop test.
            while (opMode.opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (frontLeftDrive.isBusy() && frontRightDrive.isBusy() && backLeftDrive.isBusy() && backRightDrive.isBusy())) {

                // Display it for the driver.
                opMode.telemetry.addData("Path1",  "Running to %7d :%7d", newFrontLeftTarget,  newFrontRightTarget, newBackLeftTarget, newBackRightTarget);
                opMode.telemetry.addData("Path2",  "Running at %7d :%7d",
                        frontLeftDrive.getCurrentPosition(),
                        frontRightDrive.getCurrentPosition(),
                        backLeftDrive.getCurrentPosition(),
                        backRightDrive.getCurrentPosition());
                opMode.telemetry.update();
            }



                // Stop all motion;
                frontLeftDrive.setPower(0);
                frontRightDrive.setPower(0);
                backLeftDrive.setPower(0);
                backRightDrive.setPower(0);

                // Turn off RUN_TO_POSITION
                frontLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                frontRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                backLeftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                backRightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

                 sleep(250);   // optional pause after each move
            }
        }

        public double getFrontLeft(){
            return frontLeftDrive.getCurrentPosition();
        }

        public double getBackLeft(){
            return backLeftDrive.getCurrentPosition();
        }

        public double getFrontRight(){
            return frontRightDrive.getCurrentPosition();
        }

        public double getBackRight(){
            return backRightDrive.getCurrentPosition();
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

    }



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



    public void setSpinner(boolean spinnerPower, boolean spinnerPower2) {

        if (spinnerPower2 == true) {
            servoPos += 0.01;
        }

        if (spinnerPower == true) {
            servoPos -= 0.01;
        }

        spinner.setPosition(servoPos);
    }

    /*public void setLatcher(boolean latcherPower, boolean latcherPower2){
        if (latcherPower2 == true){
            servoPos += 0.01;
        }

        if (latcherPower == true){
            servoPos -= 0.01;
        }
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
 */




