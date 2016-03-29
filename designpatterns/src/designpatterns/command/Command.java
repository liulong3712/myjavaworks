package designpatterns.command;

import java.util.HashMap;

/*
 * ����ģʽ��������������װ����������Ա�ʹ�ò�ͬ��������־�����е���������������������ģʽҲ֧�ֳ���������
 * ����ĳ����˾��Ҫ���һ�����ù��ܵ�ң�������������������£�
 * ��ң�����п��Կ��Ʒ��ȣ��׳�ƣ���ˮ���ȵȵĶ�Կ��أ����ҿ��ܻ��������ĵ�����
 * ��ʱ�����书�ܣ�����ϣ�����Ա����ӿڣ��õ�ʱ����Է������չ��
 */

/*
 * ������
 */
class Fan
{
	public void FanOn()
	{
		System.out.println("���ȿ���");
	}
	public void FanOff()
	{
		System.out.println("���ȹ���");
	}
}
/*
 * ����
 */
class Light
{
	public void FanOn()
	{
		System.out.println("��ƿ���");
	}
	public void FanOff()
	{
		System.out.println("��ƹ���");
	}
}

/*
 * ����ӿ�
 */
interface ICommand{
	void Excute();
	void Undo();
}

/*
 * ���ȵ�����ִ����FanOnCommand
 */
class FanOnCommand implements ICommand {
	Fan fan;//����һ����������ھ����ִ��
	public FanOnCommand( Fan fan)
	{
		this.fan = fan;
	}
	public void Excute() {
		this.fan.FanOn();
	}
	public void Undo() {
		this.fan.FanOff();
	}
}
/*
 * ��Ƶ�����ִ����FanOnCommand
 */
class LightOnCommand implements ICommand {
	Light light;//����һ��������ھ����ִ��
	public LightOnCommand( Light light)
	{
		this.light = light;
	}
	public void Excute() {
		this.light.FanOn();
	}
	public void Undo() {
		this.light.FanOff();
	}
}

/*
 * �����������
 */
class RemoteControl {
	HashMap<String, ICommand> CommandList = 
			new HashMap<String, ICommand>();  
	public RemoteControl() {
		
	}
	//���ִ����
	public void AddCommand(String strCommandName, ICommand OneCommand) {
		CommandList.put(strCommandName, OneCommand);
	}
	//ɾ��ִ����
	public void DeleteCommand(String strCommandName) {
		CommandList.remove(strCommandName);
	}
	//ִ��һ������
	public void ExcuteCommand(String strCommandName) {
		CommandList.get(strCommandName).Excute();
	}
	//ִ��һ����������
	public void UndoCommand(String strCommandName) {
		CommandList.get(strCommandName).Undo();
	}
}
public class Command {

	public static void main(String[] args) {
		Fan fan = new Fan();
		Light light = new Light();
		
		//����������
		RemoteControl MyRemoteControl = new RemoteControl();
		MyRemoteControl.AddCommand("Fan", new FanOnCommand(fan));
		MyRemoteControl.AddCommand("Light", new LightOnCommand(light));
		MyRemoteControl.ExcuteCommand("Light");
		MyRemoteControl.ExcuteCommand("Fan");
		MyRemoteControl.UndoCommand("Light");
		MyRemoteControl.UndoCommand("Fan");
	}
}
