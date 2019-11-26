package org.firstinspires.ftc.team8898;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="AutoRed2", group="AutoRed2")
public class AutoRed2 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        waitForStart();
        robot.encoderDrive(.8,-30,-30,30);
        robot.setLatchPower(-0.25);
        sleep(380);
        robot.setLatchPower(0);
        robot.encoderDrive(.8,29,29,30);
        robot.setLatchPower(0.25);
        sleep(400);
        robot.setLatchPower(0);
    }
}
