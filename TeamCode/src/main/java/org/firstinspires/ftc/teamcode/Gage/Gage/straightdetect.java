package org.firstinspires.ftc.teamcode.Gage.Gage;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.util.Range;

import java.util.ArrayList;
import java.util.List;

@Autonomous(name = "Straight&Detect", group = "robot")
public class straightdetect extends LinearOpMode {
    gagestestrobot robot = new gagestestrobot();

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        ModernRoboticsI2cGyro Gyro;
        OpticalDistanceSensor Optic;

        Gyro = (ModernRoboticsI2cGyro)hardwareMap.gyroSensor.get("Gyro");
        Optic = hardwareMap.opticalDistanceSensor.get("Optic");

        int X, Y , Z = 0;
        int Current = 0;
        int angleZ = 0;

        telemetry.addData(">","Gyro Calibrating");
        telemetry.update();
        Gyro.calibrate();

        while (!isStopRequested() && Gyro.isCalibrating())  {
            sleep(50);
            idle();
        }

        telemetry.addData(">","Gyro Calibrated");
        telemetry.update();

        /**************** RUNNING PROGRAM AFTER. INITIALIZATION BEFORE. **********/

        waitForStart();

        while (opModeIsActive())  {

            X = Gyro.rawX();
            Y = Gyro.rawY();
            Z = Gyro.rawZ();
            angleZ  = Gyro.getIntegratedZValue();
            Current = Gyro.getHeading();

            int StartParameter = 60;
            int EndParameter = 90;
            double Distance = Range.clip(Optic.getLightDetected() , 0, 100) * 10;

            /*********************  INIT BEFORE THIS. PROGRAM AFTER   ****************/

            if (Current < StartParameter && Distance <= 3) {
                robot.LeftUp.setPower(-.10);
                robot.RightUp.setPower(.10);
            }

             if (Current > EndParameter && Distance <= 3) {
                robot.LeftUp.setPower(.10);
                robot.RightUp.setPower(-.10);
            }

            else if (Distance <= 3){
                robot.LeftUp.setPower(.10);
                robot.RightUp.setPower(.10);
            }







            /********************** FEEDBACK TO DRIVER STATION AFTER. PROGRAM BEFORE. **************/
            telemetry.addData( " Current Heading =", Current);
            telemetry.addData( "Int. Ang. =", angleZ);
            telemetry.addData( "Xval =", X);
            telemetry.addData( "Yval =", Y);
            telemetry.addData( "Zval =", Z);
            telemetry.addData("Distance =", Distance);
            telemetry.update();


            idle();
        }
    }
}