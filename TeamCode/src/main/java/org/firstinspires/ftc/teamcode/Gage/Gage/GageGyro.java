package org.firstinspires.ftc.teamcode.Gage.Gage;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.ArrayList;
import java.util.List;

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

            angleZ  = gyro.getIntegratedZValue();
            // get the heading info
            Current = gyro.getHeading();


            /*********************  INIT BEFORE THIS. PROGRAM AFTER   ****************/



              if (Current < 60) {
                robot.LeftUp.setPower(-.10);
                robot.RightUp.setPower(.10);
            }

           else if (Current > 90) {
                robot.LeftUp.setPower(.10);
                robot.RightUp.setPower(-.10);
            }

            else {
                  robot.LeftUp.setPower(1);
                  robot.RightUp.setPower(1);
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