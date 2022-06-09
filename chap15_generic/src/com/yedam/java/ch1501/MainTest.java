package com.yedam.java.ch1501;

public class MainTest {

	public static void main(String[] args) {
		Bag bag = new Bag();
		
		//문법적으로는 문제가 없지만 실제 구현하면 오류나는경향 많음
		bag.set(new Note()); //타입에 상관없이 다 넣을수있음
		Note note = (Note)bag.get(); //리턴형태가 object이기때문에 반드시 캐스팅변환 해줘야함
		
		bag.set("신운하");
		String name = (String)bag.get();
		
		Box<Note, String, Integer> box = new Box<>();
		
		box.setT(note);
		box.setK(500);
		box.setV("홍길동");
		
		Note memo = box.getT();
		int num = box.getK();
		String str = box.getV();
		
		Box<Car, Bus, Taxi> vehicle = new Box<>();
		vehicle.setT(new Car());
		vehicle.setK(new Taxi());
		vehicle.setV(new Bus());
		
		Car car = vehicle.getT();
		Bus bus = vehicle.getV();
		Taxi taxi = vehicle.getK();
	}

}

class Car{}
class Bus{}
class Taxi{}