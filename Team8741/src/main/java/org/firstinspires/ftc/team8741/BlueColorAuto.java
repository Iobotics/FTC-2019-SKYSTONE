package org.firstinspires.ftc.team8741;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;





@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="BlueColorAuto", group = "Bot")
//@Disabled
public class BlueColorAuto extends LinearOpMode {

    private Bot robot = new Bot(this);
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.stop();
        robot.setLatcher(true,false, false);
        robot.encoderDrive(1,-15,-15, 300);
        robot.encoderDrive(1,10.75,-10.75,300);
        while((double) robot.getLeftRed() / (double)robot.getLeftGreen() >1.5) {
            robot.setPower(.5, .5);
        }
        robot.setPower(0,0);
        robot.encoderDrive(1,-10.75,10.75,300);
        robot.encoderDrive(.5,-2,-2,300);
        robot.setLatcher(false,true, false);
        robot.encoderDrive(.75,5,5,300);
        robot.encoderDrive(1,-10.75,10.75,300);
        robot.encoderDrive(1,-20,-20,300);
        robot.setLatcher(true,false, false);
        robot.encoderDrive(1, 7, 7, 10);
    }
}