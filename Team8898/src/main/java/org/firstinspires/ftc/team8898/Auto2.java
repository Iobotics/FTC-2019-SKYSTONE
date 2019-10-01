package org.firstinspires.ftc.team8898;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
@Autonomous(name="Auto2", group="Auto2")
public class Auto2 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        waitForStart();
        robot.encoderDrive(.8,-11,-11,30);
        robot.gyroTurn(90,.5);
        robot.encoderDrive(.8,-4,-4,30);
        robot.gyroTurn(0,.5);
        robot.encoderDrive(.8,-3,-3,30);
        robot.setLatchPower(0.25);
        sleep(5);
        robot.setLatchPower(0);
        robot.encoderDrive(.8,14,14,30);
        robot.setLatchPower(0.25);
        sleep(5);
        robot.setLatchPower(0);
        robot.gyroTurn(-90,.5);
        robot.encoderDrive(.8,-31,-31,30);
    }
}
