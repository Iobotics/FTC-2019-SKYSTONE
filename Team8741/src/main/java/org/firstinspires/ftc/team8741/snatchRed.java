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
        robot.encoderDrive(0.5, -26, -26, 300);

        robot.setLatcher(false, true);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            telemetry.addData("Path", "Leg 3: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.setLatcher(false, false);
    }
}