package org.firstinspires.ftc.teamcode.Gage.Gage;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Autonomous(name = "EXGYRO", group = "robot")
public class GageGyro extends LinearOpMode {
    gagestestrobot robot = new gagestestrobot();

    @Override
    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);

        ModernRoboticsI2cGyro gyro;


        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("GageGyro");


        int X, Y, Z = 0;     // beginning Gyro Values
        int Current = 0;              // Current Gyro heading
        int angleZ = 0;             //rate of heading , z value
        // Calibration
        telemetry.addData(">","Gyro Calibrating");
        telemetry.update();
        gyro.calibrate();

        // idle time to check for errors
        while (!isStopRequested() && gyro.isCalibrating())  {
            sleep(50);
            idle();
        }

        telemetry.addData(">","Gyro Calibrated");
        telemetry.update();
        /**************** RUNNING PROGRAM AFTER. INITIALIZATION BEFORE. **********/

        waitForStart();

        while (opModeIsActive())  {

            // x,y,z angles & rate of change
            X = gyro.rawX();
            Y = gyro.rawY();
            Z = gyro.rawZ();

            // get the heading info
            Current = gyro.getHeading();
            angleZ  = gyro.getIntegratedZValue();
            int Target1 = 90 ;
            boolean goalreached = Current >= Target1;
            /*********************  INIT BEFORE THIS. PROGRAM AFTER   ****************/
            if (Current > Target1) {
                Current = Current - 270;
            }
           if (goalreached) {
                robot.LeftUp.setPower(1);
                robot.RightUp.setPower(1);
            }
            if (!goalreached) {
                robot.LeftUp.setPower(-.25);
                robot.RightUp.setPower(.25);
            }






            /********************** FEEDBACK TO DRIVER STATION AFTER. PROGRAM BEFORE. **************/
            telemetry.addData( " Current Heading =", Current);
            telemetry.addData( "Int. Ang. =", angleZ);
            telemetry.addData( "Xval =", X);
            telemetry.addData( "Yval =", Y);
            telemetry.addData( "Zval =", Z);
            telemetry.update();


            idle();
        }
    }
}