package org.firstinspires.ftc.teamcode.Gage.GageoldSensor;

import android.graphics.Color;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;


@Autonomous (name = "gageColor", group = "robot")

public class Gagecolors extends LinearOpMode {
    gagestestrobot robot = new gagestestrobot();
    ColorSensor GageColor;
    @Override
    public void runOpMode() {
        robot.init(hardwareMap);
        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F,0F,0F};
        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        GageColor = hardwareMap.colorSensor.get("Color_sensor");
        boolean bLedOn = true;
       // GageColor.enableLed(bLedOn);

        // wait for the start button to be pressed.
        waitForStart();

        while (opModeIsActive()) {

            // convert the RGB values to HSV values.
            Color.RGBToHSV(GageColor.red() * 8, GageColor.green() * 8, GageColor.blue() * 8, hsvValues);

            // send the info back to driver station using telemetry function.
            telemetry.addData("Clear", GageColor.alpha());
            telemetry.addData("Red", GageColor.red());
            telemetry.addData("Green", GageColor.green());
            telemetry.addData("Blue", GageColor.blue());
            telemetry.addData("LED", bLedOn ? "On" : "Off");
            telemetry.addData("Hue", hsvValues[0]);

            /*********anything previous to this is initialization**********/
            /*********anything after this point affects autonomous*********/

            if (GageColor.red() > GageColor.blue()) {
                robot.RightUp.setPower(1);
                robot.LeftUp.setPower(1);
               }

            if (GageColor.red() < GageColor.blue()) {
                robot.RightUp.setPower(-1);
                robot.LeftUp.setPower(-1);
            }

            else {
                robot.RightUp.setPower(0);
                robot.LeftUp.setPower(0);
                sleep(5000);
            }

            telemetry.update();

       idle();
        }
        }
    }

