package org.firstinspires.ftc.teamcode.JoshRobot;




import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;




/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 * In this case that robot is a Pushbot.
 * See PushbotTeleopTank_Iterative and others classes starting with "Pushbot" for usage examples.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "left_drive"
 * Motor channel:  Right drive motor:        "right_drive"
 * Motor channel:  Manipulator drive motor:  "left_arm"
 * Servo channel:  Servo to open left claw:  "left_hand"
 * Servo channel:  Servo to open right claw: "right_hand"
 */
public class JoshRobot
{
    /* Public OpMode members. */
    public DcMotor  leftMotor   = null;
    public DcMotor  rightMotor  = null;
    public DcMotor spinMotor = null;
    public DcMotor armMotor = null;
    public DcMotor colorMotor = null;
    //public DcMotor leftarmMotor = null;
    //public DcMotor rightarmMotor = null;

    //public Servo BucketUp;
    //public Servo clawleft = null;
    //public Servo clawright = null;

    public double ClawPosition;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public JoshRobot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        leftMotor   = hwMap.dcMotor.get("left_drive");
        rightMotor  = hwMap.dcMotor.get("right_drive");
        spinMotor = hwMap.dcMotor.get("spin_drive");
        armMotor = hwMap.dcMotor.get("arm_drive");
        colorMotor = hwMap.dcMotor.get("color_drive");
        //leftarmMotor = hwMap.dcMotor.get("leftarm_drive");
        //rightarmMotor = hwMap.dcMotor.get("rightarm_drive");

        //BucketUp = hwMap.servo.get("BucketUp");
        //clawright = hwMap.servo.get("clawright");
        //clawleft = hwMap.servo.get("clawleft");
        //BucketDown = hwMap.servo.get("BucketDown");

        leftMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors
        //clawright.setDirection(Servo.Direction.REVERSE);

        // Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);
        spinMotor.setPower(0);
        armMotor.setPower(0);
        colorMotor.setPower(0);
        //leftarmMotor.setPower(0);
        //rightarmMotor.setPower(0);



     armMotor.setPower(0);

      // Set all motors to run without encoders.
      // May want to use RUN_USING_ENCODERS if encoders are installed.
      leftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        //BucketDown = hwMap.servo.get("BucketDown");


    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     *
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}
