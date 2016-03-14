package designpatterns.builder;

import java.util.ArrayList;

/*
 * 建造者模式
 * 在游戏开发中建造小人是经常的事了，要求是：小人必须包括，头，身体，手和脚。现在系统要包括的分为胖人和瘦人
 */

class BuildPerson {
	ArrayList<String> parts = new ArrayList<String>();
	public void Add(String part) {
		parts.add(part);
	}
	public void Show() {
		for(String myparts:parts) {
			System.out.print(myparts);
			System.out.print(",");
		}
		System.out.println("");
	}
}
//抽象builder类
interface InterBuilder {
	public void BuildHead();
	public void BuildBody();
	public void BuildHand();
	public void BuildFeet();
	public BuildPerson GetResult();
}
//Director类
class Director {
	void Construct(InterBuilder myBuilder) {
		myBuilder.BuildHand();
		myBuilder.BuildBody();
		myBuilder.BuildHand();
		myBuilder.BuildFeet();
	}
}
//具体胖人类
class FatPersonBuilder implements InterBuilder {

	BuildPerson product = new BuildPerson();
	public void BuildHead() {
		product.Add("胖人头");
	}

	public void BuildBody() {
		product.Add("胖人身体");
	}

	public void BuildHand() {
		product.Add("胖人手");
	}

	public void BuildFeet() {
		product.Add("胖人脚");
	}

	public BuildPerson GetResult() {
		return product;
	}
	
}
//具体瘦人类
class ThinPersonBuilder implements InterBuilder {
	private BuildPerson product = new BuildPerson();
	public void BuildHead() {
		product.Add("瘦人头");
	}

	public void BuildBody() {
		product.Add("瘦人身体");
	}

	public void BuildHand() {
		product.Add("瘦人手");
	}

	public void BuildFeet() {
		product.Add("瘦人脚");
	}

	public BuildPerson GetResult() {
		return product;
	}
	
}
public class Builder {

	public static void main(String[] args) {
		Director director = new Director();
		InterBuilder b1 = new FatPersonBuilder();
		InterBuilder b2 = new ThinPersonBuilder();
		director.Construct(b1);
		b1.GetResult().Show();
		director.Construct(b2);
		b2.GetResult().Show();
	}
}
