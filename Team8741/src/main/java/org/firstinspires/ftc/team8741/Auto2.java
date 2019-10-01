package org.firstinspires.ftc.team8741;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous", group = "Bot")
//@Disabled
public class Auto2 extends LinearOpMode {

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


        //7 is for 90 degree turns
        waitForStart();

        robot.encoderDrive(0.5, -13, -13, 300);

        robot.encoderDrive(0.5, -7, 7, 300);

        robot.encoderDrive(0.5, 4, 4, 300);

        robot.encoderDrive(0.5, 7, -7, 300);

        robot.encoderDrive(0.5, -3, -3, 300);

        robot.setLatcher(false, true);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.setLatcher(false, false);

        robot.encoderDrive(.25, 11.75, 11.75, 300);

        robot.setLatcher(true, false);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.setLatcher(false, false);

        robot.encoderDrive(0.5, 7, -7, 300);

        robot.encoderDrive(0.5, 15, 15, 300);

        telemetry.update();
        /*robot.encoderDrive(0.5, 6.5, -6.5, 300);
        robot.encoderDrive(0.5, -5, -5, 300);


         */
    }
}