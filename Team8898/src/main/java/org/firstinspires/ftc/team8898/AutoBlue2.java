package org.firstinspires.ftc.team8898;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="Resticted", group="Restricted")
public class AutoBlue2 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        robot.resetEncoder();
        waitForStart();
        robot.encoderDrive(.8,-27,-27,30);
        robot.gyroTurn(90,.8);
        robot.encoderDrive(.8,-4,-4,30);
        robot.gyroTurn(0,.8);
        robot.setLatchPower(-0.25);
        sleep(380);
        robot.setLatchPower(0);
        robot.encoderDrive(.8,-19,-19,30);
        robot.setLatchPower(0.25);
        sleep(400);
        robot.setLatchPower(0);
        robot.gyroTurn(90,-.8);
        robot.encoderDrive(.8,-35,-35,30);
    }
}
