package designpatterns.mediator;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * 中介者模式
 */
//先抽像一个使用者类（学生）
abstract class Person {
	String strName;	//姓名
	String strType;	//类型
	//每个人都有一个用来传递信息的中介List,如qq,email等
	HashMap<String, AbstractMediator> MyMediatorList = new HashMap<String, AbstractMediator>();
	public Person(String strName){
		this.strName = strName;
	}
	public String getStrName() {
		return strName;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public String getStrType() {
		return strType;
	}
	public void setStrType(String strType) {
		this.strType = strType;
	}
	public void AddMediator(AbstractMediator MyMediator) {
		MyMediatorList.put(MyMediator.getStrName(), MyMediator);
	}
	//给所有人发消息
	public void SendMessageToAll(String MediatorName, String strMessage){
		MyMediatorList.get(MediatorName).SendMessageToAll(strMessage);
	}
	//给指定类型的人发消息
	public void SendMessageByType(String MediatorName, String strType, String strMessage) {
		MyMediatorList.get(MediatorName).SendMessageByType(strType, strMessage);
	}
	//给指定名字的人发消息
	public void SendMessageByName(String MediatorName, String strName, String strMessage) {
		MyMediatorList.get(MediatorName).SendMessageByName(strName, strMessage);
	}
	//接收消息
	public void ReciveMessage(String strMessage){
		System.out.println("[" + strType +"]" + "\"" + strName + "\"" + "收到"+strMessage);
	}
}
//定义学生
class Student extends Person {

	public Student(String strName) {
		super(strName);
		strType = "学生";
	}
}

//定义老师
class Teacher extends Person {

	public Teacher(String strName) {
		super(strName);
		strType = "老师";
	}
}
//定义校长
class Principal extends Person {

	public Principal(String strName) {
		super(strName);
		strType = "校长";
	}
}
//定义一个抽象中介
abstract class AbstractMediator {
	//中介的名字
	String strName;
	public AbstractMediator (String strName) {
		this.strName = strName;
	}
	public String getStrName() {
		return strName;
	}
	//定义一个人员列表
	HashMap<String, Person> PersonList = new HashMap<String, Person>();  
	public void addPerson(Person onePerson) {
		PersonList.put(onePerson.getStrName(), onePerson);
		onePerson.AddMediator(this);
	}
	public void deletePerson(String strName) {
		PersonList.remove(strName);
	}
	//给所有人发消息
	abstract public void SendMessageToAll(String strMessage);
	//给指定类型的人发消息
	abstract public void SendMessageByType(String strType, String strMessage);
	//给指定名字的人发消息
	abstract public void SendMessageByName(String strName, String strMessage);
}
//定义一个中介（QQ）用于传递消息
class QQMediator extends AbstractMediator{

	public QQMediator(String strName) {
		super(strName);
	}

	@Override
	public void SendMessageToAll(String strMessage) {
		String strQQMessage = "来自QQ消息：" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			entry.getValue().ReciveMessage(strQQMessage);
		}
	}

	@Override
	public void SendMessageByType(String strType, String strMessage) {
		String strQQMessage = "来自QQ消息：" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			if(strType == entry.getValue().getStrType())
			{
				entry.getValue().ReciveMessage(strQQMessage);
			}
		}
	}

	@Override
	public void SendMessageByName(String strName, String strMessage) {
		String strQQMessage = "来自QQ消息：" + strMessage;
		PersonList.get(strName).ReciveMessage(strQQMessage);
	}
	
}

//定义一个中介（Email）用于传递消息
class EmailMediator extends AbstractMediator{

	public EmailMediator(String strName) {
		super(strName);
	}

	@Override
	public void SendMessageToAll(String strMessage) {
		String strQQMessage = "来自Email消息：" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			entry.getValue().ReciveMessage(strQQMessage);
		}
	}

	@Override
	public void SendMessageByType(String strType, String strMessage) {
		String strQQMessage = "来自Email消息：" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			if(strType == entry.getValue().getStrType())
			{
				entry.getValue().ReciveMessage(strQQMessage);
			}
		}
	}

	@Override
	public void SendMessageByName(String strName, String strMessage) {
		String strQQMessage = "来自Email消息：" + strMessage;
		PersonList.get(strName).ReciveMessage(strQQMessage);
	}
	
}
public class Mediator {

	public static void main(String[] args) {
		//定义两个学生
		Student student1 = new Student("学生一");
		Student student2 = new Student("学生二");
		//定义两个老师
		Teacher teacher1 = new Teacher("老师一");
		Teacher teacher2 = new Teacher("老师二");
		//定义两个校长
		Principal principal1 = new Principal("校长一");
		Principal principal2 = new Principal("校长二");
		//定义两个中介（QQ和email）
		QQMediator myQQ = new QQMediator("qq");
		EmailMediator myEmail = new EmailMediator("email");
		//将所有人员分别添加到qq和email中
		myQQ.addPerson(student1);
		myQQ.addPerson(student2);
		myQQ.addPerson(teacher1);
		myQQ.addPerson(teacher2);
		myQQ.addPerson(principal1);
		myQQ.addPerson(principal2);
		myEmail.addPerson(student1);
		myEmail.addPerson(student2);
		myEmail.addPerson(teacher1);
		myEmail.addPerson(teacher2);
		myEmail.addPerson(principal1);
		myEmail.addPerson(principal2);
		//下面开始进行通信
		//首先"校长一"通过qq向"校长二"发一条消息
		principal1.SendMessageByName("qq", "校长二", "你觉得什么时候放假好？");
		principal2.SendMessageByName("qq", "校长一", "从明天开始放假吧！");
		principal1.SendMessageByName("qq", "校长二", "好的，那我发通知了");
		//然后"校长一"通过email向所有人员发一条消息
		principal1.SendMessageByType("email", "老师", "老师们都注意了，从明天开始放假");
		//老师收到消息后再给学生发消息
		teacher1.SendMessageByType("email", "学生", "同学们都注意了，从明天开始放假了！");
		//学生收到消息后，开始qq聊起来了
		student1.SendMessageByName("qq", "学生二", "明天放假了，我们去哪玩啊？");
		student2.SendMessageByName("qq", "学生一", "我们去爬山吧，再问问还有没有别人去！");
		student2.SendMessageToAll("email", "明天我们去爬山，还有没有一起去的？");
	}

}
