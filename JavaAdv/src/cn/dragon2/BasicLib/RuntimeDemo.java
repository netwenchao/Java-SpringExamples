package cn.dragon2.BasicLib;

public class RuntimeDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runtime rt = Runtime.getRuntime();
		System.out.println("T:"+toMB(rt.totalMemory())+"Mx:"+toMB(rt.maxMemory()));
		rt.gc();
		Thread.sleep(200);
		long pref = rt.freeMemory();
		String str = "";
		for (int i = 0; i < 30000; i++) {
			str += "，" + i;
		}		
		Thread.sleep(200);
		System.out.println("T:" + (pref - rt.freeMemory()));
	}
	
	static long toMB(long g) {
		return g/1024/1024;
	}
}
