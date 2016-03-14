package designpatterns.mediator;

import java.util.HashMap;
import java.util.Map.Entry;

/*
 * �н���ģʽ
 */
//�ȳ���һ��ʹ�����ࣨѧ����
abstract class Person {
	String strName;	//����
	String strType;	//����
	//ÿ���˶���һ������������Ϣ���н�List,��qq,email��
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
	//�������˷���Ϣ
	public void SendMessageToAll(String MediatorName, String strMessage){
		MyMediatorList.get(MediatorName).SendMessageToAll(strMessage);
	}
	//��ָ�����͵��˷���Ϣ
	public void SendMessageByType(String MediatorName, String strType, String strMessage) {
		MyMediatorList.get(MediatorName).SendMessageByType(strType, strMessage);
	}
	//��ָ�����ֵ��˷���Ϣ
	public void SendMessageByName(String MediatorName, String strName, String strMessage) {
		MyMediatorList.get(MediatorName).SendMessageByName(strName, strMessage);
	}
	//������Ϣ
	public void ReciveMessage(String strMessage){
		System.out.println("[" + strType +"]" + "\"" + strName + "\"" + "�յ�"+strMessage);
	}
}
//����ѧ��
class Student extends Person {

	public Student(String strName) {
		super(strName);
		strType = "ѧ��";
	}
}

//������ʦ
class Teacher extends Person {

	public Teacher(String strName) {
		super(strName);
		strType = "��ʦ";
	}
}
//����У��
class Principal extends Person {

	public Principal(String strName) {
		super(strName);
		strType = "У��";
	}
}
//����һ�������н�
abstract class AbstractMediator {
	//�н������
	String strName;
	public AbstractMediator (String strName) {
		this.strName = strName;
	}
	public String getStrName() {
		return strName;
	}
	//����һ����Ա�б�
	HashMap<String, Person> PersonList = new HashMap<String, Person>();  
	public void addPerson(Person onePerson) {
		PersonList.put(onePerson.getStrName(), onePerson);
		onePerson.AddMediator(this);
	}
	public void deletePerson(String strName) {
		PersonList.remove(strName);
	}
	//�������˷���Ϣ
	abstract public void SendMessageToAll(String strMessage);
	//��ָ�����͵��˷���Ϣ
	abstract public void SendMessageByType(String strType, String strMessage);
	//��ָ�����ֵ��˷���Ϣ
	abstract public void SendMessageByName(String strName, String strMessage);
}
//����һ���н飨QQ�����ڴ�����Ϣ
class QQMediator extends AbstractMediator{

	public QQMediator(String strName) {
		super(strName);
	}

	@Override
	public void SendMessageToAll(String strMessage) {
		String strQQMessage = "����QQ��Ϣ��" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			entry.getValue().ReciveMessage(strQQMessage);
		}
	}

	@Override
	public void SendMessageByType(String strType, String strMessage) {
		String strQQMessage = "����QQ��Ϣ��" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			if(strType == entry.getValue().getStrType())
			{
				entry.getValue().ReciveMessage(strQQMessage);
			}
		}
	}

	@Override
	public void SendMessageByName(String strName, String strMessage) {
		String strQQMessage = "����QQ��Ϣ��" + strMessage;
		PersonList.get(strName).ReciveMessage(strQQMessage);
	}
	
}

//����һ���н飨Email�����ڴ�����Ϣ
class EmailMediator extends AbstractMediator{

	public EmailMediator(String strName) {
		super(strName);
	}

	@Override
	public void SendMessageToAll(String strMessage) {
		String strQQMessage = "����Email��Ϣ��" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			entry.getValue().ReciveMessage(strQQMessage);
		}
	}

	@Override
	public void SendMessageByType(String strType, String strMessage) {
		String strQQMessage = "����Email��Ϣ��" + strMessage;
		for(Entry<String, Person> entry : PersonList.entrySet()){
			if(strType == entry.getValue().getStrType())
			{
				entry.getValue().ReciveMessage(strQQMessage);
			}
		}
	}

	@Override
	public void SendMessageByName(String strName, String strMessage) {
		String strQQMessage = "����Email��Ϣ��" + strMessage;
		PersonList.get(strName).ReciveMessage(strQQMessage);
	}
	
}
public class Mediator {

	public static void main(String[] args) {
		//��������ѧ��
		Student student1 = new Student("ѧ��һ");
		Student student2 = new Student("ѧ����");
		//����������ʦ
		Teacher teacher1 = new Teacher("��ʦһ");
		Teacher teacher2 = new Teacher("��ʦ��");
		//��������У��
		Principal principal1 = new Principal("У��һ");
		Principal principal2 = new Principal("У����");
		//���������н飨QQ��email��
		QQMediator myQQ = new QQMediator("qq");
		EmailMediator myEmail = new EmailMediator("email");
		//��������Ա�ֱ���ӵ�qq��email��
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
		//���濪ʼ����ͨ��
		//����"У��һ"ͨ��qq��"У����"��һ����Ϣ
		principal1.SendMessageByName("qq", "У����", "�����ʲôʱ��żٺã�");
		principal2.SendMessageByName("qq", "У��һ", "�����쿪ʼ�żٰɣ�");
		principal1.SendMessageByName("qq", "У����", "�õģ����ҷ�֪ͨ��");
		//Ȼ��"У��һ"ͨ��email��������Ա��һ����Ϣ
		principal1.SendMessageByType("email", "��ʦ", "��ʦ�Ƕ�ע���ˣ������쿪ʼ�ż�");
		//��ʦ�յ���Ϣ���ٸ�ѧ������Ϣ
		teacher1.SendMessageByType("email", "ѧ��", "ͬѧ�Ƕ�ע���ˣ������쿪ʼ�ż��ˣ�");
		//ѧ���յ���Ϣ�󣬿�ʼqq��������
		student1.SendMessageByName("qq", "ѧ����", "����ż��ˣ�����ȥ���氡��");
		student2.SendMessageByName("qq", "ѧ��һ", "����ȥ��ɽ�ɣ������ʻ���û�б���ȥ��");
		student2.SendMessageToAll("email", "��������ȥ��ɽ������û��һ��ȥ�ģ�");
	}

}
