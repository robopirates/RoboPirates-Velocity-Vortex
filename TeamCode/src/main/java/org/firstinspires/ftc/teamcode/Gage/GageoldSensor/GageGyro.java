package org.firstinspires.ftc.teamcode.Gage.GageoldSensor;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "EXGYRO", group = "robot")
public class GageGyro extends LinearOpMode {
    gagestestrobot robot = new gagestestrobot();

    @Override
    public void runOpMode() throws InterruptedException{

        robot.init(hardwareMap);

        ModernRoboticsI2cGyro gyro;
        gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("GageGyro");


        int xVal, yVal, zVal = 0;     // beginning Gyro Values
        int Current = 0;              // Current Gyro heading
        int angleZ = 0;

        // Calibration
        telemetry.addData("","Gyro Calibrating");
        telemetry.update();
        gyro.calibrate();

        // idle time to check for errors
        while (!isStopRequested() && gyro.isCalibrating())  {
            sleep(50);
            idle();
        }

        telemetry.addData("","Gyro Calibrated");
        telemetry.update();
        /**************** RUNNING PROGRAM AFTER. INITIALIZATION BEFORE. **********/

        waitForStart();

        while (opModeIsActive())  {

            // x,y,z angles & rate of change
            xVal = gyro.rawX();
            yVal = gyro.rawY();
            zVal = gyro.rawZ();

            // get the heading info
            Current = gyro.getHeading();
            angleZ  = gyro.getIntegratedZValue();
            int Target1 = 90;
            /*********************  INIT BEFORE THIS. PROGRAM AFTER   ****************/


            while (Current >= Target1) {
                robot.LeftUp.setPower(0);
                robot.RightUp.setPower(1);
                idle();
            }


            /********************** FEEDBACK TO DRIVER STATION AFTER. PROGRAM BEFORE. **************/
            telemetry.addData( " Current Heading =", Current);
            telemetry.addData( "Int. Ang. =", angleZ);
            telemetry.addData( "X =", xVal);
            telemetry.addData( "Y =", yVal);
            telemetry.addData( "Z =", zVal);
            telemetry.update();


            idle();
        }
    }
}