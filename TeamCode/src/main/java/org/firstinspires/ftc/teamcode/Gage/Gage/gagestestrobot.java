package org.firstinspires.ftc.teamcode.Gage.Gage;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

class gagestestrobot
{
    OpticalDistanceSensor Gageoptic;
    GyroSensor GageGyro ;
    ColorSensor GageColor ;

    DcMotor  RightUp  = null;
    DcMotor  LeftUp   = null;
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();


    gagestestrobot(){

    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        Gageoptic = hwMap.opticalDistanceSensor.get("Optic");
        RightUp  = hwMap.dcMotor.get("RightUp");
        LeftUp = hwMap.dcMotor.get("LeftUp");
        GageGyro = hwMap.gyroSensor.get("Gyro");
        GageColor = hwMap.colorSensor.get("Color");

        RightUp.setDirection(DcMotor.Direction.REVERSE);
        LeftUp.setDirection(DcMotor.Direction.FORWARD);

        RightUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftUp.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        RightUp.setPower(0);
        LeftUp.setPower(0);

    }



}