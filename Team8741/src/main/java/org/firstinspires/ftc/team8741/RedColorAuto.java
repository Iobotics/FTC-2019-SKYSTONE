package org.firstinspires.ftc.team8741;


        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.util.ElapsedTime;


@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="RedColorAuto", group = "Bot")
//@Disabled
public class RedColorAuto extends LinearOpMode {

    private Bot robot = new Bot(this);
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        robot.stop();
        robot.setLatcher(true,false);
        robot.encoderDrive(1,-17.5,-17.5, 300);
        robot.encoderDrive(1,-10.75,10.75,300);
        while(!(robot.getLeftRed()<10&&robot.getLeftBlue()<10&&robot.getLeftGreen()<10)) {
            robot.setPower(.5, .5);
        }
        robot.setPower(0,0);
        robot.encoderDrive(1,10.75,-10.75,300);
        robot.encoderDrive(.5,2,2,300);
        robot.setLatcher(false,true);
        robot.encoderDrive(.75,-5,-5,300);
        robot.encoderDrive(1,10.75,-10.75,300);
        robot.encoderDrive(1,20,20,300);
        robot.setPower(0,0);
    }
}
