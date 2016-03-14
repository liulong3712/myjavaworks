package designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

/*
 * ��ϣ�Composite��ģʽ
 * ʹ����һ���ļ�ϵͳ������������˵�������ģʽ����;
 * */

abstract class Company {  
    private String name;  
  
    public Company(String name) {  
        this.name = name;  
    }  
  
    public Company() {  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    protected abstract void add(Company company);  
  
    protected abstract void romove(Company company);  
  
    protected abstract void display(int depth);  
}  

/*
 * Ŀ¼��
 */
class ConcreteCompany extends Company {  
    private List<Company> cList;  
  
    public ConcreteCompany() {  
        cList = new ArrayList<Company>();  
    }  
  
    public ConcreteCompany(String name) {  
        super(name);   
        cList = new ArrayList<Company>() ;   
    }  
  
    @Override  
    protected void add(Company company) {  
        cList.add(company);  
    }  
  
    @Override  
    protected void display(int depth) {  
        // TODO Auto-generated method stub  
        StringBuilder sb = new StringBuilder("");  
        for (int i = 0; i < depth; i++) {  
            sb.append("-");   
        }  
        System.out.println(new String(sb) + this.getName());  
        for (Company c : cList) {  
            c.display(depth + 2);  
        }  
    }  
  
    @Override  
    protected void romove(Company company) {  
        cList.remove(company);  
    }  
}  

/*
 * @param 
 * �ļ���
 */
class FinanceDepartment extends Company {  
    
    
    public FinanceDepartment(){  
          
    }  
      
    public FinanceDepartment(String name){  
        super(name);  
    }  
      
    @Override  
    protected void add(Company company) {  
  
    }  
  
    @Override  
    protected void display(int depth) {  
        StringBuilder sb = new StringBuilder("");  
        for (int i = 0; i < depth; i++) {  
            sb.append("-");  
        }  
        System.out.println(new String(sb) + this.getName() ) ;   
    }  
  
    @Override  
    protected void romove(Company company) {  
          
    }  
      
}

public class Composite {

	public static void main(String[] args) {
		Company root = new ConcreteCompany();  
        root.setName("�����ܹ�˾");  
        root.add(new FinanceDepartment("�ܹ�˾������Դ��"));  
        root.add(new FinanceDepartment("�ܹ�˾����"));  
        Company shandongCom = new ConcreteCompany("ɽ���ֹ�˾");  
        shandongCom.add(new FinanceDepartment("ɽ���ֹ�˾������Դ��"));  
        shandongCom.add(new FinanceDepartment("ɽ���ֹ�˾����"));  
        Company zaozhuangCom = new ConcreteCompany("��ׯ���´�");  
        zaozhuangCom.add(new FinanceDepartment("��ׯ���´�����"));  
        zaozhuangCom.add(new FinanceDepartment("��ׯ���´�������Դ��"));  
        Company jinanCom = new ConcreteCompany("���ϰ��´�");  
        jinanCom.add(new FinanceDepartment("���ϰ��´�����"));  
        jinanCom.add(new FinanceDepartment("���ϰ��´�������Դ��"));   
        shandongCom.add(jinanCom);  
        shandongCom.add(zaozhuangCom);  
        Company huadongCom = new ConcreteCompany("�Ϻ������ֹ�˾");  
        huadongCom.add(new FinanceDepartment("�Ϻ������ֹ�˾������Դ��"));  
        huadongCom.add(new FinanceDepartment("�Ϻ������ֹ�˾����"));  
        Company hangzhouCom = new ConcreteCompany("���ݰ��´�");  
        hangzhouCom.add(new FinanceDepartment("���ݰ��´�����"));  
        hangzhouCom.add(new FinanceDepartment("���ݰ��´�������Դ��"));  
        Company nanjingCom = new ConcreteCompany("�Ͼ����´�");  
        nanjingCom.add(new FinanceDepartment("�Ͼ����´�����"));  
        nanjingCom.add(new FinanceDepartment("�Ͼ����´�������Դ��"));  
        huadongCom.add(hangzhouCom);  
        huadongCom.add(nanjingCom);  
        root.add(shandongCom);  
        root.add(huadongCom);  
        root.display(0);  
	}

}
