package designpatterns.chainresponsibility;

/*
 * ������ģʽ
 * ����������һ������:����۲ͷ��õĹ���
 * ����۲ͷ��õĴ�������һ���ǣ�������������д���뵥��Ȼ�󽻸��쵼������
 * ���������׼�������쵼��֪ͨ����������ͨ����Ȼ��������ȥ������ȡ���ã�
 * ���û����׼�������쵼��֪ͨ����������δͨ��������Ҳ�ʹ����ա�
 */

/*
 * �������߽�ɫ
 */
abstract class Handler {
    /**
     * ������һ����������Ķ���
     */
    protected Handler successor = null;
    /**
     * ȡֵ����
     */
    public Handler getSuccessor() {
        return successor;
    }
    /**
     * ������һ����������Ķ���
     */
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }
    /**
     * ����۲ͷ��õ�����
     * @param user    ������
     * @param fee    �����Ǯ��
     * @return        �ɹ���ʧ�ܵľ���֪ͨ
     */
    public abstract String handleFeeRequest(String user , double fee);
}

/*
 * ���崦���߽�ɫ
 */
class ProjectManager extends Handler {

    @Override
    public String handleFeeRequest(String user, double fee) {
        
        String str = "";
        //��Ŀ����Ȩ�ޱȽ�С��ֻ����500����
        if(fee < 500)
        {
            //Ϊ�˲��ԣ��򵥵㣬ֻͬ������������
            if("����".equals(user))
            {
                str = "�ɹ�����Ŀ����ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";    
            }else
            {
                //������һ�ɲ�ͬ��
                str = "ʧ�ܣ���Ŀ����ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";
            }
        }else
        {
            //����500���������ݸ�������ߵ��˴���
            if(getSuccessor() != null)
            {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }

}
class DeptManager extends Handler {

    @Override
    public String handleFeeRequest(String user, double fee) {
        
        String str = "";
        //���ž����Ȩ��ֻ����1000����
        if(fee < 1000)
        {
            //Ϊ�˲��ԣ��򵥵㣬ֻͬ������������
            if("����".equals(user))
            {
                str = "�ɹ������ž���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";    
            }else
            {
                //������һ�ɲ�ͬ��
                str = "ʧ�ܣ����ž���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";
            }
        }else
        {
            //����1000���������ݸ�������ߵ��˴���
            if(getSuccessor() != null)
            {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }

}
class GeneralManager extends Handler {

    @Override
    public String handleFeeRequest(String user, double fee) {
        
        String str = "";
        //�ܾ����Ȩ�޺ܴ�ֻҪ����������������Դ���
        if(fee >= 1000)
        {
            //Ϊ�˲��ԣ��򵥵㣬ֻͬ������������
            if("����".equals(user))
            {
                str = "�ɹ����ܾ���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";    
            }else
            {
                //������һ�ɲ�ͬ��
                str = "ʧ�ܣ��ܾ���ͬ�⡾" + user + "���ľ۲ͷ��ã����Ϊ" + fee + "Ԫ";
            }
        }else
        {
            //������к�̵Ĵ�����󣬼�������
            if(getSuccessor() != null)
            {
                return getSuccessor().handleFeeRequest(user, fee);
            }
        }
        return str;
    }

}
public class ChainResponsibility {

	public static void main(String[] args) {
		//��Ҫ��װ������
        Handler h1 = new GeneralManager();
        Handler h2 = new DeptManager();
        Handler h3 = new ProjectManager();
        h3.setSuccessor(h2);
        h2.setSuccessor(h1);
        
        //��ʼ����
        String test1 = h3.handleFeeRequest("����", 300);
        System.out.println("test1 = " + test1);
        String test2 = h3.handleFeeRequest("����", 300);
        System.out.println("test2 = " + test2);
        System.out.println("---------------------------------------");
        
        String test3 = h3.handleFeeRequest("����", 700);
        System.out.println("test3 = " + test3);
        String test4 = h3.handleFeeRequest("����", 700);
        System.out.println("test4 = " + test4);
        System.out.println("---------------------------------------");
        
        String test5 = h3.handleFeeRequest("����", 1500);
        System.out.println("test5 = " + test5);
        String test6 = h3.handleFeeRequest("����", 1500);
        System.out.println("test6 = " + test6);
    }

}
