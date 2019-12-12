package org.firstinspires.ftc.team8741;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="snatchRed", group = "Bot")
//@Disabled
public class snatchRed extends LinearOpMode {

    private Bot robot = new Bot(this);
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.stop();

        waitForStart();
        robot.encoderDrive(1, -26.25, -26.25, 300);

        robot.setLatcher(false, true, false);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        //robot.setLatcher(false, false);

        robot.encoderDrive(1, 11, 11, 300);

        robot.encoderDrive(1, -10.25, 10.25, 300);

        robot.encoderDrive(1, -35, -35, 300);

        robot.setLatcher(true, false, false);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.setLatcher(false, false, false);
        robot.encoderDrive(1, 6, 6, 300);

    }
}