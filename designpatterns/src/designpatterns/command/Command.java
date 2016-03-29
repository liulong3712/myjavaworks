package designpatterns.command;

import java.util.HashMap;

/*
 * 命令模式：将请求或操作封装成命令对象，以便使用不同的请求、日志、队列等来参数化其他对象。命令模式也支持撤销操作。
 * 假设某个公司需要设计一个多用功能的遥控器。基本的需求如下：
 * 该遥控器有可以控制风扇，白炽灯，热水器等等的多对开关，而且可能还有其他的电器，
 * 暂时不做其功能，但是希望可以保留接口，用的时候可以方便的扩展。
 */

/*
 * 风扇类
 */
class Fan
{
	public void FanOn()
	{
		System.out.println("风扇开了");
	}
	public void FanOff()
	{
		System.out.println("风扇关了");
	}
}
/*
 * 灯类
 */
class Light
{
	public void FanOn()
	{
		System.out.println("电灯开了");
	}
	public void FanOff()
	{
		System.out.println("电灯关了");
	}
}

/*
 * 命令接口
 */
interface ICommand{
	void Excute();
	void Undo();
}

/*
 * 风扇的命令执行体FanOnCommand
 */
class FanOnCommand implements ICommand {
	Fan fan;//定义一个电风扇用于具体的执行
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
 * 电灯的命令执行体FanOnCommand
 */
class LightOnCommand implements ICommand {
	Light light;//定义一个电灯用于具体的执行
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
 * 命令的请求者
 */
class RemoteControl {
	HashMap<String, ICommand> CommandList = 
			new HashMap<String, ICommand>();  
	public RemoteControl() {
		
	}
	//添加执行体
	public void AddCommand(String strCommandName, ICommand OneCommand) {
		CommandList.put(strCommandName, OneCommand);
	}
	//删除执行体
	public void DeleteCommand(String strCommandName) {
		CommandList.remove(strCommandName);
	}
	//执行一个命令
	public void ExcuteCommand(String strCommandName) {
		CommandList.get(strCommandName).Excute();
	}
	//执行一个撤销命令
	public void UndoCommand(String strCommandName) {
		CommandList.get(strCommandName).Undo();
	}
}
public class Command {

	public static void main(String[] args) {
		Fan fan = new Fan();
		Light light = new Light();
		
		//创建调用者
		RemoteControl MyRemoteControl = new RemoteControl();
		MyRemoteControl.AddCommand("Fan", new FanOnCommand(fan));
		MyRemoteControl.AddCommand("Light", new LightOnCommand(light));
		MyRemoteControl.ExcuteCommand("Light");
		MyRemoteControl.ExcuteCommand("Fan");
		MyRemoteControl.UndoCommand("Light");
		MyRemoteControl.UndoCommand("Fan");
	}
}
