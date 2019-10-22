package org.firstinspires.ftc.team8898;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name="AutoBlue2", group="AutoBlue2")
public class AutoBlue2 extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        Bot robot = new Bot(this);
        robot.init(hardwareMap);
        waitForStart();
        robot.encoderDrive(.8,-27,-27,30);
        robot.gyroTurn(90,.8);
        robot.encoderDrive(.8,-4,-4,30);
        robot.gyroTurn(0,.8);
        robot.setLatchPower(-0.25);
        sleep(3000);
        robot.setLatchPower(0);
        robot.encoderDrive(.8,-19,-19,30);
        robot.setLatchPower(0.25);
        sleep(2000);
        robot.setLatchPower(0);
        robot.gyroTurn(-90,1);
        robot.encoderDrive(.8,-35,-35,30);
    }
}
