package test;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("gp")
public class Galaxy implements Phone {
	@Autowired
	 //Qualifier은 오토와이어를 쓸때 사용하는 보조격인존재
	private Watch watch;
	private int fbat;
	private int bat;
	public int getFbat() {
		return fbat;
	}
	public void setFbat(int fbat) {
		this.fbat = fbat;
	}
	
	
	public Watch getWatch() {
		return watch;
	}
	public void setWatch(Watch watch) {
		System.out.println("galaxy watch");
		this.watch = watch;
	}
	public int getBat() {
		return bat;
	}
	public void setBat(int bat) {
		System.out.println("galaxy bat");
		this.bat = bat;
	}
	public void initMethod() {
		System.out.println("객체를 초기화하는 작업을 처리하는 메서드...");
	}
	public void destroyMethod() {
		System.out.println("객체 메모리를 해제할때 호출하는 메서드...");
	}
	public Galaxy() {
		System.out.println("갤럭시 객체생성완료");
	}
	
	@Override
	public void powerOn() {
		System.out.println("갤럭시 전원 ON");
	}
	@Override
	public void powerOff() {
		System.out.println("갤럭시 전원 OFF");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
	
}
