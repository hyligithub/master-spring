package com.masterspring.common.demo.io.serializable;

import java.io.*;

/**
 * Created by lihuiyan on 2015/5/22.
 * (01) ���л���static��transient�������ǲ����Զ�����״̬����ġ�
 * transient�����þ��ǣ���transient�����ı��������ᱻ�Զ����л���
 * (02) ����Socket, Thread�࣬��֧�����л�����ʵ�����л��Ľӿ��У���Thread��Ա���ڶԸ���������л�����ʱ����������
 * ����Ҫ�ǻ�����Դ���䷽���ԭ�����Socket��Thread����Ա����л������Ǳ������л�֮��Ҳ�޷������ǽ������µ���Դ���䣻���ߣ�Ҳ��û�б�Ҫ����ʵ�֡�
 */
public class SerialTest1 {
    private static final String TMP_FILE = "serializable.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
            ObjectC objectC = new ObjectC(1, 100, 20);
            oo.writeObject(objectC);

//            objectC = new ObjectC(1, "two", "female");
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(TMP_FILE));
            ObjectC objectc = (ObjectC) oi.readObject();
            System.out.println(objectc);
            oi.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ObjectC implements Serializable {
    private int id;
    private static int name;
    private transient int sex;

    private transient Thread thread = new Thread(new Runnable() {
        public void run() {
            System.out.println("Serializable  thread");
        }
    });

    public ObjectC(int id, int name, int sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    private void writeObject(ObjectOutputStream o) throws IOException {
        o.defaultWriteObject();
        o.writeInt(name);
        o.writeInt(sex);
    }

    private void readObject(ObjectInputStream oi) throws IOException, ClassNotFoundException {
        oi.defaultReadObject();
        name = oi.readInt();
        sex = oi.readInt();
    }

    public String toString() {
        return "ObjectB[" + id + "--" + name + "--" + sex + "]";
    }
}
