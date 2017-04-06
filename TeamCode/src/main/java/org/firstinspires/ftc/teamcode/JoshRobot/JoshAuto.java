package org.firstinspires.ftc.teamcode.JoshRobot;


import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


/* This is an example LinearOpMode that shows how to use
* the Modern Robotics Gyro.
*
* The op mode assumes that the gyro sensor
* is attached to a Device Interface Module I2C channel
* and is configured with a name of "gyro".
*
* Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
* Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
*/
@Autonomous(name = "JoshAuto", group = "Robot")
@Disabled
public class JoshAuto extends LinearOpMode {
    JoshRobot robot = new JoshRobot();
    ModernRoboticsI2cGyro gyro = null;
    //DcMotor leftMotor;
    //DcMotor rightMotor;



    @Override


    public void runOpMode() throws InterruptedException {

        robot.leftMotor = hardwareMap.dcMotor.get("left_drive");
        robot.rightMotor = hardwareMap.dcMotor.get("right_drive");
        robot.rightMotor.setDirection(DcMotor.Direction.REVERSE);

        //robot.leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //robot.rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // double turnSpeed = 0.15;


        ModernRoboticsI2cGyro gyro;   // Hardware Device Object
        //int xVal, yVal, zVal = 0;     // Gyro rate Values
        //int heading = 0;              // Gyro integrated heading
        //int angleZ;
        //int target = 0;
        //boolean lastResetState = false;
        //boolean curResetState  = false;


        // get a reference to a Modern Robotics GyroSensor object.
        gyro = (ModernRoboticsI2cGyro) hardwareMap.gyroSensor.get("gyro");


        // start calibrating the gyro.
        telemetry.addData(">", "Gyro Calibrating. Do Not move!");
        telemetry.update();
        gyro.calibrate();


        // make sure the gyro is calibrated.
        while (gyro.isCalibrating()) {
            Thread.sleep(50);
            idle();
        }


        telemetry.addData(">", "Gyro Calibrated.  Press Start.");
        telemetry.update();


        // wait for the start button to be pressed.
        waitForStart();


        while (opModeIsActive()) {

            turnAbsolute(90);
            sleep(1000);
            turn(90);
            sleep(1000);
            idle();


        }
    }

    public void turn(int target) throws InterruptedException {
        turnAbsolute(target + gyro.getIntegratedZValue());
    }

    public void turnAbsolute(int target) throws InterruptedException {
        int angleZ = gyro.getIntegratedZValue();
        double turnSpeed = 0.15;

        while (Math.abs(angleZ - target) > 3) {


            if (angleZ > target) {
                robot.leftMotor.setPower(turnSpeed);
                robot.rightMotor.setPower(-turnSpeed);
            }
            if (angleZ < target) {
                robot.leftMotor.setPower(-turnSpeed);
                robot.rightMotor.setPower(turnSpeed);
            }


        }
    }
}