package org.firstinspires.ftc.team8741;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="simmionsAuto", group = "Bot")
//@Disabled
public class simmonsAuto extends LinearOpMode {

    private Bot robot = new Bot(this);
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.stop();
        telemetry.addData("Encoder", robot.getFrontLeft());
        telemetry.addData("Encoder 2", robot.getBackLeft());
        telemetry.addData("Encoder 3", robot.getFrontRight());
        telemetry.addData("Encoder 4", robot.getBackRight());
        telemetry.update();


        //10.25 is for 90 degree turns
        waitForStart();

        robot.encoderDrive(1, -22.25, -22.25, 300);

        telemetry.addData("Encoder", robot.getFrontLeft());
        telemetry.addData("Encoder 2", robot.getBackLeft());
        telemetry.addData("Encoder 3", robot.getFrontRight());
        telemetry.addData("Encoder 4", robot.getBackRight());
        telemetry.update();

        robot.encoderDrive(1, 10.25, -10.25, 300);

        telemetry.addData("Encoder", robot.getFrontLeft());
        telemetry.addData("Encoder 2", robot.getBackLeft());
        telemetry.addData("Encoder 3", robot.getFrontRight());
        telemetry.addData("Encoder 4", robot.getBackRight());
        telemetry.update();

        robot.encoderDrive(1, 5.25, 5.25, 300);

        telemetry.addData("Encoder", robot.getFrontLeft());
        telemetry.addData("Encoder 2", robot.getBackLeft());
        telemetry.addData("Encoder 3", robot.getFrontRight());
        telemetry.addData("Encoder 4", robot.getBackRight());
        telemetry.update();

        robot.encoderDrive(1, -10.25, 10.25, 300);

        telemetry.addData("Encoder", robot.getFrontLeft());
        telemetry.addData("Encoder 2", robot.getBackLeft());
        telemetry.addData("Encoder 3", robot.getFrontRight());
        telemetry.addData("Encoder 4", robot.getBackRight());
        telemetry.update();

        robot.encoderDrive(1, -3.75, -3.75, 300);

        telemetry.addData("Encoder", robot.getFrontLeft());
        telemetry.addData("Encoder 2", robot.getBackLeft());
        telemetry.addData("Encoder 3", robot.getFrontRight());
        telemetry.addData("Encoder 4", robot.getBackRight());
        telemetry.update();

        robot.setLatcher(false, true);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            //telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            //telemetry.update();
        }


        //robot.setLatcher(false, false);

        robot.encoderDrive(.5, 20.75, 20.75, 300);

        robot.setLatcher(true, false);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            //telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            //telemetry.update();
        }


        robot.setLatcher(false, false);



        robot.encoderDrive(1, -12.25, 12.25, 300);

        robot.encoderDrive(1, 26.25, 26.25, 300);

        telemetry.update();
        /*robot.encoderDrive(0.5, 6.5, -6.5, 300);
        robot.encoderDrive(0.5, -5, -5, 300);


         */
    }
}