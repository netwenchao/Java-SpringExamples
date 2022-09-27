package cn.dragon2.Other;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTimeTaskDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub;
		var timer = new Timer();
		// delay 10s
		timer.schedule(new SecondTimerTask("10s Delay"), 10000);
		//delay interval
		timer.schedule(new SecondTimerTask("I--10s Delay 2s interval"), 10000, 2000);
		//firstTime
		timer.schedule(new SecondTimerTask("At 2022-01-01"), new Date(2022,1,1));
		//firstTime, interval
		timer.schedule(new SecondTimerTask("I--At 2022-01-01 10s interval"), new Date(2022,1,1),10000);
	}
}

class SecondTimerTask extends TimerTask {

	private String message;

	public SecondTimerTask(String msg) {
		message = msg;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(message + "Now:" + sdf.format(new Date()));
	}

}
