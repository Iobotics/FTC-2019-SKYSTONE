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

        robot.encoderDrive(1, -17.25, -17.25, 300);

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

        robot.encoderDrive(1, 7.25, 7.25, 300);

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

        robot.encoderDrive(1, -2.25, -2.25, 300);

        telemetry.addData("Encoder", robot.getFrontLeft());
        telemetry.addData("Encoder 2", robot.getBackLeft());
        telemetry.addData("Encoder 3", robot.getFrontRight());
        telemetry.addData("Encoder 4", robot.getBackRight());
        telemetry.update();

        robot.setLatcher(false, true, false);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < .5)) {
            //telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            //telemetry.update();
        }

        //robot.setLatcher(true,true, false);

        //robot.setLatcher(false, false);

        robot.encoderDrive(.5, 17.95, 17.95, 300);

        robot.setLatcher(true, false, false);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            //telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            //telemetry.update();
        }


        robot.setLatcher(false, false, false);



        robot.encoderDrive(1, -10.25, 10.25, 300);

        robot.encoderDrive(1, 33.25, 33.25, 300);

        telemetry.update();
        /*robot.encoderDrive(0.5, 6.5, -6.5, 300);
        robot.encoderDrive(0.5, -5, -5, 300);


         */
    }
}
